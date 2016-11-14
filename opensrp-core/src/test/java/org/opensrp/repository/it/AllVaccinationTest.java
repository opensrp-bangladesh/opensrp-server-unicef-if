package org.opensrp.repository.it;

import javax.xml.ws.Action;

import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.ektorp.impl.StdObjectMapperFactory;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.opensrp.common.util.DateTimeUtil;
import org.opensrp.dto.AlertStatus;
import org.opensrp.dto.BeneficiaryType;
import org.opensrp.repository.AllVaccine;
import org.opensrp.scheduler.repository.AllActions;
import org.opensrp.scheduler.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;


public class AllVaccinationTest {
	
	@Autowired
	private AllVaccine allVaccine;
	
	@Autowired
	private ActionService actionService;
	
	
	@Autowired
	private AllActions allActions;
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
		allVaccine = new AllVaccine(2, stdCouchDbConnector);
		allActions = new AllActions(stdCouchDbConnector);
		
    }
	
	@Ignore@Test
	public void saveVacccineTest(){
		ActionService actionService =new ActionService(allActions, null, null,allVaccine);
		actionService.ActionUpdateOrCreateForOther(BeneficiaryType.members, "03166dfc-69d9-4d8b-b0fa-57acd0cc1869", "03166dfc-69d9-4d8b-b0fa-57acd0cc1866", "sohel", "TT5", "Woman_BNF", AlertStatus.upcoming, new DateTime(),new DateTime());
		
	}
	@Test
	public void shouldGeTodaysCamp(){
		
	}
	@Test
	public void shouldGetActionsByeligibleClient(){
		System.err.println("All Action:"+allActions.listOfEligibleClientForVaccines("sohel"));
		
		
	}
}
