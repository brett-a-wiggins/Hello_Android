package com.example.hello_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainSecondActivity extends AppCompatActivity {
    private Button mSavedVehicleButton;
    private Button mNewVehicleButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second);

        mSavedVehicleButton =  findViewById(R.id.saved_vehicle_button);
        mSavedVehicleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainSecondActivity.this, VehicleMenuActivity.class);
                startActivity(intent);
            }
        });
        mNewVehicleButton =  findViewById(R.id.add_new_vehicle_button);
        mNewVehicleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainSecondActivity.this, AddNewVehicleActivity.class);
                startActivity(intent);
            }
        });
    }
}
