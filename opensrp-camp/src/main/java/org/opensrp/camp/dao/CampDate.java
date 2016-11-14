package org.opensrp.camp.dao;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.ektorp.support.TypeDiscriminator;
import org.motechproject.model.MotechBaseDataObject;

@TypeDiscriminator("doc.type === 'CampDate'")
public class CampDate extends MotechBaseDataObject {
	
	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("session_date")
	private String session_date;
	
	@JsonProperty("session_id")
	private String session_id;
	@JsonProperty("session_location")
	private String session_location;
	@JsonProperty("session_name")
	private String session_name;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("health_assistant")
	private String health_assistant;
	@JsonProperty("thana")
	private String thana;
	@JsonProperty("union")
	private String union;
	@JsonProperty("ward")
	private String ward;
	@JsonProperty("unit")
	private String unit;
	
	@JsonProperty("contact")
	private String contact;
	@JsonProperty("timestamp")
	private long timestamp;
	@JsonProperty("deleted")
	private boolean deleted;
	
	public CampDate() {
		// TODO Auto-generated constructor stub
	}

	

	
    public CampDate(String session_date, String session_id, String session_location, String session_name, String status,
        String health_assistant, String thana, String union, String ward, String unit, String contact,
        long timestamp,boolean deleted) {
	    super();
	    this.session_date = session_date;
	    this.session_id = session_id;
	    this.session_location = session_location;
	    this.session_name = session_name;
	    this.status = status;
	    this.health_assistant = health_assistant;
	    this.thana = thana;
	    this.union = union;
	    this.ward = ward;
	    this.unit = unit;
	    this.contact = contact;
	    this.timestamp = timestamp;
	    this.deleted = deleted;
    }




	public String getSession_date() {
    	return session_date;
    }

	
    public String getSession_id() {
    	return session_id;
    }

	
    public String getSession_location() {
    	return session_location;
    }

	
    public String getSession_name() {
    	return session_name;
    }

	
    public String getStatus() {
    	return status;
    }

	
    public String getHealth_assistant() {
    	return health_assistant;
    }

	
    public String getContact() {
    	return contact;
    }

	
    public long getTimestamp() {
    	return timestamp;
    }

	
    public void setSession_date(String session_date) {
    	this.session_date = session_date;
    }

	
    public void setSession_id(String session_id) {
    	this.session_id = session_id;
    }

	
    public void setSession_location(String session_location) {
    	this.session_location = session_location;
    }

	
    public void setSession_name(String session_name) {
    	this.session_name = session_name;
    }

	
    public void setStatus(String status) {
    	this.status = status;
    }

	
    public void setHealth_assistant(String health_assistant) {
    	this.health_assistant = health_assistant;
    }

	
    public void setContact(String contact) {
    	this.contact = contact;
    }

	
    public void setTimestamp(long timestamp) {
    	this.timestamp = timestamp;
    }




	
    public String getThana() {
    	return thana;
    }




	
    public String getUnion() {
    	return union;
    }




	
    public String getWard() {
    	return ward;
    }




	
    public String getUnit() {
    	return unit;
    }




	
    public void setThana(String thana) {
    	this.thana = thana;
    }




	
    public void setUnion(String union) {
    	this.union = union;
    }




	
    public void setWard(String ward) {
    	this.ward = ward;
    }




	
    public void setUnit(String unit) {
    	this.unit = unit;
    }




	
    public boolean isDeleted() {
    	return deleted;
    }




	
    public void setDeleted(boolean deleted) {
    	this.deleted = deleted;
    }



    
}
