package com.example.dc.firebaseauthentication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class SignInActivity extends AppCompatActivity {
private     EditText editTextEmail;
private      EditText editTextPassword;
private Button btnSignIn;
private FirebaseAuth mAuth;

private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!= null){
                    startActivity( new Intent(SignInActivity.this, AccountActivity.class));
                    Toast.makeText(SignInActivity.this, "User already logged in", Toast.LENGTH_SHORT).show();
                }
            }
        };
            editTextEmail = (EditText) findViewById(R.id.editTextEmail);
            editTextPassword = (EditText) findViewById(R.id.editTextPassword);

            btnSignIn = (Button) findViewById(R.id.btnSignIn);


btnSignIn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        StartSignIn();
    }
});

    }


    private void StartSignIn(){
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){


            Toast.makeText(SignInActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
        }else{

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()){
                        Toast.makeText(SignInActivity.this, "Sign in problem", Toast.LENGTH_SHORT).show();
                    }else {

                        startActivity(new Intent(SignInActivity.this,AccountActivity.class));

                    }
                }
            });

        }


    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
    mAuth.addAuthStateListener(mAuthListener);
    }

}