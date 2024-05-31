package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textview;
    private Integer first, second, sum;
    private Boolean isOperationClick;
    private String operation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textview = findViewById(R.id.text_view);

    }

    public void oneNumberClick(View view) {
        String textButton = ((MaterialButton) view).getText().toString();
        if (textButton.equals("AC")) {
            textview.setText("0");
            first = 0;
            second = 0;
        } else if (textview.getText().toString().equals("0") || isOperationClick) {
            textview.setText(textButton);
        } else {
            textview.append(textButton);
        }
        isOperationClick = false;
    }

    //21+ 1 = 22
    public void oneOperationClick(View view) {
        if (view.getId() == R.id.btn_plus) {
            first = Integer.valueOf(textview.getText().toString());
            operation = "+";
        } else if (view.getId() == R.id.btn_division) {
            first = Integer.valueOf(textview.getText().toString());
            operation = "/";
        } else if (view.getId() == R.id.btn_minos) {
            first = Integer.valueOf(textview.getText().toString());
            operation = "-";
        } else if (view.getId() == R.id.btn_multiplication) {
            first = Integer.valueOf(textview.getText().toString());
            operation = "*";
        } else if (view.getId() == R.id.btn_equals) {
            second = Integer.valueOf(textview.getText().toString());
            if (operation.equals("+")) {
                sum = first + second;
                textview.setText(sum.toString());
            } else if (operation.equals("-")) {
                sum = first - second;
                textview.setText(sum.toString());
            } else if (operation.equals("*")) {
                sum = first * second;
                textview.setText(sum.toString());
            } else if (operation.equals("/")) {
                if (second == 0) {
                    textview.setText("Error");
                } else {
                    sum = first / second;
                }
            }
            textview.setText(sum.toString());
        }
        isOperationClick = true;
    }
}