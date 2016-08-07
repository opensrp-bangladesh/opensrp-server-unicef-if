package org.opensrp.register.mcare.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.ektorp.support.TypeDiscriminator;
import org.joda.time.DateTime;
import org.motechproject.model.MotechBaseDataObject;

@JsonIgnoreProperties(ignoreUnknown = true)
@TypeDiscriminator("doc.type === 'HouseHold'")
public class HouseHold extends MotechBaseDataObject {
	@JsonProperty
	private String caseId;
	@JsonProperty
	private String INSTANCEID;
	@JsonProperty
	private String PROVIDERID;
	@JsonProperty
	private String LOCATIONID;
	@JsonProperty
	private String TODAY;
	@JsonProperty
	private String START;
	@JsonProperty
	private String END;
	@JsonProperty
	private String Date_Of_Reg;
	@JsonProperty
	private String HoH_HID;
	@JsonProperty
	private String COUNTRY;
	@JsonProperty
	private String DIVISION;
	@JsonProperty
	private String DISTRICT;
	@JsonProperty
	private String UPAZILLA;
	@JsonProperty
	private String UNION;
	@JsonProperty
	private String WARD;
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
	private String HoH_birth_date_known;
	@JsonProperty
	private String HoH_Lname;
	@JsonProperty
	private String HoH_age; 
	@JsonProperty
	private String HoH_Gender;
	@JsonProperty
	private String HoH_Unique_ID;
	@JsonProperty
	private String HoH_NID;
	@JsonProperty
	private String HoH_BRID;
	@JsonProperty
	private String HoH_Mobile_No;
	@JsonProperty
	private String HoH_Education;
	@JsonProperty
	private String HoH_Occupation;
	@JsonProperty
	private String HH_Member_No;
	
	
	
	@JsonProperty
	private String deviceid;
	@JsonProperty
	private String subscriberid;
	@JsonProperty
	private String simserial;
	@JsonProperty
	private String phonenumber;
	@JsonProperty
	private String PAURASAVA;
	@JsonProperty
	private String ADDRESS_LINE;
	@JsonProperty
	private String HIE_FACILITIES; 
	@JsonProperty
	private String calc_HoH_age;
	@JsonProperty
	private String calc_HoH_dob;
	@JsonProperty
	private String calc_HoH_dob_confirm;
	@JsonProperty
	private String calc_dob_estimated;
	@JsonProperty
	private String calc_HoH_age_confirm;
	@JsonProperty
	private String birth_date_note;
	@JsonProperty
	private String note_age;
	
	
	
	@JsonProperty
	private List<Map<String, String>> MEMBERDETAILS;
	@JsonProperty
	private List<Map<String, String>> multimediaAttachments;
	@JsonProperty
	private Map<String, String> details;
	@JsonProperty
	private String BAHMNI_ID;
	
	public HouseHold() {
		this.MEMBERDETAILS = new ArrayList<>();
		this.multimediaAttachments = new ArrayList<>();
	}
	
	public HouseHold withCASEID(String caseId) {
		this.caseId = caseId;
		return this;
	}

	public HouseHold withBAHMNIID(String BAHMNI_ID){
		this.BAHMNI_ID = BAHMNI_ID;
		return this;
	}
	public HouseHold withINSTANCEID(String INSTANCEID) {
		this.INSTANCEID = INSTANCEID;
		return this;
	}

	public HouseHold withPROVIDERID(String PROVIDERID) {
		this.PROVIDERID = PROVIDERID;
		return this;
	}

	public HouseHold withLOCATIONID(String LOCATIONID) {
		this.LOCATIONID = LOCATIONID;
		return this;
	}

	public HouseHold withTODAY(String TODAY) {
		this.TODAY = TODAY;
		return this;
	}

	public HouseHold withSTART(String START) {
		this.START = START;
		return this;
	}

	public HouseHold withEND(String END) {
		this.END = END;
		return this;
	}

	public HouseHold withDate_Of_Reg(String Date_Of_Reg) {
		this.Date_Of_Reg = Date_Of_Reg;
		return this;
	}

	public HouseHold withHoH_HID(String HoH_HID) {
		this.HoH_HID = HoH_HID;
		return this;
	}

	public HouseHold withGPS(String GPS) {
		this.GPS = GPS;
		return this;
	}
	
	public HouseHold withHoH_Fname(String HoH_Fname) {
		this.HoH_Fname = HoH_Fname;
		return this;
	}

	public HouseHold withCOUNTRY(String COUNTRY) {
		this.COUNTRY = COUNTRY;
		return this;
	}

	public HouseHold withDIVISION(String DIVISION) {
		this.DIVISION = DIVISION;
		return this;
	}

	public HouseHold withDISTRICT(String DISTRICT) {
		this.DISTRICT = DISTRICT;
		return this;
	}

	public HouseHold withUPAZILLA(String UPAZILLA) {
		this.UPAZILLA = UPAZILLA;
		return this;
	}

	public HouseHold withUNION(String UNION) {
		this.UNION = UNION;
		return this;
	}

	public HouseHold withWARD(String WARD) {
		this.WARD = WARD;
		return this;
	}

	public HouseHold withHHID(String HHID) {
		this.HHID = HHID;
		return this;
	}
	
	public HouseHold withHoH_Reg_No(String HoH_Reg_No) {
		this.HoH_Reg_No = HoH_Reg_No;
		return this;
	}
	
	public HouseHold withHoH_birth_date(String HoH_birth_date) {
		this.HoH_birth_date = HoH_birth_date;
		return this;
	}

	public HouseHold withHoH_birth_date_known(String HoH_birth_date_known) {
		this.HoH_birth_date_known = HoH_birth_date_known;
		return this;
	}

	
	public HouseHold withHoH_Lname(String HoH_Lname) {
		this.HoH_Lname = HoH_Lname;
		return this;
	}

	public HouseHold withHoH_age(String HoH_age) {
		this.HoH_age = HoH_age;
		return this;
	}

	public HouseHold withHoH_Unique_ID(String HoH_Unique_ID) {
		this.HoH_Unique_ID = HoH_Unique_ID;
		return this;
	}

	public HouseHold withHoH_Gender(String HoH_Gender) {
		this.HoH_Gender = HoH_Gender;
		return this;
	}
	
	public HouseHold withHoH_NID(String HoH_NID) {
		this.HoH_NID = HoH_NID;
		return this;
	}

	public HouseHold withHoH_BRID(String HoH_BRID) {
		this.HoH_BRID = HoH_BRID;
		return this;
	}
	
	public HouseHold withHoH_Mobile_No(String HoH_Mobile_No) {
		this.HoH_Mobile_No = HoH_Mobile_No;
		return this;
	}

	public HouseHold withHoH_Education(String HoH_Education) {
		this.HoH_Education = HoH_Education;
		return this;
	}
	
	public HouseHold withHoH_Occupation(String HoH_Occupation) {
		this.HoH_Occupation = HoH_Occupation;
		return this;
	}
	
	public HouseHold withHH_Member_No(String HH_Member_No) {
		this.HH_Member_No = HH_Member_No;
		return this;
	}
	
	public HouseHold withdeviceid(String deviceid){
		this.deviceid = deviceid;
		return this;
	}

	public HouseHold withsubscriberid(String subscriberid){
		this.subscriberid = subscriberid;
		return this;
	}

	public HouseHold withsimserial(String simserial){
		this.simserial = simserial;
		return this;
	}

	public HouseHold withphonenumber(String phonenumber){
		this.phonenumber = phonenumber;
		return this;
	}

	public HouseHold withPAURASAVA(String PAURASAVA){
		this.PAURASAVA = PAURASAVA;
		return this;
	}

	public HouseHold withADDRESS_LINE(String ADDRESS_LINE){
		this.ADDRESS_LINE = ADDRESS_LINE;
		return this;
	}

	public HouseHold withHIE_FACILITIES(String HIE_FACILITIES){
		this.HIE_FACILITIES = HIE_FACILITIES;
		return this;
	}

	public HouseHold withcalc_HoH_age(String calc_HoH_age){
		this.calc_HoH_age = calc_HoH_age;
		return this;
	}

	public HouseHold withcalc_HoH_dob(String calc_HoH_dob){
		this.calc_HoH_dob = calc_HoH_dob;
		return this;
	}

	public HouseHold withcalc_HoH_dob_confirm(String calc_HoH_dob_confirm){
		this.calc_HoH_dob_confirm = calc_HoH_dob_confirm;
		return this;
	}


	public HouseHold withcalc_dob_estimated(String calc_dob_estimated){
		this.calc_dob_estimated = calc_dob_estimated;
		return this;
	}

	public HouseHold withcalc_HoH_age_confirm(String calc_HoH_age_confirm){
		this.calc_HoH_age_confirm = calc_HoH_age_confirm;
		return this;
	}

	public HouseHold withbirth_date_note(String birth_date_note){
		this.birth_date_note = birth_date_note;
		return this;
	}

	public HouseHold withnote_age(String note_age){
		this.note_age  = note_age ;
		return this;
	}
	
	public HouseHold withMEMBERDETAILS(List<Map<String, String>> MEMBERDETAILS) {
		this.MEMBERDETAILS = MEMBERDETAILS;
		return this;
	}
	
	public HouseHold withmultimediaAttachments(List<Map<String, String>> multimediaAttachments) {
		this.multimediaAttachments = multimediaAttachments;
		return this;
	}
	
	public HouseHold withDetails(Map<String, String> details) {
        this.details = new HashMap<>(details);
        return this;
    }

	public String caseId() {
		return caseId;
	}
	public String BAHMNIID(){
		return BAHMNI_ID;
	}
	public String INSTANCEID() {
		return INSTANCEID;
	}

	public String PROVIDERID() {
		return PROVIDERID;
	}

	public String LOCATIONID() {
		return LOCATIONID;
	}

	public String TODAY() {
		return TODAY;
	}

	public String START() {
		return START;

	}

	public String END() {
		return END;
	}

	public String Date_Of_Reg() {
		return Date_Of_Reg;
	}
	
	public String HoH_HID() {
		return HoH_HID;
	}

	public String GPS() {
		return GPS;
	}
	
	public String HoH_Fname() {
		return HoH_Fname;
	}

	public String COUNTRY() {
		return COUNTRY;
	}
	
	public String DIVISION() {
		return DIVISION;
	}
	
	public String DISTRICT() {
		return DISTRICT;
	}
	
	public String UPAZILLA() {
		return UPAZILLA;
	}
	
	public String UNION() {
		return UNION;
	}
	
	public String WARD() {
		return WARD;
	}
	
	public String HHID() {
		return HHID;
	}
	
	public String HoH_Reg_No() {
		return HoH_Reg_No;
	}

	public String HoH_birth_date() {
		return HoH_birth_date;
	}
	
	public String HoH_birth_date_known() {
		return HoH_birth_date_known;
	}
	
	public String HoH_Lname() {
		return HoH_Lname;
	}

	public String HoH_age() {
		return HoH_age;
	}

	public String HoH_Unique_ID() {
		return HoH_Unique_ID;
	}

	public String HoH_Gender() {
		return HoH_Gender;
	}

	public String HoH_NID() {
		return HoH_NID;
	}

	public String HoH_BRID() {
		return HoH_BRID;
	}
	
	public String HoH_Mobile_No() {
		return HoH_Mobile_No;
	}

	public String HoH_Education() {
		return HoH_Education;
	}
	
	public String HoH_Occupation() {
		return HoH_Occupation;
	}

	public String HH_Member_No() {
		return HH_Member_No;
	}
	
	public List<Map<String, String>> MEMBERDETAILS() {
		if (MEMBERDETAILS == null) {
			MEMBERDETAILS = new ArrayList<>();
		}
		return MEMBERDETAILS;
	}
	
	public List<Map<String, String>> multimediaAttachments() {
		if (multimediaAttachments == null) {
			multimediaAttachments = new ArrayList<>();
		}
		return multimediaAttachments;
	}

	private String getCaseId() {
		return caseId;
	}

	public Map<String, String> details() {
		if (details == null)
			this.details = new HashMap<>();
		return details;
	}

	public String getDetail(String name) {
		return details.get(name);
	}
	
	public String getELCODetail(String name) {	
		/*int size = MEMBERDETAILS.size();
		String elems = "";
		for (int i = 0; i < size; i++)
			elems = elems + MEMBERDETAILS.get(i).get(name) + " " ;
		return elems;	*/	

		return MEMBERDETAILS.get(0).get(name);
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