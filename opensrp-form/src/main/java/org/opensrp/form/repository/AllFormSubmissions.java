package org.opensrp.form.repository;

import org.ektorp.ComplexKey;
import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;
import org.ektorp.support.GenerateView;
import org.ektorp.support.View;
import org.motechproject.dao.MotechBaseRepository;
import org.opensrp.form.domain.FormSubmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.opensrp.common.AllConstants;

import java.util.List;

@Repository
public class AllFormSubmissions extends MotechBaseRepository<FormSubmission> {
    @Autowired
    protected AllFormSubmissions(@Qualifier(AllConstants.OPENSRP_FORM_DATABASE_CONNECTOR) CouchDbConnector db) {
        super(FormSubmission.class, db);
    }

    public boolean exists(String instanceId) {
        return findByInstanceId(instanceId) != null;
    }

    @GenerateView
    public FormSubmission findByInstanceId(String instanceId) {
        List<FormSubmission> submissions = queryView("by_instanceId", instanceId);
        if (submissions == null || submissions.isEmpty()) {
            return null;
        }
        return submissions.get(0);
    }

    @View(name = "formSubmission_by_server_version", map = "function(doc) { if (doc.type === 'FormSubmission') { emit([doc.serverVersion], null); } }")
    public List<FormSubmission> findByServerVersion(long serverVersion) {
        ComplexKey startKey = ComplexKey.of(serverVersion + 1);
        ComplexKey endKey = ComplexKey.of(Long.MAX_VALUE);
        return db.queryView(createQuery("formSubmission_by_server_version").startKey(startKey).endKey(endKey).includeDocs(true), FormSubmission.class);
    }

    public List<FormSubmission> allFormSubmissions(long serverVersion, Integer batchSize) {
        ComplexKey startKey = ComplexKey.of(serverVersion + 1);
        ComplexKey endKey = ComplexKey.of(Long.MAX_VALUE);
        ViewQuery query = createQuery("formSubmission_by_server_version")
                .startKey(startKey)
                .endKey(endKey)
                .includeDocs(true);

        if (batchSize != null) {
            query.limit(batchSize);
        }
        return db.queryView(query, FormSubmission.class);
    }
    
	@View(
            name = "formSubmission_by_anm_and_server_version",
            map = "function(doc) { if (doc.type === 'FormSubmission') { emit([doc.anmId, doc.serverVersion], null); } }")
    public List<FormSubmission> findByANMIDAndServerVersion(String anmId, long version, Integer batchSize) {
       
    	  ComplexKey startKey = ComplexKey.of(anmId, version + 1);
          ComplexKey endKey = ComplexKey.of(anmId, Long.MAX_VALUE);
        
        ViewQuery query = createQuery("formSubmission_by_anm_and_server_version")
                .startKey(startKey)
                .endKey(endKey)
                .includeDocs(true);
        if (batchSize != null) {
            query.limit(batchSize);
        }
        return db.queryView(query, FormSubmission.class);
    }

	@View(
            name = "formSubmission_by_anm_and_usertype_and_server_version",
            map = "function(doc) {if(doc.formInstance.form.fields.length > 0 && doc.type==='FormSubmission') {for(var field in doc.formInstance.form.fields) {if(doc.formInstance.form.fields[field].name ==='user_type'){emit([doc.anmId,doc.formInstance.form.fields[field].value, doc.serverVersion], null);}}}}")
    public List<FormSubmission> findByANMIDAndUserTypeAndServerVersion(String anmId, String userType, long version, Integer batchSize) {
       
    	  ComplexKey startKey = null;
          ComplexKey endKey = null;
        
            if(userType != null && !userType.isEmpty())
            {
            	startKey = ComplexKey.of(anmId, userType, version + 1);
            	endKey = ComplexKey.of(anmId, userType, Long.MAX_VALUE);
            }
            /*else {
            	startKey = ComplexKey.of(anmId, version + 1);
            	endKey = ComplexKey.of(anmId, Long.MAX_VALUE);
            }*/
            
        ViewQuery query = createQuery("formSubmission_by_anm_and_usertype_and_server_version")
                .startKey(startKey)
                .endKey(endKey)
                .includeDocs(true);
        if (batchSize != null) {
            query.limit(batchSize);
        }
        return db.queryView(query, FormSubmission.class);
    }
}
