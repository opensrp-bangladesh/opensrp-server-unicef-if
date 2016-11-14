package org.opensrp.scheduler.service;

import static org.opensrp.dto.BeneficiaryType.members;
import static org.opensrp.dto.BeneficiaryType.household;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.motechproject.util.DateUtil;
import org.opensrp.common.AllConstants;
import org.opensrp.common.AllConstants.ScheduleNames;
import org.opensrp.domain.Vaccine;
import org.opensrp.dto.ActionData;
import org.opensrp.dto.AlertStatus;
import org.opensrp.dto.BeneficiaryType;
import org.opensrp.repository.AllVaccine;
import org.opensrp.scheduler.Action;
import org.opensrp.scheduler.repository.AllActions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionService {
    private AllActions allActions;
    private ReportActionService reportActionService;
    private final ScheduleService scheduleService;
    private AllVaccine allVaccine;
    private static Logger logger = LoggerFactory.getLogger(ActionService.class
			.toString());    
    
    @Autowired
    public ActionService(AllActions allActions, ReportActionService reportActionService,ScheduleService scheduleService,AllVaccine allVaccine) {
        this.allActions = allActions;
        this.reportActionService = reportActionService;
        this.scheduleService = scheduleService;
        this.allVaccine = allVaccine;
    }    

	public List<Action> getNewAlertsForANM(String anmIdentifier, long timeStamp) {
        return allActions.findByANMIDAndTimeStamp(anmIdentifier, timeStamp);
    }

    public List<Action> findByCaseIdScheduleAndTimeStamp(String caseId, String schedule, DateTime start, DateTime end) {
		return allActions.findByCaseIdScheduleAndTimeStamp(caseId, schedule, start, end);
	}
    public void alertForBeneficiary(BeneficiaryType beneficiaryType, String caseID, String instanceId,  String anmIdentifier, String scheduleName, String visitCode, AlertStatus alertStatus, DateTime startDate, DateTime expiryDate) {
    	if (!(household.equals(beneficiaryType) || members.equals(beneficiaryType))) {
            throw new IllegalArgumentException("Beneficiary Type : " + beneficiaryType + " is of unknown type");
        }
    	else if(scheduleName.equals(ScheduleNames.ANC) || scheduleName.equals(ScheduleNames.PNC) || scheduleName.equals(ScheduleNames.CHILD)){
    		this.ActionUpdateOrCreateForMotherType(beneficiaryType, caseID, instanceId, anmIdentifier, scheduleName, visitCode, alertStatus, startDate, expiryDate);   		
    	}
    	else{    		
    		this.ActionUpdateOrCreateForOther(beneficiaryType, caseID, instanceId, anmIdentifier, scheduleName, visitCode, alertStatus, startDate, expiryDate);
    	}
    	
    }

    public void markAllAlertsAsInactive(String entityId) {
        allActions.markAllAsInActiveFor(entityId);
    }

    public void markAlertAsInactive(String anmId, String entityId, String scheduleName) {
        allActions.markAlertAsInactiveFor(anmId, entityId, scheduleName);
    }

    public void markAlertAsClosed(String caseId, String anmIdentifier, String visitCode, String completionDate) {
        allActions.add(new Action(caseId, anmIdentifier, ActionData.markAlertAsClosed(visitCode, completionDate)));
    }
    
    public void closeBeneficiary(BeneficiaryType beneficiary, String caseId, String anmIdentifier, String reasonForClose) {
        allActions.add(new Action(caseId, anmIdentifier, ActionData.closeBeneficiary(beneficiary.name(), reasonForClose)));
    }

    public void reportForIndicator(String anmIdentifier, ActionData actionData) {
        allActions.add(new Action("", anmIdentifier, actionData));
    }

    public void deleteReportActions() {
        allActions.deleteAllByTarget("report");
    }
    public void ActionUpdateOrCreateForOther(BeneficiaryType beneficiaryType, String caseID, String instanceId,  String anmIdentifier, String scheduleName, String visitCode, AlertStatus alertStatus, DateTime startDate, DateTime expiryDate){
    	try{
    		System.err.println("Schedule:"+anmIdentifier + " - "+ caseID+" -- "+ scheduleName);
	    	List<Action> existingAlerts = allActions.findAlertByANMIdEntityIdScheduleName(anmIdentifier, caseID, scheduleName);
	    	System.err.println("Schedule:"+existingAlerts.toString());
	    	if(existingAlerts.size() > 0){ 
	    		long beforTimeStamp = existingAlerts.get(0).timestamp();
	        	Map<String,String> data =existingAlerts.get(0).data(); 	      
		 	     if(!data.get("alertStatus").equals(alertStatus)){
		 	    	 this.updateDataForAction(beneficiaryType, caseID, instanceId, anmIdentifier, scheduleName, visitCode, alertStatus, startDate, expiryDate, existingAlerts);
		 	      }else{
		 	    	 existingAlerts.get(0).setRevision(existingAlerts.get(0).getRevision());
		 	    	 existingAlerts.get(0).timestamp(Calendar.getInstance().getTimeInMillis()); 	    	 
		 	    	 existingAlerts.get(0).data().put("visitCode", visitCode);
		 	    	 existingAlerts.get(0).data().put("expiryDate", expiryDate.toLocalDate().toString());
		 	    	 existingAlerts.get(0).data().put("startDate", startDate.toLocalDate().toString());
		 	    	 existingAlerts.get(0).timestamp(Calendar.getInstance().getTimeInMillis());
		 	    	 Action action = existingAlerts.get(0); 	    	 
		 	    	 allActions.update(action);
		 	    	
		 	      } 	      
		 	     List<Action> existingAlert = allActions.findAlertByANMIdEntityIdScheduleName(anmIdentifier, caseID, scheduleName);
		 	    try{
		 	    	if(scheduleName.equalsIgnoreCase(AllConstants.ScheduleNames.CENCUS)){		 	    		
		 	    	}else if(scheduleName.equalsIgnoreCase(AllConstants.ScheduleNames.SCHEDULE_Woman_BNF)){		 	    		
		 	    	}else{
		 	    		System.err.println("scheduleName:"+scheduleName);
		 	    		Vaccine vaccine = new Vaccine(anmIdentifier, caseID, existingAlert.get(0).getId(), beneficiaryType.name(), scheduleName, startDate.toLocalDate().toString(), expiryDate.toLocalDate().toString(), false, 0, new Date(), new DateTime(),DateUtil.now().getMillis());		        	
		        		allVaccine.save(vaccine);
		 	    	}
	        	}catch(Exception e){		        		
	        		e.printStackTrace();
	        	}
		 	     reportActionService.updateScheduleLog(beneficiaryType, caseID, instanceId, anmIdentifier, scheduleName, visitCode, alertStatus, startDate, expiryDate, null,null,beforTimeStamp,existingAlert.get(0).timestamp());
		 	     logger.info("Update schedule with id: "+scheduleName);
		 	     
	    	}else{
	    		
	    		if(!instanceId.equalsIgnoreCase(null) || !instanceId.isEmpty()){
	    			
		        	allActions.addOrUpdateAlert(new Action(caseID, anmIdentifier, ActionData.createAlert(beneficiaryType, scheduleName, visitCode, alertStatus, startDate, expiryDate)));
		        	
		        	List<Action> existingAlert = allActions.findAlertByANMIdEntityIdScheduleName(anmIdentifier, caseID, scheduleName);
		        	try{
		        		if(scheduleName.equalsIgnoreCase(AllConstants.ScheduleNames.CENCUS)){		 	    		
			 	    	}else if(scheduleName.equalsIgnoreCase(AllConstants.ScheduleNames.SCHEDULE_Woman_BNF)){		 	    		
			 	    	}else{
			 	    		System.err.println("scheduleName:"+scheduleName);
			 	    		Vaccine vaccine = new Vaccine(anmIdentifier, caseID, existingAlert.get(0).getId(), beneficiaryType.name(), scheduleName, startDate.toLocalDate().toString(), expiryDate.toLocalDate().toString(), false, 0, new Date(), new DateTime(),DateUtil.now().getMillis());		        	
			        		allVaccine.save(vaccine);
			 	    	}
		        	}catch(Exception e){		        		
		        		e.printStackTrace();
		        	}		        	
		        	reportActionService.updateScheduleLog(beneficiaryType, caseID, instanceId, anmIdentifier, scheduleName, visitCode, alertStatus, startDate, expiryDate, null,null,0L,existingAlert.get(0).timestamp());
		        	logger.info("Create schedule with id: "+scheduleName);
	    		}
	    	} 
    	}catch(Exception e){
    		e.printStackTrace();
    		
    	}
    	
    	
    }
    
    public void ActionUpdateOrCreateForMotherType(BeneficiaryType beneficiaryType, String caseID, String instanceId,  String anmIdentifier, String scheduleName, String visitCode, AlertStatus alertStatus, DateTime startDate, DateTime expiryDate){
    	
    	try{
	    	List<Action> existingAlerts = allActions.findAlertByANMIdEntityIdScheduleName(anmIdentifier, caseID, scheduleName);
	    	if(existingAlerts.size() > 0){ 
	    		long beforTimeStamp = existingAlerts.get(0).timestamp();
	        	Map<String,String> data =existingAlerts.get(0).data();
	        	long numOfDays =  this.getDaysDifference(expiryDate);
	        	if(numOfDays <=2  && alertStatus.name().equalsIgnoreCase("urgent")){
	    			scheduleService.fulfillMilestone(caseID, scheduleName, new LocalDate());
	    				
	    		  }else{
	    			logger.info("Date diffrenece required less or equal 2")	;
	    		 }
	     	     
	        	logger.info("alertStatus.name():"+alertStatus.name()+"visitCode: "+visitCode+"data.get(visitCode): "+data.get("visitCode"));
	 	      if(!data.get("visitCode").equalsIgnoreCase(visitCode)){ 	    	  
	 	    	  this.updateDataForAction(beneficiaryType, caseID, instanceId, anmIdentifier, scheduleName, visitCode, alertStatus, startDate, expiryDate, existingAlerts);
	 	    	  
	 	      }else if(data.get("visitCode").equalsIgnoreCase(visitCode)){
	 	    	  if(!data.get("alertStatus").equals(alertStatus)){
	 	    		  	existingAlerts.get(0).setRevision(existingAlerts.get(0).getRevision());
		 	    	   	existingAlerts.get(0).data().put("alertStatus", alertStatus.toString());
		 	    	   	existingAlerts.get(0).data().put("expiryDate", expiryDate.toLocalDate().toString());
		 	    	   	existingAlerts.get(0).data().put("startDate", startDate.toLocalDate().toString());
		 	    	   	existingAlerts.get(0).data().put("visitCode", visitCode);
		 	    	   	existingAlerts.get(0).timestamp(Calendar.getInstance().getTimeInMillis()); 	    	  
		 	    	   	Action action = existingAlerts.get(0);
		 	    	   	allActions.update(action);
	 	    	  }else{
		 	    	 existingAlerts.get(0).setRevision(existingAlerts.get(0).getRevision());
		 	    	 existingAlerts.get(0).timestamp(Calendar.getInstance().getTimeInMillis()); 	    	 
		 	    	 existingAlerts.get(0).data().put("visitCode", visitCode);
		 	    	 existingAlerts.get(0).data().put("expiryDate", expiryDate.toLocalDate().toString());
		 	    	 existingAlerts.get(0).data().put("startDate", startDate.toLocalDate().toString());
		 	    	 
		 	    	 Action action = existingAlerts.get(0); 	    	 	    	 
		 	    	 allActions.update(action);
	 	    	  }
	 	      }else{
	 	    	  
	 	      }
	 	      
	 	     List<Action> existingAlert = allActions.findAlertByANMIdEntityIdScheduleName(anmIdentifier, caseID, scheduleName);
	 	     reportActionService.updateScheduleLogMotherType(beneficiaryType, caseID, instanceId, anmIdentifier, scheduleName, visitCode, alertStatus, startDate, expiryDate, null,null,beforTimeStamp,existingAlert.get(0).timestamp());
	 	     logger.info("Update  schedule with id: "+caseID);
	        }else{
	        	if(!instanceId.equalsIgnoreCase(null) || !instanceId.isEmpty()){
		        	allActions.addOrUpdateAlert(new Action(caseID, anmIdentifier, ActionData.createAlert(beneficiaryType, scheduleName, visitCode, alertStatus, startDate, expiryDate)));
		        	List<Action> existingAlert = allActions.findAlertByANMIdEntityIdScheduleName(anmIdentifier, caseID, scheduleName);
			 	    reportActionService.updateScheduleLogMotherType(beneficiaryType, caseID, instanceId, anmIdentifier, scheduleName, visitCode, alertStatus, startDate, expiryDate, null,null,0L,existingAlert.get(0).timestamp());
		        	logger.info("Create schedule with id: "+caseID);
	        	}
	        } 
    	}catch(Exception e){
    		logger.info(e.getMessage());
    	}
    }
    
    public void updateDataForAction(BeneficiaryType beneficiaryType, String caseID, String instanceId,  String anmIdentifier, String scheduleName, String visitCode, AlertStatus alertStatus, DateTime startDate, DateTime expiryDate,List<Action> existingAlerts){
    	existingAlerts.get(0).setRevision(existingAlerts.get(0).getRevision());
	   	existingAlerts.get(0).data().put("alertStatus", alertStatus.toString());
	   	existingAlerts.get(0).data().put("expiryDate", expiryDate.toLocalDate().toString());
	   	existingAlerts.get(0).data().put("startDate", startDate.toLocalDate().toString());
	   	existingAlerts.get(0).data().put("visitCode", visitCode);
	   	existingAlerts.get(0).markAsActive();
	   	existingAlerts.get(0).timestamp(Calendar.getInstance().getTimeInMillis()); 	    	  
	   	Action action = existingAlerts.get(0);
	   	allActions.update(action);
    }
    
   
    
   public long getDaysDifference(DateTime expiryDate){
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
   	   Date today = Calendar.getInstance().getTime();
   	   //DateTime expiryDates = new DateTime(today).minus(24);
   	   long days = 0;
	   try {
	   	 Date expiredDate = format.parse(expiryDate.toString());
	   	 String todayDate = format.format(today);
	   	 Date today_date = format.parse(todayDate);
	   	 long diff = expiredDate.getTime() - today_date.getTime();
	   	 days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	    } catch (ParseException e) {
	   		// TODO Auto-generated catch block
	   		e.printStackTrace();
	   }
	   return days;
   }
   
   public long getActionTimestamp(String anmIdentifier, String caseID, String scheduleName){
	   List<Action> existingAlerts = allActions.findAlertByANMIdEntityIdScheduleName(anmIdentifier, caseID, scheduleName);
	   return existingAlerts.get(0).timestamp();
   }
}