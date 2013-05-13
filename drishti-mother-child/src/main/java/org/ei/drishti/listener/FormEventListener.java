package org.ei.drishti.listener;

import ch.lambdaj.function.convert.Converter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.ei.drishti.domain.FormExportToken;
import org.ei.drishti.dto.form.FormSubmissionDTO;
import org.ei.drishti.event.FormSubmissionEvent;
import org.ei.drishti.form.domain.FormSubmission;
import org.ei.drishti.form.service.FormSubmissionConvertor;
import org.ei.drishti.form.service.FormSubmissionService;
import org.ei.drishti.repository.AllFormExportTokens;
import org.ei.drishti.scheduler.DrishtiFormScheduler;
import org.ei.drishti.service.FormEntityService;
import org.motechproject.scheduler.domain.MotechEvent;
import org.motechproject.server.event.annotations.MotechListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static ch.lambdaj.collection.LambdaCollections.with;
import static java.text.MessageFormat.format;

@Component
public class FormEventListener {
    private static Logger logger = LoggerFactory.getLogger(FormEventListener.class.toString());
    private FormSubmissionService formSubmissionService;
    private FormEntityService formEntityService;
    private AllFormExportTokens allFormExportTokens;

    @Autowired
    public FormEventListener(FormSubmissionService formSubmissionService, FormEntityService formEntityService, AllFormExportTokens allFormExportTokens) {
        this.formSubmissionService = formSubmissionService;
        this.formEntityService = formEntityService;
        this.allFormExportTokens = allFormExportTokens;
    }

    @MotechListener(subjects = FormSubmissionEvent.SUBJECT)
    public void submitForms(MotechEvent event) {
        List<FormSubmissionDTO> formSubmissions = new Gson().fromJson((String) event.getParameters().get("data"), new TypeToken<List<FormSubmissionDTO>>() {
        }.getType());
        formSubmissionService.submit(formSubmissions);
    }

    @MotechListener(subjects = DrishtiFormScheduler.SUBJECT)
    public void fetchForms(MotechEvent event) {
        logger.info("Fetching Forms");
        long version = getVersion();

        List<FormSubmissionDTO> formSubmissionDTOs = formSubmissionService.fetch(version);
        if (formSubmissionDTOs.isEmpty()) {
            logger.info("No new forms found. Export token: " + version);
            return;
        }

        logger.info(format("Fetched {0} new forms found. Export token: {1}", formSubmissionDTOs.size(), version));
        List<FormSubmission> formSubmissions = with(formSubmissionDTOs)
                .convert(new Converter<FormSubmissionDTO, FormSubmission>() {
                    @Override
                    public FormSubmission convert(FormSubmissionDTO submission) {
                        return FormSubmissionConvertor.toFormSubmissionWithVersion(submission);
                    }
                });
        formEntityService.process(formSubmissions);
    }

    private long getVersion() {
        List<FormExportToken> exportTokens = allFormExportTokens.getAll();
        if (exportTokens.isEmpty()) {
            allFormExportTokens.add(new FormExportToken(0L));
            return 0L;
        }
        return exportTokens.get(0).getVersion();
    }
}