package com.example.currencyconverterapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTextView = findViewById(R.id.resultTextView);

        double convertedAmount = getIntent().getDoubleExtra("convertedAmount", 0.0);
        String selectedCurrency = getIntent().getStringExtra("selectedCurrency");

        resultTextView.setText(String.format("Converted Amount: %.2f %s", convertedAmount, selectedCurrency));
    }
}
