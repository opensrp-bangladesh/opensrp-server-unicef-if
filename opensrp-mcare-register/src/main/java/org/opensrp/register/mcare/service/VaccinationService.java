/**
 * @author proshanto
 * */
package org.opensrp.register.mcare.service;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.motechproject.util.DateUtil;
import org.opensrp.common.AllConstants;
import org.opensrp.domain.Vaccine;
import org.opensrp.repository.AllVaccine;
import org.opensrp.scheduler.Action;
import org.opensrp.scheduler.repository.AllActions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VaccinationService {
	
	private static Logger logger = LoggerFactory.getLogger(VaccinationService.class
		.toString());
	public VaccinationService(){
		
	}
	private AllActions allActions;
    private AllVaccine allVaccine;
    @Autowired
    public VaccinationService(AllActions allActions,AllVaccine allVaccine){
    	this.allVaccine = allVaccine;
    	this.allActions = allActions;
    	
	}
    
    @Autowired
    public void setAllVaccine(AllVaccine allVaccine) {
    	this.allVaccine = allVaccine;
    }
	@Autowired
    public void setAllActions(AllActions allActions) {
    	this.allActions = allActions;
    }
	
    public void saveVaccine(String anmIdentifier,String caseID,String scheduleName){
    	List<Action> existingAlert = allActions.findAlertByANMIdEntityIdScheduleName(anmIdentifier, caseID, scheduleName);
	 	try{
	 		if(scheduleName.equalsIgnoreCase(AllConstants.ScheduleNames.CENCUS)) {
	 		}else if(scheduleName.equalsIgnoreCase(AllConstants.ScheduleNames.SCHEDULE_Woman_BNF)){
	 		}else{
	     		Vaccine vaccine = new Vaccine(existingAlert.get(0).anmIdentifier(), existingAlert.get(0).caseId(), existingAlert.get(0).getId(), 
	     			existingAlert.get(0).data().get("beneficiaryType"), existingAlert.get(0).data().get("scheduleName"),  existingAlert.get(0).data().get("startDate"), existingAlert.get(0).data().get("expiryDate"), false, 0, new Date(), new DateTime(),DateUtil.now().getMillis());		        	
	     		allVaccine.save(vaccine);
	 		}
     	}catch(Exception e){		        		
     		e.printStackTrace();
     	}
    }
	public void updateVaccineStatus( String caseId, String vaccineName) {	    
    	try{
    		System.err.println(caseId);
    		System.err.println(vaccineName);
    		Vaccine existingVaccine = allVaccine.getVaccine(caseId,vaccineName);    		
    		existingVaccine.setStatus(true);
    		existingVaccine.setExecutionDate(new DateTime());
    		existingVaccine.setId(existingVaccine.getId());
    		existingVaccine.setRevision(existingVaccine.getRevision());
    		allVaccine.update(existingVaccine);
    	}catch(Exception e){		        		
    		e.printStackTrace();
    	}
    }
	public void updateVaccineMissedCount(String health_assistant, String caseId, String vaccineName) {	    
    	try{
    		
    		Vaccine existingVaccine = allVaccine.getVaccine(caseId,vaccineName);
    		int missedCount = existingVaccine.getMissedCount()+1;
    		existingVaccine.setMissedCount(missedCount);    		
    		existingVaccine.setId(existingVaccine.getId());
    		existingVaccine.setRevision(existingVaccine.getRevision());
    		existingVaccine.setTimeStamp(DateUtil.now().getMillis());
    		allVaccine.update(existingVaccine);
    		logger.info("Vacine updated caseID : "+ caseId +" vaccineName:"+ vaccineName);
    	}catch(Exception e){		        		
    		e.printStackTrace();
    	}
    }
	
	
}
