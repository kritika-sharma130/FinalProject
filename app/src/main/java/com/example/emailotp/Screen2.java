package com.example.emailotp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Screen2 extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    EditText e1, e2;
    Button b1, b2;
    ProgressBar p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        e1 = findViewById(R.id.editTextTextPersonEmail);
        e2 = findViewById(R.id.editTextTextPassword);
        b1 = findViewById(R.id.button3);//Login
        b2 = findViewById(R.id.button4);//Signup
        firebaseAuth = FirebaseAuth.getInstance();
        p1 = findViewById(R.id.progressBarmain);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString().trim();
                String s2 = e2.getText().toString().trim();
                if (s1.isEmpty()) {
                    e1.setError("fill username");
                    return;
                } else {
                    if (s2.isEmpty()) {
                        e2.setError("fill password");
                        return;
                    }
                }
                p1.setVisibility(View.VISIBLE);
                firebaseAuth.signInWithEmailAndPassword(s1, s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Screen2.this, "login successful", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Screen2.this, Screen6.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(Screen2.this, "details mismatch", Toast.LENGTH_SHORT).show();
                        }
                        p1.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Screen2.this, Screen3.class);
                Toast.makeText(Screen2.this, "You are being directed to the signup page", Toast.LENGTH_SHORT).show();
                startActivity(i);
                finish();
            }
        });
    }
}