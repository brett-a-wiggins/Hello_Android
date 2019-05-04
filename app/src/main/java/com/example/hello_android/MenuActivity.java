package com.example.hello_android;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    private Button selectVehicleButton;
    private Button addNewVehicleMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        selectVehicleButton = findViewById(R.id.select_vehicle_button);
        selectVehicleButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,SelectVehicleActivity.class);
                startActivity(intent);
            }
        });

        addNewVehicleMenuButton = findViewById(R.id.add_new_vehicle_menu_button);
        addNewVehicleMenuButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,AddNewVehicle.class);
                startActivity(intent);
            }
        });
    }
}
