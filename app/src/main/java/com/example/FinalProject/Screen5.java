package com.example.FinalProject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class Screen5 extends AppCompatActivity {
    EditText e2;
    Button b2;
    String phone,otp;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen5);
        phone=getIntent().getStringExtra("mobile").toString();
        e2=(EditText)findViewById(R.id.editTextOtp);
        b2=(Button)findViewById(R.id.buttonSubmit);
        firebaseAuth=FirebaseAuth.getInstance();
        getotp();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e2.getText().toString().isEmpty()){
                    Toast.makeText(Screen5.this, "Enter OTP", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(e2.getText().toString().length()!=6){
                        Toast.makeText(Screen5.this, "Invalid OTP", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        PhoneAuthCredential credential= PhoneAuthProvider.getCredential(otp,e2.getText().toString());
                        signInWithPhoneAuthCredential(credential);
                    }
                }
            }
        });
    }
    private void getotp(){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,
                60,
                TimeUnit.SECONDS,
                this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull @NotNull String s, @NonNull @NotNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        otp=s;
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull @org.jetbrains.annotations.NotNull PhoneAuthCredential phoneAuthCredential) {
                        signInWithPhoneAuthCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull @org.jetbrains.annotations.NotNull FirebaseException e) {
                        Toast.makeText(Screen5.this, "Wait for OTP", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential){
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Screen5.this, "login Successfully", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Screen5.this,Screen6.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(Screen5.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}