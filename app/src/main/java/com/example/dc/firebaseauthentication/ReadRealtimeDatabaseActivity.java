package com.example.dc.firebaseauthentication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dc.firebaseauthentication.Classes.MobileUser;
import com.example.dc.firebaseauthentication.Classes.QrCode;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ReadRealtimeDatabaseActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    ListView listView;
    ArrayAdapter adapter;
    ArrayList<String> array = new ArrayList<>();

private String qrLists[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_realtime_database);


listView = (ListView) findViewById(R.id.listViewRead);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);

        listView.setAdapter(adapter);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {
                    Toast.makeText(ReadRealtimeDatabaseActivity.this, "User not logged in", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ReadRealtimeDatabaseActivity.this, DebugActivity.class));
                }
            }
        };

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://parking-alert-main.firebaseio.com/");
        DatabaseReference myRef = database.getReference();

        myRef.child("Users/"+mAuth.getCurrentUser().getUid()).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {


                if(dataSnapshot.getKey().toString().equals("Email")){
                    String string =dataSnapshot.getKey()+": " +dataSnapshot.getValue(String.class);
                    //String string = dataSnapshot.getKey();
                    array.add(string);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                String string = dataSnapshot.getValue(String.class);
                array.add(string);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                String string = dataSnapshot.getValue(String.class);
                array.add(string);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String string = dataSnapshot.getValue(String.class);
                array.add(string);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
