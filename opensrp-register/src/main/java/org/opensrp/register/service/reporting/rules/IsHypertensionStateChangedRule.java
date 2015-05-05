package org.opensrp.register.service.reporting.rules;

import org.opensrp.common.util.IntegerUtil;
import org.opensrp.service.reporting.rules.IRule;
import org.opensrp.util.SafeMap;
import org.springframework.stereotype.Component;

import static org.opensrp.common.AllConstants.ANCVisitFormFields.*;

@Component
public class IsHypertensionStateChangedRule implements IRule {

    private static final int BP_DIASTOLIC_THRESHOLD_VALUE = 90;
    private static final int BP_SYSTOLIC_THRESHOLD_VALUE = 140;

    @Override
    public boolean apply(SafeMap reportFields) {

        boolean currentHyperTensionStatus = isHyperTensed(reportFields.get(BP_DIASTOLIC), reportFields.get(BP_SYSTOLIC));
        boolean previousHyperTensionStatus =isHyperTensed(reportFields.get(PREVIOUS_BP_DIASTOLIC),reportFields.get(PREVIOUS_BP_SYSTOLIC));

        return currentHyperTensionStatus != previousHyperTensionStatus;
    }

    private boolean isHyperTensed(String diastolicField, String systolicField) {
        return (IntegerUtil.tryParse(diastolicField, 0) >= BP_DIASTOLIC_THRESHOLD_VALUE)
                || (IntegerUtil.tryParse(systolicField, 0) >= BP_SYSTOLIC_THRESHOLD_VALUE);
    }
}
