package com.example.FinalProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sms extends AppCompatActivity {
    EditText e1, e2;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        e1 = (EditText) findViewById(R.id.editTextPhoneNumberUser);//phone
        e2 = (EditText) findViewById(R.id.editTextSmss);//sms
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.buttonbacknow);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone, message;
                phone = e1.getText().toString();
                message = e2.getText().toString();
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phone, null, message, null, null);
                    Toast.makeText(Sms.this, "Message send", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(Sms.this, "Message not send", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v = new Intent(Sms.this, Menu.class);
                startActivity(v);
                finish();
            }
        });
    }
}