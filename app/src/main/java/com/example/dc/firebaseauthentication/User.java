package com.example.dc.firebaseauthentication;

import java.io.Serializable;

public class User  {

   public String UserId;
   public String Email;
   public String Age;

    public User(String userId, String email, String age) {
        UserId = userId;
        Email = email;
        Age = age;
    }
}