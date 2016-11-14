package org.opensrp.dto.register;

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
public class HouseholdEntryDTO {
	@JsonProperty
	private String caseId;
	@JsonProperty("INSTANCEID")
	private String INSTANCEID;
	@JsonProperty("PROVIDERID")
	private String PROVIDERID;	
	@JsonProperty("TODAY")
	private String TODAY;
	@JsonProperty("START")
	private String START;
	@JsonProperty("END")
	private String END;
	@JsonProperty
	private String Date_Of_Reg;
	@JsonProperty
	private String HoH_HID;
	@JsonProperty("COUNTRY")
	private String COUNTRY;
	@JsonProperty("DIVISION")
	private String DIVISION;
	@JsonProperty("DISTRICT")
	private String DISTRICT;
	@JsonProperty("UPAZILLA")
	private String UPAZILLA;
	@JsonProperty("UNION")
	private String UNION;
	@JsonProperty("WARD")
	private String WARD;
	@JsonProperty
	private String BLOCK;	
	@JsonProperty
	private String HHID;
	@JsonProperty
	private String HoH_Reg_No;
	@JsonProperty
	private String GPS;
	@JsonProperty
	private String HoH_Fname;
	@JsonProperty
	private String HoH_birth_date;	
	@JsonProperty
	private String HoH_Lname;
	@JsonProperty
	private String HoH_Gender;
	@JsonProperty
	private String HoH_NID;
	@JsonProperty
	private String HoH_BRID;
	@JsonProperty
	private String HoH_Mobile_No;
	@JsonProperty
	private String HH_Member_No;
	
	
	public HouseholdEntryDTO() {
		
	}	
    public String getCaseId() {
    	return caseId;
    }
    @JsonProperty("INSTANCEID")
    public String getINSTANCEID() {
    	return INSTANCEID;
    }

    @JsonProperty("PROVIDERID")
    public String getPROVIDERID() {
    	return PROVIDERID;
    }

	
    public String getTODAY() {
    	return TODAY;
    }

	
    public String getSTART() {
    	return START;
    }

	
    public String getEND() {
    	return END;
    }

	
    public String getDate_Of_Reg() {
    	return Date_Of_Reg;
    }

	
    public String getHoH_HID() {
    	return HoH_HID;
    }

    @JsonProperty("COUNTRY")
    public String getCOUNTRY() {
    	return COUNTRY;
    }

    @JsonProperty("DIVISION")
    public String getDIVISION() {
    	return DIVISION;
    }

    @JsonProperty("DISTRICT")
    public String getDISTRICT() {
    	return DISTRICT;
    }

    @JsonProperty("UPAZILLA")
    public String getUPAZILLA() {
    	return UPAZILLA;
    }

    @JsonProperty("UNION")
    public String getUNION() {
    	return UNION;
    }

    @JsonProperty("WARD")
    public String getWARD() {
    	return WARD;
    }

    @JsonProperty("BLOCK")
    public String getBLOCK() {
    	return BLOCK;
    }

    @JsonProperty("HHID")
    public String getHHID() {
    	return HHID;
    }

	
    public String getHoH_Reg_No() {
    	return HoH_Reg_No;
    }

    @JsonProperty("GPS")
    public String getGPS() {
    	return GPS;
    }

	
    public String getHoH_Fname() {
    	return HoH_Fname;
    }

	
    public String getHoH_birth_date() {
    	return HoH_birth_date;
    }

	
    public String getHoH_Lname() {
    	return HoH_Lname;
    }

	
    public String getHoH_Gender() {
    	return HoH_Gender;
    }

	
    public String getHoH_NID() {
    	return HoH_NID;
    }

	
    public String getHoH_BRID() {
    	return HoH_BRID;
    }

	
    public String getHoH_Mobile_No() {
    	return HoH_Mobile_No;
    }

	
    public String getHH_Member_No() {
    	return HH_Member_No;
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