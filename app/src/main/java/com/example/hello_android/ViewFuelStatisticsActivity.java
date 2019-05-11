package com.example.hello_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewFuelStatisticsActivity extends AppCompatActivity {
    private TableLayout fuelStatTable;
    private TableRow fuelStatRow1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fuel_statistics);

        fuelStatTable = (TableLayout) findViewById(R.id.fuel_stat_table);
        ArrayList<FuelTransaction> tempFuelList = SelectVehicleActivity.getTempVehicle().getFuelTransList();

        for(FuelTransaction fuelTrans:tempFuelList){


            fuelStatRow1 = new TableRow(ViewFuelStatisticsActivity.this);

            TextView date = new  TextView(ViewFuelStatisticsActivity.this);
            date.setTextSize(10);
            date.setText(String.valueOf(fuelTrans.getTransactionDate()));
            fuelStatRow1.addView(date);

            TextView location = new  TextView(ViewFuelStatisticsActivity.this);
            location.setTextSize(10);
            location.setText(String.valueOf(fuelTrans.getLocation()));
            fuelStatRow1.addView(location);

            TextView pricePerLitre = new  TextView(ViewFuelStatisticsActivity.this);
            pricePerLitre.setText(String.valueOf(fuelTrans.getPricePerLitre()));
            pricePerLitre.setTextSize(10);
            fuelStatRow1.addView(pricePerLitre);

            TextView litres = new  TextView(ViewFuelStatisticsActivity.this);
            litres.setText(String.valueOf(fuelTrans.getLitres()));
            fuelStatRow1.addView(litres);
            litres.setTextSize(10);

            fuelStatTable.addView(fuelStatRow1);
        }
    }
}
