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
import org.opensrp.dashboard.domain.DashboardLocation;
import org.opensrp.dashboard.domain.LocationTag;
import org.opensrp.dashboard.domain.Privilege;
import org.opensrp.dashboard.dto.LocationTagDTO;
import org.opensrp.dashboard.repository.AllDashboardLocations;
import org.opensrp.dashboard.repository.AllLocationTags;
import org.opensrp.dashboard.repository.AllPrivileges;
import org.opensrp.dashboard.service.LocationTagService;
import org.springframework.beans.factory.annotation.Autowired;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-applicationContext-opensrp-register-mcare.xml")*/
public class LocationTagServiceTest {
 
	@Autowired
	private LocationTagService locationTagService;
	@Autowired  
	private AllLocationTags allLocationTags;
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
		allLocationTags = new AllLocationTags(2, stdCouchDbConnector);
		locationTagService = new LocationTagService(allLocationTags);
    }

    @Test 
    public void testLocationTagService() throws Exception {
    	LocationTag fetchedTag = allLocationTags.findLocationTagByName("Country");
    	
    	if(fetchedTag ==null){
	    	LocationTag tag = new LocationTag();
	    	tag.withName("Country").withParentTagId("");
	    	allLocationTags.add(tag);	    	
    	}
    	testAddLocationTagDivision();
    	testAddLocationTagDistrict();
    	testAddLocationTagUpazilla();
    	testAddLocationTagUnion();
    	testAddLocationTagWard();
    	testAddLocationTagUnit();
    	
    	
    } 
    
   
    public void testAddLocationTagDivision() throws Exception {
    	LocationTag fetchedTag = allLocationTags.findLocationTagByName("Country");
    	LocationTag fetchedTagDivision = allLocationTags.findLocationTagByName("Division");
    	if(fetchedTagDivision ==null){
    		System.err.println("dddd"+fetchedTag.getId());
	    	LocationTag tag = new LocationTag();
	    	tag.withName("Division").withParentTagId(fetchedTag.getId());
	    	try{
	    	allLocationTags.add(tag);
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	
    	}
    	
    	
    }
    
  
    public void testAddLocationTagDistrict() throws Exception {
    	LocationTag fetchedTagDivision = allLocationTags.findLocationTagByName("Division");
    	LocationTag fetchedTagDistrict = allLocationTags.findLocationTagByName("District");
    	if(fetchedTagDistrict ==null){    		
	    	LocationTag tag = new LocationTag();
	    	tag.withName("District").withParentTagId(fetchedTagDivision.getId());
	    	try{
	    	allLocationTags.add(tag);
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	
    	}
    	
    	
    }
    
    
    
    public void testAddLocationTagUpazilla() throws Exception {
    	LocationTag fetchedTagDistrict = allLocationTags.findLocationTagByName("District");
    	LocationTag fetchedTagUpazilla = allLocationTags.findLocationTagByName("Upazilla");
    	if(fetchedTagUpazilla ==null){    		
	    	LocationTag tag = new LocationTag();
	    	tag.withName("Upazilla").withParentTagId(fetchedTagDistrict.getId());
	    	try{
	    	allLocationTags.add(tag);
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	
    	}
    	
    }
    
    
    public void testAddLocationTagUnion() throws Exception {
    	LocationTag fetchedTagUpazilla = allLocationTags.findLocationTagByName("Upazilla");
    	LocationTag fetchedTagUnion = allLocationTags.findLocationTagByName("Union");
    	if(fetchedTagUnion ==null){    		
	    	LocationTag tag = new LocationTag();
	    	tag.withName("Union").withParentTagId(fetchedTagUpazilla.getId());
	    	try{
	    	allLocationTags.add(tag);
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	
    	}
    	
    }
    
    
    public void testAddLocationTagWard() throws Exception {
    	LocationTag fetchedTagUnion = allLocationTags.findLocationTagByName("Union");
    	LocationTag fetchedTagWard = allLocationTags.findLocationTagByName("Ward");
    	if(fetchedTagWard ==null){    		
	    	LocationTag tag = new LocationTag();
	    	tag.withName("Ward").withParentTagId(fetchedTagUnion.getId());
	    	try{
	    	allLocationTags.add(tag);
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	
    	}
    	
    }
    
   
    public void testAddLocationTagUnit() throws Exception {
    	LocationTag fetchedTagWard = allLocationTags.findLocationTagByName("Ward");
    	LocationTag fetchedTagUnit = allLocationTags.findLocationTagByName("Unit");
    	if(fetchedTagUnit ==null){    		
	    	LocationTag tag = new LocationTag();
	    	tag.withName("Unit").withParentTagId(fetchedTagWard.getId());
	    	try{
	    	allLocationTags.add(tag);
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	
    	}
    	
    }
}
