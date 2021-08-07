package com.example.FinalProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MySqualite3 extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_squalite3);
        b1 = (Button) findViewById(R.id.button50);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MySqualite3.this, "Logout successful!", Toast.LENGTH_SHORT).show();
                Intent n = new Intent(MySqualite3.this, Page2.class);
                startActivity(n);
                finish();
            }
        });
    }
}