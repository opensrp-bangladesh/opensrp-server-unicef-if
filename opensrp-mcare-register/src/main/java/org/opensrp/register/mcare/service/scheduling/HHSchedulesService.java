package org.opensrp.register.mcare.service.scheduling;

import static java.text.MessageFormat.format;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.HHSchedulesConstants.HH_SCHEDULE_CENSUS;

import org.opensrp.scheduler.HealthSchedulerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HHSchedulesService {
	
	private static Logger logger = LoggerFactory.getLogger(HHSchedulesService.class.toString());
	
	private HealthSchedulerService scheduler;
	
	@Autowired
	public HHSchedulesService(HealthSchedulerService scheduler)
	{
		this.scheduler = scheduler;
	}

	public void enrollIntoMilestoneOfCensus(String entityId, String date,String provider,String instanceId)
	{
	    logger.info(format("Enrolling household into Census schedule. Id: {0}", entityId));	    
		scheduler.enrollIntoSchedule(entityId, HH_SCHEDULE_CENSUS, date);	
	}
	
}