package org.opensrp.service;


public  class RemainderMessage extends MessageFactory{

	@Override
    public Message getMessageType(String type) {
	    // TODO Auto-generated method stub
		Message message = null;
		if(type.equalsIgnoreCase("Woman")){
			message = new WomanRemainderMessage();
		}else if(type.equalsIgnoreCase("Child")){
			message = new ChildRemainderMessage();
		}else{
			
		}
		return message;
	    
    }
	
}
