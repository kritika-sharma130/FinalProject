package com.example.FinalProject;

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

public class Screen3 extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    EditText e1, e2;
    Button b1, b2;
    ProgressBar p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        e1 = findViewById(R.id.editTextTextPersonEmail2);
        e2 = findViewById(R.id.editTextTextPassword2);
        b1 = findViewById(R.id.button5);//Signup
        b2 = findViewById(R.id.button7);//Back
        firebaseAuth = FirebaseAuth.getInstance();
        p1 = findViewById(R.id.progressBar);
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
                firebaseAuth.createUserWithEmailAndPassword(s1, s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Screen3.this, "registration done", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Screen3.this, Screen2.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(Screen3.this, "user already exits", Toast.LENGTH_SHORT).show();
                        }
                        p1.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Screen3.this, Screen2.class);
                startActivity(j);
                finish();
            }
        });
    }
}