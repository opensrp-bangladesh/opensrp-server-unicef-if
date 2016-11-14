package org.opensrp.rest.repository;

import org.opensrp.common.AllConstants;
import org.opensrp.register.mcare.domain.HouseHold;
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
/*index = "function(doc) { " + 
		"    var res = new Document(); " + 
		"    res.add(doc.TODAY,{\"field\":\"TODAY\", \"store\":\"yes\"});"+
		"    res.add(doc.PROVIDERID,{\"field\":\"PROVIDERID\", \"store\":\"yes\"});" +
		"	 res.add(doc.FWUPAZILLA,{\"field\":\"FWUPAZILLA\", \"store\":\"yes\"});" +
		"    return res; " + 
    "}")
*/
@FullText({
    @Index(
        name = "houdehold",
	    index = "function(rec) {" +
	    		" var doc=new Document();" +
	    		" doc.add(rec.TODAY,{\"field\":\"TODAY\", \"store\":\"yes\"});" +
	    		" doc.add(rec.INSTANCEID,{\"field\":\"INSTANCEID\", \"store\":\"yes\"});" +
	    		" doc.add(rec.Date_Of_Reg,{\"field\":\"Date_Of_Reg\", \"store\":\"yes\"});" +
	    		" doc.add(rec.HoH_birth_date,{\"field\":\"HoH_birth_date\", \"store\":\"yes\"});" +
	    		" doc.add(rec.HoH_Mobile_No,{\"field\":\"HoH_Mobile_No\", \"store\":\"yes\"});" +
	    		" doc.add(rec.PROVIDERID,{\"field\":\"PROVIDERID\", \"store\":\"yes\"});"+ 
	    		" doc.add(rec.HoH_Reg_No,{\"field\":\"HoH_Reg_No\", \"store\":\"yes\"});"+ 
	    		" doc.add(rec.HHID,{\"field\":\"HHID\", \"store\":\"yes\"});"+ 
	    		" doc.add(rec.hoH_NID,{\"field\":\"hoH_NID\", \"store\":\"yes\"});"+ 
	    		" doc.add(rec.caseId,{\"field\":\"caseId\", \"store\":\"yes\"});"+ 
	    		" doc.add(rec.hoH_Lname,{\"field\":\"hoH_Lname\", \"store\":\"yes\"});"+ 
	    		" doc.add(rec.hoH_BRID,{\"field\":\"hoH_BRID\", \"store\":\"yes\"});"+ 
	    		" doc.add(rec.HH_Member_No,{\"field\":\"HH_Member_No\", \"store\":\"yes\"});"+ 
	    		" doc.add(rec.BLOCK,{\"field\":\"BLOCK\", \"store\":\"yes\"});"+ 
	    		" doc.add(rec.DIVISION,{\"field\":\"DIVISION\", \"store\":\"yes\"});" + 
	    		" doc.add(rec.DISTRICT,{\"field\":\"DISTRICT\", \"store\":\"yes\"});" + 
	    		" doc.add(rec.UPAZILLA,{\"field\":\"UPAZILLA\", \"store\":\"yes\"});" + 
	    		" doc.add(rec.UNION,{\"field\":\"UNION\", \"store\":\"yes\"}); " +
	    		" doc.add(rec.WARD,{\"field\":\"WARD\", \"store\":\"yes\"}); " +
	    		" doc.add(rec.HoH_Fname,{\"field\":\"HoH_Fname\", \"store\":\"yes\"});" +
	    		" doc.add(rec.HoH_Gender,{\"field\":\"HoH_Gender\", \"store\":\"yes\"});" +	    		 
	    		" doc.add(rec.type,{\"field\":\"type\", \"store\":\"yes\"});" + 
	    		" return doc;" +
	    		"}")
})
@Repository
public class LuceneHouseHoldRepository extends CouchDbRepositorySupportWithLucene<HouseHold> {

	@Autowired
	public LuceneHouseHoldRepository(@Qualifier(AllConstants.OPENSRP_DATABASE_LUCENE_CONNECTOR)LuceneAwareCouchDbConnector db) {
		super(HouseHold.class, db);
		initStandardDesignDocument();
	}
	
	 public LuceneResult findDocsByProvider(String queryString) { 
        LuceneDesignDocument designDoc = db.get(LuceneDesignDocument.class, stdDesignDocumentId); 
        //assertTrue(designDoc != null); 
       // assertTrue(designDoc.containsIndex("by_provider")); 
        
       // String makeQueryString ="PROVIDERID:"+ providerId + " AND " + "FWUPAZILLA:" + upazilla + " AND " + "user_type:" + userType; //+ " AND TODAY:[\"2016-02-01\"+\"TO\"+\"2016-03-01\"]" ;
        LuceneQuery query = new LuceneQuery(designDoc.getId(), "houdehold"); 
        query.setQuery(queryString); 
        query.setStaleOk(false); 
        return db.queryLucene(query); 
    } 

}
