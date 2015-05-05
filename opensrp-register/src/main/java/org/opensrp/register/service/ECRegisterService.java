package org.opensrp.register.service;

import org.opensrp.register.domain.EligibleCouple;
import org.opensrp.register.domain.Mother;
import org.opensrp.register.ECRegister;
import org.opensrp.register.ECRegisterEntry;
import org.opensrp.register.repository.AllEligibleCouples;
import org.opensrp.register.repository.AllMothers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.opensrp.common.AllConstants.ANCFormFields.REGISTRATION_DATE;
import static org.opensrp.common.AllConstants.ECRegistrationFields.*;
import static org.opensrp.common.AllConstants.FamilyPlanningFormFields.CURRENT_FP_METHOD_FIELD_NAME;
import static org.opensrp.common.AllConstants.FamilyPlanningFormFields.FP_METHOD_CHANGE_DATE_FIELD_NAME;
import static org.opensrp.common.util.IntegerUtil.parseValidIntegersAndDefaultInvalidOnesToEmptyString;

@Service
public class ECRegisterService {
    private final AllMothers allMothers;
    private final AllEligibleCouples allEligibleCouples;

    @Autowired
    public ECRegisterService(AllMothers allMothers,
                             AllEligibleCouples allEligibleCouples) {
        this.allMothers = allMothers;
        this.allEligibleCouples = allEligibleCouples;
    }

    public ECRegister getRegisterForANM(String anmIdentifier) {
        ArrayList<ECRegisterEntry> ecRegisterEntries = new ArrayList<>();
        List<EligibleCouple> ecs = allEligibleCouples.allOpenECsForANM(anmIdentifier);
        for (EligibleCouple ec : ecs) {
            List<Mother> mothers = allMothers.findAllOpenANCByECCaseId(ec.caseId());
            boolean isPregnant = mothers.size() > 0;
            ECRegisterEntry ecRegisterEntry = new ECRegisterEntry()
                    .withECNumber(ec.ecNumber())
                    .withWifeName(ec.wifeName())
                    .withHusbandName(ec.husbandName())
                    .withRegistrationDate(ec.getDetail(REGISTRATION_DATE))
                    .withWifeAge(ec.getDetail(WIFE_AGE))
                    .withHusbandAge(ec.getDetail(HUSBAND_AGE))
                    .withHouseholdNumber(ec.getDetail(HOUSEHOLD_NUMBER))
                    .withHouseholdAddress(ec.getDetail(HOUSEHOLD_ADDRESS))
                    .withHeadOfHousehold(ec.getDetail(HEAD_OF_HOUSEHOLD))
                    .withReligion(ec.getDetail(RELIGION))
                    .withCaste(ec.getDetail(CASTE))
                    .withEconomicStatus(ec.getDetail(ECONOMIC_STATUS))
                    .withWifeEducationLevel(ec.getDetail(WIFE_EDUCATIONAL_LEVEL))
                    .withHusbandEducationLevel(ec.getDetail(HUSBAND_EDUCATION_LEVEL))
                    .withNumberOfLivingChildren(parseValidIntegersAndDefaultInvalidOnesToEmptyString(ec.getDetail(NUMBER_OF_LIVING_CHILDREN)))
                    .withNumberOfStillBirths(parseValidIntegersAndDefaultInvalidOnesToEmptyString(ec.getDetail(NUMBER_OF_STILL_BIRTHS)))
                    .withNumberOfAbortions(parseValidIntegersAndDefaultInvalidOnesToEmptyString(ec.getDetail(NUMBER_OF_ABORTIONS)))
                    .withParity(parseValidIntegersAndDefaultInvalidOnesToEmptyString((ec.getDetail(PARITY))))
                    .withGravida(parseValidIntegersAndDefaultInvalidOnesToEmptyString((ec.getDetail(NUMBER_OF_PREGNANCIES))))
                    .withNumberOfLivingMaleChildren(parseValidIntegersAndDefaultInvalidOnesToEmptyString(ec.getDetail(NUMBER_OF_LIVING_MALE_CHILDREN)))
                    .withNumberOfLivingFemaleChildren(parseValidIntegersAndDefaultInvalidOnesToEmptyString(ec.getDetail(NUMBER_OF_LIVING_FEMALE_CHILDREN)))
                    .withYoungestChildAge(parseValidIntegersAndDefaultInvalidOnesToEmptyString(ec.getDetail(YOUNGEST_CHILD_AGE)))
                    .withCurrentFPMethod(ec.getDetail(CURRENT_FP_METHOD_FIELD_NAME))
                    .withCurrentFPMethodStartDate(ec.getDetail(FP_METHOD_CHANGE_DATE_FIELD_NAME))
                    .withPregnancyStatus(isPregnant);
            ecRegisterEntries.add(ecRegisterEntry);
        }
        return new ECRegister(ecRegisterEntries);
    }
}
