package dashboard.test;

import static org.junit.Assert.*;

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
import org.opensrp.dashboard.domain.Role;
import org.opensrp.dashboard.domain.User;
import org.opensrp.dashboard.repository.AllDashboardLocations;
import org.opensrp.dashboard.repository.AllLocationTags;
import org.opensrp.dashboard.repository.AllPrivileges;
import org.opensrp.dashboard.repository.AllRoles;
import org.opensrp.dashboard.repository.AllUser;
import org.opensrp.dashboard.service.DashboardLocationService;
import org.opensrp.dashboard.service.RoleService;
import org.opensrp.dashboard.service.UsersService;
import org.opensrp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.crypto.password.StandardPasswordEncoder;


/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-applicationContext-opensrp-register-mcare.xml")*/
public class UserServiceTest {
 
	@Autowired  
	private AllUser allUsers;
	private AllRoles allRoles;
	private AllDashboardLocations allDashboardLocations;
	private AllLocationTags allLocationTags;
	private CouchDbInstance dbInstance;
	private StdCouchDbConnector stdCouchDbConnector;
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private RoleService roleService;
	
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
		allUsers = new AllUser(2, stdCouchDbConnector);
		allRoles = new AllRoles(2, stdCouchDbConnector);
		allDashboardLocations =  new AllDashboardLocations(2, stdCouchDbConnector);
		allLocationTags = new AllLocationTags(2, stdCouchDbConnector);
		roleService  = new RoleService(allRoles);
		
    	//initMocks(this);
		userService = new UsersService(allUsers, roleService, allDashboardLocations, allLocationTags);
    }   

    @Ignore @Test 
    public void testUserService() throws Exception {
    	/*String pass = "Pass45";
    	byte[] encodedPass = Base64.encode(pass.getBytes());
    	//byte[] encodedByteArray =
    	String encodedString = new String(Base64.encode(pass.getBytes()));
    	System.out.println(encodedString);
    	//String x =  encodedPass.toString();
    	byte[] decodedPass = Base64.decode(encodedString.getBytes());
    	String decodedString = new String(Base64.decode(encodedString.getBytes()));
    	System.out.println(decodedString);*/
    	
    	
    	//System.out.println();
    	StandardPasswordEncoder encoder = new StandardPasswordEncoder();
    	/*List<User> allUserss = allUsers.getAll();
    	for(User u : allUserss){
    		u.withPassword(encoder.encode("Pass123"));
    		allUsers.update(u);
    	}*/
    	/*User user = allUsers.findUserByUserName("asifur");
		assertNotNull(user);
		System.out.println(user.getPassword());*/
		
		//user.withPassword(encoder.encode("Pass123"));
		//allUsers.update(user);
		List<User> users = allUsers.findUsersByRole("bdb62a9f4198352123d4581c4f0095f8");
		for(int i = 0; i < users.size(); i++){
			System.out.println(users.get(i).getUserName());
		}
		
		
		//System.out.println(allUsers.findUsersByLocation("12b0f9fc6457e2f58950e582f90251ce").size());
		
		//System.out.println(userService.getLeafUsersByLocation("1e84829ef6153b9b8f05089b28020ae7").size());
		// test the code
		//System.out.println(userService.getLeafUsersByLocation("8e8fa8966b1e39997011f42f6400a59d").size());
		/*decodedPass = Base64.decode(user.getPassword().getBytes());
		System.out.println(new String(decodedPass));*/
		/*user.withPassword(encodedString);
		allUsers.update(user);*/
		
		/*user = allUsers.findUserByUserName("demosrp");
		System.out.println(user.getPassword());
		System.out.println(Base64.decode(user.getPassword().getBytes()).equals(user.getPassword().getBytes()));*/
		//System.out.println(Base64.encode(pass.getBytes()).toString());
		
		/*if(Base64.encode(pass.getBytes()).toString().equals(user.getPassword())){
			System.out.println("ok");
		}*/
		
		
		
		/*System.out.println(user.getPassword());
		if(user.getPassword().getBytes().equals(encodedPass)){
			System.out.println("ass saved.");
		}
		System.out.println();*/
		/*Role role = allRoles.findRoleById(user.getRoles().get(0).getId());// "d32766973465b8847aad7220633da341");
		for(int i = 0 ; i < role.getPrivileges().size(); i++){
			System.out.println(role.getPrivileges().get(i).getName());
		}*/	
    }
    
}
