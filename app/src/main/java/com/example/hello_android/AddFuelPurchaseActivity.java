package com.example.hello_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

public class AddFuelPurchaseActivity extends Activity {
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
                double totalCost = 0, pricePerLitre = 0, fuelAmount = 0;
                int odometer = 0;

                Intent intent = new Intent(AddFuelPurchaseActivity.this, FuelLogMenuActivity.class);
                if (fuelPriceTextView.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "You did not enter a price per litre", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    pricePerLitre = Double.valueOf(fuelPriceTextView.getText().toString());
                }
                if (fuelAmountTextView.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "You did not enter amount of litres", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    fuelAmount = Double.valueOf(fuelAmountTextView.getText().toString());
                }
                String location = fillUpLocationTextView.getText().toString();
                if (location.matches("")) {
                    Toast.makeText(getApplicationContext(), "You did not enter a location", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (odometerReadingTextView.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "You did not enter an odometer", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    odometer = Integer.valueOf(odometerReadingTextView.getText().toString());
                }
                if (totalCostTextView.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "You did not enter a total cost", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    totalCost = Double.valueOf(totalCostTextView.getText().toString());
                }



                SelectVehicleActivity.getTempVehicle().addFuelTransaction(location, totalCost, pricePerLitre, fuelAmount, odometer);
                startActivity(intent);
            }
        });



    }
}
