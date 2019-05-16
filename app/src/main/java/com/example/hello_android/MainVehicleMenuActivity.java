package com.example.hello_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainVehicleMenuActivity extends AppCompatActivity {
    private Button fuelLogMenuButton;
    private Button serviceLogMenuButton;
    private Button receiptStorageButton;
    private Button exportDataButton;
    private Button dataAnalyticsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_vehicle_menu);

        fuelLogMenuButton = this.findViewById(R.id.fuel_log_menu_button);
        fuelLogMenuButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainVehicleMenuActivity.this, FuelLogMenuActivity.class);
                startActivity(intent);
            }
        });

        serviceLogMenuButton = this.findViewById(R.id.service_log_menu_button);
        serviceLogMenuButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainVehicleMenuActivity.this, ServiceLogMenuActivity.class);
                startActivity(intent);
            }
        });

        receiptStorageButton = this.findViewById(R.id.receipt_storage_menu_button);
        receiptStorageButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainVehicleMenuActivity.this, ReceiptStorageMenuActivity.class);
                startActivity(intent);
            }
        });


        exportDataButton = this.findViewById(R.id.export_data_menu_button);
        exportDataButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainVehicleMenuActivity.this, ExportDataMenuActivity.class);
                startActivity(intent);
            }
        });


        dataAnalyticsButton = this.findViewById(R.id.data_analytics_button);
        dataAnalyticsButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainVehicleMenuActivity.this, DataAnalyticsActivity.class);
                startActivity(intent);
            }
        });



    }
}
