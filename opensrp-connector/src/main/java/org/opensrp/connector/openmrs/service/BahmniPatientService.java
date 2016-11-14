package org.opensrp.connector.openmrs.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.api.domain.Address;
import org.opensrp.api.domain.BaseEntity;
import org.opensrp.api.domain.Client;
import org.opensrp.connector.BahmniHttpUtils;
import org.opensrp.connector.HttpUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class BahmniPatientService extends OpenmrsService{
	
	private static final String GEN_ID_URL = "ws/rest/v1/idgen";
	private static final String PERSON_URL = "ws/rest/v1/person";
	private static final String PATIENT_URL = "ws/rest/v1/patientprofile";
	private static final String PATIENT_IDENTIFIER_TYPE_URL = "ws/rest/v1/patientidentifiertype";
	private static final String PERSON_ATTRIBUTE_TYPE_URL = "ws/rest/v1/personattributetype";
	
	private static final String OPENSRP_IDENTIFIER_TYPE = "OpenSRP Thrive UID";
	private static final String BAHMNI_IDENTIFIER_TYPE = "Bahmni Id";
	
	public BahmniPatientService() { }

    public BahmniPatientService(String openmrsUrl, String user, String password) {
    	super(openmrsUrl, user, password);
    }
    
    public String generateID() throws JSONException
    {
    	String ids = "BDH";
  		JSONObject gen = new JSONObject();
  		gen.put("identifierSourceName",ids);
  		
  		return BahmniHttpUtils.post(getURL()+"/"+GEN_ID_URL, "", gen.toString(), OPENMRS_USER, OPENMRS_PWD).body();
    }

    public JSONObject getPatientByIdentifier(String identifier) throws JSONException
    {
    	JSONArray p = new JSONObject(HttpUtil.get(getURL()
    			+"/"+PATIENT_URL, "v=full&identifier="+identifier, OPENMRS_USER, OPENMRS_PWD).body())
    			.getJSONArray("results");

    	return p.length()>0?p.getJSONObject(0):null;
    }
    public JSONObject createPerson(BaseEntity be) throws JSONException{
		JSONObject per = convertBaseEntityToOpenmrsJson(be);
		System.out.println("Going to create person: " + per.toString());
		//return per;
		return new JSONObject(BahmniHttpUtils.post(getURL()+"/"+PERSON_URL, "", per.toString(), OPENMRS_USER, OPENMRS_PWD).body());
	}
    
    public JSONObject convertBaseEntityToOpenmrsJson(BaseEntity be) throws JSONException {
		JSONObject per = new JSONObject();
		per.put("gender", be.getGender());
		if(be.getBirthdate() != null){
			per.put("birthdate", OPENMRS_DATE.format(be.getBirthdate()));
		}
		else{
			per.put("birthdate", OPENMRS_DATE.format("1900-01-01"));
		}
		per.put("birthdateEstimated", be.getBirthdateApprox());
		if(be.getDeathdate() != null){
			per.put("deathDate", OPENMRS_DATE.format(be.getDeathdate()));
		}
		
		String fn = be.getFirstName();
		String mn = be.getMiddleName()==null?"":be.getMiddleName();
		String ln = (be.getLastName() == null || be.getLastName().equalsIgnoreCase(".")) ? "BD" : be.getLastName();
		per.put("names", new JSONArray("[{\"givenName\":\""+fn+"\",\"middleName\":\""+mn+"\", \"familyName\":\""+ln+"\"}]"));
		per.put("attributes", convertAttributesToOpenmrsJson(be.getAttributes()));
		System.out.println("Address BE: "+be.getAddresses().toString());
		per.put("addresses", convertAddressesToOpenmrsJson(be.getAddresses()));
		return per;
	}
    public JSONArray convertAttributesToOpenmrsJson(Map<String, Object> attributes) throws JSONException {
		if(CollectionUtils.isEmpty(attributes)){
			return null;
		}
		JSONArray attrs = new JSONArray();
		for (Entry<String, Object> at : attributes.entrySet()) {
			JSONObject a = new JSONObject();			
				a.put("attributeType", getPersonAttributeType(at.getKey()).getString("uuid"));
				a.put("value", at.getValue());
				attrs.put(a);
		}
		
		return attrs;
	}
    
    public JSONObject getPersonAttributeType(String attributeName) throws JSONException
    {
    	JSONArray p = new JSONObject(HttpUtil.get(getURL()+"/"+PERSON_ATTRIBUTE_TYPE_URL, 
    			"v=full&q="+attributeName, OPENMRS_USER, OPENMRS_PWD).body()).getJSONArray("results");
    	return p.length()>0?p.getJSONObject(0):null;
    }
	
	public JSONArray convertAddressesToOpenmrsJson(List<Address> adl) throws JSONException{
		if(CollectionUtils.isEmpty(adl)){
			return null;
		}

		//System.out.println("Addresses : " + org.apache.commons.lang.StringUtils.join(adl, ","));
		
		JSONArray jaar = new JSONArray();
		System.out.println("Address::"+adl.toString());
		for (Address ad : adl) {
			System.out.println("Address ADD::"+ad.toString());
			JSONObject jao = new JSONObject();
			if(ad.getAddressFields() != null){
				jao.put("address1", ad.getAddressFieldMatchingRegex("(?i)(ADDRESS1|HOUSE_NUMBER|HOUSE|HOUSE_NO|UNIT|UNIT_NUMBER|UNIT_NO)"));
				jao.put("address2", ad.getAddressFieldMatchingRegex("(?i)(ADDRESS2|STREET|STREET_NUMBER|STREET_NO|LANE)"));
				jao.put("address3", ad.getAddressFieldMatchingRegex("(?i)(ADDRESS3|SECTOR|AREA)"));
				//jao.put("address4", "Unions Of Kaliganj Upazila");
				jao.put("address4", ad.getAddressFieldMatchingRegex("(?i)(ADDRESS4|SUB_DISTRICT|MUNICIPALITY|TOWN|LOCALITY|REGION)"));
				jao.put("address5", ad.getAddressFieldMatchingRegex("(?i)(ADDRESS5|cityVillage|city_village|CITY|VILLAGE)"));
				//jao.put("address5", "Kaliganj");
				//jao.put("countyDistrict", "Gazipur");
				jao.put("countyDistrict", ad.getAddressFieldMatchingRegex("(?i)(county_district|countyDistrict|COUNTY|DISTRICT)"));
				jao.put("cityVillage", ad.getAddressFieldMatchingRegex("(?i)(cityVillage|city_village|CITY|VILLAGE)"));

				/*String ad5V = "";
				for (Entry<String, String> af : ad.getAddressFields().entrySet()) {
					if(!af.getKey().matches("(?i)(ADDRESS1|HOUSE_NUMBER|HOUSE|HOUSE_NO|UNIT|UNIT_NUMBER|UNIT_NO|"
							+ "ADDRESS2|STREET|STREET_NUMBER|STREET_NO|LANE|"
							+ "ADDRESS3|SECTOR|AREA|"
							+ "ADDRESS4|SUB_DISTRICT|MUNICIPALITY|TOWN|LOCALITY|REGION|"
							+ "countyDistrict|county_district|COUNTY|DISTRICT|"
							+ "cityVillage|city_village|CITY|VILLAGE)")){
						ad5V += af.getKey()+":"+af.getValue()+";";
					}
				}
				if(!StringUtils.isEmptyOrWhitespaceOnly(ad5V)){
					jao.put("address5", ad5V);
				}*/
				
			}
			jao.put("address6", ad.getAddressType());
			//jao.put("stateProvince", "Dhaka");
			jao.put("stateProvince", ad.getState());
			jao.put("country", ad.getCountry());
			jao.put("postalCode", ad.getPostalCode());
			jao.put("latitude", ad.getLatitude());
			jao.put("longitude", ad.getLongitute());
			if(ad.getStartDate() != null){
				jao.put("startDate", OPENMRS_DATE.format(ad.getStartDate()));
			}
			if(ad.getEndDate() != null){
				jao.put("endDate", OPENMRS_DATE.format(ad.getEndDate()));
			}
			
			jaar.put(jao);
		}
		System.out.println("Address:"+jaar);
		return jaar;
	}
    
    public JSONObject getIdentifierType(String identifierType) throws JSONException
    {
    	// we have to use this ugly approach because identifier not found throws exception and 
    	// its hard to find whether it was network error or object not found or server error
    	JSONArray res = new JSONObject(HttpUtil.get(getURL()+"/"+PATIENT_IDENTIFIER_TYPE_URL, "v=full", 
    			OPENMRS_USER, OPENMRS_PWD).body()).getJSONArray("results");
    	for (int i = 0; i < res.length(); i++) {
			if(res.getJSONObject(i).getString("display").equalsIgnoreCase(identifierType)){
				return res.getJSONObject(i);
			}
		}
    	return null;
    }
	
    public JSONObject createIdentifierType(String name, String description) throws JSONException{
		JSONObject o = convertIdentifierToOpenmrsJson(name, description);
		return new JSONObject(HttpUtil.post(getURL()+"/"+PATIENT_IDENTIFIER_TYPE_URL, "", o.toString(), OPENMRS_USER, OPENMRS_PWD).body());
	}
    
	public JSONObject convertIdentifierToOpenmrsJson(String name, String description) throws JSONException {
		JSONObject a = new JSONObject();
		a.put("name", name);
		a.put("description", description);
		return a;
	}
	
	public JSONObject createPatient(Client c, String idGen) throws JSONException
	{
		JSONObject patientExist = null;
		patientExist = getPatientByIdentifier(c.getBaseEntity().getId());
		if (patientExist != null){
			System.out.println("Person or Patient already existis inside openmrs id:" + c.getBaseEntity().getId());
			return patientExist;
		}
		JSONObject payloadJsonObj = new JSONObject();
		JSONObject p = new JSONObject();
		//p.put("person", createPerson(c.getBaseEntity()).getString("uuid"));
		p.put("person", createPerson(c.getBaseEntity()));
		JSONArray ids = new JSONArray();
		if (c.getIdentifiers() != null) {
			for (Entry<String, String> id : c.getIdentifiers().entrySet()) {
				patientExist = getPatientByIdentifier(id.getValue());
				if (patientExist != null){
					System.out.println("Person or Patient already existis inside openmrs with identifier:" + id.getValue());
					return patientExist;
				}
				JSONObject jio = new JSONObject();
				JSONObject idobj = getIdentifierType(id.getKey());
				if (idobj == null) {
					idobj = createIdentifierType(id.getKey(), id.getKey()
							+ " - FOR THRIVE OPENSRP");
				}
				jio.put("identifierType", idobj.getString("uuid"));				
				jio.put("identifier", id.getValue());
				Object cloc = c.getBaseEntity().getAttribute("Location");
				jio.put("location", cloc == null ? "Unknown Location" : cloc);
				// jio.put("preferred", true);
				ids.put(jio);
			}
		}
		
		JSONObject jio = new JSONObject();
		JSONObject ido = getIdentifierType(OPENSRP_IDENTIFIER_TYPE);
		if(ido == null){
			ido = createIdentifierType(OPENSRP_IDENTIFIER_TYPE, OPENSRP_IDENTIFIER_TYPE+" - FOR THRIVE OPENSRP");
		}
		
		JSONObject identifierTypeObj = new JSONObject();
		identifierTypeObj.put("name",BAHMNI_IDENTIFIER_TYPE);
		
		jio.put("identifierType", identifierTypeObj);
		jio.put("identifier", idGen);
		//Object cloc = c.getBaseEntity().getAttribute("Location");
		//jio.put("location", cloc == null?"Unknown Location":cloc);
		jio.put("preferred", true);
		jio.put("voided", false);
		
		ids.put(jio);
		
		p.put("identifiers", ids);
		payloadJsonObj.put("patient", p);
		JSONArray relationships =	new JSONArray();
		payloadJsonObj.put("relationships", relationships);
		
		System.out.println("Going to create patient: " + payloadJsonObj.toString());
		return new JSONObject(BahmniHttpUtils.post(getURL()+"/"+PATIENT_URL, "", payloadJsonObj.toString(), OPENMRS_USER, OPENMRS_PWD).body());
	}

}
