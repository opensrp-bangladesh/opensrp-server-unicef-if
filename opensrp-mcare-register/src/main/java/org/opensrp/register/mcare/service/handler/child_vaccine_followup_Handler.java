/**
 * @author Asifur
 */

package org.opensrp.register.mcare.service.handler;

import org.opensrp.form.domain.FormSubmission;
import org.opensrp.register.mcare.service.MembersService;
import org.opensrp.service.formSubmission.handler.FormSubmissionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class child_vaccine_followup_Handler implements FormSubmissionHandler {

	private MembersService womanService;

	@Autowired
	public child_vaccine_followup_Handler(MembersService womanService) {
		this.womanService = womanService;
	}
	
	@Override
	public void handle(FormSubmission submission) {
		womanService.child_vaccineHandler(submission);	
	}

}
