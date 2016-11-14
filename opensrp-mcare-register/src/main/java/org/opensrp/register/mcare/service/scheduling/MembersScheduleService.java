/**
 * @author Asifur
 */

package org.opensrp.register.mcare.service.scheduling;

import static java.text.MessageFormat.format;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.MemberScheduleConstants.*;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.DateTimeDuration.duration;

import org.joda.time.LocalDate;
import org.opensrp.dto.BeneficiaryType;
import org.opensrp.scheduler.HealthSchedulerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembersScheduleService {

	private static Logger logger = LoggerFactory.getLogger(MembersScheduleService.class.toString());
	private HealthSchedulerService scheduler;
	private ScheduleLogService scheduleLogService;
	
	@Autowired
	public MembersScheduleService(HealthSchedulerService scheduler,ScheduleLogService scheduleLogService)
	{
		this.scheduler = scheduler;	
		this.scheduleLogService = scheduleLogService;
	}
	
	public void enrollimmediateMembersVisit(String entityId,String provider,String date,String instanceId,String scheduleName,String ImmediateScheduleName) {       
        logger.info(format("Enrolling Members with Entity id:{0} to Members schedule immediate BNFVisit, milestone: {1}.", entityId, ImmediateScheduleName));
        scheduler.enrollIntoSchedule(entityId, ImmediateScheduleName, date);
        scheduleLogService.createImmediateScheduleAndScheduleLog(entityId, date, provider, instanceId, BeneficiaryType.members, scheduleName, duration, ImmediateScheduleName);
    }
	
	public void enrollAfterimmediateVisit(String caseId,String provider,String date,String instanceId,String scheduleName,String ImmediateScheduleName) {
		logger.info(format("Enrolling Members into schedule. Id: {0}", caseId));	    
		scheduler.enrollIntoSchedule(caseId, scheduleName, date);
		scheduleLogService.createNewScheduleLogandUnenrollImmediateSchedule(caseId, date, provider, instanceId, ImmediateScheduleName, scheduleName, BeneficiaryType.members, duration);
	}
	
	public void enrollWomanTTVisit(String entityId,String provider,String date,String scheduleName) {       
        logger.info(format("Enrolling Members with Entity id:{0} to Members schedule , milestone: {1}.", entityId, scheduleName));
        scheduler.enrollIntoSchedule(entityId, scheduleName, date);
  
    }
	
	public void enrollChildVisit(String entityId,String provider, String scheduleName, String date) {       
        logger.info(format("Enrolling Child with Entity id:{0} to schedule & milestone: {1}.", entityId, scheduleName));
        scheduler.enrollIntoSchedule(entityId, scheduleName, date);
  
    }
    
    public void unEnrollFromAllSchedules(String entityId) {
        scheduler.unEnrollFromAllSchedules(entityId);
    }

    public void unEnrollFromSchedule(String entityId, String anmId, String scheduleName) {
        logger.info(format("Un-enrolling Members with Entity id:{0} from schedule: {1}", entityId, scheduleName));
        scheduler.unEnrollFromSchedule(entityId, anmId, scheduleName);
    }
    
    public void unEnrollFromImmediateSchedule(String entityId, String anmId, String scheduleName, String ImmediateScheduleName) {
        logger.info(format("Un-enrolling Members with Entity id:{0} from schedule: {1}", entityId, scheduleName));
        scheduler.unEnrollFromImmediateSchedule(entityId, anmId, scheduleName, ImmediateScheduleName);
    }
    
    public void unEnrollAndCloseSchedule(String entityId, String anmId, String scheduleName, LocalDate completionDate) {
        logger.info(format("Un-enrolling Members with Entity id:{0} from schedule: {1}", entityId, scheduleName));
        scheduler.unEnrollAndCloseSchedule(entityId, anmId, scheduleName, completionDate);
    }
    
    public void unEnrollAndCloseImmediateSchedule(String entityId, String anmId, String scheduleName,String ImmediateScheduleName, LocalDate completionDate) {
        logger.info(format("Un-enrolling Members with Entity id:{0} from schedule: {1}", entityId, scheduleName));
        scheduler.unEnrollAndCloseImmediateSchedule(entityId, anmId, scheduleName, ImmediateScheduleName, completionDate);
    }
    
    public void fullfillMilestone(String entityId, String providerId, String scheduleName,LocalDate completionDate ){
    	try{
    		scheduler.fullfillMilestone(entityId, providerId, scheduleName, completionDate);
    		logger.info("fullfillMilestone with id: :"+entityId);
    	}catch(Exception e){
    		logger.info("Does not a fullfillMilestone :"+e.getMessage());
    	}
    }

}

