package org.opensrp.rest.repository;

import org.opensrp.common.AllConstants;
import org.opensrp.register.mcare.domain.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.github.ldriscoll.ektorplucene.CouchDbRepositorySupportWithLucene;
import com.github.ldriscoll.ektorplucene.LuceneAwareCouchDbConnector;
import com.github.ldriscoll.ektorplucene.LuceneQuery;
import com.github.ldriscoll.ektorplucene.LuceneResult;
import com.github.ldriscoll.ektorplucene.designdocument.LuceneDesignDocument;
import com.github.ldriscoll.ektorplucene.designdocument.annotation.FullText;
import com.github.ldriscoll.ektorplucene.designdocument.annotation.Index;

@FullText({
    @Index(
        name = "member",
        index = "function(rec) {" +
	    		" var doc=new Document();" +
	    		" doc.add(rec.TODAY,{\"field\":\"TODAY\", \"store\":\"yes\"});" +
	    		" doc.add(rec.INSTANCEID,{\"field\":\"INSTANCEID\", \"store\":\"yes\"});" +	    		
	    		" doc.add(rec.PROVIDERID,{\"field\":\"PROVIDERID\", \"store\":\"yes\"});"+ 
	    		" doc.add(rec.Child_dob,{\"field\":\"Child_dob\", \"store\":\"yes\"});"+ 
	    		" doc.add(rec.Child_father_name,{\"field\":\"Child_father_name\", \"store\":\"yes\"});"+ 
	    		" doc.add(rec.Child_mother_name,{\"field\":\"Child_mother_name\", \"store\":\"yes\"});"+ 
	    		" doc.add(rec.caseId,{\"field\":\"caseId\", \"store\":\"yes\"});"+ 
	    		" doc.add(rec.Member_LName,{\"field\":\"Member_LName\", \"store\":\"yes\"});"+ 
	    		" doc.add(rec.Member_Fname,{\"field\":\"Member_Fname\", \"store\":\"yes\"});"+ 
	    		" doc.add(rec.Member_GPS,{\"field\":\"Member_GPS\", \"store\":\"yes\"});"+ 
	    		" doc.add(rec.Member_BLOCK,{\"field\":\"Member_BLOCK\", \"store\":\"yes\"});"+ 
	    		" doc.add(rec.Member_DIVISION,{\"field\":\"Member_DIVISION\", \"store\":\"yes\"});" + 
	    		" doc.add(rec.Member_DISTRICT,{\"field\":\"Member_DISTRICT\", \"store\":\"yes\"});" + 
	    		" doc.add(rec.Member_UPAZILLA,{\"field\":\"Member_UPAZILLA\", \"store\":\"yes\"});" + 
	    		" doc.add(rec.Member_UNION,{\"field\":\"Member_UNION\", \"store\":\"yes\"}); " +
	    		" doc.add(rec.Member_WARD,{\"field\":\"Member_WARD\", \"store\":\"yes\"}); " +	    		
	    		" doc.add(rec.Child_gender,{\"field\":\"Child_gender\", \"store\":\"yes\"});" +	 
	    		" doc.add(rec.Is_woman,{\"field\":\"Is_woman\", \"store\":\"yes\"});" +	
	    		" doc.add(rec.Is_child,{\"field\":\"Is_child\", \"store\":\"yes\"});" +	
	    		" doc.add(rec.Husband_name,{\"field\":\"Husband_name\", \"store\":\"yes\"});" +	
	    		" doc.add(rec.WomanInfo,{\"field\":\"WomanInfo\", \"store\":\"yes\"});" +	
	    		" doc.add(rec.type,{\"field\":\"type\", \"store\":\"yes\"});" + 
	    		" return doc;" +
	    		"}")
})

@Repository
public class LuceneMembersRepository extends CouchDbRepositorySupportWithLucene<Members>{
	@Autowired
	public LuceneMembersRepository(@Qualifier(AllConstants.OPENSRP_DATABASE_LUCENE_CONNECTOR)LuceneAwareCouchDbConnector db) {
		super(Members.class, db);
		initStandardDesignDocument();
	}
	public LuceneResult getMember(String queryString) { 
        LuceneDesignDocument designDoc = db.get(LuceneDesignDocument.class, stdDesignDocumentId);
        LuceneQuery query = new LuceneQuery(designDoc.getId(), "member"); 
        query.setQuery(queryString); 
        query.setStaleOk(false); 
        return db.queryLucene(query); 
    } 
	
	public LuceneResult findDocsByProvider(String queryString) { 
        LuceneDesignDocument designDoc = db.get(LuceneDesignDocument.class, stdDesignDocumentId);
        
        LuceneQuery query = new LuceneQuery(designDoc.getId(), "member"); 
        query.setQuery(queryString); 
        query.setStaleOk(false); 
        return db.queryLucene(query); 
    } 

}
