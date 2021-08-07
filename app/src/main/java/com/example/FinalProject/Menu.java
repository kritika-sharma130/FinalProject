package com.example.FinalProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        b1 = (Button) findViewById(R.id.buttonCalculator);
        b2 = (Button) findViewById(R.id.buttoncamera);
        b3 = (Button) findViewById(R.id.buttonsms);
        b4 = (Button) findViewById(R.id.buttonbluetoothone);
        b5 = (Button) findViewById(R.id.buttoncalling);
        b6 = (Button) findViewById(R.id.buttonvibrator);
        b7 = (Button) findViewById(R.id.buttonquiz);
        b8 = (Button) findViewById(R.id.buttonmusic);
        b9 = (Button) findViewById(R.id.button6next);//For Page 2
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Menu.this, Calculator.class);
                startActivity(a);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(Menu.this, Camera.class);
                startActivity(b);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Menu.this, Sms.class);
                startActivity(c);
                finish();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(Menu.this, BluetoothApp.class);
                startActivity(d);
                finish();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(Menu.this, Calling.class);
                startActivity(e);
                finish();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent f = new Intent(Menu.this, VibratorApp.class);
                startActivity(f);
                finish();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent g = new Intent(Menu.this, Quiz.class);
                startActivity(g);
                finish();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent g1 = new Intent(Menu.this, Song.class);
                startActivity(g1);
                finish();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k1 = new Intent(Menu.this, Page2.class);
                startActivity(k1);
                finish();
            }
        });


    }
}