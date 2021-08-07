package com.example.FinalProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Page2 extends AppCompatActivity {
    Button ba, bb, bc, bd, be, bf, bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        ba = (Button) findViewById(R.id.buttona);
        bb = (Button) findViewById(R.id.buttonb);
        bc = (Button) findViewById(R.id.buttonc);
        bd = (Button) findViewById(R.id.buttond);
        be = (Button) findViewById(R.id.buttone);
        bf = (Button) findViewById(R.id.buttonf);
        bg = (Button) findViewById(R.id.buttong);
        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(Page2.this, VidPlay.class);
                startActivity(n);
                finish();
            }
        });
        bf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n1 = new Intent(Page2.this, MainActivity.class);
                startActivity(n1);
                finish();
                Toast.makeText(Page2.this, "Logout Successful", Toast.LENGTH_SHORT).show();
            }
        });
        bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n2 = new Intent(Page2.this, Menu.class);
                startActivity(n2);
                finish();

            }
        });
        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k2 = new Intent(Page2.this, BrowsingApplication.class);
                startActivity(k2);
                finish();

            }
        });
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent(Page2.this, MySqualite.class);
                startActivity(s);
                finish();
            }
        });
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s1 = new Intent(Page2.this, CaptureVideo.class);
                startActivity(s1);
                finish();
            }
        });
        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s2 = new Intent(Page2.this, Light.class);
                startActivity(s2);
                finish();
            }
        });
    }
}