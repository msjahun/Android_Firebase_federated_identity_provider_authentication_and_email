package com.example.dc.firebaseauthentication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

public class AccountActivity extends AppCompatActivity {
        private Button btnLogout;
        private Button btnDebug;
        private FirebaseAuth mAuth;
        private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnDebug =  (Button) findViewById(R.id.btnDebug);

        btnDebug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountActivity.this, DebugActivity.class));
            }
        });
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {
                    Toast.makeText(AccountActivity.this, "User not logged in", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AccountActivity.this, DebugActivity.class));
                }
            }
        };

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                LoginManager.getInstance().logOut();
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
