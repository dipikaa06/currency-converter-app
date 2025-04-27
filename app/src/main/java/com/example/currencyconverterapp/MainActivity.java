package com.example.currencyconverterapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText amountEditText;
    Spinner currencySpinner;
    Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountEditText = findViewById(R.id.amountEditText);
        currencySpinner = findViewById(R.id.currencySpinner);
        convertButton = findViewById(R.id.convertButton);

        // Currency list (INR to USD, EUR, GBP, etc.)
        String[] currencies = {"USD", "EUR", "GBP", "AUD"};

        // Spinner adapter to display currency options
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, currencies);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencySpinner.setAdapter(adapter);

        // Convert button click listener
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amountString = amountEditText.getText().toString();

                if (amountString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter an amount", Toast.LENGTH_SHORT).show();
                } else {
                    double amount = Double.parseDouble(amountString);
                    String selectedCurrency = currencySpinner.getSelectedItem().toString();

                    double convertedAmount = 0;

                    // Conversion rates for each currency
                    switch (selectedCurrency) {
                        case "USD":
                            convertedAmount = amount * 0.012; // 1 INR = 0.012 USD approx
                            break;
                        case "EUR":
                            convertedAmount = amount * 0.011; // 1 INR = 0.011 EUR approx
                            break;
                        case "GBP":
                            convertedAmount = amount * 0.009; // 1 INR = 0.009 GBP approx
                            break;
                        case "AUD":
                            convertedAmount = amount * 0.018; // 1 INR = 0.018 AUD approx
                            break;
                    }

                    // Send the converted amount and selected currency to ResultActivity
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("convertedAmount", convertedAmount);
                    intent.putExtra("selectedCurrency", selectedCurrency);
                    startActivity(intent);
                }
            }
        });
    }
}
