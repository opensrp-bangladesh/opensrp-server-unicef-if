package org.opensrp.repository;

import java.util.List;

import org.ektorp.ComplexKey;
import org.ektorp.CouchDbConnector;
import org.ektorp.support.GenerateView;
import org.ektorp.support.View;
import org.joda.time.DateTime;
import org.motechproject.dao.MotechBaseRepository;
import org.opensrp.common.AllConstants;
import org.opensrp.domain.Vaccine;
import org.opensrp.scheduler.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class AllVaccine extends MotechBaseRepository<Vaccine> {
	
	private static Logger logger = LoggerFactory.getLogger(AllVaccine.class.toString());
	
	@Autowired
	public AllVaccine(@Value("#{opensrp['couchdb.atomfeed-db.revision-limit']}") int revisionLimit,
	                     @Qualifier(AllConstants.OPENSRP_DATABASE_CONNECTOR) CouchDbConnector db) {
		super(Vaccine.class, db);
		this.db.setRevisionLimit(revisionLimit);
	}
	
	@GenerateView
	private List<Vaccine> findByClientId(String caseId) {
		return queryView("by_clientId", caseId);
	}
	
	@View(name = "by_client_and_vaccine", map = "function(doc) { if (doc.type === 'Vaccine' && doc.clientId) { emit([doc.clientId,doc.vaccineName], doc); } }")
	public Vaccine getVaccine(String client,String vaccineName){
		ComplexKey ckey = ComplexKey.of(client, vaccineName);
		List<Vaccine> vaccine = db.queryView(createQuery("by_client_and_vaccine").key(ckey).includeDocs(true), Vaccine.class);
		if (vaccine == null || vaccine.isEmpty()) {			
			return null;
		}
		return vaccine.get(0);
		
	}
	
	@View(name = "action_by_caseId_and_schedule_and_time", map = "function(doc) { if (doc.type === 'Vaccine' && doc.clientId) { emit([doc.clientId, doc.vaccineName, doc.timeStamp], null); } }")
	public Vaccine findByCaseIdScheduleAndTimeStamp(String caseId, String schedule, long timeStamp) {
	    ComplexKey startKey = ComplexKey.of(caseId, schedule, timeStamp + 1);	   
	    ComplexKey endKey = ComplexKey.of(caseId, schedule, Long.MAX_VALUE);
	    List<Vaccine> vaccine = db.queryView(createQuery("action_by_caseId_and_schedule_and_time").startKey(startKey).endKey(endKey).includeDocs(true), Vaccine.class);
	    if (vaccine == null || vaccine.isEmpty()) {			
			return null;
		}
		return vaccine.get(0);
	}
	 
	public void save(Vaccine vaccine) {
		System.err.println("dd");
		Vaccine existingVaccine = getVaccine(vaccine.getClientId(),vaccine.getVaccineName());
		if(existingVaccine == null){
			try{
				add(vaccine);
			}catch(Exception ex){
				logger.info("Vaccine save Error:"+ex.getMessage());
			}
		}else{
			
		}		
	}
	
}
