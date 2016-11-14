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


@TypeDiscriminator("doc.type === 'LocationTag'")
public class LocationTag extends MotechBaseDataObject {
	
	private static final long serialVersionUID = 1L;
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("parentTagId")
	private String parentTagId;
	
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
	public LocationTag withName(String name) {
		this.name = name;
		return this;
	}
	
	@JsonProperty("parentTagId")
	public LocationTag withParentTagId(String parentTagId) {
		this.parentTagId = parentTagId;
		return this;
	}
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	
	@JsonProperty("parentTagId")
	public String getParentTagId() {
		return parentTagId;
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