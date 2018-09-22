package com.example.dc.firebaseauthentication.Classes;

import java.util.Date;

public class QrCode {

    public String Id;
    public String Initiator;
    public MobileUser CurrentMobileUser;
    public Boolean IsActive;
    public Date CreatedOn;

    public QrCode(String id, String initiator, MobileUser currentMobileUser, Boolean isActive, Date createdOn) {
        Id = id;
        Initiator = initiator;
        CurrentMobileUser = currentMobileUser;
        IsActive = isActive;
        CreatedOn = createdOn;
    }

    public QrCode() {
    }
}
