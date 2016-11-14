/**
 * @author proshanto
 * */
package org.opensrp.rest.services;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONObject;
import org.opensrp.dto.register.HouseholdDTO;
import org.opensrp.dto.register.HouseholdEntryDTO;
import org.opensrp.rest.register.DTO.MemberRegisterEntryDTO;
import org.opensrp.rest.register.DTO.MemeberDTO;
import org.opensrp.rest.repository.LuceneMembersRepository;
import org.opensrp.rest.util.ConvertDateStringToTimestampMills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.github.ldriscoll.ektorplucene.LuceneResult;
import com.github.ldriscoll.ektorplucene.LuceneResult.Row;

@Service
public class LuceneMembersService {
	private LuceneMembersRepository luceneMembersRepository;
	private ConvertDateStringToTimestampMills convertDateStringToTimestampMills;
	@Autowired
	private DynamicQueryString dynamicQueryString;
	@Autowired
	public LuceneMembersService(LuceneMembersRepository luceneMembersRepository,ConvertDateStringToTimestampMills convertDateStringToTimestampMills){
		this.luceneMembersRepository = luceneMembersRepository;
		this.convertDateStringToTimestampMills = convertDateStringToTimestampMills;
	}
	/**
	 * This method return Members count as today, this month or this week
	 * @param start this may be start date of a month or week
	 * @param end   this may be end date of a month or week
	 * */
	
	public MemeberDTO getMember(MultiValueMap<String, String> queryParameters) throws JsonParseException, JsonMappingException,
	IOException {
		ObjectMapper mapper = new ObjectMapper();		
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance()
				.withFieldVisibility(JsonAutoDetect.Visibility.ANY));
				
		LuceneResult luceneResult = luceneMembersRepository
				.findDocsByProvider(dynamicQueryString.makeDynamicQueryAsString(queryParameters));
		List<Row> rows = luceneResult.getRows();
		List<MemberRegisterEntryDTO> hhRegisterEntryDTOList = new ArrayList<MemberRegisterEntryDTO>();
		
		for (Row row : rows) {
			LinkedHashMap<String, Object> fields = row.getFields();
			String jsonString = new JSONObject(fields).toString();
			hhRegisterEntryDTOList.add(mapper.readValue(jsonString.getBytes(),
				MemberRegisterEntryDTO.class));
		}
		return new MemeberDTO(hhRegisterEntryDTOList);
	}
	
	public int getMembersCount(String start,String end){
		if(start.equalsIgnoreCase("")){
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    	Date today = Calendar.getInstance().getTime();    	
			String makeQueryString ="isClosed:false" + " AND " + "type:Members" + " AND " + "SUBMISSIONDATE:["+convertDateStringToTimestampMills.convertDateToTimestampMills(dateFormat.format(today))+" TO "+convertDateStringToTimestampMills.convertDateToTimestampMills(dateFormat.format(today))+"]" ;
	    	LuceneResult result = luceneMembersRepository.findDocsByProvider(makeQueryString);
			return result.getRows().size();
		}else{
			String makeQueryString ="isClosed:false" + " AND " + "type:Members" + " AND " + "SUBMISSIONDATE:["+convertDateStringToTimestampMills.convertDateToTimestampMills(start)+" TO "+convertDateStringToTimestampMills.convertDateToTimestampMills(end)+"]" ;
	    	LuceneResult result = luceneMembersRepository.findDocsByProvider(makeQueryString);
			return result.getRows().size();
		}
		
		
	}

}
