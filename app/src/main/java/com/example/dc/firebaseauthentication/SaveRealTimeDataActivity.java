package com.example.dc.firebaseauthentication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dc.firebaseauthentication.Classes.MobileUser;
import com.example.dc.firebaseauthentication.Classes.QrCode;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class SaveRealTimeDataActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private Button btnSaveToFirebase;

private EditText editTextKey;
private EditText editTextValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_real_time_data);
      // database = FirebaseDatabase.getInstance("https://parking-alert-main.firebaseio.com/");

        btnSaveToFirebase = (Button) findViewById(R.id.btnAddValueToFirebase);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {
                    Toast.makeText(SaveRealTimeDataActivity.this, "User not logged in", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SaveRealTimeDataActivity.this, DebugActivity.class));
                }
            }
        };

        editTextKey = (EditText) findViewById(R.id.editTextKey);
        editTextValue = (EditText) findViewById(R.id.editTextValue);


btnSaveToFirebase.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

// Write a message to the database
       /* String Key = editTextKey.getText().toString();
        String Value = editTextValue.getText().toString();
        Toast.makeText(SaveRealTimeDataActivity.this, "Key: "+Key+" Value: "+Value, Toast.LENGTH_SHORT).show();
        if(!TextUtils.isEmpty(Key) || !TextUtils.isEmpty(Value)){


        FirebaseDatabase database = FirebaseDatabase.getInstance("https://parking-alert-main.firebaseio.com/Users");
        DatabaseReference myRef = database.getReference(Key);

        myRef.setValue(Value);
        }else {

            Toast.makeText(SaveRealTimeDataActivity.this, "Fields are not supposed to be empty", Toast.LENGTH_SHORT).show();
        }*/

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://parking-alert-main.firebaseio.com/");
        DatabaseReference myRef = database.getReference();
        // DatabaseReference UsersRef = database.getReference("Users/");

     /*   myRef.child("Name").setValue(mAuth.getCurrentUser().getDisplayName());
        myRef.child("Profession").setValue("Engineer");
        myRef.child("Hobby").setValue("Korean Dramas");
       myRef.child("Nationality");
       myRef.child("User id").setValue( mAuth.getCurrentUser().getUid());
       myRef.child("Age").setValue("21");
       myRef.child("email").setValue(mAuth.getCurrentUser().getEmail());
        if (mAuth.getCurrentUser().getPhotoUrl()!= null){
            myRef.child("email").setValue(mAuth.getCurrentUser().getPhotoUrl());
        }

       myRef.child("University").setValue("Eastern Mediterranean University");*/

  //   User user = new User(mAuth.getCurrentUser().getUid(),mAuth.getCurrentUser().getEmail(),"12");
        MobileUser mUser = new MobileUser(
                mAuth.getCurrentUser().getUid(),
                mAuth.getCurrentUser().getEmail(),
                mAuth.getCurrentUser().getProviderId(),
                null,null
        );
     myRef.child("Users").child(mAuth.getCurrentUser().getUid()).setValue(mUser);


        QrCode mQrCode = new QrCode(
                null,
                "User",
                mUser,
                true,
               new Date()

        );

        myRef.child("QrCodes").push().setValue(mQrCode);
    }
});


    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        //   FirebaseUser currentUser = mAuth.getCurrentUser();

        mAuth.addAuthStateListener(mAuthListener);
        //  updateUI(currentUser);
    }




}
