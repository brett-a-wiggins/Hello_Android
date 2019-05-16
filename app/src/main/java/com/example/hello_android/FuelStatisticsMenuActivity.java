package com.example.hello_android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class FuelStatisticsMenuActivity extends AppCompatActivity {

    private Button viewByDate;
    private Button viewByLocation;
    private Button viewAll;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_statistics_menu);

    }
}
