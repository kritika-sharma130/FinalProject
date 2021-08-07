package com.example.FinalProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class BrowsingApplication extends AppCompatActivity {
    EditText e1;
    Button b1, b2;
    WebView w1;
    String s1 = "https://";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browsing_application);
        b1 = (Button) findViewById(R.id.buttonclick);
        b2 = (Button) findViewById(R.id.buttonclick2back);
        e1 = (EditText) findViewById(R.id.editTextques);
        w1 = (WebView) findViewById(R.id.webView);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s2 = e1.getText().toString();
                w1.loadUrl(s1 + s2);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(BrowsingApplication.this, Page2.class);
                startActivity(j);
                finish();
            }
        });
    }
}