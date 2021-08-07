package com.example.FinalProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class VibratorApp extends AppCompatActivity {
    Button b1, b2;
    Vibrator v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrator);
        b1 = (Button) findViewById(R.id.buttonVibratorApp);
        b2 = (Button) findViewById(R.id.buttonabc);
        v1 = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT > 26) {
                    v1.vibrate(8000);
                } else {
                    v1.vibrate(8000);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(VibratorApp.this, Menu.class);
                startActivity(k);
                finish();
            }
        });
    }
}
