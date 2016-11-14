package dashboard.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.ektorp.impl.StdObjectMapperFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.opensrp.dashboard.domain.DashboardLocation;
import org.opensrp.dashboard.domain.LocationTag;
import org.opensrp.dashboard.domain.Privilege;
import org.opensrp.dashboard.dto.DashboardLocationDTO;
import org.opensrp.dashboard.dto.DashboardLocationInfoDTO;
import org.opensrp.dashboard.dto.LocationTagDTO;
import org.opensrp.dashboard.dto.SimplifiedLocation;
import org.opensrp.dashboard.dto.UserDTO;
import org.opensrp.dashboard.repository.AllDashboardLocations;
import org.opensrp.dashboard.repository.AllLocationTags;
import org.opensrp.dashboard.repository.AllPrivileges;
import org.opensrp.dashboard.service.DashboardLocationService;
import org.opensrp.dashboard.service.LocationTagService;
import org.springframework.beans.factory.annotation.Autowired;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-applicationContext-opensrp-register-mcare.xml")*/
public class DashboardLocationServiceTest {
 
	@Autowired  
	private AllDashboardLocations allDashboardLocations;
	@Autowired  
	private AllLocationTags allLocationTags;
	@Autowired
	private DashboardLocationService dashboardLocationService;
	@Autowired
	private LocationTagService locationTagService;
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
		allDashboardLocations = new AllDashboardLocations(2, stdCouchDbConnector);
		allLocationTags = new AllLocationTags(2, stdCouchDbConnector);
		dashboardLocationService = new DashboardLocationService(allDashboardLocations, allLocationTags);
		locationTagService  = new LocationTagService(allLocationTags);
    }

   @Test 
    public void testDashboardLocationService() throws Exception {
	   DashboardLocation countryLocation = allDashboardLocations.findDashboardLocationByName("Bangladesh");
    	LocationTag countryTag = allLocationTags.findLocationTagByName("Country");
    	
		if(countryLocation==null){
    	DashboardLocationDTO countryDTO = new DashboardLocationDTO();
    	DashboardLocation country = new DashboardLocation();
    	
		country.withName("Bangladesh");
		
		country.withParentName("");
		country.withParentId("");
		//country.withTagId(countryTag.getId());
		allDashboardLocations.add(country);
		}
		
		
    }
    
    public Queue<String> append(Queue<String> in, String str){
    	in.add(str);
    	return in;
    }
    
    /*@Test 
    public void check() throws Exception {		
		Privilege privilege = new Privilege();
		privilege.withName("testPrivilege");
		privilege.withStatus("testStatus");
		allPrivileges.add(privilege);	
    }*/
}
