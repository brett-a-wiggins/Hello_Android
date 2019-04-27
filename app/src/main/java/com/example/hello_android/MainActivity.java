package com.example.hello_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mSavedVehicleButton;
    private Button mNewVehicleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSavedVehicleButton =  findViewById(R.id.saved_vehicle_button);
        mSavedVehicleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mNewVehicleButton =  findViewById(R.id.add_new_vehicle_button);
        mNewVehicleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
