package org.opensrp.scheduler.service;

import static java.util.Arrays.asList;
import static org.joda.time.LocalDate.parse;
import static org.joda.time.LocalTime.now;
import static org.motechproject.scheduletracking.api.domain.EnrollmentStatus.ACTIVE;
import static org.opensrp.common.util.DateUtil.today;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.motechproject.model.Time;
import org.motechproject.scheduletracking.api.domain.Enrollment;
import org.motechproject.scheduletracking.api.domain.Milestone;
import org.motechproject.scheduletracking.api.domain.Schedule;
import org.motechproject.scheduletracking.api.repository.AllSchedules;
import org.motechproject.scheduletracking.api.service.EnrollmentRecord;
import org.motechproject.scheduletracking.api.service.EnrollmentRequest;
import org.motechproject.scheduletracking.api.service.EnrollmentsQuery;
import org.motechproject.scheduletracking.api.service.ScheduleTrackingService;
import org.opensrp.scheduler.HealthSchedulerService.MetadataField;
import org.opensrp.scheduler.Schedule.ActionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    private final ScheduleTrackingService scheduleTrackingService;
    private final AllSchedules allSchedules;
    private final AllEnrollmentWrapper allEnrollments;
    private int preferredTimeHH;
    private int preferredTimeMM;
    private int preferredTime;
    @Autowired
    public ScheduleService(ScheduleTrackingService scheduleTrackingService, AllSchedules allSchedules, @Value("#{opensrp['preferred.time.hh']}") int preferredTimeHH, @Value("#{opensrp['preferred.time.mm']}") int preferredTimeMM,
    		@Value("#{opensrp['preferred.time']}") int preferredTime,AllEnrollmentWrapper allEnrollments) {
        this.scheduleTrackingService = scheduleTrackingService;
        this.allSchedules = allSchedules;
        this.preferredTimeHH = preferredTimeHH;
        this.preferredTimeMM = preferredTimeMM;
        this.allEnrollments = allEnrollments;
        this.preferredTime = preferredTime;
    }

    public void enroll(String entityId, String scheduleName, String referenceDate) {
        String startingMilestoneName = getStartingMilestoneName(scheduleName, parse(referenceDate));
        EnrollmentRequest request = new EnrollmentRequest(entityId, scheduleName, new Time(new LocalTime(preferredTimeHH, preferredTimeMM)),
                parse(referenceDate), null, null, null, startingMilestoneName, null);
        scheduleTrackingService.enroll(request);
    }

    private String getStartingMilestoneName(String name, LocalDate referenceDate) {
        Schedule schedule = allSchedules.getByName(name);
        for (Milestone milestone : schedule.getMilestones()) {
            if (referenceDate.plus(milestone.getMaximumDuration()).isAfter(today()))
                return milestone.getName();
        }
        return null;
    }

    public void enroll(String entityId, String scheduleName, String milestone, String referenceDate) {
        EnrollmentRequest request = new EnrollmentRequest(entityId, scheduleName,
                new Time(new LocalTime(preferredTimeHH, preferredTimeMM)), parse(referenceDate), null, null, null, milestone, null);
        scheduleTrackingService.enroll(request);
    }
    public void enroll(String entityId, String scheduleName, String milestone, String referenceDate, String formSubmissionId) {
    	EnrollmentRequest request = new EnrollmentRequest(entityId, scheduleName,
                new Time(new LocalTime(preferredTime, 0)), parse(referenceDate), null, null, null, milestone, addOrUpdateEventTrackMetadata(null, formSubmissionId, ActionType.enroll));
        scheduleTrackingService.enroll(request);
    }
    
    public void fulfillMilestone(String entityId, String scheduleName, LocalDate completionDate) {
    	scheduleTrackingService.fulfillCurrentMilestone(entityId, scheduleName, completionDate, new Time(now()));
    }
    public void fulfillMilestone(String entityId, String scheduleName, LocalDate completionDate, String formSubmissionId) {
    	updateExistingEnrollmentWithEventTrackMetadata(entityId, scheduleName, formSubmissionId, ActionType.fulfill);
    	scheduleTrackingService.fulfillCurrentMilestone(entityId, scheduleName, completionDate, new Time(now()));
    }
    
    public void unenroll(String entityId, String scheduleName) {
    	scheduleTrackingService.unenroll(entityId, asList(scheduleName));
	}
    
    public void unenroll(String entityId, List<String> schedules) {
    	scheduleTrackingService.unenroll(entityId, schedules);
	}
    public void unenroll(String entityId, String scheduleName, String formSubmissionId) {
    	updateExistingEnrollmentWithEventTrackMetadata(entityId, scheduleName, formSubmissionId, ActionType.unenroll);
    	scheduleTrackingService.unenroll(entityId, asList(scheduleName));
	}
    public void unenroll(String entityId, List<String> schedules, String formSubmissionId) {
    	for (String schedule : schedules) {
    		updateExistingEnrollmentWithEventTrackMetadata(entityId, schedule, formSubmissionId, ActionType.unenroll);
		}
    	scheduleTrackingService.unenroll(entityId, schedules);
	}
    public List<EnrollmentRecord> findOpenEnrollments(String entityId) {
        return scheduleTrackingService.search(new EnrollmentsQuery().havingExternalId(entityId).havingState(ACTIVE));
	}
    
    public List<Enrollment> findEnrollmentByStatusAndEnrollmentDate(String status, DateTime start, DateTime end) {
        return allEnrollments.findByEnrollmentDate(status, start, end);
	}
    public List<Enrollment> findEnrollmentByLastUpDate(DateTime start, DateTime end) {
        return allEnrollments.findByLastUpDate(start, end);
	}
    public void updateEnrollmentWithMetadata(String enrollmentId, String key, String value) {
    	Enrollment e = allEnrollments.get(enrollmentId);
    	e.getMetadata().put(key, value);
    	allEnrollments.update(e);

	}
    public List<String> findOpenEnrollmentNames(String entityId) {
    	List<EnrollmentRecord> openEnrollments = findOpenEnrollments(entityId);
    	List<String> openSchedules = new ArrayList<>();
		for (EnrollmentRecord enrollment : openEnrollments ) {
			openSchedules.add(enrollment.getScheduleName());
        }
		
		return openSchedules;
	}
    
    public EnrollmentRecord getEnrollment(String entityId, String scheduleName) {
        return scheduleTrackingService.getEnrollment(entityId, scheduleName);
	}
    private Map<String, String> addOrUpdateLastUpdateMetadata(Map<String, String> map) {
		if(map == null){
			map = new HashMap<>();
		}
		
		map.put("lastUpdate", new DateTime().toString());
		return map;
	}
    private void updateExistingEnrollmentWithLastUpdateMetadata(String entityId, String scheduleName){
    	Enrollment enr = allEnrollments.getActiveEnrollment(entityId, scheduleName);
    	enr.setMetadata(addOrUpdateLastUpdateMetadata(enr.getMetadata()));
    	allEnrollments.update(enr);
    }
    
    private Map<String, String> addOrUpdateEventTrackMetadata(Map<String, String> map, String formSubmissionId, ActionType actionType) {
		if(map == null){
			map = new HashMap<>();
		}
		
		map.put(MetadataField.lastUpdate.name(), new DateTime().toString());
		
		if(actionType.equals(ActionType.enroll)){
			map.put(MetadataField.enrollmentFormSubmission.name(), formSubmissionId);
		}
		else if(actionType.equals(ActionType.fulfill)){
			map.put(MetadataField.fulfillmentFormSubmission.name(), formSubmissionId);
		}
		else if(actionType.equals(ActionType.unenroll)){
			map.put(MetadataField.unenrollmentFormSubmission.name(), formSubmissionId);
		}
		return map;
	}
    private void updateExistingEnrollmentWithEventTrackMetadata(String entityId, String scheduleName, String formSubmissionId, ActionType actionType){
    	Enrollment enr = allEnrollments.getActiveEnrollment(entityId, scheduleName);
    	enr.setMetadata(addOrUpdateEventTrackMetadata(enr.getMetadata(), formSubmissionId, actionType));
    	allEnrollments.update(enr);
    }
}
