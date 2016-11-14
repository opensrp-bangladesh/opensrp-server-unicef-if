package org.opensrp.camp.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class CampDateDTO {
	
	@JsonProperty("session_date")
	private String session_date;
	@JsonProperty("session_location")
	private String session_location;
	@JsonProperty("session_name")
	private String session_name;	
	@JsonProperty("status")
	private String status;
	@JsonProperty("timestamp")
	private long timestamp;
	@JsonProperty("thana")
	private String thana;
	@JsonProperty("union")
	private String union;
	@JsonProperty("ward")
	private String ward;
	@JsonProperty("unit")
	private String unit;
	@JsonProperty("deleted")
	private boolean deleted;
	public CampDateDTO() {
		// TODO Auto-generated constructor stub
	}

	

	
    public CampDateDTO(String session_date, String session_location, String session_name, String status, long timestamp,
        String thana, String union, String ward, String unit,boolean deleted) {
	    super();
	    this.session_date = session_date;
	    this.session_location = session_location;
	    this.session_name = session_name;
	    this.status = status;
	    this.timestamp = timestamp;
	    this.thana = thana;
	    this.union = union;
	    this.ward = ward;
	    this.unit = unit;
	    this.deleted = deleted;
    }




	public String getSession_date() {
    	return session_date;
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

	
    public long getTimestamp() {
    	return timestamp;
    }

	
    public void setSession_date(String session_date) {
    	this.session_date = session_date;
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
