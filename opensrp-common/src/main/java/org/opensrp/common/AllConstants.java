package org.opensrp.common;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class AllConstants {
	public static final String OPENSRP_FORM_DATABASE_CONNECTOR = "opensrpFormDatabaseConnector";
    public static final String OPENSRP_DATABASE_CONNECTOR = "opensrpDatabaseConnector";
    public static final String OPENSRP_MCTS_DATABASE_CONNECTOR = "opensrpMCTSDatabaseConnector";
    public static final String OPENSRP_DATABASE_LUCENE_CONNECTOR = "opensrpDatabaseLuceneConnector";
    public static final String OPENSRP_SCHEDULE_DATABASE_CONNECTOR = "opensrpScheduleDatabaseConnector";
    public static final String SPACE = " ";
    public static final String BOOLEAN_TRUE_VALUE = "true";
    public static final String BOOLEAN_FALSE_VALUE = "false";
    public static final String AUTO_CLOSE_PNC_CLOSE_REASON = "Auto Close PNC";
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String EMPTY_STRING = "";
    public static final String OPENSRP_ERRORTRACE_DATABASE="opensrpErrorTraceDatabaseConnector";


    public static class Form {
    	public static final String HH_REGISTRATION = "new_household_registration";
    	public static final String MEMBERS_REGISTRATION = "census_enrollment";
    	public static final String BNF_Handler = "pregnancy_status_birth_notification";
    	public static final String BirthOutcome_Handler = "birthoutcome";
    	public static final String PSRF_FORM = "psrf_form";
    	public static final String NewBornHandler = "new_born_information";
    	public static final String GeneralHandler = "general";
    	public static final String Child_vaccine_followup_Handler = "child_vaccine_followup";
    	public static final String FamilyPlanningHandler = "family_planning";
    	public static final String Measles1Handler = "Measles1Handler";
    	public static final String BCGHandler_ = "BCGHandler";
    	public static final String IPVHandler_ = "IPVHandler";
    	public static final String Measles2Handler_ = "Measles2Handler";
    	public static final String OPV0Handler_ = "OPV0Handler";
    	public static final String OPV1Handler_ = "OPV1Handler";
    	public static final String OPV2Handler_ = "OPV2Handler";
    	public static final String OPV3Handler_ = "OPV3Handler";
    	public static final String PCV1Handler_ = "PCV1Handler";
    	public static final String PCV2Handler_ = "PCV2Handler";  	
    	public static final String PCV3Handler_ = "PCV3Handler";
    	public static final String PENTA1Handler_ = "PENTA1Handler";
    	public static final String PENTA2Handler_ = "PENTA2Handler";
    	public static final String PENTA3Handler_ = "PENTA3Handler";  	
    	public static final String BNF_FORM = "birthnotificationpregnancystatusfollowup";
    	public static final String TT_Visit_Handler = "woman_tt_form";
    	public static final String child_vaccine_followup_Handler = "child_vaccine_followup";
    	public static final String ENCC_REMINDER_VISIT_1 = "encc_visit_1";
    	public static final String ENCC_REMINDER_VISIT_2 = "encc_visit_2";
    	public static final String ENCC_REMINDER_VISIT_3 = "encc_visit_3";    	
        public static final String ENTITY_ID = "entityId";
        public static final String ANM_ID = "anmId";
        public static final String FORM_NAME = "formName";
        public static final String INSTANCE_ID = "instanceId";
        public static final String CLIENT_VERSION = "clientVersion";
        public static final String SERVER_VERSION = "serverVersion";
        public static final String EC_REGISTRATION = "ec_registration";
        public static final String FP_COMPLICATIONS = "fp_complications";
        public static final String FP_CHANGE = "fp_change";
        public static final String RENEW_FP_PRODUCT = "renew_fp_product";
        public static final String FP_FOLLOWUP_PRODUCT = "fp_followup";
        public static final String FP_REFERRAL_FOLLOWUP = "fp_referral_followup";
        public static final String EC_CLOSE = "ec_close";
        public static final String EC_EDIT = "ec_edit";
        public static final String ANC_REGISTRATION = "anc_registration";
        public static final String ANC_REGISTRATION_OA = "anc_registration_oa";
        public static final String ANC_VISIT = "anc_visit";
        public static final String ANC_INVESTIGATIONS = "anc_investigations";
        public static final String ANC_CLOSE = "anc_close";
        public static final String IFA = "ifa";
        public static final String HB_TEST = "hb_test";
        public static final String DELIVERY_OUTCOME = "delivery_outcome";
        public static final String DELIVERY_PLAN = "delivery_plan";
        public static final String PNC_REGISTRATION_OA = "pnc_registration_oa";
        public static final String PNC_CLOSE = "pnc_close";
        public static final String PNC_VISIT = "pnc_visit";
        public static final String CHILD_REGISTRATION_EC = "child_registration_ec";
        public static final String CHILD_REGISTRATION_OA = "child_registration_oa";
        public static final String CHILD_IMMUNIZATIONS = "child_immunizations";
        public static final String CHILD_ILLNESS = "child_illness";
        public static final String CHILD_CLOSE = "child_close";
        public static final String TT = "tt";
        public static final String TT_BOOSTER = "tt_booster";
        public static final String TT_1 = "tt_1";
        public static final String TT_2 = "tt_2";
        public static final String BOOLEAN_TRUE_VALUE = "yes";
        public static final String BOOLEAN_FALSE_VALUE = "no";
        public static final String PNC_REGISTRATION_OA_SUB_FORM_NAME = "child_registration_oa";
        public static final String PNC_VISIT_CHILD_SUB_FORM_NAME = "child_pnc_visit";
        public static final String VITAMIN_A = "vitamin_a";
        public static final String PPFP = "postpartum_family_planning";
        public static final String RECORD_ECPS = "record_ecps";
    }

    public static class Report {
        public static final int FIRST_REPORT_MONTH_OF_YEAR = 3;
        public static final int REPORTING_MONTH_START_DAY = 26;
        public static final int REPORTING_MONTH_END_DAY = 25;
        public static final double LOW_BIRTH_WEIGHT_THRESHOLD = 2.5;
        public static final int INFANT_MORTALITY_THRESHOLD_IN_YEARS = 1;
        public static final int CHILD_MORTALITY_THRESHOLD_IN_YEARS = 5;
        public static final int CHILD_EARLY_NEONATAL_MORTALITY_THRESHOLD_IN_DAYS = 7;
        public static final int CHILD_NEONATAL_MORTALITY_THRESHOLD_IN_DAYS = 28;
        public static final int CHILD_DIARRHEA_THRESHOLD_IN_YEARS = 5;
    }

    public static class ReportDataParameters {
        public static final String ANM_IDENTIFIER = "anmIdentifier";
        public static final String SERVICE_PROVIDED_DATA_TYPE = "serviceProvided";
        public static final String ANM_REPORT_DATA_TYPE = "anmReportData";
        public static final String SERVICE_PROVIDER_TYPE = "serviceProviderType";
        public static final String EXTERNAL_ID = "externalId";
        public static final String INDICATOR = "indicator";
        public static final String SERVICE_PROVIDED_DATE = "date";
        public static final String DRISTHI_ENTITY_ID = "dristhiEntityId";
        public static final String VILLAGE = "village";
        public static final String SUB_CENTER = "subCenter";
        public static final String PHC = "phc";
        public static final String QUANTITY = "quantity";
        public static final String SERVICE_PROVIDER_ANM = "ANM";
    }
    
    public static class HHRegistrationFields
    {
    	public static final String MEMBERS_REGISTRATION_SUB_FORM_NAME = "member_registration";
    	public static final String ELCO_REGISTRATION_SUB_FORM_NAME_CENSUS = "elco_registration_ce";
    	public static final String LOCATION_NAME = "location_name";
    	public static final String REFERENCE_DATE = "today";
    	public static final String DATE_OF_REG = "Date_Of_Reg";
    	public static final String MOTHER_REFERENCE_DATE = "FWPSRLMP";
    	public static final String PNC_REFERENCE_DATE = "FWEDD";
    	public static final String START_DATE = "start";
    	public static final String END_DATE = "end";
    	public static final String FW_WOMAGE = "FWWOMAGE";
    	public static final String FW_BIRTHDATE = "FWBIRTHDATE";
    	public static final String ID = "id";
    	public static final String FW_WOMLNAME = "FWWOMLNAME";
    	public static final String FW_WOMFNAME = "FWWOMFNAME";
    	public static final String FW_GOBHHID = "FWWOMNID";
    	public static final String FW_JIVITAHHID = "JiVitAHHID";
    	public static final String FW_GENDER = "FWGENDER";
    	public static final String FW_WOMBID = "FWWOMBID";
    	public static final String FW_WOMNID = "FWWOMNID";
    	public static final String FW_HUSNAME = "FWHUSNAME";
    	public static final String FW_ELIGIBLE = "FWELIGIBLE";
    	public static final String FW_DISPLAY_AGE = "FWDISPLAYAGE";
    	public static final String FW_UPAZILLA = "FWUPAZILLA";
    	public static final String EXISTING_LOCATION = "existing_location";
    	public static final String EXISTING_COUNTRY = "existing_Country";
    	public static final String EXISTING_DIVISION = "existing_Division";
    	public static final String EXISTING_DISTRICT = "existing_District";
    	public static final String EXISTING_UPAZILLA = "existing_Upazilla";
    	public static final String EXISTING_UNION = "existing_Union";
    	public static final String EXISTING_WARD = "existing_Ward";
    	public static final String EXISTING_SUBUNIT = "existing_Subunit";
    	public static final String EXISTING_MAUZAPARA = "existing_Mauzapara";
    	public static final String received_time = "received_time";
    	
    }
    
    public static class MEMBERSRegistrationFields
    {
        	public static final String MEMBER_COUNTRY ="Member_COUNTRY";
        	public static final String MEMBER_DIVISION ="Member_DIVISION";
        	public static final String MEMBER_DISTRICT ="Member_DISTRICT";
        	public static final String MEMBER_UPAZILLA ="Member_UPAZILLA";
        	public static final String MEMBER_PAURASAVA ="Member_Paurasava";
        	public static final String MEMBER_UNION ="Member_UNION";
        	public static final String MEMBER_WARD ="Member_WARD";
        	public static final String MEMBER_ADDRESS_LINE ="Member_Address_line";
        	public static final String MEMBER_HIE_FACILITIES ="Member_HIE_facilities";
        	public static final String Member_BLOCK ="Member_BLOCK";
        	public static final String MEMBER_GPS ="Member_GPS";
        	public static final String HH_ADDRESS ="HH_Address";
        	public static final String Child_vital_status = "Child_vital_status";
        	public static final String Child_name_check = "Child_name_check";
        	public static final String Child_name = "Child_name";
        	public static final String Child_last_name = "Child_last_name";
        	public static final String Member_Fname = "Member_Fname";
        	public static final String child_vaccines_2 = "child_vaccines_2";
        	public static final String add_child = "add_child";
        	public static final String MEMBER_TYPE ="Member_type";
        	public static final String REG_NO ="Reg_No";
        	public static final String MEMBER_FNAME ="Member_Fname";
        	public static final String MEMBER_LNAME ="Member_LName";
        	public static final String MEMBER_UNIQUE_ID ="Member_Unique_ID";
        	public static final String MEMBER_NID ="Member_NID";
        	public static final String MEMBER_BRID ="Member_BRID";
        	public static final String MEMBER_HID ="Member_HID";
        	public static final String MEMBER_BIRTH_DATE_KNOWN="member_birth_date_known";
        	public static final String MEMBER_BIRTH_DATE ="member_birth_date";
        	public static final String Member_Reg_Date ="Member_Reg_Date";
        	public static final String age ="age";
        	public static final String calc_age ="calc_age";
        	public static final String calc_dob="calc_dob";
        	public static final String calc_dob_confirm ="calc_dob_confirm";
        	public static final String calc_dob_estimated ="calc_dob_estimated";
        	public static final String calc_age_confirm ="calc_age_confirm";
        	public static final String birth_date_note="birth_date_note";
        	public static final String note_age ="note_age";
        	public static final String Gender ="Gender";
        	public static final String Father_name ="Father_name";
        	public static final String Husband_name ="Husband_name";
        	public static final String Visit_status ="Visit_status";
        	public static final String Marital_status ="Marital_status";
        	public static final String Couple_No ="Couple_No";
        	public static final String WomanInfo ="WomanInfo";
        	public static final String pregnant ="pregnant";
        	public static final String FP_USER ="FP_USER";
        	public static final String FP_Methods ="FP_Methods";
        	public static final String edd_lmp ="edd_lmp";
        	public static final String edd ="edd";
        	public static final String lmp ="lmp";
        	public static final String ultrasound_date ="ultrasound_date";
        	public static final String ultrasound_weeks ="ultrasound_weeks";
        	public static final String edd_calc_lmp ="edd_calc_lmp";
        	public static final String edd_calc_ultrasound ="edd_calc_ultrasound";
        	public static final String edd_calc_lmp_formatted ="edd_calc_lmp_formatted";
        	public static final String edd_calc_ultrasound_formatted ="edd_calc_ultrasound_formatted";
        	public static final String lmp_calc_edd ="lmp_calc_edd";
        	public static final String lmp_calc_ultrasound ="lmp_calc_ultrasound";
        	public static final String lmp_calc_edd_formatted ="lmp_calc_edd_formatted";
        	public static final String lmp_calc_ultrasound_formatted ="lmp_calc_ultrasound_formatted";
        	public static final String Is_preg_outcome ="Is_preg_outcome";
        	public static final String final_edd ="final_edd";
        	public static final String final_lmp ="final_lmp";
        	public static final String ga_edd ="ga_edd";
        	public static final String ga_lmp ="ga_lmp";
        	public static final String ga_ult ="ga_ult";
        	public static final String final_edd_note ="final_edd_note";
        	public static final String final_lmp_note ="final_lmp_note";
        	public static final String final_ga ="final_ga";
        	public static final String final_ga_note ="final_ga_note";
	    	public static final String vaccines ="vaccines";
	    	public static final String tt1_retro ="tt1_retro";
	    	public static final String tt_1_dose ="tt_1_dose";
	    	public static final String tt2_retro ="tt2_retro";
	    	public static final String tt_2_dose ="tt_2_dose";
	    	public static final String tt3_retro ="tt3_retro";
	    	public static final String tt_3_dose ="tt_3_dose";
	    	public static final String tt4_retro ="tt4_retro";
	    	public static final String tt_4_dose ="tt_4_dose";
	    	public static final String vaccines_2 ="vaccines_2";
	    	public static final String tt1 ="tt1";
	    	public static final String tt_1_dose_today ="tt_1_dose_today";
	    	public static final String tt2 ="tt2";
	    	public static final String tt_2_dose_today ="tt_2_dose_today";
	    	public static final String tt3 ="tt3";
	    	public static final String tt_3_dose_today ="tt_3_dose_today";
	    	public static final String tt4 ="tt4";
	    	public static final String tt_4_dose_today ="tt_4_dose_today";
	    	public static final String tt5 ="tt5";
	    	public static final String tt_5_dose_today ="tt_5_dose_today";
	    	public static final String tt1_final="tt1_final";
	    	public static final String tt2_final="tt2_final";
	    	public static final String tt3_final="tt3_final"; 
	    	public static final String tt4_final="tt4_final"; 
	    	public static final String tt5_final="tt5_final"; 
	    	public static final String e_tt1="e_tt1";
	    	public static final String e_tt2="e_tt2";
	    	public static final String e_tt3="e_tt3"; 
	    	public static final String e_tt4="e_tt4"; 
	    	public static final String e_tt5="e_tt5"; 
	    	public static final String Child_birth_date_known ="Child_birth_date_known";
	    	public static final String Child_birth_date ="Child_birth_date";
	    	public static final String Child_age ="Child_age";
	    	public static final String Child_calc_age ="Child_calc_age";
	    	public static final String Child_calc_dob ="Child_calc_dob";
	    	public static final String Child_dob ="Child_dob";
	    	public static final String Child_dob_estimated ="Child_dob_estimated";
	    	public static final String Child_age_days ="Child_age_days";
	    	public static final String child_age_days ="child_age_days";
	    	public static final String Child_birth_date_note ="Child_birth_date_note";
	    	public static final String Birth_Weigtht ="Birth_Weigtht";
	    	public static final String Newborn_Care_Received ="Newborn_Care_Received";
	    	public static final String Child_gender ="Child_gender";
	    	public static final String Child_mother_name ="Child_mother_name";
	    	public static final String Child_father_name ="Child_father_name";	    	
	    	public static final String Child_guardian_id ="Child_guardian_id";
	    	public static final String Child_Mother_NID ="Child_Mother_NID";
	    	public static final String Child_Mother_BRID ="Child_Mother_BRID";
	    	public static final String Child_Father_NID ="Child_Father_NID";
	    	public static final String Child_Father_BRID ="Child_Father_BRID";
	    	public static final String Child_Other_Guardian_NID ="Child_Other_Guardian_NID";
	    	public static final String Child_Other_Guardian_BRID ="Child_Other_Guardian_BRID";	    	
	    	public static final String epi_card_number ="epi_card_number";
	    	public static final String child_was_suffering_from_a_disease_at_birth ="child_was_suffering_from_a_disease_at_birth";
	    	public static final String reminders_approval ="reminders_approval";
	    	public static final String contact_phone_number ="contact_phone_number";
	    	public static final String child_vaccines ="child_vaccines";
	    	public static final String bcg_retro ="bcg_retro";
	    	public static final String opv0_retro ="opv0_retro";
	    	public static final String opv0_dose ="opv0_dose";
	    	public static final String pcv1_retro ="pcv1_retro";
	    	public static final String pcv1_dose ="pcv1_dose";
	    	public static final String opv1_retro ="opv1_retro";
	    	public static final String opv1_dose ="opv1_dose";
	    	public static final String penta1_retro ="penta1_retro";
	    	public static final String penta1_dose ="penta1_dose";
	    	public static final String pcv2_retro ="pcv2_retro";
	    	public static final String pcv2_dose ="pcv2_dose";
	    	public static final String opv2_retro ="opv2_retro";
	    	public static final String opv2_dose ="opv2_dose";
	    	public static final String penta2_retro ="penta2_retro";
	    	public static final String penta2_dose ="penta2_dose";
	    	public static final String pcv3_retro ="pcv3_retro";
	    	public static final String pcv3_dose ="pcv3_dose";
	    	public static final String opv3_retro ="opv3_retro";
	    	public static final String opv3_dose ="opv3_dose";
	    	public static final String penta3_retro = "penta3_retro";
	    	public static final String penta3_dose ="penta3_dose";
	    	public static final String ipv_retro ="ipv_retro";
	    	public static final String measles1_retro ="measles1_retro";
	    	public static final String measles1_dose ="measles1_dose";
	    	public static final String measles2_retro ="measles2_retro";
	    	public static final String measles2_dose ="measles2_dose";
	    	public static final String bcg ="bcg";
	    	public static final String opv0 ="opv0";
	    	public static final String opv0_dose_today ="opv0_dose_today";
	    	public static final String pcv1 ="pcv1";
	    	public static final String pcv1_dose_today ="pcv1_dose_today";
	    	public static final String opv1 ="opv1";
	    	public static final String opv1_dose_today ="opv1_dose_today";
	    	public static final String penta1 ="penta1";
	    	public static final String penta1_dose_today ="penta1_dose_today";
	    	public static final String pcv2 ="pcv2";
	    	public static final String pcv2_dose_today ="pcv2_dose_today";
	    	public static final String opv2 ="opv2";
	    	public static final String opv2_dose_today ="opv2_dose_today";
	    	public static final String penta2 ="penta2";
	    	public static final String penta2_dose_today ="penta2_dose_today";
	    	public static final String pcv3 ="pcv3";
	    	public static final String pcv3_dose_today ="pcv3_dose_today";
	    	public static final String opv3 ="opv3";
	    	public static final String opv3_dose_today ="opv3_dose_today";
	    	public static final String penta3 ="penta3";
	    	public static final String penta3_dose_today ="penta3_dose_today";
	    	public static final String ipv ="ipv";
	    	public static final String measles1 ="measles1";
	    	public static final String measles1_dose_today ="measles1_dose_today";
	    	public static final String measles2 ="measles2";
	    	public static final String measles2_dose_today ="measles2_dose_today";
	    	public static final String Is_woman ="Is_woman";
	    	public static final String Is_child ="Is_child";
	    	public static final String PVF ="PVF";
	    	public static final String outcome_current_formStatus ="outcome_current_formStatus";
	    	public static final String Interview_date= "Interview_date";
	    	public static final String current_woman_id ="current_woman_id";
	    	public static final String FW_PROVIDERID ="PROVIDERID";
	    	public static final String FW_LOCATIONID ="LOCATIONID";
	    	public static final String relationalid ="relationalid";
	    	public static final String FW_TODAY ="TODAY";
	    	public static final String FW_GOBHHID ="GOBHHID"; 
	    	public static final String FW_JiVitAHHID ="JiVitAHHID";
	    	public static final String existing_ELCO ="existing_ELCO";
	    	public static final String new_ELCO ="new_ELCO";
	    	public static final String ELCO ="ELCO";
	    	public static final String WomanREGDATE ="WomanREGDATE";
	    	public static final String form_name ="form_name";
	    	public static final String FW_CENDATE ="FWCENDATE";
	    	public static final String FW_CENSTAT ="FWCENSTAT";
	    	public static final String FW_WOMANYID = "FWWOMANYID";
	    	public static final String BDH = "BDH";
	    	public static final String DoB = "DoB";
	    	public static final String Age = "Age";
	    	public static final String Type_DoB = "Type_DoB";
	    	public static final String FW_WOMAGE = "FWWOMAGE";
	    	public static final String Display_Age = "Display_Age";
	    	public static final String Child_Vital_Status = "Child_Vital_Status";
	    	public static final String MOTHER_Vaccine_Dates = "MOTHER_Vaccine_Dates";
	    	public static final String FW_CWOMHUSSTR = "FWCWOMHUSSTR";
	    	public static final String Date_of_BCG_OPV_0 = "Date_of_BCG_OPV_0";
	    	public static final String Date_of_OPV_Penta_PCV_1 = "Date_of_OPV_Penta_PCV_1";
	    	public static final String Date_of_OPV_Penta_PCV_2 = "Date_of_OPV_Penta_PCV_2";
	    	public static final String Date_of_OPV_Penta_3_IPV ="Date_of_OPV_Penta_3_IPV";
	    	public static final String Date_of_PCV_3 ="Date_of_PCV_3";
	    	public static final String Date_of_MR ="Date_of_MR";
	    	public static final String Date_of_Measles ="Date_of_Measles";
	    	public static final String Date_BRID ="Date_BRID";
	    	public static final String Child_BRID ="Child_BRID";
	    	public static final String Date_Child_Death ="Date_Child_Death";
	    	public static final String C_Guardian_Type ="C_Guardian_Type";
	    	public static final String C_Guardian_Name_Father ="C_Guardian_Name_Father";
	    	public static final String profileImagePath = "profileImagePath";
	    	public static final String nidImagePath = "nidImagePath";	
	    	public static final String C_Guardian_Name_Mother = "C_Guardian_Name_Mother";
	    	public static final String C_Guardian_Name_Hus = "C_Guardian_Name_Hus";
	    	public static final String LMP ="LMP";
	    	public static final String EDD ="EDD";
	    	public static final String GA ="GA";
	    	public static final String Pregnancy_Status ="Pregnancy_Status";
	    	public static final String Date_of_MR_wom ="Date_of_MR_wom";
	    	public static final String Date_of_TT1 ="Date_of_TT1";
	    	public static final String Date_of_TT2 ="Date_of_TT2";
	    	public static final String Date_of_TT3 ="Date_of_TT3";   	
	    	public static final String Date_of_TT4 ="Date_of_TT4";
	    	public static final String Date_of_TT5 ="Date_of_TT5";
	    	public static final String Unique_ID ="Unique_ID";
	    	public static final String NID ="NID";
	    	public static final String BRID ="BRID";
	    	public static final String HID ="HID";
	    	public static final String Guardian_Type = "Guardian_Type";
	    	public static final String Guardian_Name_Father = "Guardian_Name_Father";
	    	public static final String Guardian_Name_Mother = "Guardian_Name_Mother";
	    	public static final String Guardian_Name_Hus = "Guardian_Name_Hus";   	
	    	public static final String Mobile_No = "Mobile_No";
	    	public static final String Education = "Education";
	    	public static final String Occupation = "Occupation";
	    	public static final String Is_TT ="Is_TT";
	    	public static final String Is_FP ="Is_FP";
	    	public static final String Is_NewBorn ="Is_NewBorn";
	    	public static final String FW_PSREVRPREG ="FWPSREVRPREG";
	    	public static final String general_Date_Of_Reg="general_Date_Of_Reg";
	    	public static final String Patient_Diagnosis="Patient_Diagnosis";	    	
	    	public static final String existing_woman_name ="existing_woman_name";
	    	public static final String existing_husband_name ="existing_husband_name";
	    	public static final String existing_block_no ="existing_block_no";   	
	    	public static final String existing_lmp ="existing_lmp";
	    	public static final String existing_location ="existing_location";	    	
	    	public static final String Gestational_age ="Gestational_age";   	
	    	public static final String Woman_vital_status ="Woman_vital_status";
	    	public static final String DOO ="DOO";	    	
	    	public static final String Display_text ="Display_text";
	    	public static final String Date_of_interview ="Date_of_interview";
	    	public static final String Confirm_info ="Confirm_info";
	    	public static final String Number_live_birth ="Number_live_birth";
	    	public static final String pregsts_bnf_current_formStatus ="pregsts_bnf_current_formStatus";  
	    	public static final String outcome_active ="outcome_active";
	    	public static final String Treatment="Treatment";
	    	public static final String FP_DATE_OF_REG="FP_DATE_OF_REG";
	    	public static final String new_born_DATE_OF_REG="new_born_DATE_OF_REG";
	    	public static final String Has_Vaccinated = "Has_Vaccinated";
	    	public static final String measles_Date_of_Vaccination = "measles_Date_of_Vaccination";
	    	public static final String TT1_Date_of_Vaccination = "TT1_Date_of_Vaccination";
	    	public static final String TT2_Date_of_Vaccination = "TT2_Date_of_Vaccination";
	    	public static final String TT3_Date_of_Vaccination = "TT3_Date_of_Vaccination";
	    	public static final String TT4_Date_of_Vaccination = "TT4_Date_of_Vaccination";
	    	public static final String TT5_Date_of_Vaccination = "TT5_Date_of_Vaccination";
	    	public static final String ChildVaccination_PENTA1_Date_of_Vaccination = "ChildVaccination_PENTA1_Date_of_Vaccination";    	
	    	public static final String ChildVaccination_PENTA2_Date_of_Vaccination = "ChildVaccination_PENTA2_Date_of_Vaccination";
	    	public static final String ChildVaccination_PENTA3_Date_of_Vaccination = "ChildVaccination_PENTA3_Date_of_Vaccination";
	    	public static final String ChildVaccination_PCV1_Date_of_Vaccination = "ChildVaccination_PCV1_Date_of_Vaccination";    	
	    	public static final String ChildVaccination_PCV2_Date_of_Vaccination = "ChildVaccination_PCV2_Date_of_Vaccination";
	    	public static final String ChildVaccination_PCV3_Date_of_Vaccination = "ChildVaccination_PCV3_Date_of_Vaccination";
	    	public static final String ChildVaccination_OPV3_Date_of_Vaccination = "ChildVaccination_OPV3_Date_of_Vaccination";
	    	public static final String ChildVaccination_OPV2_Date_of_Vaccination = "ChildVaccination_OPV2_Date_of_Vaccination";
	    	public static final String ChildVaccination_OPV1_Date_of_Vaccination = "ChildVaccination_OPV1_Date_of_Vaccination";
	    	public static final String ChildVaccination_OPV0_Date_of_Vaccination = "ChildVaccination_OPV0_Date_of_Vaccination";
	    	public static final String ChildVaccination_MR_Date_of_Vaccination = "ChildVaccination_MR_Date_of_Vaccination";
	    	public static final String ChildVaccination_Measles_Date_of_Vaccination = "ChildVaccination_Measles_Date_of_Vaccination";
	    	public static final String ChildVaccination_IPV_Date_of_Vaccination = "ChildVaccination_IPV_Date_of_Vaccination";
	    	public static final String ChildVaccination_BCG_Date_of_Vaccination = "ChildVaccination_BCG_Date_of_Vaccination";		
	
	    	public static final String existing_first_name
	    	="existing_first_name";
	    	public static final String existing_mother_name
	    	="existing_mother_name";
	    	public static final String existing_gender
	    	="existing_gender";
	    	public static final String existing_birth_date
	    	="existing_birth_date";
	    	public static final String existing_Country   
	    	= "existing_Country";
	    	public static final String existing_Division
	    	="existing_Division";
	    	public static final String existing_District
	    	="existing_District";
	    	public static final String existing_Upazilla
	    	="existing_Upazilla";
	    	public static final String existing_Paurasava
	    	="existing_Paurasava";
	    	public static final String existing_Union
	    	="existing_Union";
	    	public static final String existing_Ward
	    	="existing_Ward";
	    	public static final String existing_Block
	    	="existing_Block";
	    	public static final String existing_HIE_facilities
	    	="existing_HIE_facilities";
	    	public static final String existing_Address_line
	    	="existing_Address_line";
	    	public static final String existing_GPS
	    	="existing_GPS";
	    	public static final String existing_epi_card_number
	    	="existing_epi_card_number";	    	
	    	public static final String e_bcg
	    	="e_bcg";
	    	public static final String e_opv0
	    	="e_opv0";
	    	public static final String e_penta2
	    	="e_penta2";
	    	public static final String e_penta1
	    	="e_penta1";
	    	public static final String e_penta3
	    	="e_penta3";
	    	public static final String e_opv1
	    	="e_opv1";
	    	public static final String e_opv2
	    	="e_opv2";
	    	public static final String e_opv3
	    	="e_opv3";
	    	public static final String e_pcv1
	    	="e_pcv1";
	    	public static final String e_pcv2
	    	="e_pcv2"; 
	    	public static final String e_pcv3
	    	="e_pcv3";
	    	public static final String e_ipv
	    	="e_ipv";
	    	public static final String e_measles1
	    	="e_measles1";
	    	public static final String e_measles2
	    	="e_measles2";
	    	public static final String provider_id
	    	="provider_id";
	    	public static final String provider_location_id
	    	="provider_location_id";
	    	public static final String provider_location_name
	    	="provider_location_name";
	    	public static final String provider_location_note
	    	="provider_location_note";
	    	public static final String existing_client_reg_date_note
	    	="existing_client_reg_date_note";
	    	public static final String epi_card_number_note
	    	="epi_card_number_note";
	    	public static final String first_name_note
	    	="first_name_note";
	    	public static final String child_age
	    	="child_age";
	    	public static final String calc_dob_note
	    	="calc_dob_note";
	    	public static final String gender_note
	    	="gender_note";
	    	public static final String mother_name_note
	    	="mother_name_note";
	    	public static final String address
	    	="address";
	    	public static final String address_change
	    	="address_change";
	    	public static final String address1
	    	="address1";
	    	public static final String landmark
	    	="landmark";
	    	public static final String center_gps
	    	="center_gps";
	    	public static final String child_was_suffering_from_a_disease_at_birth_note
	    	="child_was_suffering_from_a_disease_at_birth_note";
	    	public static final String side_effects
	    	="side_effects";
	    	public static final String six_weeks
	    	="six_weeks";
	    	public static final String ten_weeks
	    	="ten_weeks";
	    	public static final String forteen_weeks
	    	="forteen_weeks";
	    	public static final String nine_months
	    	="nine_months";
	    	public static final String fifteen_months
	    	="fifteen_months";
	    	public static final String bcg_note
	    	="bcg_note";
	    	public static final String opv0_note
	    	="opv0_note";
	    	public static final String opv1_note
	    	="opv1_note";
	    	public static final String pcv1_note
	    	="pcv1_note";
	    	public static final String penta1_note
	    	="penta1_note";
	    	public static final String opv2_note
	    	="opv2_note";
	    	public static final String pcv2_note
	    	="pcv2_note";
	    	public static final String penta2_note
	    	="penta2_note";
	    	public static final String opv3_note
	    	="opv3_note";
	    	public static final String pcv3_note
	    	="pcv3_note";
	    	public static final String penta3_note
	    	="penta3_note";
	    	public static final String ipv_note
	    	="ipv_note";
	    	public static final String measles1_note
	    	="ipv_note";
	    	public static final String measles2_note
	    	="measles2_note";
	    	public static final String vaccination_date
	    	="vaccination_date";
	    	public static final String final_bcg
	    	="final_bcg";
	    	public static final String final_opv0
	    	="final_opv0";
	    	public static final String final_pcv1
	    	="final_pcv1";
	    	public static final String final_opv1
	    	="final_opv1";
	    	public static final String final_penta1
	    	="final_penta1";
	    	public static final String final_pcv2
	    	="final_pcv2";
	    	public static final String final_opv2
	    	="final_opv2";
	    	public static final String final_penta2
	    	="final_penta2";
	    	public static final String final_pcv3
	    	="final_pcv3";
	    	public static final String final_opv3
	    	="final_opv3";
	    	public static final String final_penta3
	    	="final_penta3";
	    	public static final String final_ipv
	    	="final_ipv";
	    	public static final String final_measles1
	    	="final_measles1";
	    	public static final String final_measles2
	    	="final_measles2";
	    	public static final String address_note
	    	="address_note";
	    	public static final String 	existing_contact_phone_number	="	existing_contact_phone_number	";
	    	public static final String 	father_name_note	="	father_name_note	";
	    	public static final String 	husband_name	="	husband_name	";
	    	public static final String 	husband_name_note	="	husband_name_note	";
	    	public static final String 	Marital_Status	="	Marital_Status	";
	    	public static final String 	marriage	="	marriage	";
	    	public static final String 	Member_Address_line	="	Member_Address_line	";
	    	public static final String 	Member_COUNTRY	="	Member_COUNTRY	";
	    	public static final String 	Member_DISTRICT	="	Member_DISTRICT	";
	    	public static final String 	Member_DIVISION	="	Member_DIVISION	";
	    	public static final String 	Member_GPS	="	Member_GPS	";
	    	public static final String 	Member_HIE_facilities	="	Member_HIE_facilities	";
	    	public static final String 	Member_Paurasava	="	Member_Paurasava	";
	    	public static final String 	Member_UNION	="	Member_UNION	";
	    	public static final String 	Member_UPAZILLA	="	Member_UPAZILLA	";
	    	public static final String 	Member_WARD	="	Member_WARD	";
	    	public static final String 	tt1_note	="	tt1_note	";
	    	public static final String 	tt2_note	="	tt2_note	";
	    	public static final String 	tt3_note	="	tt3_note	";
	    	public static final String 	tt4_note	="	tt4_note	";
    }

    public static class PSRFFields
    {
    	public static final String FW_PSRDATE ="FWPSRDATE";
    	public static final String FW_CONFIRMATION ="FWCONFIRMATION";
    	public static final String FW_PSRSTS ="FWPSRSTS";
    	public static final String FW_PSRLMP ="FWPSRLMP";
    	public static final String FW_PSRPREGSTS ="FWPSRPREGSTS";
    	public static final String FW_PSRWOMPREGWTD ="FWPSRWOMPREGWTD";
    	public static final String FW_PSRHUSPREGWTD ="FWPSRHUSPREGWTD";
    	public static final String FW_PSREVRPREG ="FWPSREVRPREG";
    	public static final String FW_PSRTOTBIRTH ="FWPSRTOTBIRTH";
    	public static final String FW_PSRNBDTH ="FWPSRNBDTH";
    	public static final String FW_PSRPRSB ="FWPSRPRSB";
    	public static final String FW_PSRPRMC ="FWPSRPRMC";
    	public static final String FW_PSRPREGTWYRS ="FWPSRPREGTWYRS";
    	public static final String FW_PSRPRVPREGCOMP ="FWPSRPRVPREGCOMP";
    	public static final String FW_PSRPRCHECKS ="FWPSRPRCHECKS";
    	public static final String FW_PSRVDGMEM ="FWPSRVDGMEM";
    	public static final String FW_PSRWOMEDU ="FWPSRWOMEDU";
    	public static final String FW_PSRHHLAT ="FWPSRHHLAT";
    	public static final String FW_PSRHHRICE ="FWPSRHHRICE";
    	public static final String FW_PSRANM ="FWPSRANM";
    	public static final String FW_PSRHBP ="FWPSRHBP";
    	public static final String FW_PSRDBT ="FWPSRDBT";
    	public static final String FW_PSRTHY ="FWPSRTHY";
    	public static final String FW_PSRHGT ="FWPSRHGT";
    	public static final String FW_PSRMUAC ="FWPSRMUAC";	
    	public static final String FW_PSRPHONE ="FWPSRPHONE";
    	public static final String FW_PSRPHONENUM ="FWPSRPHONENUM";	
    	public static final String FW_VG = "FWVG";
    	public static final String FW_HRP = "FWHRP";
    	public static final String FW_HR_PSR = "FWHR_PSR";
    	public static final String FW_FLAGVALUE = "FWFLAGVALUE";
    	public static final String FW_SORTVALUE = "FWSORTVALUE"; 
    	public static final String FWNOTELIGIBLE = "FWNOTELIGIBLE";
    	public static final String current_formStatus = "current_formStatus";
    	
    }
    
    public static class TT_VisitFields
    {
    	public static final String FW_PSRDATE ="FWPSRDATE";
    	public static final String FW_CONFIRMATION ="FWCONFIRMATION";
    	public static final String FW_PSRSTS ="FWPSRSTS";
    	public static final String FW_PSRLMP ="FWPSRLMP";
    	public static final String Received_Time = "received_time";
    }
    
    public static class ANCVisitOneFields
    {
    	public static final String anc1_current_formStatus="anc1_current_formStatus";
    	public static final String FWANC1DATE ="FWANC1DATE";
    	public static final String FWCONFIRMATION ="FWCONFIRMATION";
    	public static final String FWGESTATIONALAGE ="FWGESTATIONALAGE";
    	public static final String FWEDD ="FWEDD";
    	public static final String FWANC1REMSTS ="FWANC1REMSTS";
    	public static final String FWANC1INT ="FWANC1INT";
    	public static final String DISPLAYTEXT2 ="DISPLAYTEXT2";
    	public static final String FWANC1KNWPRVDR ="FWANC1KNWPRVDR";
    	public static final String DISPLAYTEXT3 ="DISPLAYTEXT3";
    	public static final String FWANC1ANM ="FWANC1ANM";
    	public static final String FWANC1HBP ="FWANC1HBP";
    	public static final String FWANC1DBT ="FWANC1DBT";
    	public static final String FWANC1THY ="FWANC1THY";
    	public static final String DISPLAYTEXT4 ="DISPLAYTEXT4";
    	public static final String FWANC1PROB ="FWANC1PROB";
    	public static final String FWDISPLAYTEXT5 ="FWDISPLAYTEXT5";
    	public static final String FWDISPLAYTEXT6 ="FWDISPLAYTEXT6";
    	public static final String FWDISPLAYTEXT7 ="FWDISPLAYTEXT7";
    	public static final String FWDISPLAYTEXT8 ="FWDISPLAYTEXT8";
    	public static final String FWDISPLAYTEXT9 ="FWDISPLAYTEXT9";
    	public static final String FWDISPLAYTEXT10 ="FWDISPLAYTEXT10";
    	public static final String FWDISPLAYTEXT11 ="FWDISPLAYTEXT11";
    	public static final String FWBPC1LOCOFDEL ="FWBPC1LOCOFDEL";
    	public static final String FWBPC1DISPLAYTEXT1 ="FWBPC1DISPLAYTEXT1";
    	public static final String FWBPC1DISPLAYTEXT2 ="FWBPC1DISPLAYTEXT2";
    	public static final String FWBPC1DISPLAYTEXT3 ="FWBPC1DISPLAYTEXT3";
    	public static final String FWBPC1ASSTLAB ="FWBPC1ASSTLAB";
    	public static final String FWBPC1DISPLAYTEXT4 ="FWBPC1DISPLAYTEXT4";
    	public static final String FWBPC1DISPLAYTEXT5 ="FWBPC1DISPLAYTEXT5";
    	public static final String FWBPC1TRNSPRT ="FWBPC1TRNSPRT";
    	public static final String FWBPC1DISPLAYTEXT6 ="FWBPC1DISPLAYTEXT6";
    	public static final String FWBPC1DISPLAYTEXT7 ="FWBPC1DISPLAYTEXT7";
    	public static final String FWBPC1BLDGRP ="FWBPC1BLDGRP";
    	public static final String FWBPC1DISPLAYTEXT8 ="FWBPC1DISPLAYTEXT8";
    	public static final String FWBPC1DISPLAYTEXT9 ="FWBPC1DISPLAYTEXT9";
    	public static final String FWBPC1BLDDNR ="FWBPC1BLDDNR";
    	public static final String FWBPC1DISPLAYTEXT10 ="FWBPC1DISPLAYTEXT10";
    	public static final String FWBPC1DISPLAYTEXT11 ="FWBPC1DISPLAYTEXT11";
    	public static final String FWBPC1FINARGMT ="FWBPC1FINARGMT";
    	public static final String FWBPC1DISPLAYTEXT12 ="FWBPC1DISPLAYTEXT12";
    	public static final String FWBPC1DISPLAYTEXT13 ="FWBPC1DISPLAYTEXT13";
    	public static final String FWANC1HEAD="FWANC1HEAD";
    	public static final String mauza ="mauza";
    	public static final String mother_mauza ="mother_mauza";
    	public static final String FWVG ="FWVG";
    	public static final String FWHR_PSR ="FWHR_PSR";
    	public static final String FWHRP ="FWHRP";
    	public static final String existing_ELCO ="existing_ELCO";
    	public static final String FWANC1BLRVIS ="FWANC1BLRVIS";
    	public static final String FWANC1SWLNG ="FWANC1SWLNG";
    	public static final String FWANC1CONVL ="FWANC1CONVL";
    	public static final String FWANC1BLD ="FWANC1BLD";
    	public static final String FWANC1DS1 ="FWANC1DS1";
    	public static final String FWANC1DS2 ="FWANC1DS2";
    	public static final String FWANC1DS3 ="FWANC1DS3";
    	public static final String FWANC1DS4 ="FWANC1DS4";
    	public static final String FWANC1DS5 ="FWANC1DS5";
    	public static final String FWANC1DS6 ="FWANC1DS6";
    	public static final String FWDANGERVALUE ="FWDANGERVALUE";
    	public static final String FWNOTELIGIBLE ="FWNOTELIGIBLE";
    	public static final String ELCO ="ELCO";
    	public static final String FWHR_ANC1 ="FWHR_ANC1";
    	public static final String FWFLAGVALUE ="FWFLAGVALUE";
    	public static final String FWSORTVALUE ="FWSORTVALUE";
    	public static final String user_type ="user_type";
    	public static final String external_user_ID ="external_user_ID";
    	public static final String relationalid ="relationalid";
    	public static final String mother_valid = "mother_valid";
    	
    }
    
    public static class ANCVisitTwoFields
    {
    	public static final String ANC2_current_formStatus="ANC2_current_formStatus";
    	public static final String FWANC2DATE ="FWANC2DATE";
    	public static final String FWANC2REMSTS ="FWANC2REMSTS";
    	public static final String FWANC2INT ="FWANC2INT";
    	public static final String FWANC2KNWPRVDR ="FWANC2KNWPRVDR";
    	public static final String FWANC2PREGCOND ="FWANC2PREGCOND";
    	public static final String FWANC2PROB ="FWANC2PROB";
    	public static final String FWBPC2LOCOFDEL ="FWBPC2LOCOFDEL";
    	public static final String FWBPC2DISPLAYTEXT1 ="FWBPC2DISPLAYTEXT1";
    	public static final String FWBPC2DISPLAYTEXT2 ="FWBPC2DISPLAYTEXT2";
    	public static final String FWBPC2DISPLAYTEXT3 ="FWBPC2DISPLAYTEXT3";
    	public static final String FWBPC2ASSTLAB ="FWBPC2ASSTLAB";
    	public static final String FWBPC2DISPLAYTEXT4 ="FWBPC2DISPLAYTEXT4";
    	public static final String FWBPC2DISPLAYTEXT5 ="FWBPC2DISPLAYTEXT5";
    	public static final String FWBPC2TRNSPRT ="FWBPC2TRNSPRT";
    	public static final String FWBPC2DISPLAYTEXT6 ="FWBPC2DISPLAYTEXT6";
    	public static final String FWBPC2DISPLAYTEXT7 ="FWBPC2DISPLAYTEXT7";
    	public static final String FWBPC2BLDGRP ="FWBPC2BLDGRP";
    	public static final String FWBPC2DISPLAYTEXT8 ="FWBPC2DISPLAYTEXT8";
    	public static final String FWBPC2DISPLAYTEXT9 ="FWBPC2DISPLAYTEXT9";
    	public static final String FWBPC2BLDDNR ="FWBPC2BLDDNR";
    	public static final String FWBPC2DISPLAYTEXT10 ="FWBPC2DISPLAYTEXT10";
    	public static final String FWBPC2DISPLAYTEXT11 ="FWBPC2DISPLAYTEXT11";
    	public static final String FWBPC2FINARGMT ="FWBPC2FINARGMT";
    	public static final String FWBPC2DISPLAYTEXT12 ="FWBPC2DISPLAYTEXT12";
    	public static final String FWBPC2DISPLAYTEXT13 ="FWBPC2DISPLAYTEXT13";
    	public static final String FWHR_ANC2 ="FWHR_ANC2";
    	
    	public static final String FWANC2ANM ="FWANC2ANM";
    	public static final String FWANC2HBP ="FWANC2HBP";
    	public static final String FWANC2DBT ="FWANC2DBT";
    	public static final String FWANC2THY ="FWANC2THY";
    	public static final String FWANC2HEAD ="FWANC2HEAD";
    	public static final String FWANC2BLRVIS ="FWANC2BLRVIS";
    	public static final String FWANC2SWLNG ="FWANC2SWLNG";
    	public static final String FWANC2CONVL ="FWANC2CONVL";
    	public static final String FWANC2BLD ="FWANC2BLD";
    	public static final String FWANC2DS1 ="FWANC2DS1";
    	public static final String FWANC2DS2 ="FWANC2DS2";
    	public static final String FWANC2DS3 ="FWANC2DS3";
    	public static final String FWANC2DS4 ="FWANC2DS4";
    	public static final String FWANC2DS5 ="FWANC2DS5";
    	public static final String FWANC2DS6 ="FWANC2DS6";
    	
    }
    
    public static class ANCVisitThreeFields
    {
    	public static final String ANC3_current_formStatus="ANC3_current_formStatus";
    	public static final String FWANC3DATE ="FWANC3DATE";
    	public static final String FWANC3REMSTS ="FWANC3REMSTS";
    	public static final String FWANC3INT ="FWANC3INT";
    	public static final String FWANC3KNWPRVDR ="FWANC3KNWPRVDR";
    	public static final String FWANC3PREGCOND ="FWANC3PREGCOND";
    	public static final String FWANC3PROB ="FWANC3PROB";
    	public static final String FWANC3DNGRSIGN ="FWANC3DNGRSIGN";
    	public static final String FWBPC3LOCOFDEL ="FWBPC3LOCOFDEL";
    	public static final String FWBPC3DISPLAYTEXT1 ="FWBPC3DISPLAYTEXT1";
    	public static final String FWBPC3DISPLAYTEXT2 ="FWBPC3DISPLAYTEXT2";
    	public static final String FWBPC3DISPLAYTEXT3 ="FWBPC3DISPLAYTEXT3";
    	public static final String FWBPC3ASSTLAB ="FWBPC3ASSTLAB";
    	public static final String FWBPC3DISPLAYTEXT4 ="FWBPC3DISPLAYTEXT4";
    	public static final String FWBPC3DISPLAYTEXT5 ="FWBPC3DISPLAYTEXT5";
    	public static final String FWBPC3TRNSPRT ="FWBPC3TRNSPRT";
    	public static final String FWBPC3DISPLAYTEXT6 ="FWBPC3DISPLAYTEXT6";
    	public static final String FWBPC3DISPLAYTEXT7 ="FWBPC3DISPLAYTEXT7";
    	public static final String FWBPC3BLDGRP ="FWBPC3BLDGRP";
    	public static final String FWBPC3DISPLAYTEXT8 ="FWBPC3DISPLAYTEXT8";
    	public static final String FWBPC3DISPLAYTEXT9 ="FWBPC3DISPLAYTEXT9";
    	public static final String FWBPC3BLDDNR ="FWBPC3BLDDNR";
    	public static final String FWBPC3DISPLAYTEXT10 ="FWBPC3DISPLAYTEXT10";
    	public static final String FWBPC3DISPLAYTEXT11 ="FWBPC3DISPLAYTEXT11";
    	public static final String FWBPC3FINARGMT ="FWBPC3FINARGMT";
    	public static final String FWBPC3DISPLAYTEXT12 ="FWBPC3DISPLAYTEXT12";
    	public static final String FWBPC3DISPLAYTEXT13 ="FWBPC3DISPLAYTEXT13";
    	
    	public static final String FWANC3ANM ="FWANC3ANM";
    	public static final String FWANC3HBP ="FWANC3HBP";
    	public static final String FWANC3DBT ="FWANC3DBT";
    	public static final String FWANC3THY ="FWANC3THY";
    	public static final String FWANC3HEAD ="FWANC3HEAD";
    	public static final String FWANC3BLRVIS ="FWANC3BLRVIS";
    	public static final String FWANC3SWLNG ="FWANC3SWLNG";
    	public static final String FWANC3CONVL ="FWANC3CONVL";
    	public static final String FWANC3BLD ="FWANC3BLD";
    	public static final String FWANC3DS1 ="FWANC3DS1";
    	public static final String FWANC3DS2 ="FWANC3DS2";
    	public static final String FWANC3DS3 ="FWANC3DS3";
    	public static final String FWANC3DS4 ="FWANC3DS4";
    	public static final String FWANC3DS5 ="FWANC3DS5";
    	public static final String FWANC3DS6 ="FWANC3DS6";
    	public static final String FWHR_ANC3 ="FWHR_ANC3";
    
    }
    
    public static class ANCVisitFourFields
    {
    	public static final String ANC4_current_formStatus="ANC4_current_formStatus";
    	public static final String FWANC4DATE ="FWANC4DATE";
    	public static final String FWANC4REMSTS ="FWANC4REMSTS";
    	public static final String FWANC4INT ="FWANC4INT";
    	public static final String FWANC4KNWPRVDR ="FWANC4KNWPRVDR";
    	public static final String FWANC4PREGCOND ="FWANC4PREGCOND";
    	public static final String FWANC4PROB ="FWANC4PROB";
    	public static final String FWANC4DNGRSIGN ="FWANC4DNGRSIGN";
    	public static final String FWBPC4LOCOFDEL ="FWBPC4LOCOFDEL";
    	public static final String FWBPC4DISPLAYTEXT1 ="FWBPC4DISPLAYTEXT1";
    	public static final String FWBPC4DISPLAYTEXT2 ="FWBPC4DISPLAYTEXT2";
    	public static final String FWBPC4DISPLAYTEXT3 ="FWBPC4DISPLAYTEXT3";
    	public static final String FWBPC4ASSTLAB ="FWBPC4ASSTLAB";
    	public static final String FWBPC4DISPLAYTEXT4 ="FWBPC4DISPLAYTEXT4";
    	public static final String FWBPC4DISPLAYTEXT5 ="FWBPC4DISPLAYTEXT5";
    	public static final String FWBPC4TRNSPRT ="FWBPC4TRNSPRT";
    	public static final String FWBPC4DISPLAYTEXT6 ="FWBPC4DISPLAYTEXT6";
    	public static final String FWBPC4DISPLAYTEXT7 ="FWBPC4DISPLAYTEXT7";
    	public static final String FWBPC4BLDGRP ="FWBPC4BLDGRP";
    	public static final String FWBPC4DISPLAYTEXT8 ="FWBPC4DISPLAYTEXT8";
    	public static final String FWBPC4DISPLAYTEXT9 ="FWBPC4DISPLAYTEXT9";
    	public static final String FWBPC4BLDDNR ="FWBPC4BLDDNR";
    	public static final String FWBPC4DISPLAYTEXT10 ="FWBPC4DISPLAYTEXT10";
    	public static final String FWBPC4DISPLAYTEXT11 ="FWBPC4DISPLAYTEXT11";
    	public static final String FWBPC4FINARGMT ="FWBPC4FINARGMT";
    	public static final String FWBPC4DISPLAYTEXT12 ="FWBPC4DISPLAYTEXT12";
    	public static final String FWBPC4DISPLAYTEXT13 ="FWBPC4DISPLAYTEXT13";
    	
    	public static final String FWANC4ANM ="FWANC4ANM";
    	public static final String FWANC4HBP ="FWANC4HBP";
    	public static final String FWANC4DBT ="FWANC4DBT";
    	public static final String FWANC4THY ="FWANC4THY";
    	public static final String FWANC4HEAD ="FWANC4HEAD";
    	public static final String FWANC4BLRVIS ="FWANC4BLRVIS";
    	public static final String FWANC4SWLNG ="FWANC4SWLNG";
    	public static final String FWANC4CONVL ="FWANC4CONVL";
    	public static final String FWANC4BLD ="FWANC4BLD";
    	public static final String FWANC4DS1 ="FWANC4DS1";
    	public static final String FWANC4DS2 ="FWANC4DS2";
    	public static final String FWANC4DS3 ="FWANC4DS3";
    	public static final String FWANC4DS4 ="FWANC4DS4";
    	public static final String FWANC4DS5 ="FWANC4DS5";
    	public static final String FWANC4DS6 ="FWANC4DS6";
    	public static final String FWHR_ANC4 ="FWHR_ANC4";
    
    }
    
    public static class BnfFollowUpVisitFields
    {
    	public static final String FWBNFDATE ="FWBNFDATE";
    	public static final String FWBNFSTS ="FWBNFSTS";
    	public static final String FWDISPLAYTEXT1 ="FWDISPLAYTEXT1";
    	public static final String FWBNFWOMVITSTS ="FWBNFWOMVITSTS";
    	public static final String FWBNFDTOO ="FWBNFDTOO";
    	public static final String FWBNFLB ="FWBNFLB";
    	public static final String FWBNFGEN ="FWBNFGEN";
    	public static final String FWBNFCHLDVITSTS ="FWBNFCHLDVITSTS";
    	public static final String FWBNFSMSRSN ="FWBNFSMSRSN";
    	public static final String STS_LB ="3";
    	public static final String STS_SB ="4";
    	public static final String STS_GONE ="7";
    	public static final String STS_GO ="8";
    	public static final String STS_WD ="9";
    	public static final String SCHEDULE_BNF_IME = "ImmediateBirthNotificationPregnancyStatusFollowUp";
    	public static final String SCHEDULE_BNF = "BirthNotificationPregnancyStatusFollowUp";
    	public static final String bnf_current_formStatus = "bnf_current_formStatus";     
    }
    
    public static class PNCVisitOneFields
    {
    	public static final String FWPNC1DATE ="FWPNC1DATE";
    	public static final String FWPNC1REMSTS ="FWPNC1REMSTS";
    	public static final String FWPNC1INT ="FWPNC1INT";
    	public static final String FWPNC1KNWPRVDR ="FWPNC1KNWPRVDR";
    	public static final String FWPNC1FVR ="FWPNC1FVR";
    	public static final String FWPNC1TEMP ="FWPNC1TEMP";
    	public static final String FWPNC1DNGRSIGN ="FWPNC1DNGRSIGN";
    	public static final String FWPNC1DELTYPE ="FWPNC1DELTYPE";
    	public static final String FWPNC1DELCOMP ="FWPNC1DELCOMP";
    	public static final String pnc1_current_formStatus ="pnc1_current_formStatus";
    	
    }
    
    public static class PNCVisitTwoFields
    {
    	public static final String FWPNC2DATE ="FWPNC2DATE";
    	public static final String FWPNC2REMSTS ="FWPNC2REMSTS";
    	public static final String FWPNC2INT ="FWPNC2INT";
    	public static final String FWPNC2KNWPRVDR ="FWPNC2KNWPRVDR";
    	public static final String FWPNC2FVR ="FWPNC2FVR";
    	public static final String FWPNC2TEMP ="FWPNC2TEMP";
    	public static final String FWPNC2DNGRSIGN ="FWPNC2DNGRSIGN";
    	public static final String FWPNC2DELCOMP ="FWPNC2DELCOMP";
    	public static final String pnc2_current_formStatus ="pnc2_current_formStatus";
    	
    }
    
    public static class PNCVisitThreeFields
    {
    	public static final String FWPNC3DATE ="FWPNC3DATE";
    	public static final String FWPNC3REMSTS ="FWPNC3REMSTS";
    	public static final String FWPNC3INT ="FWPNC3INT";
    	public static final String FWPNC3KNWPRVDR ="FWPNC3KNWPRVDR";
    	public static final String FWPNC3FVR ="FWPNC3FVR";
    	public static final String FWPNC3TEMP ="FWPNC3TEMP";
    	public static final String FWPNC3DNGRSIGN ="FWPNC3DNGRSIGN";
    	public static final String FWPNC3DELCOMP ="FWPNC3DELCOMP";
    	public static final String pnc3_current_formStatus ="pnc3_current_formStatus";
    	
    }
    
    public static class ENCCVisitOneFields
    {
    	public static final String FWENC1DATE ="FWENC1DATE";
    	public static final String FWENC1STS ="FWENC1STS";
    	public static final String FWENC1BFINTN ="FWENC1BFINTN";
    	public static final String FWENC1PRLCTL ="FWENC1PRLCTL";
    	public static final String FWENC1DRYWM ="FWENC1DRYWM";
    	public static final String FWENC1HDCOV ="FWENC1HDCOV";
    	public static final String FWENC1BTHD ="FWENC1BTHD";
    	public static final String FWENC1UMBS ="FWENC1UMBS";
    	public static final String FWENC1DSFVRCLD ="FWENC1DSFVRCLD";
    	public static final String FWENC1TEMP ="FWENC1TEMP";
    	public static final String FWENC1DSFOULUMBS ="FWENC1DSFOULUMBS";
    	public static final String FWENC1DSLIMBLUE ="FWENC1DSLIMBLUE";
    	public static final String FWENC1DSSKNYLW ="FWENC1DSSKNYLW";
    	public static final String FWENC1DSLETH ="FWENC1DSLETH";
    	public static final String FWENC1DSDIFBRTH ="FWENC1DSDIFBRTH";
    	public static final String FWENC1DSCONVL ="FWENC1DSCONVL";
    	public static final String FWENC1DELCOMP ="FWENC1DELCOMP";
    	public static final String encc1_current_formStatus ="encc1_current_formStatus";
    	
    }
    
    public static class ENCCVisitTwoFields
    {
    	public static final String FWENC2DATE ="FWENC2DATE";
    	public static final String FWENC2STS ="FWENC2STS";
    	public static final String FWENC2BFINTN ="FWENC2BFINTN";
    	public static final String FWENC2PRLCTL ="FWENC2PRLCTL";
    	public static final String FWENC2DRYWM ="FWENC2DRYWM";
    	public static final String FWENC2HDCOV ="FWENC2HDCOV";
    	public static final String FWENC2BTHD ="FWENC2BTHD";
    	public static final String FWENC2UMBS ="FWENC2UMBS";
    	public static final String FWENC2DSFVRCLD ="FWENC2DSFVRCLD";
    	public static final String FWENC2TEMP ="FWENC2TEMP";
    	public static final String FWENC2DSFOULUMBS ="FWENC2DSFOULUMBS";
    	public static final String FWENC2DSLIMBLUE ="FWENC2DSLIMBLUE";
    	public static final String FWENC2DSSKNYLW ="FWENC2DSSKNYLW";
    	public static final String FWENC2DSLETH ="FWENC2DSLETH";
    	public static final String FWENC2DSDIFBRTH ="FWENC2DSDIFBRTH";
    	public static final String FWENC2DSCONVL ="FWENC2DSCONVL";
    	public static final String FWENC2DELCOMP ="FWENC2DELCOMP";
    	public static final String encc2_current_formStatus ="encc2_current_formStatus";
    	
    }
    
    public static class ENCCVisitThreeFields
    {
    	public static final String FWENC3DATE ="FWENC3DATE";
    	public static final String FWENC3STS ="FWENC3STS";
    	public static final String FWENC3BFINTN ="FWENC3BFINTN";
    	public static final String FWENC3PRLCTL ="FWENC3PRLCTL";
    	public static final String FWENC3DRYWM ="FWENC3DRYWM";
    	public static final String FWENC3HDCOV ="FWENC3HDCOV";
    	public static final String FWENC3BTHD ="FWENC3BTHD";
    	public static final String FWENC3UMBS ="FWENC3UMBS";
    	public static final String FWENC3DSFVRCLD ="FWENC3DSFVRCLD";
    	public static final String FWENC3TEMP ="FWENC3TEMP";
    	public static final String FWENC3DSFOULUMBS ="FWENC3DSFOULUMBS";
    	public static final String FWENC3DSLIMBLUE ="FWENC3DSLIMBLUE";
    	public static final String FWENC3DSSKNYLW ="FWENC3DSSKNYLW";
    	public static final String FWENC3DSLETH ="FWENC3DSLETH";
    	public static final String FWENC3DSDIFBRTH ="FWENC3DSDIFBRTH";
    	public static final String FWENC3DSCONVL ="FWENC3DSCONVL";
    	public static final String FWENC3DELCOMP ="FWENC3DELCOMP";
    	public static final String encc3_current_formStatus ="encc3_current_formStatus";
    	
    }
    
    public static class ECRegistrationFields {
        public static final String CASTE = "caste";
        public static final String RELIGION = "religion";
        public static final String ECONOMIC_STATUS = "economicStatus";
        public static final String ECONOMIC_STATUS_APL_VALUE = "apl";
        public static final String ECONOMIC_STATUS_BPL_VALUE = "bpl";
        public static final String AADHAR_NUMBER = "aadharNumber";
        public static final String HOUSEHOLD_ADDRESS = "householdAddress";
        public static final String WIFE_AGE = "wifeAge";
        public static final String PHONE_NUMBER = "phoneNumber";
        public static final String WIFE_EDUCATIONAL_LEVEL = "educationalLevel";
        public static final String HUSBAND_EDUCATION_LEVEL = "husbandEducationLevel";
        public static final String BPL_CARD_NUMBER = "bplCardNumber";
        public static final String NUMBER_OF_PREGNANCIES = "numberOfPregnancies";
        public static final String PARITY = "parity";
        public static final String NUMBER_OF_LIVING_CHILDREN = "numberOfLivingChildren";
        public static final String NUMBER_OF_STILL_BIRTHS = "numberOfStillBirths";
        public static final String NUMBER_OF_ABORTIONS = "numberOfAbortions";
        public static final String YOUNGEST_CHILD_DOB = "youngestChildDOB";
        public static final String YOUNGEST_CHILD_AGE = "youngestChildAge";
        public static final String WIFE_DOB = "womanDOB";
        public static final String HUSBAND_AGE = "husbandAge";
        public static final String HOUSEHOLD_NUMBER = "householdNumber";
        public static final String HEAD_OF_HOUSEHOLD = "headOfHousehold";
        public static final String NUMBER_OF_LIVING_MALE_CHILDREN = "numberOfLivingMaleChildren";
        public static final String NUMBER_OF_LIVING_FEMALE_CHILDREN = "numberOfLivingFemaleChild";
        public static final String SC_VALUE = "sc";
        public static final String ST_VALUE = "st";
        public static final String C_OTHERS_VALUE = "c_others";
        public static final String IS_OUT_OF_AREA_FALSE = "false";
        public static final String IS_OUT_OF_AREA = "isOutOfArea";

    }

    public static class DeliveryOutcomeFields {
        public static final String DELIVERY_OUTCOME = "deliveryOutcome";
        public static final String DELIVERY_PLACE = "deliveryPlace";
        public static final String DID_WOMAN_SURVIVE = "didWomanSurvive";
        public static final String DID_MOTHER_SURVIVE = "didMotherSurvive";
        public static final String DID_BREAST_FEEDING_START = "didBreastfeedingStart";
        public static final String DELIVERY_COMPLICATIONS = "deliveryComplications";
        public static final String LIVE_BIRTH_FIELD_VALUE = "live_birth";
        public static final String PHC_FIELD_VALUE = "phc";
        public static final String CHC_FIELD_VALUE = "chc";
        public static final String SDH_FIELD_VALUE = "sdh";
        public static final String DH_FIELD_VALUE = "dh";
        public static final String PRIVATE_FACILITY_FIELD_VALUE = "private_facility";
        public static final String CHILD_REGISTRATION_SUB_FORM_NAME = "child_registration";
        public static final String STILL_BIRTH_VALUE = "still_birth";
        public static final String DELIVERY_TYPE = "deliveryType";
        public static final String CESAREAN_VALUE = "cesarean";
        public static final String IS_SKILLED_DELIVERY = "isSkilledDelivery";
        public static final String IMMUNIZATIONS_AT_BIRTH = "immunizationsAtBirth";
    }

    public static class ANCRegistrationFormFields {
        public static final String JSY_BENEFICIARY = "isJSYBeneficiary";
        public static final String ANC_NUMBER = "ancNumber";
        public static final String EDD = "edd";
        public static final String HEIGHT = "height";
        public static final String BLOOD_GROUP = "bloodGroup";
    }

    public static class ANCFormFields {
        public static final String MOTHER_ID = "motherId";
        public static final String MCARE_MOTHER_ID = "id";
        public static final String REGISTRATION_DATE = "registrationDate";
        public static final String ANC_VISIT_DATE_FIELD = "ancVisitDate";
        public static final String ANC_VISIT_NUMBER_FIELD = "ancVisitNumber";
        public static final String TT1_DOSE_VALUE = "tt1";
        public static final String TT2_DOSE_VALUE = "tt2";
        public static final String TT_BOOSTER_DOSE_VALUE = "ttbooster";
        public static final String TT_DOSE_FIELD = "ttDose";
        public static final String TT_DATE_FIELD = "ttDate";
        public static final String THAYI_CARD_NUMBER = "thayiCardNumber";
    }

    public static class ANCVisitFormFields {
        public static final String BP_DIASTOLIC = "bpDiastolic";
        public static final String PREVIOUS_BP_DIASTOLIC = "previousBpDiastolic";
        public static final String PREVIOUS_BP_SYSTOLIC = "previousBpSystolic";
        public static final String BP_SYSTOLIC = "bpSystolic";
        public static final String IS_HYPERTENSION_DETECTED_FOR_FIRST_TIME = "isHypertensionDetectedForFirstTime";
        public static final String RISK_OBSERVED_DURING_ANC = "riskObservedDuringANC";
        public static final String BLEEDING_VALUE = "bleeding";
        public static final String WEIGHT = "weight";
    }

    public static class HbTestFormFields {
        public static final String HB_TEST_DATE_FIELD = "hbTestDate";
        public static final String HB_LEVEL_FIELD = "hbLevel";
        public static final String ANAEMIC_STATUS_FIELD = "anaemicStatus";
        public static final String PREVIOUS_ANAEMIC_STATUS_FIELD = "previousAnaemicStatus";
    }

    public static class ANCInvestigationsFormFields {
        public static final String TEST_DATE = "testDate";
        public static final String TESTS_RESULTS_TO_ENTER = "testResultsToEnter";
        public static final String WOMAN_BLOOD_GROUP = "womanBloodGroup";
        public static final String RH_INCOMPATIBLE_COUPLE = "rhIncompatibleCouple";
        public static final String TESTS_POSITIVE_RESULTS = "testsResultPositive";
        public static final String BILE_SALTS = "bileSalts";
        public static final String BILE_PIGMENTS = "bilePigments";
        public static final String URINE_SUGAR_VALUE = "urine_sugar";
        public static final String MALARIA_VALUE = "mp";
    }

    public static class PNCVisitFormFields {
        public static final String VISIT_DATE_FIELD_NAME = "pncVisitDate";
        public static final String VISIT_DAY_FIELD_NAME = "pncVisitDay";
        public static final String VISIT_DATES_FIELD_NAME = "pncVisitDates";
        public static final String VISIT_PLACE_FIELD_NAME = "pncVisitPlace";
        public static final String VISIT_PERSON_FIELD_NAME = "pncVisitPerson";
        public static final String URINE_STOOL_PROBLEMS = "urineStoolProblems";
        public static final String ACTIVITY_PROBLEMS = "activityProblems";
        public static final String BREATHING_PROBLEMS = "breathingProblems";
        public static final String SKIN_PROBLEMS = "skinProblems";
        public static final String DIFFICULTIES_FIELD_NAME = "difficulties1";
        public static final String ABDOMINAL_PROBLEMS_FIELD_NAME = "abdominalProblems";
        public static final String VAGINAL_PROBLEMS_FIELD_NAME = "vaginalProblems";
        public static final String URINAL_PROBLEMS_FIELD_NAME = "difficulties2";
        public static final String BREAST_PROBLEMS = "breastProblems";
        public static final String DISCHARGE_DATE = "dischargeDate";
        public static final String HEAVY_BLEEDING_VALUE = "heavy_bleeding";
        public static final String BAD_SMELL_LOCHEA_VALUE = "bad_smell_lochea";
        public static final String HAS_FEVER_FIELD = "hasFever";
        public static final String IMMEDIATE_REFERRAL = "immediateReferral";
    }

    public static class CommonFormFields {
        public static final String SUBMISSION_DATE_FIELD_NAME = "submissionDate";
        public static final String ID = "id";
        public static final String relationalid = "relationalid";
        public static final String SERVICE_PROVIDED_PLACE = "serviceProvidedPlace";
        public static final String SERVICE_PROVIDED_DATE = "serviceProvidedDate";
        public static final String SUB_CENTER_SERVICE_PROVIDED_PLACE_VALUE = "sub_center";
        public static final String SUBCENTER_SERVICE_PROVIDED_PLACE_VALUE = "subcenter";
        public static final String HOME_FIELD_VALUE = "home";
        public static final String REFERENCE_DATE = "referenceDate";
        public static final String IS_HIGH_RISK = "isHighRisk";
    }

    public static class CommonChildFormFields {
        public static final String DIARRHEA_VALUE = "diarrhea";
        public static final String FEMALE_VALUE = "female";
        public static final String MALE_VALUE = "male";
        public static final String GENDER = "gender";
    }

    public static class ChildRegistrationFormFields {
        public static final String BF_POSTBIRTH = "didBreastfeedingStart";
        public static final String DATE_OF_BIRTH = "dateOfBirth";
        public static final String CHILD_VITAMIN_A_HISTORY = "childVitaminAHistory";
        public static final String DATE = "Date";
        public static final String VITAMIN = "vitamin";
        public static final String SHOULD_CLOSE_MOTHER = "shouldCloseMother";
        public static final String THAYI_CARD = "thayiCard";
    }

    public static class ChildCloseFormFields {
        public static final String CLOSE_REASON_FIELD_NAME = "closeReason";
        public static final String IS_IMMUNIZATION_DEATH = "isImmunizationDeath";
        public static final String DEATH_OF_CHILD_VALUE = "death_of_child";
        public static final String DATE_OF_DEATH_FIELD_NAME = "deathDate";
        public static final String DEATH_CAUSE = "deathCause";
        public static final String PERMANENT_RELOCATION_VALUE = "permanent_relocation";
        public static final String WITHIN_24HRS_VALUE = "within_24hrs";
        public static final String SEPSIS_VALUE = "sepsis";
        public static final String ASPHYXIA_VALUE = "asphyxia";
        public static final String DIARRHEA_VALUE = "diarrhea";
        public static final String LBW_VALUE = "lbw";
        public static final String FEVER_RELATED_VALUE = "fever_related";
        public static final String PNEUMONIA_VALUE = "pneumonia";
        public static final List<String> OTHERS_LIST = new ArrayList<String>() {{
            add("cause_not_identified");
            add("others");
        }};
        public static final List<String> OTHERS_VALUE_LIST = new ArrayList<String>() {{
            add("malnutrition");
            add("ari");
            add("malaria");
        }};
    }

    public static class EntityCloseFormFields {
        public static final String CLOSE_REASON_FIELD_NAME = "closeReason";
        public static final String ANC_DEATH_DATE_FIELD_NAME = "maternalDeathDate";
        public static final String IS_MATERNAL_LEAVE_FIELD_NAME = "isMaternalDeath";
        public static final String WRONG_ENTRY_VALUE = "wrong_entry";
    }

    public static class ANCCloseFields {
        public static final String CLOSE_MTP_DATE_FIELD_NAME = "dateOfInducedAbortion";
        public static final String CLOSE_SPONTANEOUS_ABORTION_DATE_FIELD_NAME = "dateOfSpontaneousAbortion";
        public static final String CLOSE_MTP_TIME_FIELD_NAME = "timeOfInducedAbortion";
        public static final String MTP_GREATER_THAN_12_WEEKS_FIELD_NAME = "greater_12wks";
        public static final String MTP_LESS_THAN_12_WEEKS_FIELD_NAME = "less_12wks";
        public static final String DEATH_OF_WOMAN_VALUE = "death_of_woman";
        public static final String PERMANENT_RELOCATION_VALUE = "relocation_permanent";
        public static final String SPONTANEOUS_ABORTION_VALUE = "spontaneous_abortion";
    }

    public static class PNCCloseFields {
        public static final String DEATH_DATE_FIELD_NAME = "deathDate";
        public static final String DEATH_OF_MOTHER_VALUE = "death_of_mother";
        public static final String PERMANENT_RELOCATION_VALUE = "permanent_relocation";
    }

    public static class ECCloseFields {
        public static final String IS_EC_CLOSE_CONFIRMED_FIELD_NAME = "isECCloseConfirmed";
        public static final String IS_STERILIZATION_DEATH_FIELD_NAME = "isSterilizationDeath";
        public static final String MATERNAL_DEATH_CAUSE_FIELD_NAME = "maternalDeathCause";
        public static final String ABORTION_VALUE = "abortion";
        public static final String PROLONGED_OBSTRUCTED_LABOR_VALUE = "prolonged_obstructed_labor";
        public static final String HYPERTENSION_FITS_VALUE = "hypertension_fits";
        public static final String BLEEDING_VALUE = "bleeding_hemorrhage";
        public static final String HIGH_FEVER_VALUE = "fever_infection";
    }

    public static class FamilyPlanningFormFields {
        public static final String LMP_DATE = "lmpDate";
        public static final String UPT_RESULT = "uptResult";
        public static final String CURRENT_FP_METHOD_FIELD_NAME = "currentMethod";
        public static final String FP_METHOD_CHANGE_DATE_FIELD_NAME = "familyPlanningMethodChangeDate";
        public static final String DMPA_INJECTION_DATE_FIELD_NAME = "dmpaInjectionDate";
        public static final String DMPA_INJECTABLE_FP_METHOD_VALUE = "dmpa_injectable";
        public static final String OCP_REFILL_DATE_FIELD_NAME = "ocpRefillDate";
        public static final String NUMBER_OF_OCP_STRIPS_SUPPLIED_FIELD_NAME = "numberOfOCPDelivered";
        public static final String NUMBER_OF_CONDOMS_SUPPLIED_FIELD_NAME = "numberOfCondomsSupplied";
        public static final String NUMBER_OF_CENTCHROMAN_PILLS_SUPPLIED_FIELD_NAME = "numberOfCentchromanPillsDelivered";
        public static final String NUMBER_OF_ECPS_GIVEN_FIELD_NAME = "numberOfECPsGiven";
        public static final String FP_FOLLOWUP_DATE_FIELD_NAME = "fpFollowupDate";
        public static final String STERILIZATION_SIDE_EFFECT_FIELD_NAME = "sterilizationSideEffect";
        public static final String IS_STERILIZATION_FAILURE_FIELD_NAME = "isSterilizationFailure";
        public static final String OCP_FP_METHOD_VALUE = "ocp";
        public static final String CONDOM_FP_METHOD_VALUE = "condom";
        public static final String FEMALE_STERILIZATION_FP_METHOD_VALUE = "female_sterilization";
        public static final String MALE_STERILIZATION_FP_METHOD_VALUE = "male_sterilization";
        public static final String CENTCHROMAN_FP_METHOD_VALUE = "centchroman";
        public static final String COMPLICATION_DATE_FIELD_NAME = "complicationDate";
        public static final String NEEDS_FOLLOWUP_FIELD_NAME = "needsFollowup";
        public static final String NEEDS_REFERRAL_FOLLOWUP_FIELD_NAME = "needsReferralFollowup";
        public static final String IUD_FP_METHOD_VALUE = "iud";
        public static final String REFERRAL_FOLLOW_UP_DATE_FIELD_NAME = "referralFollowupDate";
        public static final String PREVIOUS_FP_METHOD_FIELD_NAME = "currentMethod";
        public static final String NEW_FP_METHOD_FIELD_NAME = "newMethod";
        public static final String IUD_REMOVAL_PLACE = "iudRemovalPlace";
        public static final String IUD_PLACE = "iudPlace";
        public static final String FEMALE_STERILIZATION_TYPE = "femaleSterilizationType";
        public static final String MALE_STERILIZATION_TYPE = "maleSterilizationType";
        public static final String FP_RENEW_METHOD_VISIT_DATE = "fpRenewMethodVisitDate";
    }

    public static class ChildImmunizationFields {
        public static final String IMMUNIZATIONS_GIVEN_FIELD_NAME = "immunizationsGiven";
        public static final String PREVIOUS_IMMUNIZATIONS_FIELD_NAME = "previousImmunizations";
        public static final String IMMUNIZATION_DATE_FIELD_NAME = "immunizationDate";

        public static final String BCG_VALUE = "bcg";

        public static final String DPT_BOOSTER_1_VALUE = "dptbooster_1";
        public static final String DPT_BOOSTER_2_VALUE = "dptbooster_2";

        public static final String HEPATITIS_0_VALUE = "hepb_0";

        public static final String MEASLES_VALUE = "measles";
        public static final String MEASLES_BOOSTER_VALUE = "measlesbooster";

        public static final String OPV_0_VALUE = "opv_0";
        public static final String OPV_1_VALUE = "opv_1";
        public static final String OPV_2_VALUE = "opv_2";
        public static final String OPV_3_VALUE = "opv_3";
        public static final String OPV_BOOSTER_VALUE = "opvbooster";

        public static final String PENTAVALENT_1_VALUE = "pentavalent_1";
        public static final String PENTAVALENT_2_VALUE = "pentavalent_2";
        public static final String PENTAVALENT_3_VALUE = "pentavalent_3";
        public static final List<String> IMMUNIZATIONS_VALUE_LIST = new ArrayList<String>() {{
            add(BCG_VALUE);
            add(PENTAVALENT_1_VALUE);
            add(PENTAVALENT_2_VALUE);
            add(PENTAVALENT_3_VALUE);
            add(OPV_0_VALUE);
            add(OPV_1_VALUE);
            add(OPV_2_VALUE);
            add(OPV_3_VALUE);
            add(MEASLES_VALUE);

        }};

        public static final List<String> IMMUNIZATIONS_WITH_MMR_VALUE_LIST = new ArrayList<String>() {{
            add(BCG_VALUE);
            add(PENTAVALENT_1_VALUE);
            add(PENTAVALENT_2_VALUE);
            add(PENTAVALENT_3_VALUE);
            add(OPV_0_VALUE);
            add(OPV_1_VALUE);
            add(OPV_2_VALUE);
            add(OPV_3_VALUE);
            add(MMR_VALUE);
        }};

        public static final String MMR_VALUE = "mmr";
        public static final String JE_VALUE = "je";
    }

    public static class VitaminAFields {
        public static final String VITAMIN_A_DOSE = "vitaminADose";
        public static final String VITAMIN_A_DATE = "vitaminADate";
        public static final String VITAMIN_A_DOSE_1_VALUE = "1";
        public static final String VITAMIN_A_DOSE_2_VALUE = "2";
        public static final String VITAMIN_A_DOSE_3_VALUE = "3";
        public static final String VITAMIN_A_DOSE_4_VALUE = "4";
        public static final String VITAMIN_A_DOSE_5_VALUE = "5";
        public static final String VITAMIN_A_DOSE_6_VALUE = "6";
        public static final String VITAMIN_A_DOSE_7_VALUE = "7";
        public static final String VITAMIN_A_DOSE_8_VALUE = "8";
        public static final String VITAMIN_A_DOSE_9_VALUE = "9";
        public static final List<String> VITAMIN_A_DOSES_1_2_5_9 =
                asList(
                        VITAMIN_A_DOSE_1_VALUE,
                        VITAMIN_A_DOSE_2_VALUE,
                        VITAMIN_A_DOSE_5_VALUE,
                        VITAMIN_A_DOSE_9_VALUE);
        public static final String VITAMIN_A_DOSE_PREFIX = "dose";
    }

    public static class IFAFields {
        public static final String NUMBER_OF_IFA_TABLETS_GIVEN = "numberOfIFATabletsGiven";
        public static final String IFA_TABLETS_DATE = "ifaTabletsDate";
        public static final String TOTAL_NUMBER_OF_IFA_TABLETS_GIVEN = "totalNumberOfIFATabletsGiven";
    }

    public static class ChildIllnessFields {
        public static final String CHILD_SIGNS = "childSigns";
        public static final String SICK_VISIT_DATE = "sickVisitDate";
        public static final String REPORT_CHILD_DISEASE = "reportChildDisease";
        public static final String REPORT_CHILD_DISEASE_DATE = "reportChildDiseaseDate";
        public static final String DIARRHEA_DEHYDRATION_VALUE = "diarrhea_dehydration";
        public static final String MALARIA_VALUE = "malaria";
    }

    public static class FormEntityTypes {
        public static final String CHILD_TYPE = "child";
        public static final String MCARE_CHILD_TYPE = "mcarechild";
        public static final String MOTHER_TYPE = "mother";
        public static final String ELIGIBLE_COUPLE_TYPE = "eligible_couple";
        public static final String MCTS_REPORT_TYPE = "MCTSReport";
        
        public static final String HOUSE_HOLD_TYPE = "household";
        public static final String MEMBER_TYPE = "members";
        public static final String MCARE_MOTHER_TYPE = "mcaremother";
    }

    public static class HTTP {
        public static final String ACCESS_CONTROL_ALLOW_ORIGIN_HEADER = "Access-Control-Allow-Origin";
        public static final String WWW_AUTHENTICATE_HEADER = "www-authenticate";
    }
    
    public static class MembersSchedulesConstantsImediate {
    	public static final String IMD_Members_SCHEDULE = "IMEDIATE Members";
    	public static final String Members_SCHEDULE = "Members";
    }
    
    public static class ScheduleNames{
    	public static final String CENCUS = "FW CENSUS";
    	public static final String SCHEDULE_Woman_BNF = "Woman_BNF";
    	public static final String IMD_SCHEDULE_Woman_BNF = "IMD_Woman_BNF";
        public static final String SCHEDULE_Woman_Measles = "Woman_measles";
        public static final String SCHEDULE_Woman_1 = "Woman_TT1";
        public static final String SCHEDULE_Woman_2 = "Woman_TT2";
        public static final String SCHEDULE_Woman_3 = "Woman_TT3";
        public static final String SCHEDULE_Woman_4 = "Woman_TT4";
        public static final String SCHEDULE_Woman_5 = "Woman_TT5";
        public static final String child_vaccination_bcg = "child_bcg";
    	public static final String IMD_child_bcg = "IMD_child_bcg";
        public static final String child_vaccination_ipv = "child_ipv";
        public static final String child_vaccination_measles1 = "child_measles1";
        public static final String child_vaccination_measles2 = "child_measles2";
        public static final String child_vaccination_opv0 = "child_opv0";  
    	public static final String IMD_child_opv0 = "IMD_child_opv0";
        public static final String child_vaccination_opv1 = "child_opv1";
        public static final String child_vaccination_opv2 = "child_opv2";
        public static final String child_vaccination_opv3 = "child_opv3";
        public static final String child_vaccination_pcv1 = "child_pcv1";
        public static final String child_vaccination_pcv2 = "child_pcv2";        
        public static final String child_vaccination_pcv3 = "child_pcv3";        
        public static final String child_vaccination_penta1 = "child_penta1";
        public static final String child_vaccination_penta2 = "child_penta2";
        public static final String child_vaccination_penta3 = "child_penta3";    
        public static final String CHILD = "CHILD";
        public static final String ANC = "ANC";
        public static final String PNC = "PNC";
    }
    public static class OpenmrsTrackUuid {
    	public static final String ENROLLMENT_TRACK_UUID = "openmrsTrackUuid";
    }
    public static class BaseEntity{
    	public static final String BASE_ENTITY_ID = "baseEntityId";
    	public static final String ADDRESS_TYPE = "addressType";
    	public static final String START_DATE = "startDate";
    	public static final String END_DATE = "endDate";
    	public static final String LATITUDE = "latitude";
    	public static final String LONGITUTE = "longitute";
    	public static final String GEOPOINT = "geopoint";
    	public static final String POSTAL_CODE = "postalCode";
    	public static final String SUB_TOWN = "subTown";
    	public static final String TOWN = "town";
    	public static final String SUB_DISTRICT = "subDistrict";
    	public static final String COUNTY_DISTRICT = "countyDistrict";
    	public static final String CITY_VILLAGE = "cityVillage";
    	public static final String STATE_PROVINCE = "stateProvince";
    	public static final String COUNTRY = "country";
    	public static final String LAST_UPDATE = "lastEdited";
    	
    }
    public static class Client extends BaseEntity{
    	public static final String FIRST_NAME = "firstName";
    	public static final String MIDDLE_NAME = "middleName";
    	public static final String LAST_NAME = "lastName";
    	public static final String BIRTH_DATE = "birthdate";
    	public static final String DEATH_DATE = "deathdate";
    	public static final String BIRTH_DATE_APPROX = "birthdateApprox";
    	public static final String DEATH_DATE_APPROX = "deathdateApprox";
    	public static final String GENDER = "gender";
    }
    public static class Event {
    	public static final String FORM_SUBMISSION_ID = "formSubmissionId";
    	public static final String EVENT_TYPE = "eventType";
    	public static final String EVENT_ID = "eventId";
    	public static final String LOCATION_ID = "locationId";
    	public static final String EVENT_DATE = "eventDate";
    	public static final String PROVIDER_ID = "providerId";
    	public static final String ENTITY_TYPE = "entityType";

    }
    public static class OpenSRPEvent{
		public static final String FORM_SUBMISSION = "FORM_SUBMISSION";
	}

	public enum Config {
		FORM_ENTITY_PARSER_LAST_SYNCED_FORM_SUBMISSION
	}
	public static final String FORM_SCHEDULE_SUBJECT = "FORM-SCHEDULE";
	
	}


