package org.opensrp.dashboard.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

public class DashboardLocationInfoDTONew {
	@JsonProperty
	private String tagName;
	
	@JsonProperty
	private List<UnitDashboardLocationInfo> locations;  // refers to all the children of the parent of this location
	
	public DashboardLocationInfoDTONew() {
		locations = new ArrayList<UnitDashboardLocationInfo>();
	}	
	
	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public List<UnitDashboardLocationInfo> getLocations() {
		return locations;
	}
	
	public void setLocations(UnitDashboardLocationInfo location) {
		this.locations.add(location);
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
