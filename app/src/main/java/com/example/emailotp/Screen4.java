package com.example.emailotp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hbb20.CountryCodePicker;

public class Screen4 extends AppCompatActivity {
    CountryCodePicker cp;
    EditText e1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4);
        e1=(EditText)findViewById(R.id.editTextPhoneNumber);
        cp=(CountryCodePicker)findViewById(R.id.cpp);
        cp.registerCarrierNumberEditText(e1);
        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Screen4.this,Screen5.class);
                i.putExtra("mobile",cp.getFullNumberWithPlus().trim());
                startActivity(i);
            }
        });
    }
}