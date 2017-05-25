package com.example.jrosariohdz.rpncalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnPnt;
    private Button btnCS;
    private Button btnDiv;
    private Button btnMul;
    private Button btnSum;
    private Button btnSub;
    private Button btnEnt;
    private Button btnClr;
    private TextView textViewRes;
    private TextView textViewEntry;
    private  Double num1 = 0.0;
    private Stack stack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stack = new Stack();
        initBtnsViews();


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewEntry.setText(textViewEntry.getText()+"0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewEntry.setText(textViewEntry.getText()+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewEntry.setText(textViewEntry.getText()+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewEntry.setText(textViewEntry.getText()+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewEntry.setText(textViewEntry.getText()+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewEntry.setText(textViewEntry.getText()+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewEntry.setText(textViewEntry.getText()+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewEntry.setText(textViewEntry.getText()+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewEntry.setText(textViewEntry.getText()+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewEntry.setText(textViewEntry.getText()+"9");
            }
        });
        btnEnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  if()
                num1 = Double.parseDouble(textViewEntry.getText().toString());
                stack.push(num1);
                textViewEntry.setText(null);
                num1=null;


            }
        });
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewRes.setText(stack.pop().toString());
            }
        });

    }

    private void initBtnsViews(){
        btn0 = (Button) findViewById(R.id.button0);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btnPnt = (Button) findViewById(R.id.buttonPoint);
        btnCS = (Button) findViewById(R.id.buttonSignChange);
        btnDiv = (Button) findViewById(R.id.buttonDiv);
        btnMul = (Button) findViewById(R.id.buttonMul);
        btnSum = (Button) findViewById(R.id.buttonSum);
        btnSub = (Button) findViewById(R.id.buttonSub);
        btnEnt = (Button) findViewById(R.id.buttonEnter);
        btnClr = (Button) findViewById(R.id.buttonClear);
        textViewRes = (TextView) findViewById(R.id.textViewRes);
        textViewEntry = (TextView) findViewById(R.id.textViewEntry);
    }
}
