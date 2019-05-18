package com.example.hello_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.InputMismatchException;


public class AddNewCarActivity extends AppCompatActivity {
    private Button addCarButton2;
    private TextView registrationInput;
    private TextView odometerInput;
    private String registration;
    private int odometer;


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

                try {
                    registration = registrationInput.getText().toString();
                    if (registration.matches("")) {
                        Toast.makeText(getApplicationContext(), "You did not enter a registration", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (odometerInput.getText().toString().trim().isEmpty()) {
                        Toast.makeText(getApplicationContext(), "You did not enter an odometer value", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        odometer = Integer.valueOf(odometerInput.getText().toString());
                    }

                    ExistingUserActivity.getTempOwner().addNewCar(registration, odometer);
                    Intent intent = new Intent(AddNewCarActivity.this, SelectVehicleMenuActivity.class);
                    startActivity(intent);
                } catch (InputMismatchException e) {
                    Toast.makeText(getApplicationContext(),
                           e.getMessage(), Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}
