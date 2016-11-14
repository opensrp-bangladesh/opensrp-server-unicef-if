package org.opensrp.dashboard.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

public class DashboardLocationDTO {
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String id;
	@JsonProperty
	private String parentName;
	@JsonProperty
	private String parentId;
	@JsonProperty
	private String tagId;
	
	public DashboardLocationDTO() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	public String getParentName(){
		return parentName;
	}
	
	public String getParentId(){
		return parentId;
	}
	
	public String getTagId(){
		return tagId;
	}
	
	public void withName(String name) {
		this.name = name;
	}
	
	public void withId(String id) {
		this.id = id;
	}
	
	public void withParentname(String parentName){
		this.parentName = parentName;
	}
	
	public void withParentId(String parentId){
		this.parentId = parentId;
	}	
	
	public void withTagId(String tagId){
		this.tagId = tagId;
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
