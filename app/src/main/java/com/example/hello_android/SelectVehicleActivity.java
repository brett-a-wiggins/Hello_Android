package com.example.hello_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class SelectVehicleActivity extends AppCompatActivity {
    private Button chooseVehicleButton;
    private Spinner vehicleSelectSpinner;
    private VehicleOwner tempOwner;
    private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_vehicle);
        Bundle vehicleMenuActivityBundle = this.getIntent().getExtras();
        //this.vehicleList = (ArrayList<Vehicle>) vehicleMenuActivityBundle.getParcelable("vehicleList");
        this.tempOwner = (VehicleOwner) vehicleMenuActivityBundle.getParcelable("tempOwner");
        this.vehicleList = this.tempOwner.getVehicleList();
        vehicleList.add(new Car("444-666-J", 170000));


        vehicleSelectSpinner = this.findViewById(R.id.vehicle_select_spinner);
        ArrayAdapter vehicleListAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, this.vehicleList);
        vehicleListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        vehicleSelectSpinner.setAdapter(vehicleListAdapter);




        chooseVehicleButton = findViewById(R.id.choose_vehicle_button);
        chooseVehicleButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SelectVehicleActivity.this, MainVehicleMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
