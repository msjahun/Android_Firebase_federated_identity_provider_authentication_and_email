package com.example.dc.firebaseauthentication.Classes;

import java.util.Date;

public class Devices {

    public String Id;
    public MobileUser MobileUser;
    public Date CreatedOn;

    public Devices(String id, com.example.dc.firebaseauthentication.Classes.MobileUser mobileUser, Date createdOn) {
        Id = id;
        MobileUser = mobileUser;
        CreatedOn = createdOn;
    }
}
