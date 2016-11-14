package org.opensrp.camp.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.opensrp.camp.dao.Camp;
import org.opensrp.camp.dao.CampDate;
import org.opensrp.camp.dto.CampDTO;
import org.opensrp.camp.dto.CampDateDTO;
import org.opensrp.camp.interfaces.CampInterface;
import org.opensrp.camp.repository.CampDateRepository;
import org.opensrp.common.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class CampDateService implements CampInterface<CampDate>{
	
	private static Logger logger = LoggerFactory.getLogger(CampDateService.class);
	
	private CampDateRepository campDateRepository;
	
	public CampDateService() {
		
	}
	
	@Autowired
	public void setCampDateRepository(CampDateRepository campDateRepository) {
		this.campDateRepository = campDateRepository;
	}
	
	public List<CampDate> getCampDateBySessionId(String session_id) {
		List<CampDate> campDates = campDateRepository.findBySessionId(session_id);
		Gson gson = new Gson();
		// convert your list to json
		String jsonCartList = gson.toJson(campDates);
		
		logger.info("Camp : " + jsonCartList.toString());
		return campDates;
		
	}	
	
	public CampDate CampDateDTO2CampDate(CampDateDTO campDateDTO,Camp camp,CampDTO campDTO) throws ParseException{
		CampDate campDate = new CampDate();
		campDate.setSession_date(campDateDTO.getSession_date());
		campDate.setSession_id(camp.getId());
		campDate.setContact(camp.getContact());
		campDate.setSession_name(camp.getSession_name());
		campDate.setSession_location(camp.getSession_location());
		campDate.setHealth_assistant(camp.getHealth_assistant());
		campDate.setStatus(campDateDTO.getStatus());
		
		campDate.setThana(campDTO.getThana());
		campDate.setUnion(campDTO.getUnion());
		campDate.setWard(campDTO.getWard());
		campDate.setUnit(campDTO.getUnit());		
		campDate.setDeleted(campDateDTO.isDeleted());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(campDateDTO.getSession_date().toString());
		campDate.setTimestamp(date.getTime());
		return campDate;		
	}

	@Override
    public String add(CampDate object) {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public String edit(CampDate object) {
	    // TODO Auto-generated method stub
		campDateRepository.update(object);
	    return null;
    }

	@Override
    public List<CampDate> getAll() {
		List<CampDate> camps = campDateRepository.getAll();
	    return camps;
    }

	@Override
    public String delete(String id) {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public CampDate findById(String id) {
	    // TODO Auto-generated method stub
	    return campDateRepository.findById(id);
    }
	
	public List<CampDate> search(String thana,String union,String ward,String unit,String healthAssistant ){
		return campDateRepository.search(thana, union, ward, unit, healthAssistant);
	}
	public List<CampDate> findCampByToday(String HA){		
		return campDateRepository.findByTimeStampByHealthAssistant(DateTimeUtil.getTimeStampTodatDay(),HA);	
		
	}
	public List<CampDate> findByTimeStamp(){		
		return campDateRepository.findByTimeStamp(DateTimeUtil.getTimeStampPlusOneDay());	
		
	}
	private long getTimeStamp(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");		
		Date day = null;		
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, 1);	    
	    String today = dateFormat.format(now.getTime());	   
		try {
			day = dateFormat.parse(today);			
		} catch (ParseException e) {			
			e.printStackTrace();
		}		
		return day.getTime();
	}

	public List<CampDate> findCampByTodayForVaccinationListener() {
	    // TODO Auto-generated method stub
		return campDateRepository.findByTimeStamp(DateTimeUtil.getTimeStampTodatDay());
    }
	
}
