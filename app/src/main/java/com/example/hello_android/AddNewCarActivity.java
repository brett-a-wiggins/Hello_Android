package com.example.hello_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class AddNewCarActivity extends AppCompatActivity {
    private Button addCarButton2;
    private TextView registrationInput;
    private TextView odometerInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_car);


        registrationInput = findViewById(R.id.registrationInput);
        odometerInput = findViewById(R.id.odometerInput);


        addCarButton2 =  findViewById(R.id.addCarButton2);
        addCarButton2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String registration = registrationInput.getText().toString();
                int odometer = Integer.valueOf(odometerInput.getText().toString());
                ExistingUserActivity.getTempOwner().addNewCar(registration, odometer);
                Intent intent = new Intent(AddNewCarActivity.this, SelectVehicleMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
