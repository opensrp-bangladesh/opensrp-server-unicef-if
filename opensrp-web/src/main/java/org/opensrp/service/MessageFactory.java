package org.opensrp.service;


public abstract class MessageFactory {
	public abstract Message getMessageType(String type);
	public static MessageFactory getMessageFactory(String type){
		MessageFactory messageFactory = null;
		if(type.equalsIgnoreCase("Ann")){
			messageFactory = new AnnouncementMessage();
		}else if(type.equalsIgnoreCase("Rem")){
			messageFactory = new RemainderMessage();
		}
		return messageFactory;
		
		
	}
	
}
