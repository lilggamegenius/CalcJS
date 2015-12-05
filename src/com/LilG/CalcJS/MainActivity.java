package com.LilG.CalcJS;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;
import com.evgenii.jsevaluator.JsEvaluator;
import com.evgenii.jsevaluator.interfaces.JsCallback;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private EditText text;
    private Button[] buttons = new Button[14];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initializeThing();
    }

    private void initializeThing() {
        text = (EditText) findViewById(R.id.editText);
        buttons[0]  = (Button) findViewById(R.id.buttonEval);
        buttons[1]  = (Button) findViewById(R.id.button1);
        buttons[2]  = (Button) findViewById(R.id.button2);
        buttons[3]  = (Button) findViewById(R.id.button3);
        buttons[4]  = (Button) findViewById(R.id.button4);
        buttons[5]  = (Button) findViewById(R.id.button5);
        buttons[6]  = (Button) findViewById(R.id.button6);
        buttons[7]  = (Button) findViewById(R.id.button7);
        buttons[8]  = (Button) findViewById(R.id.button8);
        buttons[9]  = (Button) findViewById(R.id.button9);
        buttons[10] = (Button) findViewById(R.id.buttonDivide);
        buttons[11] = (Button) findViewById(R.id.buttonMul);
        buttons[12] = (Button) findViewById(R.id.buttonPlus);
        buttons[13] = (Button) findViewById(R.id.buttonMinus);
        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eval();
            }
        });

        for(int i = 1; i < 10; i++) {
            final int x = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    text.setText(text.getText().toString() + x);
                }
            });
        }
        buttons[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText().toString() + "/");
            }
        });
        buttons[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText().toString() + "*");
            }
        });
        buttons[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText().toString() + "+");
            }
        });
        buttons[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText().toString() + "-");
            }
        });
        Log.i("myApp", "Listener created");
    }

    private void eval(){
        JsEvaluator jsEvaluator = new JsEvaluator(this);
        String factorialFunct = "function factorial(num) {  if (num < 0) {    return -1;  } else if (num == 0) {    return 1;  }  var tmp = num;  while (num-- > 2) {    tmp *= num;  }  return tmp;}function getBit(num, bit) {  var result = (num >> bit) & 1; return result == 1} var life = 42; ";
        String eval = text.getText().toString();
        jsEvaluator.evaluate(factorialFunct + eval, new JsCallback() {
            @Override
            public void onResult(final String result) {
                text.setText(result);
            }
        });
    }
}
