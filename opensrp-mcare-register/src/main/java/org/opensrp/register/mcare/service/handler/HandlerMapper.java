/**
 * @author Asifur
 */
package org.opensrp.register.mcare.service.handler;

import java.util.Map;

import org.opensrp.common.util.EasyMap;
import org.opensrp.form.repository.AllFormSubmissions;
import org.opensrp.service.formSubmission.handler.FormSubmissionHandler;
import org.opensrp.service.formSubmission.handler.IHandlerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import static org.opensrp.common.AllConstants.Form.*;

@Service
public class HandlerMapper implements IHandlerMapper {

	private final Map<String, FormSubmissionHandler> handlerMap;
	
	@Autowired
	public HandlerMapper(  
			AllFormSubmissions formSubmissionsRepository,
			HHRegistrationHandler hhRegistrationHandler,
			MEMBERSHandler membersHandler,
			BNFHandler BNFHandler,
			Birth_OutcomeHandler Birth_OutcomeHandler,
			GeneralHandler generalHandler,
			TTform_Handler TTform_Handler,
			child_vaccine_followup_Handler child_vaccine_followup_Handler
			)
	{
		handlerMap = EasyMap.create(HH_REGISTRATION, (FormSubmissionHandler) hhRegistrationHandler)
					 .put(MEMBERS_REGISTRATION, membersHandler)	
					 .put(BNF_Handler, BNFHandler)
					 .put(BirthOutcome_Handler, Birth_OutcomeHandler)
				     .put(GeneralHandler, generalHandler)
				     .put(TT_Visit_Handler, TTform_Handler)
				     .put(Child_vaccine_followup_Handler, child_vaccine_followup_Handler)
                     .map();
	}

	@Override
	public Map<String, FormSubmissionHandler> handlerMapper() {
		return handlerMap;
	}

}