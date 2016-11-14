package org.opensrp.register.mcare.repository.it;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.opensrp.register.mcare.repository.AllMembers;
import org.opensrp.register.mcare.repository.AllHouseHolds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-applicationContext-opensrp-register-mcare.xml")
public class AllHouseHoldsIntegrationTest {

	@Autowired
    private AllHouseHolds allHouseHolds;
	@Autowired
    private AllMembers allMembers;
	
    @Before
    public void setUp() throws Exception {
    	allHouseHolds.removeAll();
    	allMembers.removeAll();
    }
    
  /*  @Test
    public void shouldRegisterEligibleCouple() throws Exception {
    	HouseHold houseHold = new HouseHold().withFWHOHNAME("HouseHold-1").withPROVIDERID("Provider-I");

    	allHouseHolds.add(houseHold);

        List<HouseHold> allHouseHoldsInDB = allHouseHolds.getAll();
        assertThat(allHouseHoldsInDB, is(asList(houseHold)));
        assertThat(allHouseHoldsInDB.get(0).FWHOHNAME(), is("HouseHold-1"));
    }*/

}
