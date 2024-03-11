package com.pjatk.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText bodyMassText = findViewById(R.id.editTextBodyMass);
        final EditText heightText = findViewById(R.id.editTextHeight);
        final TextView resultTextView = findViewById(R.id.resultTextView);

        final Button button = findViewById(R.id.calculateButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    double bodyMass = Double.parseDouble(bodyMassText.getText().toString());
                    double height = Double.parseDouble(heightText.getText().toString());
                    double bmi = bodyMass / (height * height);
                    resultTextView.setText(String.valueOf(bmi));
                } catch (NumberFormatException e) {
                    resultTextView.setText("provide data first");
                }
            }
        });
    }
}