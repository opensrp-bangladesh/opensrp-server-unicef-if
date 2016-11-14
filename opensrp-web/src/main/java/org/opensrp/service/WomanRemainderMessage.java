package org.opensrp.service;

import org.opensrp.camp.dao.CampDate;
import org.opensrp.register.mcare.domain.Members;


public class WomanRemainderMessage implements Message {

	@Override
    public String message(Members member, CampDate campDate) {
	    // TODO Auto-generated method stub
		String message = "  AGAMIKAL " +
				campDate.getSession_date() +
				"  APNAR ELAKAY TIKADAN KENDRO BOSHBE. SOMOY MOTO TT TIKA PETE " +
				campDate.getSession_name() +
				" KENDRE CHOLE ASUN";
		return message;
    }

	
	
}
