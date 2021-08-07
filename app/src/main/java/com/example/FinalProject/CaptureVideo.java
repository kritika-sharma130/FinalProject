package com.example.FinalProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class CaptureVideo extends AppCompatActivity {
    MediaController m1;
    VideoView v1;
    Button b1;
    Uri u1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_video);
        v1 = (VideoView) findViewById(R.id.videoView);
        b1 = (Button) findViewById(R.id.button_videoRec);
        MediaController m1 = new MediaController(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(i, 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        u1 = data.getData();
        v1.setVideoURI(u1);
        v1.setMediaController(m1);
        m1.setAnchorView(v1);
    }
}