package org.opensrp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.camp.dao.CampDate;
import org.opensrp.camp.service.CampDateService;
import org.opensrp.domain.Vaccine;
import org.opensrp.repository.AllVaccine;
import org.opensrp.scheduler.Action;
import org.opensrp.scheduler.repository.AllActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class ClientListForCamp {
	
	private CampDateService campDateService;	
	private AllActions allActions;
	 private AllVaccine allVaccine;
	@Autowired
    public void setCampDateService(CampDateService campDateService) {
    	this.campDateService = campDateService;
    }
	
	@Autowired
    public void setAllActions(AllActions allActions) {
    	this.allActions = allActions;
    }
	@Autowired
    public void setAllVaccine(AllVaccine allVaccine) {
    	this.allVaccine = allVaccine;
    }

	public List<EligibleClient> todaysClientList(String provider) {
		Map<String,Integer> clients = new HashMap<String,Integer>();
		List<CampDate> campDates =campDateService.findCampByToday(provider);	
		if(campDates != null){
			for (CampDate campDate : campDates) {
				List<Action> actions = allActions.listOfEligibleClientForVaccineTodaysChild(campDate.getHealth_assistant(),campDate.getSession_name());
				
				for (Action action : actions) {
					Vaccine existingVaccine = allVaccine.getVaccine(action.caseId(),action.data().get("scheduleName"));
					if(existingVaccine !=null){
						clients.put(action.caseId(), existingVaccine.getMissedCount());
					}
				}
			}
		}		
		List<EligibleClient> client_lists = new ArrayList<>();
		
		for (Map.Entry<String, Integer> entry : clients.entrySet())
		{
			EligibleClient client_list = new EligibleClient();
			client_list.setMissedCount(entry.getValue());
			client_list.setEntityId(entry.getKey());			
			client_lists.add(client_list);
		}
		return client_lists;
	}
	
	public List<EligibleClient> clientList(String provider,long timeStamp) {
		Map<String,Vaccine> clients = new HashMap<String,Vaccine>();			
		List<Action> actions = allActions.listOfEligibleClientForVaccines(provider);
		
		for (Action action : actions) {
			Vaccine existingVaccine = allVaccine.findByCaseIdScheduleAndTimeStamp(action.caseId(),action.data().get("scheduleName"),timeStamp);
			
			if(existingVaccine !=null){				
				clients.put(action.caseId(), existingVaccine);
			}
		}		
		List<EligibleClient> client_lists = new ArrayList<>();
		
		for (Map.Entry<String, Vaccine> entry : clients.entrySet())
		{
			
			EligibleClient client_list = new EligibleClient();
			client_list.setMissedCount(entry.getValue().getMissedCount());
			client_list.setEntityId(entry.getKey());
			client_list.setTimeStamp(entry.getValue().getTimeStamp());
			client_lists.add(client_list);
		}
		return client_lists;
	}
	
}
