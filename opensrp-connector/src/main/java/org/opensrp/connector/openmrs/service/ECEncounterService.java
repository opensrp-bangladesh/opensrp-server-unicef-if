package org.opensrp.connector.openmrs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.common.util.HttpResponse;
import org.opensrp.connector.HttpUtil;
import org.opensrp.domain.Client;
import org.opensrp.domain.Event;
import org.opensrp.domain.Obs;
import org.opensrp.domain.User;
import org.opensrp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;

@Service
public class ECEncounterService extends OpenmrsService{
	
	private static final String ENCOUNTER_URL = "ws/rest/v1/encounter";
	private static final String ENCOUNTER__TYPE_URL = "ws/rest/v1/encountertype";
	private ECPatientService patientService;
	private OpenmrsUserService userService;
	private ClientService clientService;

	@Autowired
	public ECEncounterService(ECPatientService patientService, OpenmrsUserService userService,ClientService clientService) {
		this.patientService = patientService;
		this.userService = userService;
		this.clientService = clientService;
	}
	
	public ECEncounterService(String openmrsUrl, String user, String password) {
    	super(openmrsUrl, user, password);
	}
	
	public ECPatientService getPatientService() {
		return patientService;
	}

	public void setPatientService(ECPatientService patientService) {
		this.patientService = patientService;
	}

	public OpenmrsUserService getUserService() {
		return userService;
	}

	public void setUserService(OpenmrsUserService userService) {
		this.userService = userService;
	}

    public JSONObject getEncounterByUuid(String uuid, boolean noRepresentationTag) throws JSONException
    {
    	return new JSONObject(HttpUtil.get(getURL()
    			+"/"+ENCOUNTER_URL+"/"+uuid, noRepresentationTag?"":"v=full", OPENMRS_USER, OPENMRS_PWD).body());
    }
    
	public JSONObject getEncounterType(String encounterType) throws JSONException
    {
    	// we have to use this ugly approach because identifier not found throws exception and 
    	// its hard to find whether it was network error or object not found or server error
    	JSONArray res = new JSONObject(HttpUtil.get(getURL()+"/"+ENCOUNTER__TYPE_URL, "v=full", 
    			OPENMRS_USER, OPENMRS_PWD).body()).getJSONArray("results");
    	for (int i = 0; i < res.length(); i++) {
			if(res.getJSONObject(i).getString("display").equalsIgnoreCase(encounterType)){
				return res.getJSONObject(i);
			}
		}
    	return null;
    }
	
    public JSONObject createEncounterType(String name, String description) throws JSONException{
		JSONObject o = convertEncounterToOpenmrsJson(name, description);
		return new JSONObject(HttpUtil.post(getURL()+"/"+ENCOUNTER__TYPE_URL, "", o.toString(), OPENMRS_USER, OPENMRS_PWD).body());
	}
    
    public JSONObject convertEncounterToOpenmrsJson(String name, String description) throws JSONException {
		JSONObject a = new JSONObject();
		a.put("name", name);
		a.put("description", description);
		return a;
	}
	
	public JSONObject createEncounter(Event e) throws JSONException{
		JSONObject pt = patientService.getPatientByIdentifier(e.getBaseEntityId());
		JSONObject enc = new JSONObject();
		
		JSONObject pr = userService.getPersonByUser(e.getProviderId());
		
		enc.put("encounterDatetime", OPENMRS_DATE.format(e.getEventDate().toDate()));
		// patient must be existing in OpenMRS before it submits an encounter. if it doesnot it would throw NPE
		enc.put("patient", pt.getString("uuid"));
		enc.put("encounterType", e.getEventType());
		enc.put("location", e.getLocationId());
		enc.put("provider", pr.getString("uuid"));

		List<Obs> ol = e.getObs();
		Map<String, JSONArray> p = new HashMap<>();
		Map<String, JSONArray> pc = new HashMap<>();
		
		if(ol != null)
		for (Obs obs : ol) {
			if(!StringUtils.isEmptyOrWhitespaceOnly(obs.getFieldCode())){//skipping empty obs
				//if no parent simply make it root obs
				if(StringUtils.isEmptyOrWhitespaceOnly(obs.getParentCode())){
					p.put(obs.getFieldCode(), convertObsToJson(obs));
				}
				else {
					//find parent obs if not found search and fill or create one
					JSONArray parentObs = p.get(obs.getParentCode());
					if(parentObs == null){
						p.put(obs.getParentCode(), convertObsToJson(getOrCreateParent(ol, obs)));
					}
					// find if any other exists with same parent if so add to the list otherwise create new list
					JSONArray obl = pc.get(obs.getParentCode());
					if(obl == null){
						obl = new JSONArray();
					}
					JSONArray addobs = convertObsToJson(obs);
					for (int i = 0; i < addobs.length(); i++) {
						obl.put(addobs.getJSONObject(i));
					}
					pc.put(obs.getParentCode(), obl);
				}
			}
		}
		
		JSONArray obar = new JSONArray();
		for (String ok : p.keySet()) {
			for (int i = 0; i < p.get(ok).length(); i++) {
				JSONObject obo = p.get(ok).getJSONObject(i);
				
				JSONArray cob = pc.get(ok);
				if(cob != null && cob.length() > 0) {
					obo.put("groupMembers", cob);
				}
				
				obar.put(obo);
			}
		}
		enc.put("obs", obar);
		
		HttpResponse op = HttpUtil.post(HttpUtil.removeEndingSlash(OPENMRS_BASE_URL)+"/"+ENCOUNTER_URL, "", enc.toString(), OPENMRS_USER, OPENMRS_PWD);
		return new JSONObject(op.body());
	}
	
	public JSONObject updateEncounter(Event e) throws JSONException{
		if(StringUtils.isEmptyOrWhitespaceOnly(e.getEventId())){
			throw new IllegalArgumentException("Encounter was never pushed to OpenMRS as eventId is empty. Consider creating a new one");
		}
		JSONObject pt = patientService.getPatientByIdentifier(e.getBaseEntityId());//TODO find by any identifier
		JSONObject enc = new JSONObject();
		
		JSONObject pr = userService.getPersonByUser(e.getProviderId());
		
		enc.put("encounterDatetime", OPENMRS_DATE.format(e.getEventDate().toDate()));
		// patient must be existing in OpenMRS before it submits an encounter. if it doesnot it would throw NPE
		enc.put("patient", pt.getString("uuid"));
		enc.put("encounterType", e.getEventType());
		enc.put("location", e.getLocationId());
		enc.put("provider", pr.getString("uuid"));

		List<Obs> ol = e.getObs();
		Map<String, JSONArray> p = new HashMap<>();
		Map<String, JSONArray> pc = new HashMap<>();
		
		if(ol != null)
		for (Obs obs : ol) {
			if(StringUtils.isEmptyOrWhitespaceOnly(obs.getFieldCode())){//skipping empty obs
				//if no parent simply make it root obs
				if(StringUtils.isEmptyOrWhitespaceOnly(obs.getParentCode())){
					p.put(obs.getFieldCode(), convertObsToJson(obs));
				}
				else {
					//find parent obs if not found search and fill or create one
					JSONArray parentObs = p.get(obs.getParentCode());
					if(parentObs == null){
						p.put(obs.getParentCode(), convertObsToJson(getOrCreateParent(ol, obs)));
					}
					// find if any other exists with same parent if so add to the list otherwise create new list
					JSONArray obl = pc.get(obs.getParentCode());
					if(obl == null){
						obl = new JSONArray();
					}
					JSONArray addobs = convertObsToJson(obs);
					for (int i = 0; i < addobs.length(); i++) {
						obl.put(addobs.getJSONObject(i));
					}
					pc.put(obs.getParentCode(), obl);
				}
			}
		}
		
		JSONArray obar = new JSONArray();
		for (String ok : p.keySet()) {
			for (int i = 0; i < p.get(ok).length(); i++) {
				JSONObject obo = p.get(ok).getJSONObject(i);
				
				JSONArray cob = pc.get(ok);
				if(cob != null && cob.length() > 0) {
					obo.put("groupMembers", cob);
				}
				
				obar.put(obo);
			}
		}
		enc.put("obs", obar);
		
		HttpResponse op = HttpUtil.post(HttpUtil.removeEndingSlash(OPENMRS_BASE_URL)+"/"+ENCOUNTER_URL+"/"+e.getEventId(), "", enc.toString(), OPENMRS_USER, OPENMRS_PWD);
		return new JSONObject(op.body());
	}
	
	private JSONArray convertObsToJson(Obs o) throws JSONException{
		JSONArray arr = new JSONArray();
		if(o.getValues() == null || o.getValues().size()==0){//must be parent of some obs
			JSONObject obo = new JSONObject();
			obo.put("concept", o.getFieldCode());

			arr.put(obo);
		}
		else {
			//OpenMRS can not handle multivalued obs so add obs with multiple values as two different obs
			for (Object v : o.getValues()) {
				JSONObject obo = new JSONObject();
				obo.put("concept", o.getFieldCode());
				obo.put("value", v);
	
				arr.put(obo);
			}
		}
		return arr;
	}
	
	private Obs getOrCreateParent(List<Obs> obl, Obs o){
		for (Obs obs : obl) {
			if(o.getParentCode().equalsIgnoreCase(obs.getFieldCode())){
				return obs;
			}
		}
		return new Obs("concept", "parent", o.getParentCode(), null, null, null, null);
	}
	// TODO needs review and refctor
	public Event convertToEvent(JSONObject encounter) throws JSONException{
		Event e = new Event();
		JSONObject p = patientService.getPatientByUuid(encounter.getJSONObject("patient").getString("uuid"), false);
		
		Client c = patientService.convertToClient(p);
		Client client = clientService.findClient(c);
		String baseEntityId = "";
		if(client!= null){
			baseEntityId = client.getBaseEntityId();
		}else{
			baseEntityId = c.getBaseEntityId();
		}
		if(baseEntityId == null){
			throw new IllegalStateException("Client was not registered before adding an Event in OpenSRP");
		}		
		
		System.out.println( encounter.getString("encounterDatetime"));
		try{
			JSONArray creator = encounter.getJSONArray("encounterProviders");
		e.withBaseEntityId(baseEntityId)
			.withCreator(new User(creator.getJSONObject(0).getString("uuid"), creator.getJSONObject(0).getString("display"), null, null))
			.withDateCreated(new Date());
		e.withEventDate(new DateTime(encounter.getString("encounterDatetime")));
			//.withEntityType(entityType) //TODO
		e.withEventType(encounter.getJSONObject("encounterType").get("display").toString())
		//.withFormSubmissionId(formSubmissionId)//TODO
		.withLocationId(encounter.getJSONObject("location").getString("display"))
		.withProviderId(creator.getJSONObject(0).getString("display"))
		.withFormSubmissionId(encounter.getString("uuid"))
		.withVoided(encounter.getBoolean("voided"));
		
		try{
			JSONArray ol = encounter.getJSONArray("obs");
			for (int i = 0; i < ol.length(); i++) {
				JSONObject o = ol.getJSONObject(i);
				System.out.println(o.get("display"));
				/*List<Object> values = new ArrayList<Object>();
				if(o.optJSONObject("display") != null){
					values.add(o.getJSONObject("value").getString("uuid"));
				}
				else if(o.has("value")){
					values.add(o.getString("value"));
				}*/
				e.addObs(new Obs(null, null, o.get("uuid").toString(), null /*//TODO*/,o.get("display"), null/*comments*/, null/*formSubmissionField*/));
			}
			
		}catch(Exception eee){
			
		}
		}catch(Exception ee){
			
			
		}
		
		return e;
	}

}
