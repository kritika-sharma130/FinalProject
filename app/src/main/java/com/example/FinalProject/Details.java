package com.example.FinalProject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Details extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    Button backToLogin;
    Button menuPage;
    FirebaseAuth firebaseAuth;
    GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        imageView = (ImageView) findViewById(R.id.details);
        textView = (TextView) findViewById(R.id.info);
        backToLogin = (Button) findViewById(R.id.buttonbacktologin);
        menuPage = (Button) findViewById(R.id.buttonjumptomenu);
        firebaseAuth = FirebaseAuth.getInstance();
        googleSignInClient = GoogleSignIn.getClient(Details.this, GoogleSignInOptions.DEFAULT_SIGN_IN);
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        menuPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent z = new Intent(Details.this, Menu.class);
                startActivity(z);
            }
        });
        if (firebaseUser != null) {
            Glide.with(Details.this).load(firebaseUser.getPhotoUrl()).into(imageView);
            textView.setText(firebaseUser.getDisplayName());

        }

        backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Details.this, "logout successfull", Toast.LENGTH_SHORT).show();
                            firebaseAuth.signOut();
                            finish();
                        }
                    }
                });
            }
        });

    }
}