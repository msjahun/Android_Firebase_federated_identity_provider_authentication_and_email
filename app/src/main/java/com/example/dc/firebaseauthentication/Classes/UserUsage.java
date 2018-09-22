package com.example.dc.firebaseauthentication.Classes;

import java.util.Date;

public class UserUsage
{
    public String Id;
    public MobileUser ScannedBy;
    public QrCode ScannedQrCode;
    public Date CreatedOn;


    public UserUsage(String id, MobileUser scannedBy, QrCode scannedQrCode, Date createdOn) {
        Id = id;
        ScannedBy = scannedBy;
        ScannedQrCode = scannedQrCode;
        CreatedOn = createdOn;
    }
}
