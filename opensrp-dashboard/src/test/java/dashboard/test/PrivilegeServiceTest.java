package dashboard.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
import org.opensrp.dashboard.domain.Privilege;
import org.opensrp.dashboard.repository.AllPrivileges;
import org.springframework.beans.factory.annotation.Autowired;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-applicationContext-opensrp-register-mcare.xml")*/
public class PrivilegeServiceTest {
 
	@Autowired  
	private AllPrivileges allPrivileges;
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
		allPrivileges = new AllPrivileges(2, stdCouchDbConnector);
    	//initMocks(this);
    }

    @Test 
    public void testPrivilegeService() throws Exception {
		
		List<String> privilegeList = new ArrayList<>();
		
		privilegeList.add("Privilege List");
		privilegeList.add("Add Privilege");
		privilegeList.add("Edit Privilege");
		privilegeList.add("Camp List");
		privilegeList.add("Add Camp");
		privilegeList.add("Edit Camp");
		privilegeList.add("View Camp");
		
		privilegeList.add("Add Role");
		privilegeList.add("Role List");
		privilegeList.add("Role Edit");
		
		privilegeList.add("Add User");
		privilegeList.add("User List");
		privilegeList.add("Edit User");
		privilegeList.add("User Location Assign");
		
		privilegeList.add("Location List");
		privilegeList.add("Edit Location");
		privilegeList.add("Add Location");
		privilegeList.add("User Location Assign");
		
		for (String name : privilegeList) {
			Privilege privilege = new Privilege();
			privilege.withName(name);
			privilege.withStatus("Active");
			Privilege existingPrivilege = allPrivileges.privilegeByName(name);
			if(existingPrivilege == null){
			allPrivileges.add(privilege);
			}
			
        }
		
		
		
    }
    
    /*@Test 
    public void check() throws Exception {		
		Privilege privilege = new Privilege();
		privilege.withName("testPrivilege");
		privilege.withStatus("testStatus");
		allPrivileges.add(privilege);	
    }*/
}
