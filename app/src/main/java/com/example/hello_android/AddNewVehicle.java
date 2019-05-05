package com.example.hello_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class AddNewVehicle extends AppCompatActivity {
    private Button addNewCarButton;
    private VehicleOwner tempOwner;
    private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_vehicle);

        Bundle vehicleMenuActivityBundle = this.getIntent().getExtras();
        this.tempOwner = (VehicleOwner) vehicleMenuActivityBundle.getParcelable("tempOwner");
        this.vehicleList = this.tempOwner.getVehicleList();

        addNewCarButton =  findViewById(R.id.addNewCarButton);
        addNewCarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddNewVehicle.this,AddNewCar.class);
                intent.putParcelableArrayListExtra("vehicleList", tempOwner.getVehicleList());
                intent.putExtra("tempOwner", tempOwner);
                startActivity(intent);
            }
        });
    }
}
