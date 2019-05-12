package com.example.hello_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewFuelStatisticsActivity extends AppCompatActivity {
    private LinearLayout fuelStatLinear;

    private ListView dateListView;
    private ListView locationListView;
    private ListView pricePerLitreListView;
    private ListView litresListView;
    private ListView fuelCostListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fuel_statistics);
        fuelStatLinear = findViewById(R.id.fuel_stat_linear);
        dateListView = findViewById(R.id.date_list_view);
        locationListView = findViewById(R.id.location_listview);
        pricePerLitreListView = findViewById(R.id.priceperlitre_listvieew);
        litresListView = findViewById(R.id.litres_listview);
        fuelCostListView = findViewById(R.id.fuelcost_listview);


        ArrayAdapter fuelDateAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, populateFuelDateList());
        fuelDateAdapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);

        dateListView.setAdapter(fuelDateAdapter);
        dateListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_LONG).show();
            }
        });

        ArrayAdapter fuelLocationAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, populateFuelLocationList());
        fuelLocationAdapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);

        locationListView.setAdapter(fuelLocationAdapter);
        locationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_LONG).show();
            }
        });

        ArrayAdapter fuelPricePerLitreAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, populateFuelPricePerLitreList());
        fuelPricePerLitreAdapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);

        pricePerLitreListView.setAdapter(fuelPricePerLitreAdapter);
        pricePerLitreListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_LONG).show();
            }
        });

        ArrayAdapter fuelLitresAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, populateFuelLitresList());
        fuelLitresAdapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);

        litresListView.setAdapter(fuelLitresAdapter);
        litresListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_LONG).show();
            }
        });

        ArrayAdapter fuelFuelCostAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, populateFuelFuelCostList());
        fuelFuelCostAdapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);

        fuelCostListView.setAdapter(fuelFuelCostAdapter);
        fuelCostListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_LONG).show();
            }
        });

    }


    public ArrayList<String> populateFuelDateList() {
        ArrayList<String> fuelDateList = new ArrayList<>();
        for (int i = 0; i < SelectVehicleActivity.getTempVehicle().getFuelTransList().size(); i++) {
            ArrayList<FuelTransaction> tempFuelList = SelectVehicleActivity.getTempVehicle().getFuelTransList();
            fuelDateList.add(tempFuelList.get(i).getTransactionDate().toString());
        }
        return fuelDateList;
    }

    public ArrayList<String> populateFuelLocationList() {
        ArrayList<String> fuelLocationList = new ArrayList<>();
        for (int i = 0; i < SelectVehicleActivity.getTempVehicle().getFuelTransList().size(); i++) {
            ArrayList<FuelTransaction> tempFuelList = SelectVehicleActivity.getTempVehicle().getFuelTransList();
            fuelLocationList.add(tempFuelList.get(i).getLocation());
        }
        return fuelLocationList;
    }

    public ArrayList<Double> populateFuelPricePerLitreList() {
        ArrayList<Double> fuelPricePerLitreList = new ArrayList<>();
        for (int i = 0; i < SelectVehicleActivity.getTempVehicle().getFuelTransList().size(); i++) {
            ArrayList<FuelTransaction> tempFuelList = SelectVehicleActivity.getTempVehicle().getFuelTransList();
            fuelPricePerLitreList.add(Double.valueOf(tempFuelList.get(i).getPricePerLitre()));
        }
        return fuelPricePerLitreList;
    }

    public ArrayList<Double> populateFuelLitresList() {
        ArrayList<Double> fuelLitresList = new ArrayList<>();
        for (int i = 0; i < SelectVehicleActivity.getTempVehicle().getFuelTransList().size(); i++) {
            ArrayList<FuelTransaction> tempFuelList = SelectVehicleActivity.getTempVehicle().getFuelTransList();
            fuelLitresList.add(Double.valueOf(tempFuelList.get(i).getLitres()));
        }
        return fuelLitresList;
    }

    public ArrayList<Double> populateFuelFuelCostList() {
        ArrayList<Double> fuelFuelCostList = new ArrayList<>();
        for (int i = 0; i < SelectVehicleActivity.getTempVehicle().getFuelTransList().size(); i++) {
            ArrayList<FuelTransaction> tempFuelList = SelectVehicleActivity.getTempVehicle().getFuelTransList();
            fuelFuelCostList.add(Double.valueOf(tempFuelList.get(i).getFuelTotal()));
        }
        return fuelFuelCostList;
    }

}
