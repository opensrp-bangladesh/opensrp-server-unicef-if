package org.opensrp.camp.repository;

import java.util.List;

import org.ektorp.ComplexKey;
import org.ektorp.CouchDbConnector;
import org.ektorp.support.View;
import org.motechproject.dao.MotechBaseRepository;
import org.opensrp.camp.dao.Camp;
import org.opensrp.camp.dao.CampDate;
import org.opensrp.common.AllConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class CampDateRepository extends MotechBaseRepository<CampDate> {
	
	private static Logger logger = LoggerFactory.getLogger(CampDateRepository.class);
	
	@Autowired
	public CampDateRepository(@Value("#{opensrp['couchdb.atomfeed-db.revision-limit']}") int revisionLimit,
	    @Qualifier(AllConstants.OPENSRP_DATABASE_CONNECTOR) CouchDbConnector db) {
		super(CampDate.class, db);
		this.db.setRevisionLimit(revisionLimit);
	}
	
	@View(name = "by_session_id", map = "function(doc) { if (doc.type === 'CampDate' && doc._id) { emit(doc.session_id, doc); } }")
	public List<CampDate> findBySessionId(String session_id) {
		List<CampDate> campDates = db.queryView(createQuery("by_session_id").key(session_id).includeDocs(true), CampDate.class);
		return campDates;
	}
	
	@View(name = "by_session_name_and_health_assistant", map = "function(doc) { if (doc.type === 'CampDate' && doc.health_assistant) { emit([doc.session_name,doc.health_assistant], doc); } }")
	public CampDate findBySessionName(String session_name,String health_assistant) {	
		ComplexKey ckey = ComplexKey.of(session_name, health_assistant);
		List<CampDate> camps = db.queryView(createQuery("by_session_name_and_health_assistant").key(ckey).includeDocs(true), CampDate.class);
		if (camps == null || camps.isEmpty()) {			
			return null;
		}
		return camps.get(0);
	}
	
	@View(name = "by_id", map = "function(doc) { if (doc.type === 'CampDate' && doc._id) { emit(doc._id, doc); } }")
	public CampDate findById(String id) {		
		List<CampDate> camp = db.queryView(createQuery("by_id").key(id).includeDocs(true), CampDate.class);
		if (camp == null || camp.isEmpty()) {
			return null;
		}
		return camp.get(0);
	}
	
	@View(name = "by_TimeStamp", map = "function(doc) { if (doc.type === 'CampDate' && doc._id && doc.status=='Active') { emit(doc.timestamp, doc); } }")
	public List<CampDate> findByTimeStamp(long date) {		
		List<CampDate> camp = db.queryView(createQuery("by_TimeStamp").key(date).includeDocs(true), CampDate.class);
		if (camp == null || camp.isEmpty()) {
			return null;
		}
		return camp;
	}
	@View(name = "by_TimeStamp_Health_Assistant", map = "function(doc) { if (doc.type === 'CampDate' && doc._id && doc.status=='Active') { emit([doc.timestamp,doc.health_assistant], doc); } }")
	public List<CampDate> findByTimeStampByHealthAssistant(long date,String HealthAssistant) {
		ComplexKey ckey = ComplexKey.of(date, HealthAssistant);
		List<CampDate> camp = db.queryView(createQuery("by_TimeStamp_Health_Assistant").key(ckey).includeDocs(true), CampDate.class);
		if (camp == null || camp.isEmpty()) {
			return null;
		}
		return camp;
	}
	
	@View(name = "all_camp_with_username", map = "function(doc) { if (doc.type === 'CampDate' && doc.username) { emit(doc._id,doc); } }")
		public List<CampDate> getAllCamp() {
			return db.queryView(
					createQuery("all_camp_with_user")
							.includeDocs(true), CampDate.class);
			
		}
	@View(name = "search", map = "function(doc) { if (doc.type === 'CampDate') { emit([doc.thana,doc.union,doc.ward,doc.unit,doc.health_assistant], doc); } }")
	public List<CampDate> search(String thana,String union,String ward,String unit,String healthAssistant) {
		Object thanaObj;
		Object unionObj;
		Object wardObj;
		Object unitObj;
		Object healthAssistantObj;
		
		if(thana==""){
			 thanaObj = ComplexKey.emptyObject();
		}else{
			thanaObj = thana;
		}
		
		if(union == ""){
			unionObj = ComplexKey.emptyObject();
		}else{
			unionObj = union;
		}
		
		if(ward ==""){
			wardObj = ComplexKey.emptyObject();
		}else{
			wardObj = ward;
		}
		
		if(unit ==""){
			unitObj = ComplexKey.emptyObject();
		}else{
			unitObj = unit;
		}
		
		if(healthAssistant ==""){
			System.err.println("healthAssistant:"+healthAssistant);
			healthAssistantObj = ComplexKey.emptyObject();
		}else{
			healthAssistantObj = healthAssistant;
			System.out.println("healthAssistant:"+healthAssistant);
		}
		
		
		ComplexKey startkey = ComplexKey.of(thana, union,ward,unit,healthAssistant);
		ComplexKey endkey = ComplexKey.of(thanaObj, unionObj,wardObj,unitObj,healthAssistantObj);
		
		List<CampDate> camps = db.queryView(createQuery("search")
			.startKey(startkey)	
			.endKey(endkey)
			.includeDocs(true), CampDate.class);
		System.out.println(camps.toString());
		return camps;
	}
	
}
