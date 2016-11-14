package org.opensrp.service;


public class AnnouncementMessage extends MessageFactory {

	@Override
    public Message getMessageType(String type) {
	    // TODO Auto-generated method stub
		Message message = null;
		if(type.equalsIgnoreCase("Woman")){
			message = new WomanAnnouncementMessage();
		}else if(type.equalsIgnoreCase("Child")){
			message = new ChildAnnouncementMessage();
		}else{
		}
		return message;
    }
	
}
