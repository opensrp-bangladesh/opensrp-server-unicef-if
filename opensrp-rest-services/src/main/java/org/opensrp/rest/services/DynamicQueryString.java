package org.opensrp.rest.services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
public class DynamicQueryString {
	
	public String  makeDynamicQueryAsString(MultiValueMap<String, String> queryParameters){
		Map<String, String> preparedParameters = prepareParameters(queryParameters);
		String makeQueryString = "";
		int paramCounter = 1;
		for(Entry<String, String> entry : preparedParameters.entrySet())
		{
			makeQueryString+=entry.getKey()+":"+entry.getValue();
			
			if(preparedParameters.size()>paramCounter)
				makeQueryString+=" AND ";			
			paramCounter++;
		}	
		return makeQueryString;
		
	}
	
	
	private Map<String, String> prepareParameters(MultiValueMap<String, String> queryParameters) {

		Map<String, String> parameters = new HashMap<String, String>();

		Iterator<String> it = queryParameters.keySet().iterator();

		while (it.hasNext()) {
			String theKey = (String) it.next();
			parameters.put(theKey, queryParameters.getFirst(theKey));
		}

		return parameters;

	}
	
}
