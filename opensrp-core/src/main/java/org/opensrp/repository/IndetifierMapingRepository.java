package org.opensrp.repository;

import java.util.List;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.GenerateView;
import org.motechproject.dao.MotechBaseRepository;
import org.opensrp.common.AllConstants;
import org.opensrp.domain.IdentifierMaping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class IndetifierMapingRepository  extends MotechBaseRepository<IdentifierMaping>{
	private static Logger logger = LoggerFactory.getLogger(IndetifierMapingRepository.class);
	
	@Autowired
	public IndetifierMapingRepository(
			@Qualifier(AllConstants.OPENSRP_DATABASE_CONNECTOR) CouchDbConnector db) {
		super(IdentifierMaping.class, db);
	}
	@GenerateView
	public IdentifierMaping findByentityId(String genId) {
		List<IdentifierMaping> ids = queryView("by_entityId", genId);
		if (ids == null || ids.isEmpty()) {
			return null;
		}
		return ids.get(0);
		
	}
	/*@GenerateView
	public IdentifierMaping findBybahmniId(String bahmniId) {
		List<IdentifierMaping> ids = queryView("by_bahmniId", bahmniId);
		if (ids == null || ids.isEmpty()) {
			return null;
		}
		return ids.get(0);
		
	}*/
	
	
	
}
