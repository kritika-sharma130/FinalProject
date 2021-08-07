package com.example.FinalProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quiz extends AppCompatActivity {
    static int score = 0;
    Button b1;
    RadioGroup rg, rg1, rg2;
    RadioButton r1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        b1 = findViewById(R.id.button15);
        rg = findViewById(R.id.radioGrp);
        rg1 = findViewById(R.id.radioGrp2);
        rg2 = findViewById(R.id.radioGrp3);
        r1 = findViewById(R.id.radioButton7);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = 0;
                if (rg.getCheckedRadioButtonId() == R.id.radioButton7) {
                    ++score;
                } else {
                    --score;
                }
                if (rg1.getCheckedRadioButtonId() == R.id.radioButton17) {
                    ++score;
                } else {
                    --score;
                }
                if (rg2.getCheckedRadioButtonId() == R.id.radioButton21) {
                    ++score;
                } else {
                    --score;
                }
                startActivity(new
                        Intent(Quiz.this, QuizResultActivity.class));
            }
        });

    }
}