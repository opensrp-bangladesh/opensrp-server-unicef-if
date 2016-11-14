/**
 * @author Asifur
 */

package org.opensrp.register.mcare.repository;

import java.util.List;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.GenerateView;
import org.ektorp.support.View;
import org.motechproject.dao.MotechBaseRepository;
import org.opensrp.common.AllConstants;
import org.opensrp.register.mcare.domain.Members;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class AllMembers extends MotechBaseRepository<Members> {

	private static Logger logger = LoggerFactory.getLogger(AllMembers.class);

	@Autowired
	public AllMembers(@Value("#{opensrp['couchdb.atomfeed-db.revision-limit']}") int revisionLimit,
			@Qualifier(AllConstants.OPENSRP_DATABASE_CONNECTOR) CouchDbConnector db) {
		super(Members.class, db);
		this.db.setRevisionLimit(revisionLimit);
	}

	@GenerateView
	public Members findByCaseId(String caseId) {
		List<Members> members = queryView("by_caseId", caseId);
		if (members == null || members.isEmpty()) {
			return null;
		}
		return members.get(0);
	}

	public void close(String caseId) {
		Members members = findByCaseId(caseId);
		update(members.setIsClosed(true));
	}
	
	@View(name = "all_open_members_for_provider", map = "function(doc) { if (doc.type === 'Members' && doc.PROVIDERID) { emit(doc.PROVIDERID); } }")
	public List<Members> allOpenMembersForProvider(String providerId) {
		return db.queryView(
				createQuery("all_open_members_for_provider").key(providerId)
						.includeDocs(true), Members.class);
	}
	@View(name = "all_open_members_for_provider", map = "function(doc) { if (doc.type === 'Members' && doc.PROVIDERID) { emit(doc.PROVIDERID); } }")
	public List<Members> allOpenMembers() {
		return db.queryView(
				createQuery("all_open_members_for_provider")
						.includeDocs(true), Members.class);
	}


}
