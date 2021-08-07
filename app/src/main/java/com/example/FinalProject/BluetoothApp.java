package com.example.FinalProject;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class BluetoothApp extends AppCompatActivity {
    ImageButton b1;
    Button b2;
    BluetoothAdapter ba;
    TextToSpeech ts;
    String s3;
    private boolean status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        b1 = findViewById(R.id.imageButtonone);
        ba = BluetoothAdapter.getDefaultAdapter();
        b2 = findViewById(R.id.buttonToBack);
        ts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                ts.setLanguage(Locale.ENGLISH);
                ts.setSpeechRate(0.8f);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (status == false) {
                    ba.enable();
                    status = true;
                    b1.setImageResource(R.drawable.play);
                    s3 = "Your bluetooth has been enabled";
                    Toast.makeText(BluetoothApp.this, s3, Toast.LENGTH_SHORT).show();
                    ts.speak(s3, TextToSpeech.QUEUE_FLUSH, null);
                } else {
                    ba.disable();
                    status = false;
                    b1.setImageResource(R.drawable.pause);
                    s3 = "Your bluetooth has been disabled";
                    Toast.makeText(BluetoothApp.this, s3, Toast.LENGTH_SHORT).show();
                    ts.speak(s3, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(BluetoothApp.this, Menu.class);
                startActivity(m);
                finish();
            }
        });
    }
}