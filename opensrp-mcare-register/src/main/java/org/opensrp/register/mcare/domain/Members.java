/**
 * @author Asifur
 */

package org.opensrp.register.mcare.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.ektorp.support.TypeDiscriminator;
import org.motechproject.model.MotechBaseDataObject;

@JsonIgnoreProperties(ignoreUnknown = true)
@TypeDiscriminator("doc.type === 'Members'")
public class Members extends MotechBaseDataObject {
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
	private String Member_COUNTRY
;
	@JsonProperty
	private String Member_DIVISION
;
	@JsonProperty
	private String Member_DISTRICT
;
	@JsonProperty
	private String Member_UPAZILLA
;
	@JsonProperty
	private String Member_Paurasava
;
	@JsonProperty
	private String Member_UNION
;
	@JsonProperty
	private String Member_WARD
;
	@JsonProperty
	private String Member_BLOCK
;
	@JsonProperty
	private String Member_Address_line
;
	@JsonProperty
	private String Member_HIE_facilities
;
	@JsonProperty
	private String Member_GPS
;
	@JsonProperty
	private String HH_Address
;
	@JsonProperty
	private String Member_type
;
	@JsonProperty
	private String Reg_No
;
	@JsonProperty
	private String Member_Fname
;
	@JsonProperty
	private String Member_LName
;
	@JsonProperty
	private String Member_Unique_ID
;
	@JsonProperty
	private String Member_NID
;
	@JsonProperty
	private String Member_BRID
;
	@JsonProperty
	private String Member_HID
;
	@JsonProperty
	private String member_birth_date_known
;
	@JsonProperty
	private String member_birth_date
;
	@JsonProperty
	private String age
;
	@JsonProperty
	private String calc_age
;
	@JsonProperty
	private String calc_dob
;
	@JsonProperty
	private String calc_dob_confirm
;
	@JsonProperty
	private String calc_dob_estimated
;
	@JsonProperty
	private String calc_age_confirm
;
	@JsonProperty
	private String birth_date_note
;
	@JsonProperty
	private String note_age
;
	@JsonProperty
	private String Gender
;
	@JsonProperty
	private String Father_name
;
	@JsonProperty
	private String Husband_name
;
	@JsonProperty
	private String Marital_status
;
	@JsonProperty
	private String Couple_No
;
	@JsonProperty
	private String WomanInfo
;
	@JsonProperty
	private String pregnant
;
	@JsonProperty
	private String FP_USER
;
	@JsonProperty
	private String FP_Methods
;
	@JsonProperty
	private String edd_lmp
;
	@JsonProperty
	private String edd
;
	@JsonProperty
	private String lmp
;
	@JsonProperty
	private String ultrasound_date
;
	@JsonProperty
	private String ultrasound_weeks
;
	@JsonProperty
	private String edd_calc_lmp
;
	@JsonProperty
	private String edd_calc_ultrasound
;
	@JsonProperty
	private String edd_calc_lmp_formatted
;
	@JsonProperty
	private String edd_calc_ultrasound_formatted
;
	@JsonProperty
	private String lmp_calc_edd
;
	@JsonProperty
	private String lmp_calc_ultrasound
;
	@JsonProperty
	private String lmp_calc_edd_formatted
;
	@JsonProperty
	private String lmp_calc_ultrasound_formatted
;
	@JsonProperty
	private String final_edd
;
	@JsonProperty
	private String final_lmp
;
	@JsonProperty
	private String ga_edd
;
	@JsonProperty
	private String ga_lmp
;
	@JsonProperty
	private String ga_ult
;
	@JsonProperty
	private String final_edd_note
;
	@JsonProperty
	private String final_lmp_note
;
	@JsonProperty
	private String final_ga
;
	@JsonProperty
	private String final_ga_note
;
	@JsonProperty
	private String vaccines
;
	@JsonProperty
	private String tt1_retro
;
	@JsonProperty
	private String tt_1_dose
;
	@JsonProperty
	private String tt2_retro
;
	@JsonProperty
	private String tt_2_dose
;
	@JsonProperty
	private String tt3_retro
;
	@JsonProperty
	private String tt_3_dose
;
	@JsonProperty
	private String tt4_retro
;
	@JsonProperty
	private String tt_4_dose
;
	@JsonProperty
	private String vaccines_2
;
	@JsonProperty
	private String tt1
;
	@JsonProperty
	private String tt_1_dose_today
;
	@JsonProperty
	private String tt2
;
	@JsonProperty
	private String tt_2_dose_today
;
	@JsonProperty
	private String tt3
;
	@JsonProperty
	private String tt_3_dose_today
;
	@JsonProperty
	private String tt4
;
	@JsonProperty
	private String tt_4_dose_today
;
	@JsonProperty
	private String tt5
;
	@JsonProperty
	private String tt_5_dose_today
;
	@JsonProperty
	private String tt1_final
;
	@JsonProperty
	private String tt2_final
;
	@JsonProperty
	private String tt3_final
;
	@JsonProperty
	private String tt4_final
;
	@JsonProperty
	private String tt5_final
;
	@JsonProperty
	private String Child_birth_date_known
;
	@JsonProperty
	private String Child_birth_date
;
	@JsonProperty
	private String Child_age
;
	@JsonProperty
	private String Child_calc_age
;
	@JsonProperty
	private String Child_calc_dob
;
	@JsonProperty
	private String Child_dob
;
	@JsonProperty
	private String Child_dob_estimated
;
	@JsonProperty
	private String Child_age_days
;
	@JsonProperty
	private String Child_birth_date_note
;
	@JsonProperty
	private String Birth_Weigtht
;
	@JsonProperty
	private String Newborn_Care_Received
;
	@JsonProperty
	private String Child_gender
;
	@JsonProperty
	private String Child_mother_name
;
	@JsonProperty
	private String Child_father_name
;
	@JsonProperty
	private String Child_guardian_id
;
	@JsonProperty
	private String Child_Mother_NID
;
	@JsonProperty
	private String Child_Mother_BRID
;
	@JsonProperty
	private String Child_Father_NID
;
	@JsonProperty
	private String Child_Father_BRID
;
	@JsonProperty
	private String Child_Other_Guardian_NID
;
	@JsonProperty
	private String Child_Other_Guardian_BRID
;
	@JsonProperty
	private String child_was_suffering_from_a_disease_at_birth
;
	@JsonProperty
	private String reminders_approval
;
	@JsonProperty
	private String contact_phone_number
;
	@JsonProperty
	private String child_vaccines
;
	@JsonProperty
	private String bcg_retro
;
	@JsonProperty
	private String opv0_retro
;
	@JsonProperty
	private String opv0_dose
;
	@JsonProperty
	private String pcv1_retro
;
	@JsonProperty
	private String pcv1_dose
;
	@JsonProperty
	private String opv1_retro
;
	@JsonProperty
	private String opv1_dose
;
	@JsonProperty
	private String penta1_retro
;
	@JsonProperty
	private String penta1_dose
;
	@JsonProperty
	private String pcv2_retro
;
	@JsonProperty
	private String pcv2_dose
;
	@JsonProperty
	private String opv2_retro
;
	@JsonProperty
	private String opv2_dose
;
	@JsonProperty
	private String penta2_retro
;
	@JsonProperty
	private String penta2_dose
;
	@JsonProperty
	private String pcv3_retro
;
	@JsonProperty
	private String pcv3_dose
;
	@JsonProperty
	private String opv3_retro
;
	@JsonProperty
	private String opv3_dose
;
	@JsonProperty
	private String penta3_retro
;
	@JsonProperty
	private String penta3_dose
;
	@JsonProperty
	private String ipv_retro
;
	@JsonProperty
	private String measles1_retro
;
	@JsonProperty
	private String measles1_dose
;
	@JsonProperty
	private String measles2_retro
;
	@JsonProperty
	private String measles2_dose
;
	@JsonProperty
	private String bcg
;
	@JsonProperty
	private String opv0
;
	@JsonProperty
	private String opv0_dose_today
;
	@JsonProperty
	private String pcv1
;
	@JsonProperty
	private String pcv1_dose_today
;
	@JsonProperty
	private String opv1
;
	@JsonProperty
	private String opv1_dose_today
;
	@JsonProperty
	private String penta1
;
	@JsonProperty
	private String penta1_dose_today
;
	@JsonProperty
	private String pcv2
;
	@JsonProperty
	private String pcv2_dose_today
;
	@JsonProperty
	private String opv2
;
	@JsonProperty
	private String opv2_dose_today
;
	@JsonProperty
	private String penta2
;
	@JsonProperty
	private String penta2_dose_today
;
	@JsonProperty
	private String pcv3
;
	@JsonProperty
	private String pcv3_dose_today
;
	@JsonProperty
	private String opv3
;
	@JsonProperty
	private String opv3_dose_today
;
	@JsonProperty
	private String penta3
;
	@JsonProperty
	private String penta3_dose_today
;
	@JsonProperty
	private String ipv
;
	@JsonProperty
	private String measles1
;
	@JsonProperty
	private String measles1_dose_today
;
	@JsonProperty
	private String measles2
;
	@JsonProperty
	private String measles2_dose_today
;
	@JsonProperty
	private String final_bcg
;
	@JsonProperty
	private String final_opv0
;
	@JsonProperty
	private String final_pcv1
;
	@JsonProperty
	private String final_opv1
;
	@JsonProperty
	private String final_penta1
;
	@JsonProperty
	private String final_pcv2
;
	@JsonProperty
	private String final_opv2
;
	@JsonProperty
	private String final_penta2
;
	@JsonProperty
	private String final_pcv3
;
	@JsonProperty
	private String final_opv3
;
	@JsonProperty
	private String final_penta3
;
	@JsonProperty
	private String final_ipv
;
	@JsonProperty
	private String final_measles1
;
	@JsonProperty
	private String final_measles2
;
	@JsonProperty
	private String Member_Reg_Date
;
	@JsonProperty
	private String child_vaccines_2
;
	@JsonProperty
	private String Is_woman
;
	@JsonProperty
	private String Is_child
;
	@JsonProperty
	private String Is_preg_outcome;
	@JsonProperty
	private String relationalid;
	@JsonProperty
	private Map<String, String> details;
	@JsonProperty
	private Map<String, String> TTVisit;
	@JsonProperty
	private Map<String, String> generalVisit;
	@JsonProperty
	private List<Map<String, String>> child_vaccine;
	@JsonProperty
	private Map<String, String> BNFVisit;
	@JsonProperty
	private String isClosed;
	public Members() {
		this.details = new HashMap<>();
		this.TTVisit = new HashMap<>();
		this.generalVisit = new HashMap<>();
		this.BNFVisit = new HashMap<>();
		this.child_vaccine = new ArrayList<>();
		this.setIsClosed(false);
	}
	
	public Members setCaseId(String caseId) {
		this.caseId = caseId;
		return this;
	}

	public Members setINSTANCEID(String INSTANCEID) {
		this.INSTANCEID = INSTANCEID;
		return this;
	}

	public Members setPROVIDERID(String PROVIDERID) {
		this.PROVIDERID = PROVIDERID;
		return this;
	}

	public Members setLOCATIONID(String LOCATIONID) {
		this.LOCATIONID = LOCATIONID;
		return this;
	}
	
	public Members setTODAY(String TODAY) {
		this.TODAY = TODAY;
		return this;
	}
	
	public Members setSTART(String START) {
		this.START = START;
		return this;
	}

	public Members setEND(String END) {
		this.END = END;
		return this;
	}

	public Members setMember_Fname(String Member_Fname) {
		this.Member_Fname = Member_Fname;
		return this;
	}

	public Members setReg_No(String Reg_No) {
		this.Reg_No = Reg_No;
		return this;
	}
	public Members setMember_LName(String Member_LName) {
		this.Member_LName = Member_LName;
		return this;
	}
	public Members setGender(String Gender) {
		this.Gender = Gender;
		return this;
	}

	public Members setage(String age) {
		this.age = age;
		return this;
	}
	
	public Members setMarital_status(String Marital_status) {
		this.Marital_status = Marital_status;
		return this;
	}
	
	public Members setedd(String edd) {
		this.edd = edd;
		return this;
	}
	
	public Members setMember_COUNTRY(String Member_COUNTRY) {
		this.Member_COUNTRY = Member_COUNTRY;
		return this;
	}
	
	public Members setMember_DIVISION(String Member_DIVISION) {
		this.Member_DIVISION = Member_DIVISION;
		return this;
	}
	
	public Members setMember_DISTRICT(String Member_DISTRICT) {
		this.Member_DISTRICT = Member_DISTRICT;
		return this;
	}
	
	public Members setMember_UPAZILLA(String Member_UPAZILLA) {
		this.Member_UPAZILLA = Member_UPAZILLA;
		return this;
	}
	
	public Members setMember_UNION(String Member_UNION) {
		this.Member_UNION = Member_UNION;
		return this;
	}
	
	public Members setMember_WARD(String Member_WARD) {
		this.Member_WARD = Member_WARD;
		return this;
	}
	
	public Members setMember_GPS(String Member_GPS) {
		this.Member_GPS = Member_GPS;
		return this;
	}
	
	public Members setMember_BLOCK(String Member_BLOCK) {
		this.Member_BLOCK = Member_BLOCK;
		return this;
	}
	
	public Members setDetails(Map<String, String> details) {
        this.details = new HashMap<>(details);
        return this;
    }
	public Members setgeneralVisit(Map<String, String> generalVisit) {
        this.generalVisit = new HashMap<>(generalVisit);
        return this;
    }
    public Members setTTVisit(Map<String, String> TTVisit) {
        this.TTVisit = new HashMap<>(TTVisit);
        return this;
    }
    public Members setBNFVisit(Map<String, String> BNFVisit) {
        this.BNFVisit = new HashMap<>(BNFVisit);
        return this;
    }
    public Members setchild_vaccine(List<Map<String, String>> child_vaccine) {
		this.child_vaccine = child_vaccine;
		return this;
	}
	public Members setMember_Address_line(String member_Address_line) {
		Member_Address_line = member_Address_line;
		return this;
	}
	public Members setMember_HIE_facilities(String member_HIE_facilities) {
		Member_HIE_facilities = member_HIE_facilities;
		return this;
	}
	public Members setHH_Address(String hH_Address) {
		HH_Address = hH_Address;
		return this;
	}
	public Members setMember_type(String member_type) {
		Member_type = member_type;
		return this;
	}
	public Members setMember_Unique_ID(String member_Unique_ID) {
		Member_Unique_ID = member_Unique_ID;
		return this;
	}
	public Members setMember_NID(String member_NID) {
		Member_NID = member_NID;
		return this;
	}
	public Members setMember_BRID(String member_BRID) {
		Member_BRID = member_BRID;
		return this;
	}
	public Members setMember_HID(String member_HID) {
		Member_HID = member_HID;
		return this;
	}
	public Members setMember_birth_date_known(String member_birth_date_known) {
		this.member_birth_date_known = member_birth_date_known;
		return this;
	}
	public Members setMember_birth_date(String member_birth_date) {
		this.member_birth_date = member_birth_date;
		return this;
	}
	public Members setCalc_age(String calc_age) {
		this.calc_age = calc_age;
		return this;
	}
	public Members setCalc_dob(String calc_dob) {
		this.calc_dob = calc_dob;
		return this;
	}
	public Members setCalc_dob_confirm(String calc_dob_confirm) {
		this.calc_dob_confirm = calc_dob_confirm;
		return this;
	}
	public Members setCalc_dob_estimated(String calc_dob_estimated) {
		this.calc_dob_estimated = calc_dob_estimated;
		return this;
	}
	public Members setCalc_age_confirm(String calc_age_confirm) {
		this.calc_age_confirm = calc_age_confirm;
		return this;
	}
	public Members setBirth_date_note(String birth_date_note) {
		this.birth_date_note = birth_date_note;
		return this;
	}
	public Members setNote_age(String note_age) {
		this.note_age = note_age;
		return this;		
	}
	public Members setFather_name(String father_name) {
		Father_name = father_name;
		return this;
	}
	public Members setHusband_name(String husband_name) {
		Husband_name = husband_name;
		return this;
	}
	public Members setCouple_No(String couple_No) {
		Couple_No = couple_No;
		return this;
	}
	public Members setWomanInfo(String womanInfo) {
		WomanInfo = womanInfo;
		return this;
	}
	public Members setPregnant(String pregnant) {
		this.pregnant = pregnant;
		return this;
	}
	public Members setFP_USER(String fP_USER) {
		FP_USER = fP_USER;
		return this;
	}
	public Members setFP_Methods(String fP_Methods) {
		FP_Methods = fP_Methods;
		return this;
	}
	public Members setEdd_lmp(String edd_lmp) {
		this.edd_lmp = edd_lmp;
		return this;
	}
	public Members setLmp(String lmp) {
		this.lmp = lmp;
		return this;
	}
	public Members setUltrasound_date(String ultrasound_date) {
		this.ultrasound_date = ultrasound_date;
		return this;
	}
	public Members setUltrasound_weeks(String ultrasound_weeks) {
		this.ultrasound_weeks = ultrasound_weeks;
		return this;
	}
	public Members setEdd_calc_lmp(String edd_calc_lmp) {
		this.edd_calc_lmp = edd_calc_lmp;
		return this;
	}
	public Members setEdd_calc_ultrasound(String edd_calc_ultrasound) {
		this.edd_calc_ultrasound = edd_calc_ultrasound;
		return this;
	}
	public Members setEdd_calc_lmp_formatted(String edd_calc_lmp_formatted) {
		this.edd_calc_lmp_formatted = edd_calc_lmp_formatted;
		return this;
	}
	public Members setEdd_calc_ultrasound_formatted(
			String edd_calc_ultrasound_formatted) {
		this.edd_calc_ultrasound_formatted = edd_calc_ultrasound_formatted;
		return this;
	}
	public Members setLmp_calc_edd(String lmp_calc_edd) {
		this.lmp_calc_edd = lmp_calc_edd;
		return this;
	}
	public Members setLmp_calc_ultrasound(String lmp_calc_ultrasound) {
		this.lmp_calc_ultrasound = lmp_calc_ultrasound;
		return this;
	}
	public Members setLmp_calc_edd_formatted(String lmp_calc_edd_formatted) {
		this.lmp_calc_edd_formatted = lmp_calc_edd_formatted;
		return this;
	}
	public Members setLmp_calc_ultrasound_formatted(
			String lmp_calc_ultrasound_formatted) {
		this.lmp_calc_ultrasound_formatted = lmp_calc_ultrasound_formatted;
		return this;
	}
	public Members setFinal_edd(String final_edd) {
		this.final_edd = final_edd;
		return this;
	}
	public Members setFinal_lmp(String final_lmp) {
		this.final_lmp = final_lmp;
		return this;
	}
	public Members setGa_edd(String ga_edd) {
		this.ga_edd = ga_edd;
		return this;
	}
	public Members setGa_lmp(String ga_lmp) {
		this.ga_lmp = ga_lmp;
		return this;
	}
	public Members setGa_ult(String ga_ult) {
		this.ga_ult = ga_ult;
		return this;
	}
	public Members setFinal_edd_note(String final_edd_note) {
		this.final_edd_note = final_edd_note;
		return this;
	}
	public Members setFinal_lmp_note(String final_lmp_note) {
		this.final_lmp_note = final_lmp_note;
		return this;
	}
	public Members setFinal_ga(String final_ga) {
		this.final_ga = final_ga;
		return this;
	}
	public Members setFinal_ga_note(String final_ga_note) {
		this.final_ga_note = final_ga_note;
		return this;
	}
	public Members setVaccines(String vaccines) {
		this.vaccines = vaccines;
		return this;
	}
	public Members setTt1_retro(String tt1_retro) {
		this.tt1_retro = tt1_retro;
		return this;
	}
	public Members setTt_1_dose(String tt_1_dose) {
		this.tt_1_dose = tt_1_dose;
		return this;
	}
	public Members setTt2_retro(String tt2_retro) {
		this.tt2_retro = tt2_retro;
		return this;
	}
	public Members setTt_2_dose(String tt_2_dose) {
		this.tt_2_dose = tt_2_dose;
		return this;
	}
	public Members setTt3_retro(String tt3_retro) {
		this.tt3_retro = tt3_retro;
		return this;
	}
	public Members setTt_3_dose(String tt_3_dose) {
		this.tt_3_dose = tt_3_dose;
		return this;
	}
	public Members setTt4_retro(String tt4_retro) {
		this.tt4_retro = tt4_retro;
		return this;
	}
	public Members setTt_4_dose(String tt_4_dose) {
		this.tt_4_dose = tt_4_dose;
		return this;
	}
	public Members setVaccines_2(String vaccines_2) {
		this.vaccines_2 = vaccines_2;
		return this;
	}
	public Members setTt1(String tt1) {
		this.tt1 = tt1;
		return this;
	}
	public Members setTt_1_dose_today(String tt_1_dose_today) {
		this.tt_1_dose_today = tt_1_dose_today;
		return this;
	}
	public Members setTt2(String tt2) {
		this.tt2 = tt2;
		return this;
	}
	public Members setTt_2_dose_today(String tt_2_dose_today) {
		this.tt_2_dose_today = tt_2_dose_today;
		return this;
	}
	public Members setTt3(String tt3) {
		this.tt3 = tt3;
		return this;
	}
	public Members setTt_3_dose_today(String tt_3_dose_today) {
		this.tt_3_dose_today = tt_3_dose_today;
		return this;
	}
	public Members setTt4(String tt4) {
		this.tt4 = tt4;
		return this;
	}
	public Members setTt_4_dose_today(String tt_4_dose_today) {
		this.tt_4_dose_today = tt_4_dose_today;
		return this;
	}
	public Members setTt5(String tt5) {
		this.tt5 = tt5;
		return this;
	}
	public Members setTt_5_dose_today(String tt_5_dose_today) {
		this.tt_5_dose_today = tt_5_dose_today;
		return this;
	}
	public Members setChild_birth_date_known(String child_birth_date_known) {
		Child_birth_date_known = child_birth_date_known;
		return this;
	}
	public Members setChild_birth_date(String child_birth_date) {
		Child_birth_date = child_birth_date;
		return this;
	}
	public Members setChild_age(String child_age) {
		Child_age = child_age;
		return this;
	}
	public Members setChild_calc_age(String child_calc_age) {
		Child_calc_age = child_calc_age;
		return this;
	}
	public Members setChild_calc_dob(String child_calc_dob) {
		Child_calc_dob = child_calc_dob;
		return this;
	}
	public Members setChild_dob(String child_dob) {
		Child_dob = child_dob;
		return this;
	}
	public Members setChild_dob_estimated(String child_dob_estimated) {
		Child_dob_estimated = child_dob_estimated;
		return this;
	}
	public Members setChild_age_days(String child_age_days) {
		Child_age_days = child_age_days;
		return this;
	}
	public Members setChild_birth_date_note(String child_birth_date_note) {
		Child_birth_date_note = child_birth_date_note;
		return this;
	}
	public Members setBirth_Weigtht(String birth_Weigtht) {
		Birth_Weigtht = birth_Weigtht;
		return this;
	}
	public Members setNewborn_Care_Received(String newborn_Care_Received) {
		Newborn_Care_Received = newborn_Care_Received;
		return this;
	}
	public Members setChild_gender(String child_gender) {
		Child_gender = child_gender;
		return this;
	}
	public Members setChild_mother_name(String child_mother_name) {
		Child_mother_name = child_mother_name;
		return this;
	}
	public Members setChild_father_name(String child_father_name) {
		Child_father_name = child_father_name;
		return this;
	}
	public void setChild_guardian_id(String child_guardian_id) {
		Child_guardian_id = child_guardian_id;
	}
	public void setChild_Mother_NID(String child_Mother_NID) {
		Child_Mother_NID = child_Mother_NID;
	}
	public void setChild_Mother_BRID(String child_Mother_BRID) {
		Child_Mother_BRID = child_Mother_BRID;
	}
	public void setChild_Father_NID(String child_Father_NID) {
		Child_Father_NID = child_Father_NID;
	}
	public void setChild_Father_BRID(String child_Father_BRID) {
		Child_Father_BRID = child_Father_BRID;
	}
	public void setChild_Other_Guardian_NID(String child_Other_Guardian_NID) {
		Child_Other_Guardian_NID = child_Other_Guardian_NID;
	}
	public void setChild_Other_Guardian_BRID(String child_Other_Guardian_BRID) {
		Child_Other_Guardian_BRID = child_Other_Guardian_BRID;
	}
	public Members setChild_was_suffering_from_a_disease_at_birth(
			String child_was_suffering_from_a_disease_at_birth) {
		this.child_was_suffering_from_a_disease_at_birth = child_was_suffering_from_a_disease_at_birth;
		return this;
	}
	public Members setReminders_approval(String reminders_approval) {
		this.reminders_approval = reminders_approval;
		return this;
	}
	public Members setContact_phone_number(String contact_phone_number) {
		this.contact_phone_number = contact_phone_number;
		return this;
	}
	public Members setChild_vaccines(String child_vaccines) {
		this.child_vaccines = child_vaccines;
		return this;
	}
	public Members setOpv0_retro(String opv0_retro) {
		this.opv0_retro = opv0_retro;
		return this;
	}
	public Members setOpv0_dose(String opv0_dose) {
		this.opv0_dose = opv0_dose;
		return this;
	}
	public Members setPcv1_retro(String pcv1_retro) {
		this.pcv1_retro = pcv1_retro;
		return this;
	}
	public Members setPcv1_dose(String pcv1_dose) {
		this.pcv1_dose = pcv1_dose;
		return this;
	}
	public Members setOpv1_retro(String opv1_retro) {
		this.opv1_retro = opv1_retro;
		return this;
	}
	public Members setOpv1_dose(String opv1_dose) {
		this.opv1_dose = opv1_dose;
		return this;
	}
	public Members setPenta1_retro(String penta1_retro) {
		this.penta1_retro = penta1_retro;
		return this;
	}
	public Members setPenta1_dose(String penta1_dose) {
		this.penta1_dose = penta1_dose;
		return this;
	}
	public Members setPcv2_retro(String pcv2_retro) {
		this.pcv2_retro = pcv2_retro;
		return this;
	}
	public Members setPcv2_dose(String pcv2_dose) {
		this.pcv2_dose = pcv2_dose;
		return this;
	}
	public Members setOpv2_retro(String opv2_retro) {
		this.opv2_retro = opv2_retro;
		return this;
	}
	public Members setOpv2_dose(String opv2_dose) {
		this.opv2_dose = opv2_dose;
		return this;
	}
	public Members setPenta2_retro(String penta2_retro) {
		this.penta2_retro = penta2_retro;
		return this;
	}
	public Members setPenta2_dose(String penta2_dose) {
		this.penta2_dose = penta2_dose;
		return this;
	}
	public Members setPcv3_retro(String pcv3_retro) {
		this.pcv3_retro = pcv3_retro;
		return this;
	}
	public Members setPcv3_dose(String pcv3_dose) {
		this.pcv3_dose = pcv3_dose;
		return this;
	}
	public Members setOpv3_retro(String opv3_retro) {
		this.opv3_retro = opv3_retro;
		return this;
	}
	public Members setOpv3_dose(String opv3_dose) {
		this.opv3_dose = opv3_dose;
		return this;
	}
	public Members setPenta3_retro(String penta3_retro) {
		this.penta3_retro = penta3_retro;
		return this;
	}
	public Members setPenta3_dose(String penta3_dose) {
		this.penta3_dose = penta3_dose;
		return this;
	}
	public Members setIpv_retro(String ipv_retro) {
		this.ipv_retro = ipv_retro;
		return this;
	}
	public Members setMeasles1_retro(String measles1_retro) {
		this.measles1_retro = measles1_retro;
		return this;
	}
	public Members setMeasles1_dose(String measles1_dose) {
		this.measles1_dose = measles1_dose;
		return this;
	}
	public Members setMeasles2Visit_retro(String measles2_retro) {
		this.measles2_retro = measles2_retro;
		return this;
	}
	public Members setMeasles2Visit_dose(String measles2_dose) {
		this.measles2_dose = measles2_dose;
		return this;
	}
	public Members setbcg(String bcg) {
		this.bcg = bcg;
		return this;
	}
	public Members setOpv0(String opv0) {
		this.opv0 = opv0;
		return this;
	}
	public Members setOpv0_dose_today(String opv0_dose_today) {
		this.opv0_dose_today = opv0_dose_today;
		return this;
	}
	public Members setPcv1(String pcv1) {
		this.pcv1 = pcv1;
		return this;
	}
	public Members setPcv1_dose_today(String pcv1_dose_today) {
		this.pcv1_dose_today = pcv1_dose_today;
		return this;
	}
	public Members setOpv1(String opv1) {
		this.opv1 = opv1;
		return this;
	}
	public Members setOpv1_dose_today(String opv1_dose_today) {
		this.opv1_dose_today = opv1_dose_today;
		return this;
	}
	public Members setPenta1(String penta1) {
		this.penta1 = penta1;
		return this;
	}
	public Members setPenta1_dose_today(String penta1_dose_today) {
		this.penta1_dose_today = penta1_dose_today;
		return this;
	}
	public Members setPcv2(String pcv2) {
		this.pcv2 = pcv2;
		return this;
	}
	public Members setPcv2_dose_today(String pcv2_dose_today) {
		this.pcv2_dose_today = pcv2_dose_today;
		return this;
	}
	public Members setOpv2(String opv2) {
		this.opv2 = opv2;
		return this;
	}
	public Members setOpv2_dose_today(String opv2_dose_today) {
		this.opv2_dose_today = opv2_dose_today;
		return this;
	}
	public Members setPenta2(String penta2) {
		this.penta2 = penta2;
		return this;
	}
	public Members setPenta2_dose_today(String penta2_dose_today) {
		this.penta2_dose_today = penta2_dose_today;
		return this;
	}
	public Members setPcv3(String pcv3) {
		this.pcv3 = pcv3;
		return this;
	}
	public Members setPcv3_dose_today(String pcv3_dose_today) {
		this.pcv3_dose_today = pcv3_dose_today;
		return this;
	}
	public Members setOpv3(String opv3) {
		this.opv3 = opv3;
		return this;
	}
	public Members setOpv3_dose_today(String opv3_dose_today) {
		this.opv3_dose_today = opv3_dose_today;
		return this;
	}
	public Members setPenta3(String penta3) {
		this.penta3 = penta3;
		return this;
	}
	public Members setPenta3_dose_today(String penta3_dose_today) {
		this.penta3_dose_today = penta3_dose_today;
		return this;
	}
	public Members setIpv(String ipv) {
		this.ipv = ipv;
		return this;
	}
	public Members setMeasles1(String measles1) {
		this.measles1 = measles1;
		return this;
	}
	public Members setMeasles1_dose_today(String measles1_dose_today) {
		this.measles1_dose_today = measles1_dose_today;
		return this;
	}
	public Members setIs_woman(String Is_woman) {
		this.Is_woman = Is_woman;
		return this;
	}
	public Members setIs_child(String Is_child) {
		this.Is_child = Is_child;
		return this;
	}
	public Members setIs_preg_outcomed(String Is_preg_outcome) {
		this.Is_preg_outcome = Is_preg_outcome;
		return this;
	}
	public Members setrelationalid(String relationalid) {
		this.relationalid = relationalid;
		return this;
	}
	public Members setMember_Paurasava(String Member_Paurasava) {
		this.Member_Paurasava = Member_Paurasava;
		return this;
	}
	public Members set_Measles2_Visit(String measles2) {
		this.measles2 = measles2;
		return this;
	}
	
	public Members setMeasles2Visit_dose_today(String measles2_dose_today) {
		this.measles2_dose_today = measles2_dose_today;
		return this;
	}
	
	public void setTt1_final(String tt1_final) {
		this.tt1_final = tt1_final;
	}

	public void setTt2_final(String tt2_final) {
		this.tt2_final = tt2_final;
	}

	public void setTt3_final(String tt3_final) {
		this.tt3_final = tt3_final;
	}

	public void setTt4_final(String tt4_final) {
		this.tt4_final = tt4_final;
	}

	public void setTt5_final(String tt5_final) {
		this.tt5_final = tt5_final;
	}

	public void setFinal_bcg(String final_bcg) {
		this.final_bcg = final_bcg;
	}

	public void setFinal_opv0(String final_opv0) {
		this.final_opv0 = final_opv0;
	}

	public void setFinal_pcv1(String final_pcv1) {
		this.final_pcv1 = final_pcv1;
	}

	public void setFinal_opv1(String final_opv1) {
		this.final_opv1 = final_opv1;
	}

	public void setFinal_penta1(String final_penta1) {
		this.final_penta1 = final_penta1;
	}

	public void setFinal_pcv2(String final_pcv2) {
		this.final_pcv2 = final_pcv2;
	}

	public void setFinal_opv2(String final_opv2) {
		this.final_opv2 = final_opv2;
	}

	public void setFinal_penta2(String final_penta2) {
		this.final_penta2 = final_penta2;
	}

	public void setFinal_pcv3(String final_pcv3) {
		this.final_pcv3 = final_pcv3;
	}

	public void setFinal_opv3(String final_opv3) {
		this.final_opv3 = final_opv3;
	}

	public void setFinal_penta3(String final_penta3) {
		this.final_penta3 = final_penta3;
	}

	public void setFinal_ipv(String final_ipv) {
		this.final_ipv = final_ipv;
	}

	public void setFinal_measles1(String final_measles1) {
		this.final_measles1 = final_measles1;
	}

	public void setFinal_measles2(String final_measles2) {
		this.final_measles2 = final_measles2;
	}
	public void setMember_Reg_Date(String Member_Reg_Date) {
		this.Member_Reg_Date = Member_Reg_Date;
	}
	public void setchild_vaccines_2(String child_vaccines_2) {
		this.child_vaccines_2 = child_vaccines_2;
	}
	public String caseId() {
		return caseId;
	}
	
	private String getCaseId() {
		return caseId;
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
	
	public String Member_Fname() {
		return Member_Fname;
	}
	public String Reg_No() {
		return Reg_No;
	}
	public String Member_LName() {
		return Member_LName;
	}
	public String Gender() {
		return Gender;
	}

	public String age() {
		return age;
	}
	
	public String Marital_status() {
		return Marital_status;
	}

	public String Couple_No() {
		return Couple_No;
	}

	public String Member_COUNTRY() {
		return Member_COUNTRY;
	}
	
	public String Member_DIVISION() {
		return Member_DIVISION;
	}
	
	public String Member_DISTRICT() {
		return Member_DISTRICT;
	}
	
	public String Member_UPAZILLA() {
		return Member_UPAZILLA;
	}
	
	public String Member_UNION() {
		return Member_UNION;
	}
	
	public String Member_WARD() {
		return Member_WARD;
	}
	
	public String Member_GPS() {
		return Member_GPS;
	}	
	
	public String Member_BLOCK() {
		return Member_BLOCK;
	}	
	
	public String isClosed() {
		return isClosed;
	}
	
	public String Member_Address_line() {
		return Member_Address_line;
	}
	public String Member_HIE_facilities() {
		return Member_HIE_facilities;
	}
	public String HH_Address() {
		return HH_Address;
	}
	public String Member_type() {
		return Member_type;
	}
	public String Member_Unique_ID() {
		return Member_Unique_ID;
	}
	public String Member_NID() {
		return Member_NID;
	}
	public String Member_BRID() {
		return Member_BRID;
	}
	public String Member_HID() {
		return Member_HID;
	}
	public String Member_birth_date_known() {
		return member_birth_date_known;
	}
	public String Member_birth_date() {
		return member_birth_date;
	}
	public String Age() {
		return age;
	}
	public String Calc_age() {
		return calc_age;
	}
	public String Calc_dob() {
		return calc_dob;
	}
	public String Calc_dob_confirm() {
		return calc_dob_confirm;
	}
	public String Calc_dob_estimated() {
		return calc_dob_estimated;
	}
	public String Calc_age_confirm() {
		return calc_age_confirm;
	}
	public String Birth_date_note() {
		return birth_date_note;
	}
	public String Note_age() {
		return note_age;
	}
	public String Father_name() {
		return Father_name;
	}
	public String Husband_name() {
		return Husband_name;
	}
	public String WomanInfo() {
		return WomanInfo;
	}
	public String Pregnant() {
		return pregnant;
	}
	public String FP_USER() {
		return FP_USER;
	}
	public String FP_Methods() {
		return FP_Methods;
	}
	public String Edd_lmp() {
		return edd_lmp;
	}
	public String Edd() {
		return edd;
	}
	public String Lmp() {
		return lmp;
	}
	public String Ultrasound_date() {
		return ultrasound_date;
	}
	public String Ultrasound_weeks() {
		return ultrasound_weeks;
	}
	public String Edd_calc_lmp() {
		return edd_calc_lmp;
	}
	public String Edd_calc_ultrasound() {
		return edd_calc_ultrasound;
	}
	public String Edd_calc_lmp_formatted() {
		return edd_calc_lmp_formatted;
	}
	public String Edd_calc_ultrasound_formatted() {
		return edd_calc_ultrasound_formatted;
	}
	public String Lmp_calc_edd() {
		return lmp_calc_edd;
	}
	public String Lmp_calc_ultrasound() {
		return lmp_calc_ultrasound;
	}
	public String Lmp_calc_edd_formatted() {
		return lmp_calc_edd_formatted;
	}
	public String Lmp_calc_ultrasound_formatted() {
		return lmp_calc_ultrasound_formatted;
	}
	public String Final_edd() {
		return final_edd;
	}
	public String Final_lmp() {
		return final_lmp;
	}
	public String Ga_edd() {
		return ga_edd;
	}
	public String Ga_lmp() {
		return ga_lmp;
	}
	public String Ga_ult() {
		return ga_ult;
	}
	public String Final_edd_note() {
		return final_edd_note;
	}
	public String Final_lmp_note() {
		return final_lmp_note;
	}
	public String Final_ga() {
		return final_ga;
	}
	public String Final_ga_note() {
		return final_ga_note;
	}
	public String Vaccines() {
		return vaccines;
	}
	public String Tt1_retro() {
		return tt1_retro;
	}
	public String Tt_1_dose() {
		return tt_1_dose;
	}
	public String Tt2_retro() {
		return tt2_retro;
	}
	public String Tt_2_dose() {
		return tt_2_dose;
	}
	public String Tt3_retro() {
		return tt3_retro;
	}
	public String Tt_3_dose() {
		return tt_3_dose;
	}
	public String Tt4_retro() {
		return tt4_retro;
	}
	public String Tt_4_dose() {
		return tt_4_dose;
	}
	public String Vaccines_2() {
		return vaccines_2;
	}
	public String Tt1() {
		return tt1;
	}
	public String Tt_1_dose_today() {
		return tt_1_dose_today;
	}
	public String Tt2() {
		return tt2;
	}
	public String Tt_2_dose_today() {
		return tt_2_dose_today;
	}
	public String Tt3() {
		return tt3;
	}
	public String Tt_3_dose_today() {
		return tt_3_dose_today;
	}
	public String Tt4() {
		return tt4;
	}
	public String Tt_4_dose_today() {
		return tt_4_dose_today;
	}
	public String Tt5() {
		return tt5;
	}
	public String Tt_5_dose_today() {
		return tt_5_dose_today;
	}
	public String Child_birth_date_known() {
		return Child_birth_date_known;
	}
	public String Child_birth_date() {
		return Child_birth_date;
	}
	public String Child_age() {
		return Child_age;
	}
	public String Child_calc_age() {
		return Child_calc_age;
	}
	public String Child_calc_dob() {
		return Child_calc_dob;
	}
	public String Child_dob() {
		return Child_dob;
	}
	public String Child_dob_estimated() {
		return Child_dob_estimated;
	}
	public String Child_age_days() {
		return Child_age_days;
	}
	public String Child_birth_date_note() {
		return Child_birth_date_note;
	}
	public String Birth_Weigtht() {
		return Birth_Weigtht;
	}
	public String Newborn_Care_Received() {
		return Newborn_Care_Received;
	}
	public String Child_gender() {
		return Child_gender;
	}
	public String Child_mother_name() {
		return Child_mother_name;
	}
	public String Child_father_name() {
		return Child_father_name;
	}
	public String Child_guardian_id() {
		return Child_guardian_id;
	}

	public String Child_Mother_NID() {
		return Child_Mother_NID;
	}

	public String Child_Mother_BRID() {
		return Child_Mother_BRID;
	}

	public String Child_Father_NID() {
		return Child_Father_NID;
	}

	public String Child_Father_BRID() {
		return Child_Father_BRID;
	}

	public String Child_Other_Guardian_NID() {
		return Child_Other_Guardian_NID;
	}

	public String Child_Other_Guardian_BRID() {
		return Child_Other_Guardian_BRID;
	}
	public String Child_was_suffering_from_a_disease_at_birth() {
		return child_was_suffering_from_a_disease_at_birth;
	}
	public String Reminders_approval() {
		return reminders_approval;
	}
	public String Contact_phone_number() {
		return contact_phone_number;
	}
	public String Child_vaccines() {
		return child_vaccines;
	}
	public String Opv0_retro() {
		return opv0_retro;
	}
	public String Opv0_dose() {
		return opv0_dose;
	}
	public String Pcv1_retro() {
		return pcv1_retro;
	}
	public String Pcv1_dose() {
		return pcv1_dose;
	}
	public String Opv1_retro() {
		return opv1_retro;
	}
	public String Opv1_dose() {
		return opv1_dose;
	}
	public String Penta1_retro() {
		return penta1_retro;
	}
	public String Penta1_dose() {
		return penta1_dose;
	}
	public String Pcv2_retro() {
		return pcv2_retro;
	}
	public String Pcv2_dose() {
		return pcv2_dose;
	}
	public String Opv2_retro() {
		return opv2_retro;
	}
	public String Opv2_dose() {
		return opv2_dose;
	}
	public String Penta2_retro() {
		return penta2_retro;
	}
	public String Penta2_dose() {
		return penta2_dose;
	}
	public String Pcv3_retro() {
		return pcv3_retro;
	}
	public String Pcv3_dose() {
		return pcv3_dose;
	}
	public String Opv3_retro() {
		return opv3_retro;
	}
	public String Opv3_dose() {
		return opv3_dose;
	}
	public String Penta3_retro() {
		return penta3_retro;
	}
	public String Penta3_dose() {
		return penta3_dose;
	}
	public String Ipv_retro() {
		return ipv_retro;
	}
	public String Measles1_retro() {
		return measles1_retro;
	}
	public String Measles1_dose() {
		return measles1_dose;
	}
	public String Measles2Visit_retro() {
		return measles2_retro;
	}
	public String Measles2Visit_dose() {
		return measles2_dose;
	}
	public String Bcg() {
		return bcg;
	}
	public String Opv0() {
		return opv0;
	}
	public String Opv0_dose_today() {
		return opv0_dose_today;
	}
	public String Pcv1() {
		return pcv1;
	}
	public String Pcv1_dose_today() {
		return pcv1_dose_today;
	}
	public String Opv1() {
		return opv1;
	}
	public String Opv1_dose_today() {
		return opv1_dose_today;
	}
	public String Penta1() {
		return penta1;
	}
	public String Penta1_dose_today() {
		return penta1_dose_today;
	}
	public String Pcv2() {
		return pcv2;
	}
	public String Pcv2_dose_today() {
		return pcv2_dose_today;
	}
	public String Opv2() {
		return opv2;
	}
	public String Opv2_dose_today() {
		return opv2_dose_today;
	}
	public String Penta2() {
		return penta2;
	}
	public String Penta2_dose_today() {
		return penta2_dose_today;
	}
	public String Pcv3() {
		return pcv3;
	}
	public String Pcv3_dose_today() {
		return pcv3_dose_today;
	}
	public String Opv3() {
		return opv3;
	}
	public String Opv3_dose_today() {
		return opv3_dose_today;
	}
	public String Penta3() {
		return penta3;
	}
	public String Penta3_dose_today() {
		return penta3_dose_today;
	}
	public String Ipv() {
		return ipv;
	}	
	public String Is_woman() {
		return Is_woman;
	}
	public String Is_child() {
		return Is_child;
	}
	public String Is_preg_outcome() {
		return Is_preg_outcome;
	}
	public String relationalid() {
		return relationalid;
	}
	public String Member_Paurasava() {
		return Member_Paurasava;
	}	
	public String Measles1() {
		return measles1;
	}
	public String Measles1_dose_today() {
		return measles1_dose_today;
	}
	public String Measles2Visit_dose_today() {
		return measles2_dose_today;
	}
	public String Tt1_final() {
		return tt1_final;
	}
	public String Tt2_final() {
		return tt2_final;
	}
	public String Tt3_final() {
		return tt3_final;
	}
	public String Tt4_final() {
		return tt4_final;
	}
	public String Tt5_final() {
		return tt5_final;
	}	
	public String Final_bcg() {
		return final_bcg;
	}

	public String Final_opv0() {
		return final_opv0;
	}

	public String Final_pcv1() {
		return final_pcv1;
	}

	public String Final_opv1() {
		return final_opv1;
	}

	public String Final_penta1() {
		return final_penta1;
	}

	public String Final_pcv2() {
		return final_pcv2;
	}

	public String Final_opv2() {
		return final_opv2;
	}

	public String Final_penta2() {
		return final_penta2;
	}

	public String Final_pcv3() {
		return final_pcv3;
	}

	public String Final_opv3() {
		return final_opv3;
	}

	public String Final_penta3() {
		return final_penta3;
	}

	public String Final_ipv() {
		return final_ipv;
	}

	public String Final_measles1() {
		return final_measles1;
	}

	public String Final_measles2() {
		return final_measles2;
	}
	
	public String Member_Reg_Date() {
		return Member_Reg_Date;
	}
	
	public String child_vaccines_2() {
		return child_vaccines_2;
	}
	
	public Map<String, String> details() {
		if (details == null)
			this.details = new HashMap<>();
		return details;
	}
	
	public String Detail(String name) {
		return details.get(name);
	}

	public Map<String, String> generalVisit() {
		if (generalVisit == null)
			this.generalVisit = new HashMap<>();
		return generalVisit;
	}
	public Map<String, String> TTVisit() {
		if (TTVisit == null)
			this.TTVisit = new HashMap<>();
		return TTVisit;
	}
	public Map<String, String> BNFVisit() {
		if (BNFVisit == null)
			this.BNFVisit = new HashMap<>();
		return BNFVisit;
	}
	public List<Map<String, String>> child_vaccine() {
		if (child_vaccine == null) {
			child_vaccine = new ArrayList<>();
		}
		return child_vaccine;
	}
    public Members setIsClosed(boolean isClosed) {
        this.isClosed = Boolean.toString(isClosed);
        return this;
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
