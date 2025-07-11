package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tvInput;
    String input = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInput = findViewById(R.id.tvInput);
    }

    public void onDigit(View view) {
        input += ((TextView)view).getText().toString();
        tvInput.setText(input);
    }

    public void onOperator(View view) {
        input += " " + ((TextView)view).getText().toString() + " ";
        tvInput.setText(input);
    }

    public void onClear(View view) {
        input = "";
        tvInput.setText("");
    }

    public void onBackspace(View view) {
        if (!input.isEmpty()) {
            input = input.trim();
            input = input.substring(0, input.length() - 1);
            tvInput.setText(input);
        }
    }

    public void onEqual(View view) {
        try {
            String[] tokens = input.split(" ");
            double result = 0;
            if (tokens.length == 3) {
                double a = Double.parseDouble(tokens[0]);
                double b = Double.parseDouble(tokens[2]);
                String op = tokens[1];
                switch (op) {
                    case "+": result = a + b; break;
                    case "-": result = a - b; break;
                    case "*": result = a * b; break;
                    case "/": result = b != 0 ? a / b : 0; break;
                }
                tvInput.setText(String.valueOf(result));
                input = String.valueOf(result);
            }
        } catch (Exception e) {
            tvInput.setText("Error");
        }
    }
}
