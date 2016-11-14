package org.opensrp.connector.openmrs.constants;

import org.ict4h.atomfeed.client.AtomFeedProperties;

public class OpenmrsConstants {

	public static final String SCHEDULER_TRACKER_SYNCER_SUBJECT = "OpenMRS Scheduler Tracker Syncer";
	public static final String ENROLLMENT_TRACK_UUID = "openmrsTrackUuid";
	
	public static final String SCHEDULER_OPENMRS_ATOMFEED_SYNCER_SUBJECT_CLIENT = "OpenMRS Atomfeed Syncer";
	public static final String ATOMFEED_URL = "ws/atomfeed";
    public static final String ATOMFEED_DATABASE_CONNECTOR = "atomfeedDatabaseConnector";
    public static final String SCHEDULER_OPENMRS_ATOMFEED_SYNCER_SUBJECT_EVENT = "OpenMRS Atomfeed Syncer Event";
    
	public enum ScheduleTrackerConfig {
		openmrs_syncer_last_timestamp_non_active_enrollment,
		openmrs_syncer_sync_by_last_update_enrollment,
		openmrs_syncer_sync_status,
		openmrs_syncer_sync_timestamp
	}
	
	public interface OpenmrsEntity {
		public String entity();
		public String entityId();
		
	}
	
	public enum Person implements OpenmrsEntity{
		first_name,
		middle_name,
		last_name,
		gender,
		birthdate,
		birthdate_estimated,
		dead,
		deathdate,
		deathdate_estimated;
		
		public String entity(){return "person";}
		public String entityId(){return this.name();}
	}
	
	public enum PersonAddress implements OpenmrsEntity{
		;
		public String entity(){return "person_address";}
		public String entityId(){return this.name();}
	}
	
	public enum Encounter implements OpenmrsEntity{
		encounter_date,
		location_id,
		encounter_start,
		encounter_end;
		
		public String entity(){return "encounter";}
		public String entityId(){return this.name();}
	}
	public static AtomFeedProperties DEFUALT_ATOM_FEED_PROPERTIES = new AtomFeedProperties();
}