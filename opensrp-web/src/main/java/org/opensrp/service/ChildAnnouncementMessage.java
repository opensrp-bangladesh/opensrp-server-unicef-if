package org.opensrp.service;

import org.opensrp.camp.dao.CampDate;
import org.opensrp.register.mcare.domain.Members;


public class ChildAnnouncementMessage implements Message {

	@Override
    public String message(Members member, CampDate campDate) {
		String message = " APNAR ELAKAR TIKADAN KENDRO EKHON KHOLA ASE " +
				member.Child_mother_name() +
				"  -ER BACHCHAKE TIKA DEYAR JONNO NIYE ASUN" ;
				
		return message;
		
    }

	
	
}
