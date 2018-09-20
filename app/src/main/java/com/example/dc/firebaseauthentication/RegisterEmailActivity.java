package com.example.dc.firebaseauthentication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

public class RegisterEmailActivity extends AppCompatActivity {
    private static final String TAG = "RegisterEmailActivity";
    private FirebaseAuth mAuth;
    EditText editTextEmail;
    EditText editTextPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_email);

        mAuth = FirebaseAuth.getInstance();
editTextEmail = (EditText) findViewById(R.id.editTextEmail);
editTextPassword = (EditText) findViewById(R.id.editTextPassword);
btnRegister = (Button) findViewById(R.id.btnRegister);



btnRegister.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        RegisterNewUser();
    }
});
    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }


    public void RegisterNewUser(){

String email = editTextEmail.getText().toString();
String password = editTextPassword.getText().toString();


        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){

        }else{
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                startActivity(new Intent(RegisterEmailActivity.this, AccountActivity.class));

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(RegisterEmailActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }

                            // ...
                        }
                    });

        }


    }
}
