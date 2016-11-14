/**
 * @author Asifur
 */

package org.opensrp.register.mcare.service.scheduling;

import static org.opensrp.common.AllConstants.HHRegistrationFields.REFERENCE_DATE;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.joda.time.LocalDate;
import org.opensrp.form.domain.FormSubmission;
import org.opensrp.register.mcare.domain.Members;
import org.opensrp.register.mcare.service.MembersService;
import org.opensrp.register.mcare.service.VaccinationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WomanVaccineSchedule {
	
	private static Logger logger = LoggerFactory.getLogger(MembersService.class.toString());
	private MembersScheduleService membersScheduleService;
	private VaccinationService vaccinationService;
	
	@Autowired
	public WomanVaccineSchedule(MembersScheduleService membersScheduleService) {
		this.membersScheduleService = membersScheduleService;	
	}
	
	@Autowired
    public void setVaccinationService(VaccinationService vaccinationService) {
    	this.vaccinationService = vaccinationService;
    }

	public void immediateWomanVaccine(FormSubmission submission, Members members, Map<String, String> membersFields, String scheduleName, String immediateScheduleName, String refDate, String cond1, String cond2) {
		
		if(membersFields.containsKey(cond1))
		if(membersFields.get(cond1) != null && !membersFields.get(cond1).equalsIgnoreCase(""))
		if(membersFields.get(cond1).equalsIgnoreCase("1")){
			if(membersFields.containsKey(refDate)){
			if(membersFields.get(refDate) != null && !membersFields.get(refDate).equalsIgnoreCase(""))
			if(isValidDate(membersFields.get(refDate)))
				membersScheduleService.enrollimmediateMembersVisit(
					members.caseId(),submission.anmId(),membersFields.get(refDate),submission.instanceId(),scheduleName,immediateScheduleName);
			}
			else if(isValidDate(submission.getField(REFERENCE_DATE))){
				membersScheduleService.enrollimmediateMembersVisit(
					members.caseId(),submission.anmId(),submission.getField(REFERENCE_DATE),submission.instanceId(),scheduleName,immediateScheduleName);
			}
			}
		
		/*if(membersFields.containsKey(cond2))
			if(membersFields.get(cond2) != null && !membersFields.get(cond2).equalsIgnoreCase(""))
			if(membersFields.get(cond2).equalsIgnoreCase("3")){
				membersScheduleService.unEnrollFromImmediateSchedule(
					members.caseId(),submission.anmId(),scheduleName,immediateScheduleName);
				vaccinationService.updateVaccineStatus(members.caseId(), scheduleName);
			}*/
		
	}
	
	public void WomanVaccine(FormSubmission submission, Members members, Map<String, String> membersFields, String scheduleName, String refDate, String cond) {
		
		if (membersFields.containsKey(cond))
		if (membersFields.get(cond) == null || membersFields.get(cond).equalsIgnoreCase(""))
		if (membersFields.containsKey(refDate)){
		if(isValidDate(membersFields.get(refDate)))
			membersScheduleService.enrollWomanTTVisit(members.caseId(),submission.anmId(),membersFields.get(refDate),scheduleName);
		}
		
		if (!membersFields.containsKey(cond))
		if (membersFields.containsKey(refDate)){
		if(isValidDate(membersFields.get(refDate)))
			membersScheduleService.enrollWomanTTVisit(members.caseId(),submission.anmId(),membersFields.get(refDate),scheduleName);
		}
		
		/*if (membersFields.containsKey(cond))
		if (membersFields.get(cond) != null && !membersFields.get(cond).equalsIgnoreCase("")){
			membersScheduleService.unEnrollFromSchedule(
					members.caseId(),submission.anmId(),scheduleName);
			vaccinationService.updateVaccineStatus(members.caseId(), scheduleName);
		}*/		
	}
	
	public void WomanFollowupVaccine(FormSubmission submission, Members members, String scheduleName, String refDate, String cond) {
		
		if (submission.getField(cond) == null || submission.getField(cond).equalsIgnoreCase("")){
		if (submission.getField(refDate) != null && !submission.getField(refDate).equalsIgnoreCase(""))
		if(isValidDate(submission.getField(refDate)))
			membersScheduleService.enrollWomanTTVisit(members.caseId(),submission.anmId(),submission.getField(refDate),scheduleName);
		}
		
		if (submission.getField(cond) != null && !submission.getField(cond).equalsIgnoreCase("")){
			membersScheduleService.unEnrollFromSchedule(
					members.caseId(),submission.anmId(),scheduleName);	
			vaccinationService.updateVaccineStatus(members.caseId(), scheduleName);
		}
		
	}
	
	public boolean isValidDate(String dateString) {
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    try {
	        df.parse(dateString);
	        return true;
	    } catch (ParseException e) {
	        return false;
	    }
	}
	

}
