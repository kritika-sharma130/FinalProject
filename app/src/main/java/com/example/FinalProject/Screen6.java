package com.example.FinalProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Screen6 extends AppCompatActivity {
    EditText e1, e2, e3, e4;
    Button submit, next;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Button logout;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen6);
        e1 = (EditText) findViewById(R.id.editTextTextPersonName);
        e2 = (EditText) findViewById(R.id.editTextTextPassword);
        e3 = (EditText) findViewById(R.id.editTextTextPhoneNumber);
        e4 = (EditText) findViewById(R.id.editTextEmail);
        submit = (Button) findViewById(R.id.submit);
        next = (Button) findViewById(R.id.next);
        firebaseDatabase = FirebaseDatabase.getInstance();
        logout = (Button) findViewById(R.id.logout);
        firebaseAuth = FirebaseAuth.getInstance();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference = firebaseDatabase.getReference("Users");
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                if (s3.length() != 10) {
                    Toast.makeText(Screen6.this, "Enter a valid phone number", Toast.LENGTH_SHORT).show();
                } else {
                    Users users = new Users(s1, s2, s3, s4);
                    databaseReference.child(s3).setValue(users);
                    Toast.makeText(Screen6.this, "Database updated", Toast.LENGTH_SHORT).show();
                }
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                Intent i = new Intent(Screen6.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(Screen6.this, Menu.class);
                startActivity(m);
                Toast.makeText(Screen6.this, "You are being redirected to the main menu", Toast.LENGTH_SHORT).show();
            }
        });
    }
}