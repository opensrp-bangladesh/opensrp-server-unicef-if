package org.opensrp.service;

import org.opensrp.camp.dao.CampDate;
import org.opensrp.register.mcare.domain.Members;


public interface Message {
	public String message(Members member,CampDate campDate);
}
