package com.example.hello_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AddNewServiceActivity extends Activity {
    private Button submitServiceButton;
    private TextView serviceDateTextView;
    private TextView nextServiceTextView;
    private TextView laborCostTextView;
    private TextView partCostTextView;
    private TextView nextOdometerTextView;
    private SimpleDateFormat format1 = new SimpleDateFormat("ddMMyy");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_service);

        serviceDateTextView = findViewById(R.id.transaction_date_textview);
        nextServiceTextView = findViewById(R.id.next_service_date_textview);
        laborCostTextView = findViewById(R.id.laborcost_textview);
        partCostTextView = findViewById(R.id.partcost_textview);
        nextOdometerTextView = findViewById(R.id.next_service_odometer);

        submitServiceButton = findViewById(R.id.submit_service_button);
        submitServiceButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AddNewServiceActivity.this, ServiceLogMenuActivity.class);
                double laborCost = 0, partCost = 0;
                int nextServiceOdometer = 0;
                String servDate = serviceDateTextView.getText().toString();

                if (serviceDateTextView.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "You did not enter a service date", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (serviceDateTextView.getText().toString().length() > 6 || serviceDateTextView.getText().toString().length() <= 0){
                    Toast.makeText(getApplicationContext(), "Service date is not equal to six numbers", Toast.LENGTH_SHORT).show();
                    return;
                }
                String nextServDate = nextServiceTextView.getText().toString();
                if (nextServDate.matches("")) {
                    Toast.makeText(getApplicationContext(), "You did not enter a next service date", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (nextServDate.length() > 6 || nextServDate.length() <= 0){
                    Toast.makeText(getApplicationContext(), "Next Service date is not equal to six numbers", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (laborCostTextView.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "You did not enter a labor cost", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    laborCost = Double.valueOf(laborCostTextView.getText().toString());
                }
//                double laborCost = Double.valueOf(laborCostTextView.getText().toString());
                if (partCostTextView.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "You did not enter a part cost", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    partCost = Double.valueOf(partCostTextView.getText().toString());
                }
//                double partCost = Double.valueOf(partCostTextView.getText().toString());
                if (nextOdometerTextView.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "You did not enter an odometer", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    nextServiceOdometer = Integer.valueOf(nextOdometerTextView.getText().toString());
                }
//                int nextServiceOdometer = Integer.valueOf(nextOdometerTextView.getText().toString());
                try {
                    SelectVehicleActivity.getTempVehicle().addServiceTransaction(format1.parse(servDate), format1.parse(nextServDate), laborCost, partCost, nextServiceOdometer);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                startActivity(intent);
            }
        });

    }
}

