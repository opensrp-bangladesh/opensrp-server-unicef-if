package org.opensrp.dashboard.repository;

import java.util.List;

import org.ektorp.ComplexKey;
import org.ektorp.CouchDbConnector;
import org.ektorp.support.View;
import org.motechproject.dao.MotechBaseRepository;
import org.opensrp.common.AllConstants;
import org.opensrp.dashboard.domain.DashboardLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class AllDashboardLocations extends MotechBaseRepository<DashboardLocation> {
	
	private static Logger logger = LoggerFactory.getLogger(AllDashboardLocations.class);
	
	@Autowired
	public AllDashboardLocations(@Value("#{opensrp['couchdb.atomfeed-db.revision-limit']}") int revisionLimit,
	    @Qualifier(AllConstants.OPENSRP_DATABASE_CONNECTOR) CouchDbConnector db) {
		super(DashboardLocation.class, db);
		this.db.setRevisionLimit(revisionLimit);
	}
	
	@View(name = "by_name", map = "function(doc) { if (doc.type === 'DashboardLocation' && doc.name) { emit(doc.name, doc); } }")
	public DashboardLocation findDashboardLocationByName(String name) {
		List<DashboardLocation> dashboardLocations = db.queryView(createQuery("by_name").key(name).includeDocs(true), DashboardLocation.class);
		if (dashboardLocations == null || dashboardLocations.isEmpty()) {
			logger.info("DashboardLocation with name- " + name + " not found.");
			return null;
		}
		return dashboardLocations.get(0);
	}	
	
	@View(name = "children_locations_by_parentId", map = "function(doc) { if (doc.type === 'DashboardLocation' && doc.parentId) { emit(doc.parentId, doc); } }")
	public List<DashboardLocation> findChildrenLocations(String parentId) {
		List<DashboardLocation> dashboardLocations = db.queryView(createQuery("children_locations_by_parentId").key(parentId).includeDocs(true), DashboardLocation.class);
		if (dashboardLocations == null || dashboardLocations.isEmpty()) {
			logger.info("children locations with parentId- " + parentId + " not found.");
			return null;
		}
		return dashboardLocations;
	}
	
	@View(name = "locations_by_parent_and_tag", map = "function(doc) { if (doc.type === 'DashboardLocation' && doc.parentId && doc.tagId) { emit([doc.parentId, doc.tagId], doc); } }")
	public List<DashboardLocation> findLocationsByParentAndTag(String parentId, String tagId) {
		ComplexKey complexKey = ComplexKey.of(parentId, tagId);		
		List<DashboardLocation> dashboardLocations = db.queryView(createQuery("locations_by_parent_and_tag").key(complexKey).includeDocs(true), DashboardLocation.class);
		if (dashboardLocations == null || dashboardLocations.isEmpty()) {
			logger.info("locations with parentId- " + parentId + " and tagId " + tagId + " not found.");
			return null;
		}
		return dashboardLocations;
	}
	
	@View(name = "locations_by_tag", map = "function(doc) { if (doc.type === 'DashboardLocation' && doc.tagId) { emit(doc.tagId, doc); } }")
	public List<DashboardLocation> findLocationsByTag(String tagId) {
		List<DashboardLocation> dashboardLocations = db.queryView(createQuery("locations_by_tag").key(tagId).includeDocs(true), DashboardLocation.class);
		if (dashboardLocations == null || dashboardLocations.isEmpty()) {
			logger.info("DashboardLocation with tagId- " + tagId + " not found.");
			return null;
		}
		return dashboardLocations;	
	}
}
