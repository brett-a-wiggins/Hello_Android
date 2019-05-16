package com.example.hello_android;

import android.app.Activity;
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

        SelectVehicleActivity.getTempVehicle().getFuelTransList().add(new FuelTransaction("BP Petrol Station", 25.50, 1.30, 5, 187000));
        SelectVehicleActivity.getTempVehicle().getFuelTransList().add(new FuelTransaction("Shell Petrol Station", 27.50, 1.25, 12, 423000));
        SelectVehicleActivity.getTempVehicle().getFuelTransList().add(new FuelTransaction("Caltex Petrol", 15.50, 1.60, 3, 121000));
        SelectVehicleActivity.getTempVehicle().getFuelTransList().add(new FuelTransaction("7/11 Service Station", 54.50, 1.75, 22, 243000));


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
