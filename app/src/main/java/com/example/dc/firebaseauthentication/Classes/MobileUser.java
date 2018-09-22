package com.example.dc.firebaseauthentication.Classes;

import java.util.Date;

public class MobileUser {

    public String UID;
    public String Email;
    public String Provider;
    public Date CreatedOn;
    public Date LastSignedIn;


    public MobileUser(String UID, String email, String provider, Date createdOn, Date lastSignedIn) {
        this.UID = UID;
        Email = email;
        Provider = provider;
        CreatedOn = createdOn;
        LastSignedIn = lastSignedIn;
    }



}
