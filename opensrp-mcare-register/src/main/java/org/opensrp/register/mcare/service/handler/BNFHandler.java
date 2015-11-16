/**
 * @author julkar nain 
 */
package org.opensrp.register.mcare.service.handler;

import org.opensrp.form.domain.FormSubmission;
import org.opensrp.register.mcare.service.ANCService;
import org.opensrp.service.formSubmission.handler.FormSubmissionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BNFHandler implements FormSubmissionHandler {

	private ANCService ancService;

	@Autowired
	public BNFHandler(ANCService ancService) {
		this.ancService = ancService;
	}

	@Override
	public void handle(FormSubmission submission) {
		ancService.registerANC(submission);
	}
}