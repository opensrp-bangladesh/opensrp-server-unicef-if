package org.opensrp.dashboard.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;
import org.ektorp.support.TypeDiscriminator;
import org.motechproject.model.MotechBaseDataObject;


@TypeDiscriminator("doc.type === 'DashboardLocation'")
public class DashboardLocation extends MotechBaseDataObject {
	
	private static final long serialVersionUID = 1L;
	@JsonProperty("name")
	private String name;
	@JsonProperty("tagId")
	private String tagId;
	
	@JsonProperty("parentName")
	private String parentName;
	@JsonProperty("parentId")
	private String parentId;	
	
	@JsonProperty("status")
	private String status;
	@JsonProperty("meta")
	private Map<String, String> meta;
	@JsonProperty("created_at")
	private String created_at;
	@JsonProperty("updated_at")
	private String updated_at;
	@JsonProperty("created_by")
	private String created_by;
	@JsonProperty("updated_by")
	private String updated_by;
	
	@JsonProperty("name")
	public DashboardLocation withName(String name) {
		this.name = name;
		return this;
	}
	
	@JsonProperty("tagId")
	public DashboardLocation withTagId(String tagId) {
		this.tagId = tagId;
		return this;
	}
	
	@JsonProperty("parentName")
	public DashboardLocation withParentName(String parentName) {
		this.parentName = parentName;
		return this;
	}
	
	@JsonProperty("parentId")
	public DashboardLocation withParentId(String parentId) {
		this.parentId = parentId;
		return this;
	}
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	
	@JsonProperty("tagId")
	public String getTagId() {
		return tagId;
	}
	
	@JsonProperty("parentName")
	public String getParentName() {
		return parentName;
	}
	
	@JsonProperty("parentId")
	public String getParentId() {
		return parentId;
	}
	
	@Override
	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o, "id", "revision");
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id", "revision");
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}