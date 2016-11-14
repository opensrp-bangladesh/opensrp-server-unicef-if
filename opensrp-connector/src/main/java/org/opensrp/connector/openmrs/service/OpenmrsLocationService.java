package org.opensrp.connector.openmrs.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.formula.functions.Address;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.api.domain.Location;
import org.opensrp.api.util.LocationTree;
import org.opensrp.common.util.HttpResponse;
import org.opensrp.connector.HttpUtil;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;

@Service
public class OpenmrsLocationService extends OpenmrsService{
	private static final String LOCATION_URL = "ws/rest/v1/location";

	public OpenmrsLocationService() {	}

	public OpenmrsLocationService(String openmrsUrl, String user, String password) {
    	super(openmrsUrl, user, password);
	}

	public Location getLocation(String locationIdOrName) throws JSONException {
		HttpResponse op = HttpUtil.get(HttpUtil.removeEndingSlash(OPENMRS_BASE_URL)+"/"+LOCATION_URL+"/"+(locationIdOrName.replaceAll(" ", "%20")), "v=full", OPENMRS_USER, OPENMRS_PWD);
		
		if(!StringUtils.isEmptyOrWhitespaceOnly(op.body())){
			return makeLocation(op.body());
		}
		return null;
	}
	
	public Location getParent(JSONObject locobj) throws JSONException {
		JSONObject parentL = (locobj.has("parentLocation")&&!locobj.isNull("parentLocation"))?locobj.getJSONObject("parentLocation"):null;

		if(parentL != null){
			return new Location(parentL.getString("uuid"), parentL.getString("display"), null, getParent(parentL));
		}
		return null;
	}
	
	
	private Location makeLocation(String locationJson) throws JSONException{
		JSONObject obj = new JSONObject(locationJson);		
		Location p = getParent(obj);
		System.out.println("Address:"+obj.toString());
		Map<String, String> addressFields = new HashMap<String, String>();
		addressFields.put("Country", obj.getString("country"));
		addressFields.put("Division", obj.getString("stateProvince"));
		addressFields.put("District", obj.getString("countyDistrict"));
		addressFields.put("Upazilla", obj.getString("address5"));
		addressFields.put("Union", obj.getString("address3"));
		addressFields.put("Paurasava", obj.getString("address4"));		
		addressFields.put("HIE_facilities", obj.getString("name"));
		addressFields.put("Address_line", obj.getString("address1"));
		
		
		
		org.opensrp.api.domain.Address address = new org.opensrp.api.domain.Address(null, null, null, addressFields, null, null, null, null, null);
		
		Location l = new Location(obj.getString("uuid"), obj.getString("name"), 
				address, null, p , null, null);
		JSONArray t = obj.getJSONArray("tags");
		
		for (int i = 0; i < t.length(); i++) {
			if(t.getJSONObject(i).getString("display").equalsIgnoreCase("HIE Facilities")){
				l.addTag(t.getJSONObject(i).getString("display").replace(" ", "_"));
			}
		}
		
		JSONArray a = obj.getJSONArray("attributes");
		
		for (int i = 0; i < a.length(); i++) {
			String ad = a.getJSONObject(i).getString("display");
			l.addAttribute(ad.substring(0,ad.indexOf(":")), ad.substring(ad.indexOf(":")+2));
		}
		
		return l;
	}
	
	private Location makeLocation(JSONObject location) throws JSONException{
		return makeLocation(location.toString());
	}
	
	public LocationTree getLocationTree() throws JSONException {
		LocationTree ltr = new LocationTree();
		HttpResponse op = HttpUtil.get(HttpUtil.removeEndingSlash(OPENMRS_BASE_URL)+"/"+LOCATION_URL, "v=full", OPENMRS_USER, OPENMRS_PWD);
		
		JSONArray res = new JSONObject(op.body()).getJSONArray("results");
		if(res.length() == 0){
			return ltr;
		}
		
		for (int i = 0; i < res.length(); i++) {
			ltr.addLocation(makeLocation(res.getJSONObject(i)));
		}
		return ltr;
	}
	
	public LocationTree getLocationTreeOf(String locationIdOrName) throws JSONException {
		LocationTree ltr = new LocationTree();		
		fillTreeWithHierarchy(ltr, locationIdOrName);
		fillTreeWithUpperHierarchy(ltr, locationIdOrName);		
		return ltr;
	}
	
	public LocationTree getLocationTreeOf(String[] locationIdsOrNames) throws JSONException {
		LocationTree ltr = new LocationTree();
		
		for (String loc : locationIdsOrNames) {
			String locTreeId = fillTreeWithHierarchy(ltr, loc);
			Location lp = ltr.findLocation(locTreeId).getParentLocation();
			if(lp != null){
				fillTreeWithUpperHierarchy(ltr, lp.getLocationId());
			}
		}		
		
		return ltr;
	}
	
	private String fillTreeWithHierarchy(LocationTree ltr, String locationIdOrName) throws JSONException{
		HttpResponse op = HttpUtil.get(HttpUtil.removeEndingSlash(OPENMRS_BASE_URL)+"/"+LOCATION_URL+"/"+(locationIdOrName.replaceAll(" ", "%20")), "v=full", OPENMRS_USER, OPENMRS_PWD);
		JSONObject lo = new JSONObject(op.body());		
		Location l = makeLocation(op.body());
		ltr.addLocation(l);		
		if(lo.has("childLocations")){
			JSONArray lch = lo.getJSONArray("childLocations");	
			for (int i = 0; i < lch.length(); i++) {	
				JSONObject cj = lch.getJSONObject(i);
				fillTreeWithHierarchy(ltr, cj.getString("uuid"));
			}
		}
		return l.getLocationId();
	}

	private void fillTreeWithUpperHierarchy(LocationTree ltr, String locationId) throws JSONException{
		HttpResponse op = HttpUtil.get(HttpUtil.removeEndingSlash(OPENMRS_BASE_URL)+"/"+LOCATION_URL+"/"+(locationId.replaceAll(" ", "%20")), "v=full", OPENMRS_USER, OPENMRS_PWD);
		Location l = makeLocation(op.body());		
		ltr.addLocation(l);		
		if(l.getParentLocation() != null){
			fillTreeWithUpperHierarchy(ltr, l.getParentLocation().getLocationId());
		}
	}
}
