package org.opensrp.service.formSubmission.handler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ECHandlerMapper {

	private static final Map<String, CustomFormSubmissionHandler> handlerMap = new HashMap<String, CustomFormSubmissionHandler>();
	
	public Map<String, CustomFormSubmissionHandler> handlerMap() {
		return Collections.unmodifiableMap(handlerMap);
	}

	public ECHandlerMapper addHandler(String formName, CustomFormSubmissionHandler handler) {
		handlerMap.put(formName, handler);
		return this;
	}
}
