package com.example.hello_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
                Date serviceDate = new Date();
                Date nextServiceDate = new Date();
                String servDate = serviceDateTextView.getText().toString();
                SimpleDateFormat servInput = new SimpleDateFormat("dd/MM/yy");
                try {
                    serviceDate = servInput.parse(servDate);                 // parse input
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String nextServDate = serviceDateTextView.getText().toString();
                SimpleDateFormat nextServInput = new SimpleDateFormat("dd/MM/yy");
                try {
                    nextServiceDate = nextServInput.parse(nextServDate);                 // parse input
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                double laborCost = Double.valueOf(laborCostTextView.getText().toString());
                double partCost = Double.valueOf(partCostTextView.getText().toString());
                int nextServiceOdometer = Integer.valueOf(nextOdometerTextView.getText().toString());
                SelectVehicleActivity.getTempVehicle().addServiceTransaction(serviceDate, nextServiceDate, laborCost, partCost, nextServiceOdometer);
                startActivity(intent);
            }
        });

    }
}

