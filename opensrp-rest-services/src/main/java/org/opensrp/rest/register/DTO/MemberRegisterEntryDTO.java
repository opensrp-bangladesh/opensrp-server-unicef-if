package org.opensrp.rest.register.DTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;
public class MemberRegisterEntryDTO extends Member {
	
	@JsonProperty
	private String Child_gender;
	@JsonProperty
	private String Child_mother_name;
	@JsonProperty
	private String Child_father_name;	
	@JsonProperty
	private String Child_dob;
	
	
    public String getChild_gender() {
    	return Child_gender;
    }
	
    public String getChild_mother_name() {
    	return Child_mother_name;
    }
	
    public String getChild_father_name() {
    	return Child_father_name;
    }
	
    public String getChild_dob() {
    	return Child_dob;
    }
   
	
    public void setChild_gender(String child_gender) {
    	Child_gender = child_gender;
    }
	
    public void setChild_mother_name(String child_mother_name) {
    	Child_mother_name = child_mother_name;
    }
	
    public void setChild_father_name(String child_father_name) {
    	Child_father_name = child_father_name;
    }
	
    public void setChild_dob(String child_dob) {
    	Child_dob = child_dob;
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