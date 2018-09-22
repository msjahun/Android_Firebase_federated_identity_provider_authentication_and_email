package com.example.dc.firebaseauthentication.Classes;

import java.util.Date;

public class QrCodeUserClaim {

    public String Id;
    public MobileUser MobileUser;
    public QrCode QrCode;
    public Date TimeStamp;

    public QrCodeUserClaim(String id, com.example.dc.firebaseauthentication.Classes.MobileUser mobileUser, com.example.dc.firebaseauthentication.Classes.QrCode qrCode, Date timeStamp) {
        Id = id;
        MobileUser = mobileUser;
        QrCode = qrCode;
        TimeStamp = timeStamp;
    }
}
