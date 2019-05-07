package com.example.hello_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FuelLogMenuActivity extends AppCompatActivity {
    private Button addFuelPurchaseButton;
    private Button viewFuelPurchasesButton;
    private Button removeFuelPurchaseButton;
    private Button viewFuelStatisticsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_log_menu);

        addFuelPurchaseButton = this.findViewById(R.id.add_fuel_purchase_button);
        addFuelPurchaseButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FuelLogMenuActivity.this, AddFuelPurchaseActivity.class);
                startActivity(intent);
            }
        });

        viewFuelPurchasesButton = this.findViewById(R.id.view_fuel_purchases_button);
        viewFuelPurchasesButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent( FuelLogMenuActivity.this, ViewFuelPurchasesActivity.class);
                startActivity(intent);
            }
        });

        removeFuelPurchaseButton = this.findViewById(R.id.remove_fuel_purchase_button);
        removeFuelPurchaseButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent( FuelLogMenuActivity.this, RemoveFuelPurchaseActivity.class);
                startActivity(intent);
            }
        });

        viewFuelStatisticsButton = this.findViewById(R.id.view_fuel_statistics_button);
        viewFuelStatisticsButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent( FuelLogMenuActivity.this, ViewFuelStatisticsActivity.class);
                startActivity(intent);
            }
        });

    }
}
