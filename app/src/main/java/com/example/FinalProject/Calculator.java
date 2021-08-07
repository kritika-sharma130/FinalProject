package com.example.FinalProject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {
    EditText opr1;
    EditText opr2;
    Button btnadd;
    Button btnsub;
    Button btnmul;
    Button btndiv;
    Button btnclr, back;
    TextView txtresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        opr1 = (EditText) findViewById(R.id.editOp1);
        opr2 = (EditText) findViewById(R.id.editOp2);
        btnadd = (Button) findViewById(R.id.btnadd);
        btnsub = (Button) findViewById(R.id.btnsub);
        btnmul = (Button) findViewById(R.id.btnmul);
        btndiv = (Button) findViewById(R.id.btndiv);
        btnclr = (Button) findViewById(R.id.btnclr);
        back = (Button) findViewById(R.id.buttonback);
        txtresult = (TextView) findViewById(R.id.result);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((opr1.getText().length() > 0) && (opr2.getText().length() > 0)) {
                    double oper1 = Double.parseDouble(opr1.getText().toString());
                    double oper2 = Double.parseDouble(opr2.getText().toString());
                    double result = oper1 + oper2;
                    txtresult.setText(Double.toString(result));
                } else {
                    Toast toast = Toast.makeText(Calculator.this, "Enter The Required Numbers", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((opr1.getText().length() > 0) && (opr2.getText().length() > 0)) {
                    double oper1 = Double.parseDouble(opr1.getText().toString());
                    double oper2 = Double.parseDouble(opr2.getText().toString());
                    double result = oper1 - oper2;
                    txtresult.setText(Double.toString(result));
                } else {
                    Toast toast = Toast.makeText(Calculator.this, "Enter The Required Numbers", Toast.LENGTH_LONG);
                    toast.show();
                }

            }
        });

        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((opr1.getText().length() > 0) && (opr2.getText().length() > 0)) {
                    double oper1 = Double.parseDouble(opr1.getText().toString());
                    double oper2 = Double.parseDouble(opr2.getText().toString());
                    double result = oper1 * oper2;
                    txtresult.setText(Double.toString(result));
                } else {
                    Toast toast = Toast.makeText(Calculator.this, "Enter The Required Numbers", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        // Division
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((opr1.getText().length() > 0) && (opr2.getText().length() > 0)) {
                    double oper1 = Double.parseDouble(opr1.getText().toString());
                    double oper2 = Double.parseDouble(opr2.getText().toString());
                    double result = oper1 / oper2;
                    txtresult.setText(Double.toString(result));
                } else {
                    Toast toast = Toast.makeText(Calculator.this, "Enter The Required Numbers", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        btnclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opr1.setText("");
                opr2.setText("");
                txtresult.setText("0.00");
                opr1.requestFocus();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Calculator.this, Menu.class);
                startActivity(i);
                finish();
            }
        });

    }
}
