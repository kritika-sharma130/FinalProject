package com.example.FinalProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MySqualite extends AppCompatActivity {
    EditText e1, e2;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_squalite);
        e1 = (EditText) findViewById(R.id.editTextname);
        e2 = (EditText) findViewById(R.id.editTextpass);
        b1 = (Button) findViewById(R.id.buttonlogin);
        b2 = (Button) findViewById(R.id.buttonsignup);//signup
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MySqualite.this, MySqualite2.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if (s1.equals("") || s2.equals("")) {
                    Toast.makeText(MySqualite.this, "plz fill all the field", Toast.LENGTH_SHORT).show();
                } else {
                    SQLiteDatabase sql = openOrCreateDatabase("gla", MODE_PRIVATE, null);
                    sql.execSQL("create table if not exists student (name varchar,email varchar,password varchar)");
                    String s3 = "select * from student where name='" + s1 + "' and email='" + s2 + "'";
                    Cursor c1 = sql.rawQuery(s3, null);
                    if (c1.getCount() > 0) {
                        Toast.makeText(MySqualite.this, "Login Done", Toast.LENGTH_SHORT).show();
                        Intent m = new Intent(MySqualite.this, MySqualite3.class);
                        startActivity(m);
                        finish();
                    } else {
                        Toast.makeText(MySqualite.this, "Login failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}