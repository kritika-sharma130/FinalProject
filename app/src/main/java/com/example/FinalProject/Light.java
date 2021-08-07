package com.example.FinalProject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Light extends AppCompatActivity {
    ImageButton ib;
    Button b1;
    CameraManager cm;
    private boolean torch = false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);
        b1 = (Button) findViewById(R.id.button21);
        ib = (ImageButton) findViewById(R.id.imageButton20);
        cm = (CameraManager) getSystemService(CAMERA_SERVICE);
        ib.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (torch == false) {
                    try {
                        String id = cm.getCameraIdList()[0];
                        cm.setTorchMode(id, true);
                        torch = true;
                        ib.setImageResource(R.drawable.download2);
                        Toast.makeText(Light.this, "Torch ON",
                                Toast.LENGTH_SHORT).show();
                    } catch (CameraAccessException e) {
                    }
                } else {
                    try {
                        String id = cm.getCameraIdList()[0];
                        cm.setTorchMode(id, false);
                        torch = false;
                        ib.setImageResource(R.drawable.download1);
                        Toast.makeText(Light.this, "Torch OFF",
                                Toast.LENGTH_SHORT).show();
                    } catch (CameraAccessException e) {
                    }
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent z = new Intent(Light.this, Page2.class);
                startActivity(z);
                finish();

            }
        });

    }
}