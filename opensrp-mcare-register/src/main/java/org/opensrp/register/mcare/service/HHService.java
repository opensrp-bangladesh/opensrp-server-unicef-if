/**
 * @author Asifur
 */

package org.opensrp.register.mcare.service;

import static java.text.MessageFormat.format;
import static org.opensrp.common.AllConstants.CommonFormFields.ID;
import static org.opensrp.common.AllConstants.MEMBERSRegistrationFields.*;
import static org.opensrp.common.AllConstants.TT_VisitFields.Received_Time;
import static org.opensrp.common.AllConstants.HHRegistrationFields.*;
import static org.opensrp.common.util.EasyMap.create;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.MemberScheduleConstants.child_vaccination_bcg;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.opensrp.form.domain.FormSubmission;
import org.opensrp.form.domain.SubFormData;
import org.opensrp.register.mcare.domain.HouseHold;
import org.opensrp.register.mcare.domain.Members;
import org.opensrp.register.mcare.repository.AllHouseHolds;
import org.opensrp.register.mcare.service.scheduling.HHSchedulesService;
import org.opensrp.register.mcare.service.scheduling.ScheduleLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HHService {

	private static Logger logger = LoggerFactory.getLogger(HHService.class
			.toString());
	private AllHouseHolds allHouseHolds;
	private MembersService membersService;
	private HHSchedulesService hhSchedulesService;
	private ScheduleLogService scheduleLogService;	 
	@Autowired
	public HHService(AllHouseHolds allHouseHolds, MembersService membersService,
			HHSchedulesService hhSchedulesService) {
		this.allHouseHolds = allHouseHolds;
		this.membersService = membersService;
		this.hhSchedulesService = hhSchedulesService;	
	}	
	public void registerHouseHold(FormSubmission submission) {		
		HouseHold houseHold = allHouseHolds.findByCaseId(submission.entityId());		
		if (houseHold == null) {
			logger.warn(format(
					"Failed to handle Census form as there is no household registered with ID: {0}",
					submission.entityId()));
			return;
		}
		SubFormData subFormData =null;
		subFormData = submission.getSubFormByName(MEMBERS_REGISTRATION_SUB_FORM_NAME);		
		
		addMEMBERDETAILSToHH(submission, subFormData, houseHold);
		
		houseHold.setPROVIDERID(submission.anmId());
		houseHold.setINSTANCEID(submission.instanceId());
		houseHold.setTODAY(submission.getField(REFERENCE_DATE));	

		allHouseHolds.update(houseHold);
			
		hhSchedulesService.enrollIntoMilestoneOfCensus(submission.entityId(),
			submission.getField(REFERENCE_DATE),submission.anmId(),submission.instanceId());
		
		membersService.registerMembers(submission);
	}

	private void addMEMBERDETAILSToHH(FormSubmission submission,
			SubFormData subFormData, HouseHold houseHold) {
		
		SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
		for (Map<String, String> membersFields : subFormData.instances()) {

			Map<String, String> members = create(ID, membersFields.get(ID))
					.put(REFERENCE_DATE, submission.getField(REFERENCE_DATE))
					.put(START_DATE, submission.getField(START_DATE))
					.put(END_DATE, submission.getField(END_DATE))
					.put(REG_NO, membersFields.get(REG_NO))
					.put(MEMBER_FNAME, membersFields.get(MEMBER_FNAME))
					.put(MEMBER_LNAME, membersFields.get(MEMBER_LNAME))
					.put(Gender, membersFields.get(Gender))
					.put(Marital_status, membersFields.get(Marital_status))
					.put(Couple_No, membersFields.get(Couple_No))
					.put(lmp, membersFields.get(lmp))
					.put(edd, membersFields.get(edd))
					.put(MEMBER_COUNTRY, membersFields.get(MEMBER_COUNTRY))
					.put(MEMBER_DIVISION, membersFields.get(MEMBER_DIVISION))
					.put(MEMBER_DISTRICT, membersFields.get(MEMBER_DISTRICT))
					.put(MEMBER_UPAZILLA, membersFields.get(MEMBER_UPAZILLA))
					.put(MEMBER_PAURASAVA, membersFields.get(MEMBER_PAURASAVA))
					.put(MEMBER_UNION, membersFields.get(MEMBER_UNION))
					.put(MEMBER_WARD, membersFields.get(MEMBER_WARD))
					.put(MEMBER_ADDRESS_LINE, membersFields.get(MEMBER_ADDRESS_LINE))
					.put(MEMBER_HIE_FACILITIES, membersFields.get(MEMBER_HIE_FACILITIES))
					.put(Member_BLOCK, submission.getField(Member_BLOCK))
					.put(HH_ADDRESS, membersFields.get(HH_ADDRESS))
					.put(MEMBER_TYPE, membersFields.get(MEMBER_TYPE))
					.put(MEMBER_UNIQUE_ID, membersFields.get(MEMBER_UNIQUE_ID))
					.put(MEMBER_GPS, membersFields.get(MEMBER_GPS))
					.put(MEMBER_NID, membersFields.get(MEMBER_NID))
					.put(MEMBER_BRID, membersFields.get(MEMBER_BRID))
					.put(MEMBER_HID, membersFields.get(MEMBER_HID))
					.put(MEMBER_BIRTH_DATE_KNOWN, membersFields.get(MEMBER_BIRTH_DATE_KNOWN))
					.put(MEMBER_BIRTH_DATE, membersFields.get(MEMBER_BIRTH_DATE))
					.put(age, membersFields.get(age))
					.put(calc_age, membersFields.get(calc_age))
					.put(calc_dob, membersFields.get(calc_dob))
					.put(calc_dob_confirm, membersFields.get(calc_dob_confirm))
					.put(calc_dob_estimated, membersFields.get(calc_dob_estimated))
					.put(calc_age_confirm, membersFields.get(calc_age_confirm))
					.put(birth_date_note, membersFields.get(birth_date_note))
					.put(note_age, membersFields.get(note_age))
					.put(Father_name, membersFields.get(Father_name))
					.put(Husband_name, membersFields.get(Husband_name))
					.put(WomanInfo, membersFields.get(WomanInfo))
					.put(pregnant, membersFields.get(pregnant))
					.put(FP_USER, membersFields.get(FP_USER))
					.put(FP_Methods, membersFields.get(FP_Methods))
					.put(edd_lmp, membersFields.get(edd_lmp))
					.put(ultrasound_date, membersFields.get(ultrasound_date))
					.put(ultrasound_weeks, membersFields.get(ultrasound_weeks))
					.put(edd_calc_lmp, membersFields.get(edd_calc_lmp))
					.put(edd_calc_ultrasound, membersFields.get(edd_calc_ultrasound))
					.put(edd_calc_lmp_formatted, membersFields.get(edd_calc_lmp_formatted))
					.put(edd_calc_ultrasound_formatted, membersFields.get(edd_calc_ultrasound_formatted))
					.put(lmp_calc_edd, membersFields.get(lmp_calc_edd))
					.put(lmp_calc_ultrasound, membersFields.get(lmp_calc_ultrasound))
					.put(lmp_calc_edd_formatted, membersFields.get(lmp_calc_edd_formatted))
					.put(lmp_calc_ultrasound_formatted, membersFields.get(lmp_calc_ultrasound_formatted))
					.put(final_edd, membersFields.get(final_edd))
					.put(final_lmp, membersFields.get(final_lmp))
					.put(ga_edd, membersFields.get(ga_edd))
					.put(ga_lmp, membersFields.get(ga_lmp))
					.put(ga_ult, membersFields.get(ga_ult))
					.put(final_edd_note, membersFields.get(final_edd_note))
					.put(final_lmp_note, membersFields.get(final_lmp_note))
					.put(final_ga, membersFields.get(final_ga))
					.put(final_ga_note, membersFields.get(final_ga_note))
					.put(vaccines, membersFields.get(vaccines))
					.put(tt1_retro, membersFields.get(tt1_retro))
					.put(tt_1_dose, membersFields.get(tt_1_dose))
					.put(tt2_retro, membersFields.get(tt2_retro))
					.put(tt_2_dose, membersFields.get(tt_2_dose))
					.put(tt3_retro, membersFields.get(tt3_retro))
					.put(tt_3_dose, membersFields.get(tt_3_dose))
					.put(tt4_retro, membersFields.get(tt4_retro))
					.put(tt_4_dose, membersFields.get(tt_4_dose))
					.put(vaccines_2, membersFields.get(vaccines_2))
					.put(tt1, membersFields.get(tt1))
					.put(tt_1_dose_today, membersFields.get(tt_1_dose_today))
					.put(tt2, membersFields.get(tt2))
					.put(tt_2_dose_today, membersFields.get(tt_2_dose_today))
					.put(tt3, membersFields.get(tt3))
					.put(tt_3_dose_today, membersFields.get(tt_3_dose_today))
					.put(tt4, membersFields.get(tt4))
					.put(tt_4_dose_today, membersFields.get(tt_4_dose_today))
					.put(tt5, membersFields.get(tt5))
					.put(tt_5_dose_today, membersFields.get(tt_5_dose_today))
					.put(tt1_final, membersFields.get(tt1_final))
					.put(tt2_final, membersFields.get(tt2_final))
					.put(tt3_final, membersFields.get(tt3_final))
					.put(tt4_final, membersFields.get(tt4_final))
					.put(tt5_final, membersFields.get(tt5_final))	
					.put(child_vaccines_2, membersFields.get(child_vaccines_2))
					.put(Member_Reg_Date, membersFields.get(Member_Reg_Date))
					.put(Child_birth_date_known, membersFields.get(Child_birth_date_known))
					.put(Child_birth_date, membersFields.get(Child_birth_date))
					.put(Child_age, membersFields.get(Child_age))
					.put(Child_calc_age, membersFields.get(Child_calc_age))
					.put(Child_calc_dob, membersFields.get(Child_calc_dob))
					.put(Child_dob, membersFields.get(Child_dob))
					.put(Child_dob_estimated, membersFields.get(Child_dob_estimated))
					.put(Child_age_days, membersFields.get(Child_age_days))
					.put(Child_birth_date_note, membersFields.get(Child_birth_date_note))
					.put(Birth_Weigtht, membersFields.get(Birth_Weigtht))
					.put(Newborn_Care_Received, membersFields.get(Newborn_Care_Received))
					.put(Child_gender, membersFields.get(Child_gender))
					.put(Child_mother_name, membersFields.get(Child_mother_name))
					.put(Child_father_name, membersFields.get(Child_father_name))
					.put(Child_guardian_id, membersFields.get(Child_guardian_id))
					.put(Child_Mother_NID, membersFields.get(Child_Mother_NID))
					.put(Child_Mother_BRID, membersFields.get(Child_Mother_BRID))
					.put(Child_Father_NID, membersFields.get(Child_Father_NID))
					.put(Child_Father_BRID, membersFields.get(Child_Father_BRID))
					.put(Child_Other_Guardian_NID, membersFields.get(Child_Other_Guardian_NID))
					.put(Child_Other_Guardian_BRID, membersFields.get(Child_Other_Guardian_BRID))	
					.put(child_was_suffering_from_a_disease_at_birth, membersFields.get(child_was_suffering_from_a_disease_at_birth))
					.put(reminders_approval, membersFields.get(reminders_approval))
					.put(contact_phone_number, membersFields.get(contact_phone_number))
					.put(child_vaccines, membersFields.get(child_vaccines))
					.put(bcg_retro, membersFields.get(bcg_retro))
					.put(opv0_retro, membersFields.get(opv0_retro))
					.put(opv0_dose, membersFields.get(opv0_dose))
					.put(pcv1_retro, membersFields.get(pcv1_retro))
					.put(pcv1_dose, membersFields.get(pcv1_dose))
					.put(opv1_retro, membersFields.get(opv1_retro))
					.put(opv1_dose, membersFields.get(opv1_dose))
					.put(penta1_retro, membersFields.get(penta1_retro))
					.put(penta1_dose, membersFields.get(penta1_dose))
					.put(pcv2_retro, membersFields.get(pcv2_retro))
					.put(pcv2_dose, membersFields.get(pcv2_dose))
					.put(opv2_retro, membersFields.get(opv2_retro))
					.put(opv2_dose, membersFields.get(opv2_dose))
					.put(penta2_retro, membersFields.get(penta2_retro))
					.put(penta2_dose, membersFields.get(penta2_dose))
					.put(pcv3_retro, membersFields.get(pcv3_retro))
					.put(pcv3_dose, membersFields.get(pcv3_dose))
					.put(opv3_retro, membersFields.get(opv3_retro))
					.put(opv3_dose, membersFields.get(opv3_dose))
					.put(penta3_retro, membersFields.get(penta3_retro))
					.put(penta3_dose, membersFields.get(penta3_dose))
					.put(ipv_retro, membersFields.get(ipv_retro))
					.put(measles1_retro, membersFields.get(measles1_retro))
					.put(measles1_dose, membersFields.get(measles1_dose))
					.put(measles2_retro, membersFields.get(measles2_retro))
					.put(measles2_dose, membersFields.get(measles2_dose))
					.put(bcg, membersFields.get(bcg))
					.put(opv0, membersFields.get(opv0))
					.put(opv0_dose_today, membersFields.get(opv0_dose_today))
					.put(pcv1, membersFields.get(pcv1))
					.put(pcv1_dose_today, membersFields.get(pcv1_dose_today))
					.put(opv1, membersFields.get(opv1))
					.put(opv1_dose_today, membersFields.get(opv1_dose_today))
					.put(penta1, membersFields.get(penta1))
					.put(penta1_dose_today, membersFields.get(penta1_dose_today))
					.put(pcv2, membersFields.get(pcv2))
					.put(pcv2_dose_today, membersFields.get(pcv2_dose_today))
					.put(opv2, membersFields.get(opv2))
					.put(opv2_dose_today, membersFields.get(opv2_dose_today))
					.put(penta2, membersFields.get(penta2))
					.put(penta2_dose_today, membersFields.get(penta2_dose_today))
					.put(pcv3, membersFields.get(pcv3))
					.put(pcv3_dose_today, membersFields.get(pcv3_dose_today))
					.put(opv3, membersFields.get(opv3))
					.put(opv3_dose_today, membersFields.get(opv3_dose_today))
					.put(penta3, membersFields.get(penta3))
					.put(penta3_dose_today, membersFields.get(penta3_dose_today))
					.put(ipv, membersFields.get(ipv))
					.put(measles1, membersFields.get(measles1))
					.put(measles1_dose_today, membersFields.get(measles1_dose_today))
					.put(measles2, membersFields.get(measles2))
					.put(measles2_dose_today, membersFields.get(measles2_dose_today))
					.put(Is_woman, membersFields.get(Is_woman))
					.put(Is_child, membersFields.get(Is_child))
					.put(final_bcg, membersFields.get(final_bcg))
					.put(final_opv0, membersFields.get(final_opv0))
					.put(final_pcv1, membersFields.get(final_pcv1))
					.put(final_opv1, membersFields.get(final_opv1))
					.put(final_penta1, membersFields.get(final_penta1))
					.put(final_pcv2, membersFields.get(final_pcv2))
					.put(final_opv2, membersFields.get(final_opv2))
					.put(final_penta2, membersFields.get(final_penta2))
					.put(final_pcv3, membersFields.get(final_pcv3))
					.put(final_opv3, membersFields.get(final_opv3))
					.put(final_penta3, membersFields.get(final_penta3))
					.put(final_ipv, membersFields.get(final_ipv))
					.put(final_measles1, membersFields.get(final_measles1))
					.put(final_measles2, membersFields.get(final_measles2))
					.put(received_time, dateTime.format(today).toString()).map();
			
				if(membersFields.containsKey(REG_NO)){
					if(!membersFields.get(REG_NO).equalsIgnoreCase("") || membersFields.get(REG_NO) != null){
						houseHold.MEMBERDETAILS().add(members);
				  }
				}						
		}		
	}
	
	public String getEntityIdBybrnId(List<String> brnIdList)
	{
	   List<HouseHold> houseHolds =	allHouseHolds.findAllHouseHolds();
	   
	   if (houseHolds == null || houseHolds.isEmpty()) {
           return null;
       }
	   
	   for (HouseHold household : houseHolds)
	   {
		   for ( Map<String, String> members : household.MEMBERDETAILS()) 
		   {
			   if(brnIdList.contains(members.get("FWWOMBID")))
				   return household.caseId();
		   }
	   }
	   return null;
	}
	
}
