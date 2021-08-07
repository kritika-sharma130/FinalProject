package com.example.FinalProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MySqualite2 extends AppCompatActivity {
    EditText e1, e2, e3;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_squalite2);
        e1 = (EditText) findViewById(R.id.editTextNamee);//name
        e2 = (EditText) findViewById(R.id.editTextEmaill);//email
        e3 = (EditText) findViewById(R.id.editTextPasswordNew);//password
        e3.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        b1 = (Button) findViewById(R.id.button_signup);//signup
        b2 = (Button) findViewById(R.id.button_login);//login
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(MySqualite2.this, MySqualite.class);
                startActivity(j);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                if (s1.equals("") || s2.equals("") || s3.equals("")) {
                    Toast.makeText(MySqualite2.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    SQLiteDatabase sql = openOrCreateDatabase("gla", MODE_PRIVATE, null);
                    sql.execSQL("create table if not exists student (name varchar,email varchar,password varchar)");
                    String s4 = "select * from student where name='" + s1 + "' and email='" + s2 + "'"; //'=variable' and'' states string value
                    //Cursor can store the output
                    Cursor c1 = sql.rawQuery(s4, null);//rawQuery executes the query and also calls the value.
                    if (c1.getCount() > 0) {
                        Toast.makeText(MySqualite2.this, "User already exists", Toast.LENGTH_SHORT).show();
                    } else {
                        sql.execSQL("insert into student values ('" + s1 + "','" + s2 + "','" + s3 + "')");
                        Toast.makeText(MySqualite2.this, "database updated", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}