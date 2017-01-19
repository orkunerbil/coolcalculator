package com.example.orkun.coolcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView resultTextView;

    String runningNumber = "";
    String leftSideValue;
    String rightSideValue;
    Operation currentOperation;
    int result = 0;

    public enum Operation{
        ADD, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonOne = (Button) findViewById(R.id.buttonOne);
        Button buttonTwo = (Button) findViewById(R.id.buttonTwo);
        Button buttonThree = (Button) findViewById(R.id.buttonThree);
        Button buttonFour = (Button) findViewById(R.id.buttonFour);
        Button buttonFive = (Button) findViewById(R.id.buttonFive);
        Button buttonSix = (Button) findViewById(R.id.buttonSix);
        Button buttonSeven = (Button) findViewById(R.id.buttonSeven);
        Button buttonEight = (Button) findViewById(R.id.buttonEight);
        Button buttonNine = (Button) findViewById(R.id.buttonNine);
        Button buttonZero = (Button) findViewById(R.id.buttonZero);

        Button buttonClear = (Button) findViewById(R.id.buttonClear);

        ImageButton imageButtonAdd = (ImageButton) findViewById(R.id.imageButtonAdd);
        ImageButton imageButtonSubtract = (ImageButton) findViewById(R.id.imageButtonSubtract);
        ImageButton imageButtonMultiply = (ImageButton) findViewById(R.id.imageButtonMultiply);
        ImageButton imageButtonDivide = (ImageButton) findViewById(R.id.imageButtonDivide);
        ImageButton imageButtonCalculate = (ImageButton) findViewById(R.id.imageButtonCalculate);

        resultTextView = (TextView) findViewById(R.id.ResultTextView);

        resultTextView.setText("");

        buttonOne.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                numberPressed(1);
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                numberPressed(2);
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                numberPressed(3);
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                numberPressed(4);
            }
        });

        buttonFive.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                numberPressed(5);
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                numberPressed(6);
            }
        });

        buttonSeven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                numberPressed(7);
            }
        });

        buttonEight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                numberPressed(8);
            }
        });

        buttonNine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                numberPressed(9);
            }
        });

        buttonZero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                numberPressed(0);
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                leftSideValue = "";
                rightSideValue = "";
                result = 0;
                runningNumber = "";
                currentOperation = null;
                resultTextView.setText("0");
            }
        });

        imageButtonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                processOperation(Operation.ADD);
            }
        });

        imageButtonSubtract.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                processOperation(Operation.SUBTRACT);
            }
        });

        imageButtonMultiply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                processOperation(Operation.MULTIPLY);
            }
        });

        imageButtonDivide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                processOperation(Operation.DIVIDE);
            }
        });

        imageButtonCalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                processOperation(Operation.EQUAL);
            }
        });
    }

    void processOperation(Operation operation){
        if(currentOperation != null){
            if(runningNumber != ""){
                rightSideValue = runningNumber;
                runningNumber = "";

                switch (currentOperation){
                    case ADD:
                        result = Integer.parseInt(leftSideValue) + Integer.parseInt(rightSideValue);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftSideValue) - Integer.parseInt(rightSideValue);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftSideValue) * Integer.parseInt(rightSideValue);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftSideValue) / Integer.parseInt(rightSideValue);
                        break;
                }

                leftSideValue = String.valueOf(result);
                resultTextView.setText(leftSideValue);
            }
        } else{
            leftSideValue = runningNumber;
            runningNumber = "";
        }

        currentOperation = operation;
    }

    void numberPressed(int number){
        runningNumber += String.valueOf(number);
        resultTextView.setText(runningNumber);
    }
}
