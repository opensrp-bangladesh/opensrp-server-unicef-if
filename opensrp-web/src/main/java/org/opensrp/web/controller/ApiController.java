package org.opensrp.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.IOException;

import org.opensrp.dto.register.HHRegisterDTO;
import org.opensrp.dto.register.HouseholdDTO;
import org.opensrp.rest.register.DTO.MemeberDTO;
import org.opensrp.rest.services.LuceneHouseHoldService;
import org.opensrp.rest.services.LuceneMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class ApiController {

	private LuceneHouseHoldService luceneHouseHoldService;
	@Autowired
	private LuceneMembersService luceneMembersService;
	@Autowired
	public ApiController(LuceneHouseHoldService luceneHouseHoldService)
	{
		this.luceneHouseHoldService = luceneHouseHoldService;
	}
	
	@RequestMapping(method = GET, value="/households/search")
    @ResponseBody
	public ResponseEntity<HouseholdDTO> getHouseHolds(@RequestParam MultiValueMap<String, String> queryParameters) throws JsonParseException, JsonMappingException, IOException
	{
		 HouseholdDTO  hhRegisterDTO  = luceneHouseHoldService.getHousehold(queryParameters);
		 return new ResponseEntity<>(hhRegisterDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = GET, value="/child/search")
    @ResponseBody
	public ResponseEntity<MemeberDTO> getChilds(@RequestParam MultiValueMap<String, String> queryParameters) throws JsonParseException, JsonMappingException, IOException
	{
		MemeberDTO  hhRegisterDTO  = luceneMembersService.getMember(queryParameters);
		 return new ResponseEntity<>(hhRegisterDTO, HttpStatus.OK);
	}
}
