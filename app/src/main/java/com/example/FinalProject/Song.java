package com.example.FinalProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Song extends AppCompatActivity {
    Button b1, b2, b3;
    MediaPlayer m1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        b1 = (Button) findViewById(R.id.buttonsong);
        b2 = (Button) findViewById(R.id.buttonsong2);
        b3 = (Button) findViewById(R.id.button6menu);
        m1 = (MediaPlayer.create(this, R.raw.a));
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m1.start();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m1.pause();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h = new Intent(Song.this, Menu.class);
                startActivity(h);
                finish();


            }
        });
    }
}