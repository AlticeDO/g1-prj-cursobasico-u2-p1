package com.example.jrosariohdz.rpncalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    private TextView textViewEntry;
    private Spinner stackSpinner;
    private  Double num1 = 0.0, num2, result;
    private Integer numCS;
    private Stack stack;
    private Boolean operated=false;
    private String[] history = new String[5];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stack = new Stack<Double>();
        initBtnsViews();

        //Set ArrayAdapter for Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, history){
            public boolean isEnabled(int position){
                    //Disable all items of spinner.
                    return false;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stackSpinner.setAdapter(adapter);

        //Actions to perform when numbers from 0-9 are presses
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatedValueClean();
                textViewEntry.setText(textViewEntry.getText()+"0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatedValueClean();
                textViewEntry.setText(textViewEntry.getText()+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatedValueClean();
                textViewEntry.setText(textViewEntry.getText()+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatedValueClean();
                textViewEntry.setText(textViewEntry.getText()+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatedValueClean();
                textViewEntry.setText(textViewEntry.getText()+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatedValueClean();
                textViewEntry.setText(textViewEntry.getText()+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatedValueClean();
                textViewEntry.setText(textViewEntry.getText()+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatedValueClean();
                textViewEntry.setText(textViewEntry.getText()+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatedValueClean();
                textViewEntry.setText(textViewEntry.getText()+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatedValueClean();
                textViewEntry.setText(textViewEntry.getText()+"9");
            }
        });

        //Making sure dot only is written after a Zero
        btnPnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (!textViewEntry.getText().toString().contains(".")) {
                if (textViewEntry.getText().equals("")){
                    operatedValueClean();
                    textViewEntry.setText(textViewEntry.getText() + "0.");
                }else {
                    operatedValueClean();
                    textViewEntry.setText(textViewEntry.getText() + ".");

                }
            }
            }
        });

        //Enter puts Entry in the stack and messages if no number has been introduced before
        btnEnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!textViewEntry.getText().equals("")){
                num1 = Double.parseDouble(textViewEntry.getText().toString());
                stack.push(num1);
                num1=null;
                }else{
                    Toast.makeText(getApplicationContext(), "No new value has been inserted", Toast.LENGTH_SHORT).show();
                }// To diferentiate new entry from result or old entry
                operated=true;
                toHistory(textViewEntry.getText().toString());
            }
        });

        //Addition function
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operated) {
                    if (stack.size()>1) {
                        num2 = Double.parseDouble(stack.pop().toString());
                        num1 = Double.parseDouble(stack.pop().toString());
                        result = num1 + num2;
                        stack.push(result);
                        textViewEntry.setText(result.toString());
                        operated=true;
                        toHistory("+    res:    "+result.toString());

                    }
                }
            }
        });

        //Substraction function
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operated) {
                    if (stack.size()>1) {
                        num2 = Double.parseDouble(stack.pop().toString());
                        num1 = Double.parseDouble(stack.pop().toString());
                        result = num1 - num2;
                        stack.push(result);
                        textViewEntry.setText(result.toString());
                        operated=true;
                        toHistory("-    res:    "+result.toString());

                    }
                }
            }
        });

        //Multiplication function
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operated) {
                    if (stack.size()>1) {
                        num2 = Double.parseDouble(stack.pop().toString());
                        num1 = Double.parseDouble(stack.pop().toString());
                        result = num1 * num2;
                        stack.push(result);
                        textViewEntry.setText(result.toString());
                        operated=true;
                        toHistory("*    res:    "+result.toString());

                    }
                }
            }
        });

        //Division function. Warns division by 0 is not valid
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operated) {
                    if (stack.size()>1) {
                        num2 = Double.parseDouble(stack.pop().toString());
                        if (num2!=0) {
                            num1 = Double.parseDouble(stack.pop().toString());
                            result = num1 / num2;
                            stack.push(result);
                            textViewEntry.setText(result.toString());

                        }else{
                            Toast.makeText(getApplicationContext(), "Division by 0 not allowed", Toast.LENGTH_SHORT).show();

                        }operated=true;
                        toHistory("/    res:    "+result.toString());
                    }
                }
            }
        });

        //Clear function clears the numbers in the textview
        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewEntry.setText("");
            }
        });

        //Sign Swap. uses integers to maintain logic
        btnCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textViewEntry.getText().equals("")) {
                    if (!stack.empty() && operated) {
                        stack.pop();
                        num1 = Double.parseDouble(textViewEntry.getText().toString());
                        num1 = num1 * (-1);
                        stack.push(num1);
                        textViewEntry.setText(stack.peek().toString());
                    } else {
                        if (textViewEntry.getText().toString().contains(".")) {
                            num1 = Double.parseDouble(textViewEntry.getText().toString());
                            num1 = num1 * (-1);
                            textViewEntry.setText(num1.toString());
                        } else {
                            numCS = Integer.parseInt(textViewEntry.getText().toString());
                            numCS = numCS * (-1);
                            textViewEntry.setText(numCS.toString());
                        }
                    }
                }
            }
        });

    }

    //Initiates every view in the activity
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
        textViewEntry = (TextView) findViewById(R.id.textViewEntry);
        stackSpinner = (Spinner) findViewById(R.id.stackSpinner);
    }

    //Cleans textview entry if new numbers are typed after an operation or stack entry
    private void operatedValueClean() {
        if (operated) {
            operated = false;
            textViewEntry.setText("");
        }
    }

    //updates history of operations (5) on spinner
    private void toHistory(String o){
        history[4]=history[3];
        history[3]=history[2];
        history[2]=history[1];
        history[1]=history[0];
        history[0]=o;

    }

}
