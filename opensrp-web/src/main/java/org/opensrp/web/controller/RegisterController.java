package org.opensrp.web.controller;

import java.util.List;

import org.opensrp.dto.CountServiceDTO;
import org.opensrp.dto.register.HHRegisterDTO;
import org.opensrp.register.mcare.HHRegister;
import org.opensrp.register.mcare.mapper.HHRegisterMapper;
import org.opensrp.register.mcare.service.HHRegisterService;
import org.opensrp.register.mcare.service.MultimediaRegisterService;
import org.opensrp.service.DataCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {

	private HHRegisterService hhRegisterService;
	private HHRegisterMapper hhRegisterMapper;
	private MultimediaRegisterService multimediaRegisterService;
	private DataCountService dataCountService;
	 
	@Autowired
	public RegisterController(HHRegisterService hhRegisterService, 
			HHRegisterMapper hhRegisterMapper,
			MultimediaRegisterService multimediaRegisterService,
			DataCountService dataCountService) {
		this.hhRegisterService = hhRegisterService;
		this.hhRegisterMapper = hhRegisterMapper;
		this.multimediaRegisterService = multimediaRegisterService;
		this.dataCountService = dataCountService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/registers/hh")
    @ResponseBody
    public ResponseEntity<HHRegisterDTO> hhRegister(@RequestParam("anm-id") String anmIdentifier) {
        HHRegister hhRegister = hhRegisterService.getHHRegisterForProvider(anmIdentifier);
        return new ResponseEntity<>(hhRegisterMapper.mapToDTO(hhRegister), HttpStatus.OK);
    }
		
  /*  private ANCRegisterService ancRegisterService;
    private PNCRegisterService pncRegisterService;
    private ECRegisterService ecRegisterService;
    private ChildRegisterService childRegisterService;
    private FPRegisterService fpRegisterService;
    private ANCRegisterMapper ancRegisterMapper;
    private ECRegisterMapper ecRegisterMapper;
    private ChildRegisterMapper childRegisterMapper;
    private FPRegisterMapper fpRegisterMapper;
    private PNCRegisterMapper pncRegisterMapper;

    @Autowired
    public RegisterController(ANCRegisterService ancRegisterService,
                              PNCRegisterService pncRegisterService,
                              ECRegisterService ecRegisterService,
                              ChildRegisterService childRegisterService,
                              FPRegisterService fpRegisterService,
                              ANCRegisterMapper ancRegisterMapper,
                              ECRegisterMapper ecRegisterMapper,
                              ChildRegisterMapper childRegisterMapper,
                              FPRegisterMapper fpRegisterMapper,
                              PNCRegisterMapper pncRegisterMapper) {
        this.ancRegisterService = ancRegisterService;
        this.ecRegisterService = ecRegisterService;
        this.pncRegisterService = pncRegisterService;
        this.childRegisterService = childRegisterService;
        this.fpRegisterService = fpRegisterService;
        this.ancRegisterMapper = ancRegisterMapper;
        this.ecRegisterMapper = ecRegisterMapper;
        this.childRegisterMapper = childRegisterMapper;
        this.fpRegisterMapper = fpRegisterMapper;
        this.pncRegisterMapper = pn@RequestMapping(method = GET, value = "/registers/ec")
    @ResponseBody
    public ResponseEntity<ECRegisterDTO> ecRegister(@RequestParam("anm-id") String anmIdentifier) {
        ECRegister ecRegister = ecRegisterService.getRegisterForANM(anmIdentifier);
        return new ResponseEntity<>(ecRegisterMapper.mapToDTO(ecRegister), HttpStatus.OK);
    }

    @RequestMapping(method = GET, value = "/registers/anc")
    @ResponseBody
    public ResponseEntity<ANCRegisterDTO> ancRegister(@RequestParam("anm-id") String anmIdentifier) {
        ANCRegister ancRegister = ancRegisterService.getRegisterForANM(anmIdentifier);
        return new ResponseEntity<>(ancRegisterMapper.mapToDTO(ancRegister), HttpStatus.OK);
    }cRegisterMapper;
    }

    @RequestMapping(method = GET, value = "/registers/ec")
    @ResponseBody
    public ResponseEntity<ECRegisterDTO> ecRegister(@RequestParam("anm-id") String anmIdentifier) {
        ECRegister ecRegister = ecRegisterService.getRegisterForANM(anmIdentifier);
        return new ResponseEntity<>(ecRegisterMapper.mapToDTO(ecRegister), HttpStatus.OK);
    }*/   
    
    @RequestMapping(method = RequestMethod.GET, value = "/getMultimedia")
    @ResponseBody
    public ResponseEntity<String>  getMultimedia()
    {
    	multimediaRegisterService.getMultimedia();
    	return new ResponseEntity<>("Welcome to multimedia service", HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/registers/data-count")
    @ResponseBody
    public ResponseEntity<List<CountServiceDTO>>  getHouseHoldInformation(@RequestParam("anm-id") String provider,@RequestParam("start-month") String startMonth,@RequestParam("end-month") String endMonth,
    		@RequestParam("start-week") String startWeek,@RequestParam("end-week") String endtWeek,@RequestParam("type") String type){
    	dataCountService.getHHCountInformation(provider,startMonth,endMonth,startWeek,endtWeek,type);
    	return new ResponseEntity<>(dataCountService.getHHCountInformation(provider,startMonth,endMonth,startWeek,endtWeek,type), HttpStatus.OK);
    }
    
/*
    @RequestMapping(method = GET, value = "/registers/child")
    @ResponseBody
    public ResponseEntity<ChildRegisterDTO> childRegister(@RequestParam("anm-id") String anmIdentifier) {
        ChildRegister childRegister = childRegisterService.getRegisterForANM(anmIdentifier);
        return new ResponseEntity<>(childRegisterMapper.mapToDTO(childRegister), HttpStatus.OK);
    }

    @RequestMapping(method = GET, value = "/registers/fp")
    @ResponseBody
    public ResponseEntity<FPRegisterDTO> fpRegister(@RequestParam("anm-id") String anmIdentifier) {
        FPRegister fpRegister = fpRegisterService.getRegisterForANM(anmIdentifier);
        return new ResponseEntity<>(fpRegisterMapper.mapToDTO(fpRegister), HttpStatus.OK);

    }

    @RequestMapping(method = GET, value = "/registers/pnc")
    @ResponseBody
    public ResponseEntity<PNCRegisterDTO> pncRegister(@RequestParam("anm-id") String anmIdentifier) {
        PNCRegister pncRegister = pncRegisterService.getRegisterForANM(anmIdentifier);
        return new ResponseEntity<>(pncRegisterMapper.mapToDTO(pncRegister), HttpStatus.OK);
    }*/
}
