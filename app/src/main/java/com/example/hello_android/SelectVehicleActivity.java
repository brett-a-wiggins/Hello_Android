package com.example.hello_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SelectVehicleActivity extends AppCompatActivity {
    private Button chooseVehicleButton;
    private Spinner vehicleSelectSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_vehicle);

        vehicleSelectSpinner = this.findViewById(R.id.vehicle_select_spinner);
        ArrayAdapter userListAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tempOwner.getVehicleList());
        userListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        vehicleSelectSpinner.setAdapter(userListAdapter);



        chooseVehicleButton = findViewById(R.id.select_vehicle_button);
        chooseVehicleButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SelectVehicleActivity.this, MainVehicleMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
