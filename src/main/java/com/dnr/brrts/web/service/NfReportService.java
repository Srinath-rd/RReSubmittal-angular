package com.dnr.brrts.web.service;

import com.dnr.brrts.web.model.*;
import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NfReportService {

    NfReport saveNfReport(NfReport report, boolean formComplete);


    List<NfReport> findReportsByUserName(String email);

    NfReport buildNewReport(NfUser user, FormName formName);

    List<NfReport> findReportsByUserNameAndStatus(String email, FormStatus pending);

    NfReport findReportByReportId(Long reportId);

    void deleteReportById(String reportId);

    @Transactional
    NfReport updateNfFormDetails(NfReport reportInp, boolean formComplete);


    NfReport deleteAttachmentByAttachmentId(Long reportId, Long attachmentId) throws Exception;

    Resource loadAsResource(NfAttachment attachment);
}
