package org.opensrp.dashboard.repository;

import java.util.List;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.View;
import org.motechproject.dao.MotechBaseRepository;
import org.opensrp.common.AllConstants;
import org.opensrp.dashboard.domain.DashboardLocation;
import org.opensrp.dashboard.domain.LocationTag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class AllLocationTags extends MotechBaseRepository<LocationTag> {
	
	private static Logger logger = LoggerFactory.getLogger(AllLocationTags.class);
	
	@Autowired
	public AllLocationTags(@Value("#{opensrp['couchdb.atomfeed-db.revision-limit']}") int revisionLimit,
	    @Qualifier(AllConstants.OPENSRP_DATABASE_CONNECTOR) CouchDbConnector db) {
		super(LocationTag.class, db);
		this.db.setRevisionLimit(revisionLimit);
	}		
	
	@View(name = "by_name", map = "function(doc) { if (doc.type === 'LocationTag' && doc.name) { emit(doc.name, doc); } }")
	public LocationTag findLocationTagByName(String name) {
		List<LocationTag> locationTags = db.queryView(createQuery("by_name").key(name).includeDocs(true), LocationTag.class);
		if (locationTags == null || locationTags.isEmpty()) {
			logger.info("DashboardLocation with name- " + name + " not found.");
			return null;
		}
		return locationTags.get(0);
	}	
}
