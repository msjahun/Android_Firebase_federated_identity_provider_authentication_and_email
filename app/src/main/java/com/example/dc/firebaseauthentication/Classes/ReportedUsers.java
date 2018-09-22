package com.example.dc.firebaseauthentication.Classes;

import java.util.Date;

public class ReportedUsers {

    public String Id;
    public QrCode QrReported;
    public MobileUser ReportedBy;
    public String ReasonForReport;
    public Date CreatedOn;

    public ReportedUsers(String id, QrCode qrReported, MobileUser reportedBy, String reasonForReport, Date createdOn) {
        Id = id;
        QrReported = qrReported;
        ReportedBy = reportedBy;
        ReasonForReport = reasonForReport;
        CreatedOn = createdOn;
    }
}
