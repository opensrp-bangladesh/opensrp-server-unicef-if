package org.opensrp.camp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.opensrp.camp.dao.Camp;
import org.opensrp.camp.dao.CampDate;
import org.opensrp.camp.dto.CampDTO;
import org.opensrp.camp.dto.CampDateDTO;
import org.opensrp.camp.interfaces.CampInterface;
import org.opensrp.camp.repository.CampDateRepository;
import org.opensrp.camp.repository.CampRepository;
import org.opensrp.common.AllConstants.ScheduleNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class CampService implements CampInterface<CampDTO> {
	
	private static Logger logger = LoggerFactory.getLogger(CampService.class);
	
	private CampRepository campRepository;
	
	private CampDateRepository campDateRepository;
	
	private CampDateService campDateService;
	
	public CampService() {
		
	}
	
	@Autowired
	public void setCampDateService(CampDateService campDateService) {
		this.campDateService = campDateService;
	}
	
	@Autowired
	public void setCampDateRepository(CampDateRepository campDateRepository) {
		this.campDateRepository = campDateRepository;
	}
	
	@Autowired
	public void setCampRepository(CampRepository campRepository) {
		this.campRepository = campRepository;
	}
	public String campNameList(){
		List<String> camp = new ArrayList<>();
		camp.add(ScheduleNames.SCHEDULE_Woman_Measles);
		camp.add(ScheduleNames.SCHEDULE_Woman_1);
		camp.add(ScheduleNames.SCHEDULE_Woman_2);
		camp.add(ScheduleNames.SCHEDULE_Woman_3);
		camp.add(ScheduleNames.SCHEDULE_Woman_4);
		camp.add(ScheduleNames.SCHEDULE_Woman_5);
		camp.add(ScheduleNames.child_vaccination_bcg);
		camp.add(ScheduleNames.child_vaccination_ipv);
		camp.add(ScheduleNames.child_vaccination_measles1);
		camp.add(ScheduleNames.child_vaccination_measles2);
		camp.add(ScheduleNames.child_vaccination_opv0);
		camp.add(ScheduleNames.child_vaccination_opv1);
		camp.add(ScheduleNames.child_vaccination_opv2);
		camp.add(ScheduleNames.child_vaccination_opv3);
		camp.add(ScheduleNames.child_vaccination_pcv1);
		camp.add(ScheduleNames.child_vaccination_pcv2);
		camp.add(ScheduleNames.child_vaccination_pcv3);
		camp.add(ScheduleNames.child_vaccination_penta1);
		camp.add(ScheduleNames.child_vaccination_penta2);
		camp.add(ScheduleNames.child_vaccination_penta3);
		Gson gson = new Gson();
		String campString = gson.toJson(camp);
		return campString;
		
	}
	public String getCampById(String id) {
		logger.info("campRepository: " + campRepository);
		Camp campDates = campRepository.findById(id);
		Gson gson = new Gson();
		String jsonCartList = gson.toJson(campDates);
		logger.info("Camp : " + jsonCartList.toString());
		return jsonCartList.toString();
	}
	
	@Override
	public String add(CampDTO campDTO) {
		String msg = "";
		Camp camp = campDTO2Camp(campDTO);
		Camp findCamp = campRepository.findBySessionName(campDTO.getSession_name(), campDTO.getHealth_assistant());
		if (findCamp == null) {
			List<CampDateDTO> campDateDTOs = (List<CampDateDTO>) campDTO.getCamp_dates();
			try {
				campRepository.add(camp);
				if (camp.getId() != null) {
					for (CampDateDTO campDateDTO : campDateDTOs) {
						CampDate campDate = campDateService.CampDateDTO2CampDate(campDateDTO, camp,campDTO);
						campDateRepository.add(campDate);
					}
				}
				msg = "1";
			}
			catch (Exception e) {
				logger.debug("Message: " + e);
				msg = "3";
			}
			
		} else {
			msg = "2";
		}
		return msg;
	}
	
	@Override
	public List<CampDTO> getAll() {
		List<Camp> camps = campRepository.getAll();
		List<CampDTO> campDTOs = new ArrayList<CampDTO>();
		for (Camp camp : camps) {
			CampDTO campDTO = new CampDTO();
			campDTO = camp2CampDTO(camp, campDTO);
			Set<CampDate> campDates = (Set<CampDate>) camp.getCamp_dates();
			List<CampDateDTO> campDateDTOs = new ArrayList<CampDateDTO>();
			for (CampDate campDate : campDates) {
				CampDateDTO campDateDTO = new CampDateDTO();
				campDateDTO.setSession_date(campDate.getSession_date());
				campDateDTO.setStatus(campDate.getStatus());
				campDateDTO.setTimestamp(campDate.getTimestamp());
				campDateDTOs.add(campDateDTO);
			}
			campDTO.setCamp_dates(campDateDTOs);
			campDTOs.add(campDTO);
		}
		
		return campDTOs;
	}
	
	@Override
	public String delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public CampDTO findById(String id) {
		return null;
		// TODO Auto-generated method stub
		
	}
	
	private CampDTO camp2CampDTO(Camp camp, CampDTO campDTO) {
		campDTO.setContact(camp.getContact());
		campDTO.setCreated_at(camp.getCreated_at());
		campDTO.setCreated_by(camp.getCreated_by());
		campDTO.setSession_id(camp.getId());
		campDTO.setSession_location(camp.getSession_location());
		campDTO.setSession_name(camp.getSession_name());
		campDTO.setTotal_adolescent(camp.getTotal_adolescent());
		campDTO.setTotal_child0(camp.getTotal_child0());
		campDTO.setTotal_child1(camp.getTotal_child1());
		campDTO.setTotal_child2(camp.getTotal_child2());
		campDTO.setTotal_hh(camp.getTotal_hh());
		campDTO.setTotal_population(camp.getTotal_population());
		campDTO.setTotal_women(camp.getTotal_women());		
		campDTO.setHealth_assistant(camp.getHealth_assistant());
		return campDTO;
	}
	
	private Camp campDTO2Camp(CampDTO campDTO) {
		Camp camp = new Camp();
		camp.setHealth_assistant(campDTO.getHealth_assistant());
		camp.setSession_name(campDTO.getSession_name());
		camp.setSession_location(campDTO.getSession_location());
		camp.setContact(campDTO.getContact());
		camp.setCreated_at(campDTO.getCreated_at());
		camp.setTotal_adolescent(campDTO.getTotal_adolescent());
		camp.setTotal_child0(campDTO.getTotal_child0());
		camp.setTotal_child1(campDTO.getTotal_child1());
		camp.setTotal_child2(campDTO.getTotal_child2());
		camp.setTotal_hh(campDTO.getTotal_hh());
		camp.setCreated_by(campDTO.getCreated_by());
		camp.setTotal_women(campDTO.getTotal_women());
		camp.setTotal_population(campDTO.getTotal_population());
		return camp;
	}
	
	@Override
	public String edit(CampDTO campDTO) {
		// TODO Auto-generated method stub
		Camp campById = campRepository.findById(campDTO.getSession_id());
		if (campById != null) {
			Camp camp = campDTO2Camp(campDTO);
			camp.setRevision(campById.getRevision());
			camp.setId(campById.getId());
			try {
				campRepository.update(camp);
				campDateRepository.removeAll("session_id", camp.getId());
				List<CampDateDTO> campDateDTOs = (List<CampDateDTO>) campDTO.getCamp_dates();
				for (CampDateDTO campDateDTO : campDateDTOs) {
					CampDate campDate = campDateService.CampDateDTO2CampDate(campDateDTO, camp,campDTO);
					campDateRepository.add(campDate);
				}				
			}
			catch (Exception e) {
				return "2";
			}
			
		}
		return "1";
		
	}
	
}
