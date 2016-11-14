package org.opensrp.service;


public class EligibleClient {
	private String entityId;
	private Integer missedCount;
	private long timeStamp;
	
	public EligibleClient(){
		
	}

	
    public EligibleClient(String entityId, Integer missedCount, long timeStamp) {
	    super();
	    this.entityId = entityId;
	    this.missedCount = missedCount;
	    this.timeStamp = timeStamp;
    }


	public String getEntityId() {
    	return entityId;
    }

	
    public Integer getMissedCount() {
    	return missedCount;
    }

	
    public long getTimeStamp() {
    	return timeStamp;
    }

	
    public void setEntityId(String entityId) {
    	this.entityId = entityId;
    }

	
    public void setMissedCount(Integer missedCount) {
    	this.missedCount = missedCount;
    }

	
    public void setTimeStamp(long timeStamp) {
    	this.timeStamp = timeStamp;
    }
	
   
	
	
}
