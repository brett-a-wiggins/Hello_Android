package com.example.hello_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ServiceLogMenuActivity extends AppCompatActivity {
    private Button addNewServiceButton;
    private Button viewServicesButton;
    private Button removeServicesButton;
    private Button serviceStatisticsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_log_menu);

        addNewServiceButton = this.findViewById(R.id.add_new_service_button);
        addNewServiceButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ServiceLogMenuActivity.this, AddNewServiceActivity.class);
                startActivity(intent);
            }
        });

        viewServicesButton = this.findViewById(R.id.view_services_button);
        viewServicesButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ServiceLogMenuActivity.this, ViewServicesActivity.class);
                startActivity(intent);
            }
        });

        removeServicesButton = this.findViewById(R.id.remove_service_button);
        removeServicesButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ServiceLogMenuActivity.this, RemoveServiceActivity.class);
                startActivity(intent);
            }
        });

        serviceStatisticsButton = this.findViewById(R.id.service_statistics_button);
        serviceStatisticsButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ServiceLogMenuActivity.this, ServiceStatisticsMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
