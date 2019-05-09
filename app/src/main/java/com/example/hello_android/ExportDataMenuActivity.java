package com.example.hello_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ExportDataMenuActivity extends AppCompatActivity {
    private Button export_button;
    private PrintWriter writer;
    private VehicleOwner current_owner;
    private Vehicle current_vehicle;
    private ArrayList<FuelTransaction> mFuelTransactions;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_export_data_menu);
        export_button = findViewById(R.id.export_to_csv_button);
        export_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_vehicle = SelectVehicleActivity.getTempVehicle();
                mFuelTransactions = current_vehicle.getFuelTransList();
                try {
                    writer = new PrintWriter(new File("guzzle.csv"));
                    StringBuilder sb = new StringBuilder();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });


    }


}
