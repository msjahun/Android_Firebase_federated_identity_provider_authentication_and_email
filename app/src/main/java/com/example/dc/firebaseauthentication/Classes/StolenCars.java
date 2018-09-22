package com.example.dc.firebaseauthentication.Classes;

import java.util.Date;

public class StolenCars {

    public String Id;
    public QrCode QrCode;
    public Date CreatedOn;


    public StolenCars(String id, com.example.dc.firebaseauthentication.Classes.QrCode qrCode, Date createdOn) {
        Id = id;
        QrCode = qrCode;
        CreatedOn = createdOn;
    }
}
