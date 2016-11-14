package org.opensrp.register.mcare.repository.it;

import java.util.List;

import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.ektorp.impl.StdObjectMapperFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.opensrp.register.mcare.domain.HouseHold;
import org.opensrp.register.mcare.domain.Members;
import org.opensrp.register.mcare.repository.AllHouseHolds;
import org.opensrp.register.mcare.repository.AllMembers;


public class AllMemberTest {
	
	private AllMembers allMembers;
	private AllHouseHolds allHouseHolds;
	private CouchDbInstance dbInstance;
	private StdCouchDbConnector stdCouchDbConnector;
	
	@Before
    public void setUp() throws Exception {
       HttpClient httpClient = new StdHttpClient.Builder() 
        .host("localhost") 
       	//.host("192.168.19.55")
        .port(5984) 
        .socketTimeout(1000) 
        .build(); 
		dbInstance = new StdCouchDbInstance(httpClient); 		
		stdCouchDbConnector = new StdCouchDbConnector("opensrp", dbInstance, new StdObjectMapperFactory());		 
		stdCouchDbConnector.createDatabaseIfNotExists();		
		allMembers = new AllMembers(2, stdCouchDbConnector);
		allHouseHolds = new AllHouseHolds(2, stdCouchDbConnector);
		
    }
	
	@Ignore@Test
	public void shouldGetMemberByCaseId(){
		Members member = allMembers.findByCaseId("f34aa45d-6e89-445c-a894-22176b3c71ce");		
	    System.err.println(member.details().get("relationalid"));
	    System.err.println(member.Member_Fname());
        HouseHold houseHold = allHouseHolds.findByCaseId(member.details().get("relationalid"));
        System.err.println(houseHold.HoH_Mobile_No());
		
	}
	
}
