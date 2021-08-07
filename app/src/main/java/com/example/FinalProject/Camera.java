package com.example.FinalProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Camera extends AppCompatActivity {
    Button b1, b2;
    ImageView i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        i1 = (ImageView) findViewById(R.id.imageViewcamera);
        b1 = (Button) findViewById(R.id.buttoncamera3);
        b2 = (Button) findViewById(R.id.buttoncamera2);//Button to revert back
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            Bitmap bp = (Bitmap) data.getExtras().get("data");
            i1.setImageBitmap(bp);
        } else {
            Toast.makeText(Camera.this, "Image not captured", Toast.LENGTH_SHORT).show();
        }
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(Camera.this, Menu.class);
                startActivity(j);
                finish();

            }
        });

    }
}