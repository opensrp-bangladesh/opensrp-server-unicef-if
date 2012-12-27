package org.ei.drishti.service;

import org.ei.drishti.contract.*;
import org.ei.drishti.domain.EligibleCouple;
import org.ei.drishti.repository.AllEligibleCouples;
import org.ei.drishti.service.reporting.ECReportingService;
import org.ei.drishti.service.scheduling.ECSchedulingService;
import org.ei.drishti.util.IdGenerator;
import org.ei.drishti.util.SafeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import static org.apache.commons.lang.StringUtils.isBlank;
import static org.ei.drishti.common.AllConstants.DETAILS_EXTRA_DATA_KEY_NAME;
import static org.ei.drishti.common.AllConstants.FamilyPlanningCommCareFields.NO_FP_METHOD_COMMCARE_FIELD_VALUE;
import static org.ei.drishti.common.AllConstants.Report.REPORT_EXTRA_DATA_KEY_NAME;
import static org.ei.drishti.scheduler.DrishtiScheduleConstants.ECSchedulesConstants.EC_SCHEDULE_FP_COMPLICATION_MILESTONE;

@Service
public class ECService {
    private AllEligibleCouples allEligibleCouples;
    private ActionService actionService;
    private ECReportingService reportingService;
    private ECSchedulingService schedulingService;
    private IdGenerator idGenerator;
    private static Logger logger = LoggerFactory.getLogger(ActionService.class.toString());

    @Autowired
    public ECService(AllEligibleCouples allEligibleCouples, ActionService actionService, ECReportingService reportingService, IdGenerator idGenerator, ECSchedulingService schedulingService) {
        this.allEligibleCouples = allEligibleCouples;
        this.actionService = actionService;
        this.reportingService = reportingService;
        this.idGenerator = idGenerator;
        this.schedulingService = schedulingService;
    }

    public void registerEligibleCouple(EligibleCoupleRegistrationRequest request, Map<String, Map<String, String>> extraData) {
        EligibleCouple couple = new EligibleCouple(request.caseId(), request.ecNumber())
                .withCouple(request.wife(), request.husband()).withANMIdentifier(request.anmIdentifier())
                .withLocation(request.village(), request.subCenter(), request.phc()).withDetails(extraData.get(DETAILS_EXTRA_DATA_KEY_NAME));

        allEligibleCouples.register(couple);

        reportingService.registerEC(new SafeMap(extraData.get(REPORT_EXTRA_DATA_KEY_NAME)));
        actionService.registerEligibleCouple(request.caseId(), request.ecNumber(), request.wife(), request.husband(),
                request.anmIdentifier(), request.village(), request.subCenter(), request.phc(), extraData.get(DETAILS_EXTRA_DATA_KEY_NAME));
        schedulingService.enrollToFPComplications(request, extraData.get(DETAILS_EXTRA_DATA_KEY_NAME));
    }

    public EligibleCouple registerEligibleCoupleForOutOfAreaANC(OutOfAreaANCRegistrationRequest request, Map<String, Map<String, String>> extraData) {
        EligibleCouple couple = new EligibleCouple(idGenerator.generateUUID().toString(), "0")
                .withCouple(request.wife(), request.husband()).withANMIdentifier(request.anmIdentifier())
                .withLocation(request.village(), request.subCenter(), request.phc()).withDetails(extraData.get(DETAILS_EXTRA_DATA_KEY_NAME))
                .asOutOfArea();

        allEligibleCouples.register(couple);
        return couple;
    }

    public void closeEligibleCouple(EligibleCoupleCloseRequest request) {
        allEligibleCouples.close(request.caseId());
        actionService.closeEligibleCouple(request.caseId(), request.anmIdentifier());
    }

    public void updateFamilyPlanningMethod(FamilyPlanningUpdateRequest request, Map<String, Map<String, String>> extraData) {
        EligibleCouple couple = allEligibleCouples.findByCaseId(request.caseId());
        if (couple == null) {
            logger.warn("Tried to update details of a non-existing EC: " + request + ". Extra details: " + extraData);
            return;
        }

        EligibleCouple updatedCouple = allEligibleCouples.updateDetails(request.caseId(), extraData.get("details"));
        reportingService.updateFamilyPlanningMethod(new SafeMap(extraData.get(REPORT_EXTRA_DATA_KEY_NAME)));
        actionService.updateEligibleCoupleDetails(request.caseId(), request.anmIdentifier(), updatedCouple.details());

        schedulingService.updateFPComplications(request, updatedCouple);

        closeAlertsForFPComplicationSchedule(request);
    }

    private void closeAlertsForFPComplicationSchedule(FamilyPlanningUpdateRequest request) {
        if (!(isBlank(request.currentMethod()) || NO_FP_METHOD_COMMCARE_FIELD_VALUE.equalsIgnoreCase(request.currentMethod()))) {
            actionService.markAlertAsClosed(request.caseId(), request.anmIdentifier(), EC_SCHEDULE_FP_COMPLICATION_MILESTONE, request.familyPlanningMethodChangeDate());
        }
    }

    public void reportFPComplications(FPComplicationsRequest request, Map<String, Map<String, String>> extraData) {
        EligibleCouple couple = allEligibleCouples.findByCaseId(request.caseId());
        if (couple == null) {
            logger.warn("Tried to report FP Complications of a non-existing EC: " + request + ". Extra details: " + extraData);
            return;
        }

        reportingService.fpComplications(new SafeMap(extraData.get(REPORT_EXTRA_DATA_KEY_NAME)));
    }
}
