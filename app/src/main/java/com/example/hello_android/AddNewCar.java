package com.example.hello_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class AddNewCar extends AppCompatActivity {
    private Button addCarButton2;
    private TextView registrationInput;
    private TextView odometerInput;
    private VehicleOwner tempOwner;
    private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_car);
        Bundle vehicleMenuActivityBundle = this.getIntent().getExtras();
        this.tempOwner = (VehicleOwner) vehicleMenuActivityBundle.getParcelable("tempOwner");
        this.vehicleList = this.tempOwner.getVehicleList();

        registrationInput = findViewById(R.id.registrationInput);
        odometerInput = findViewById(R.id.odometerInput);

        addCarButton2 =  findViewById(R.id.addCarButton2);
        addCarButton2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String registration = registrationInput.getText().toString();
                int odometer = Integer.valueOf(odometerInput.getText().toString());
                vehicleList.add(new Car(registration, odometer));
                Intent intent = new Intent(AddNewCar.this, VehicleMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
