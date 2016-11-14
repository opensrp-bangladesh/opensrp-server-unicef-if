package org.opensrp.dashboard.dto;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

public class DashboardLocationInfoDTO {
	@JsonProperty
	private String tagName;
	
	@JsonProperty
	private List<DashboardLocationDTO> ownSiblings;  // refers to all the children of the parent of this location
	
	@JsonProperty
	private DashboardLocationDTO parentWard;
	@JsonProperty
	private List<DashboardLocationDTO> parentWardSiblings;
	
	@JsonProperty
	private DashboardLocationDTO parentUnion;
	@JsonProperty
	private List<DashboardLocationDTO> parentUnionSiblings;
	
	@JsonProperty
	private DashboardLocationDTO parentUpazilla;
	@JsonProperty
	private List<DashboardLocationDTO> parentUpazillaSiblings;
	
	@JsonProperty
	private DashboardLocationDTO parentDistrict;
	@JsonProperty
	private List<DashboardLocationDTO> parentDistrictSiblings;
	
	@JsonProperty
	private DashboardLocationDTO parentDivision;
	@JsonProperty
	private List<DashboardLocationDTO> parentDivisionSiblings;
	
	
	public DashboardLocationInfoDTO() {
		
	}	
	
	public String getTagName() {
		return tagName;
	}


	public void setTagName(String tagName) {
		this.tagName = tagName;
	}


	public DashboardLocationDTO getParentWard() {
		return parentWard;
	}


	public void setParentWard(DashboardLocationDTO parentWard) {
		this.parentWard = parentWard;
	}


	public List<DashboardLocationDTO> getParentWardSiblings() {
		return parentWardSiblings;
	}


	public void setParentWardSiblings(List<DashboardLocationDTO> parentWardSiblings) {
		this.parentWardSiblings = parentWardSiblings;
	}


	public DashboardLocationDTO getParentUnion() {
		return parentUnion;
	}


	public void setParentUnion(DashboardLocationDTO parentUnion) {
		this.parentUnion = parentUnion;
	}


	public List<DashboardLocationDTO> getParentUnionSiblings() {
		return parentUnionSiblings;
	}


	public void setParentUnionSiblings(
			List<DashboardLocationDTO> parentUnionSiblings) {
		this.parentUnionSiblings = parentUnionSiblings;
	}


	public DashboardLocationDTO getParentUpazilla() {
		return parentUpazilla;
	}


	public void setParentUpazilla(DashboardLocationDTO parentUpazilla) {
		this.parentUpazilla = parentUpazilla;
	}


	public List<DashboardLocationDTO> getParentUpazillaSiblings() {
		return parentUpazillaSiblings;
	}


	public void setParentUpazillaSiblings(
			List<DashboardLocationDTO> parentUpazillaSiblings) {
		this.parentUpazillaSiblings = parentUpazillaSiblings;
	}


	public DashboardLocationDTO getParentDistrict() {
		return parentDistrict;
	}


	public void setParentDistrict(DashboardLocationDTO parentDistrict) {
		this.parentDistrict = parentDistrict;
	}


	public List<DashboardLocationDTO> getParentDistrictSiblings() {
		return parentDistrictSiblings;
	}


	public void setParentDistrictSiblings(
			List<DashboardLocationDTO> parentDistrictSiblings) {
		this.parentDistrictSiblings = parentDistrictSiblings;
	}


	public DashboardLocationDTO getParentDivision() {
		return parentDivision;
	}


	public void setParentDivision(DashboardLocationDTO parentDivision) {
		this.parentDivision = parentDivision;
	}


	public List<DashboardLocationDTO> getParentDivisionSiblings() {
		return parentDivisionSiblings;
	}


	public void setParentDivisionSiblings(
			List<DashboardLocationDTO> parentDivisionSiblings) {
		this.parentDivisionSiblings = parentDivisionSiblings;
	}
	
	
	public List<DashboardLocationDTO> getOwnSiblings() {
		return ownSiblings;
	}

	public void setOwnSiblings(List<DashboardLocationDTO> ownSiblings) {
		this.ownSiblings = ownSiblings;
	}
	
	public DashboardLocationInfoDTO setMember(String currentTag, DashboardLocationDTO currentParentDTO, List<DashboardLocationDTO>parentSiblingsDTOs){
		if(currentTag.equals("Unit")){
			this.setParentWard(currentParentDTO);
			this.setParentWardSiblings(parentSiblingsDTOs);							
		}
		else if(currentTag.equals("Ward")){
			this.setParentUnion(currentParentDTO);
			this.setParentUnionSiblings(parentSiblingsDTOs);
		}
		else if(currentTag.equals("Union")){
			this.setParentUpazilla(currentParentDTO);
			this.setParentUpazillaSiblings(parentSiblingsDTOs);
		}
		else if(currentTag.equals("Upazilla")){
			this.setParentDistrict(currentParentDTO);
			this.setParentDistrictSiblings(parentSiblingsDTOs);
		}
		else if(currentTag.equals("District")){
			this.setParentDivision(currentParentDTO);
			this.setParentDivisionSiblings(parentSiblingsDTOs);
		}
		else if(currentTag.equals("Division")){
			this.setParentDivision(currentParentDTO);
		}
		
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
