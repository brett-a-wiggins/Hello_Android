package com.example.hello_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;

public class AddFuelPurchaseActivity extends AppCompatActivity {
    private Button captureReceiptButton;
    private Button submitFuelPurchaseButton;
    private TextView fuelPriceTextView;
    private TextView fuelAmountTextView;
    private TextView fillUpLocationTextView;
    private TextView odometerReadingTextView;
    private Spinner fuelTypeSpinner;
    private TextView totalCostTextView;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fuel_purchase);

        fuelPriceTextView = findViewById(R.id.fuel_price_textView);
        fuelAmountTextView = findViewById(R.id.fuel_amount_textView);
        fillUpLocationTextView = findViewById(R.id.fillup_location_textView);
        odometerReadingTextView = findViewById(R.id.odometer_reading_textView);
        totalCostTextView = findViewById(R.id.total_price_textView);





        captureReceiptButton = this.findViewById(R.id.goto_receipt_capture_button);
        captureReceiptButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AddFuelPurchaseActivity.this, CaptureReceiptActivity.class);
                startActivity(intent);
            }
        });

        submitFuelPurchaseButton = this.findViewById(R.id.fuel_log_submit_button);
        submitFuelPurchaseButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AddFuelPurchaseActivity.this, FuelLogMenuActivity.class);
                double totalCost = Double.valueOf(totalCostTextView.getText().toString());
                double pricePerLitre = Double.valueOf(fuelPriceTextView.getText().toString());
                double fuelAmount = Double.valueOf(fuelAmountTextView.getText().toString());
                int odometer = Integer.valueOf(odometerReadingTextView.getText().toString());
                SelectVehicleActivity.getTempVehicle().addFuelTransaction(fillUpLocationTextView.getText().toString(), totalCost, pricePerLitre, fuelAmount, odometer);
                startActivity(intent);
            }
        });



    }
}
