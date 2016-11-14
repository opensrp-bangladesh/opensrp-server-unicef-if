package org.opensrp.dashboard.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

public class LocationTagDTO {
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String id;
	@JsonProperty
	private String parentTagId;
	
	public LocationTagDTO() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	public String getParentTagId(){
		return parentTagId;
	}
	
	public LocationTagDTO withName(String name){
		this.name = name;
		return this;
	}
	
	public LocationTagDTO withId(String id){
		this.id = id;
		return this;
	}
	
	public LocationTagDTO withParentTagId(String parentTagid){
		this.parentTagId = parentTagid;
		return this;
	}
	
	@Override
	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o);
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
