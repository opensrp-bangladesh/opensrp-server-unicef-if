package org.opensrp.dashboard.dto;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

public class UnitDashboardLocationInfo {
	@JsonProperty
	private String tagName;
	
	@JsonProperty
	private List<DashboardLocationDTO> ownSiblings;  // refers to all the children of the parent of this location
	
	@JsonProperty
	private DashboardLocationDTO currentSelection;
	
	@JsonProperty
	private DashboardLocationDTO parentSelection;
	
	
	public UnitDashboardLocationInfo() {
		
	}	
	
	public String getTagName() {
		return tagName;
	}


	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	public DashboardLocationDTO getParentSelection() {
		return parentSelection;
	}

	public void setParentSelection(DashboardLocationDTO parentSelection) {
		this.parentSelection = parentSelection;
	}

	public DashboardLocationDTO getCurrentSelection() {
		return currentSelection;
	}

	public void setCurrentSelection(DashboardLocationDTO currentSelection) {
		this.currentSelection = currentSelection;
	}
	
	public List<DashboardLocationDTO> getOwnSiblings() {
		return ownSiblings;
	}

	public void setOwnSiblings(List<DashboardLocationDTO> ownSiblings) {
		this.ownSiblings = ownSiblings;
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
