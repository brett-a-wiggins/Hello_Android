package com.example.hello_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddNewVehicle extends AppCompatActivity {
    private Button addNewCarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_vehicle);

        addNewCarButton =  findViewById(R.id.addNewCarButton);
        addNewCarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddNewVehicle.this,AddNewCar.class);
                startActivity(intent);
            }
        });
    }
}
