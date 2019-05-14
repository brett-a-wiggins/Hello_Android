package com.example.hello_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewFuelStatisticsActivity extends AppCompatActivity {
    private RecyclerView fuelStatRecycler;
    private TextView text;

//    private ListView dateListView;
//    private ListView locationListView;
//    private ListView pricePerLitreListView;
//    private ListView litresListView;
//    private ListView fuelCostListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_statistics_view);
        //fuelStatRecycler = findViewById(R.id.fuel_stat_recycler);

        ArrayList<FuelTransaction> data = SelectVehicleActivity.getTempVehicle().getFuelTransList();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fuel_stat_recycler);
        Recycler_View_Adapter adapter = new Recycler_View_Adapter(data, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


//        dateListView = findViewById(R.id.date_listview);
//        locationListView = findViewById(R.id.location_listview);
//        pricePerLitreListView = findViewById(R.id.priceperlitre_listvieew);
//        litresListView = findViewById(R.id.litres_listview);
//        fuelCostListView = findViewById(R.id.fuelcost_listview);
//
//
//        ArrayAdapter fuelDateAdapter = new ArrayAdapter(this, R.layout.fuelstat_listview, populateFuelDateList());
//        fuelDateAdapter.setDropDownViewResource(R.layout.fuelstat_listview);
//
//        dateListView.setAdapter(fuelDateAdapter);
//        dateListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                // When clicked, show a toast with the TextView text
//                Toast.makeText(getApplicationContext(),
//                        ((TextView) view).getText(), Toast.LENGTH_LONG).show();
//            }
//        });
//
//        ArrayAdapter fuelLocationAdapter = new ArrayAdapter(this, R.layout.fuelstat_listview, populateFuelLocationList());
//        fuelLocationAdapter.setDropDownViewResource(R.layout.fuelstat_listview);
//
//        locationListView.setAdapter(fuelLocationAdapter);
//        locationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                // When clicked, show a toast with the TextView text
//                Toast.makeText(getApplicationContext(),
//                        ((TextView) view).getText(), Toast.LENGTH_LONG).show();
//            }
//        });
//
//        ArrayAdapter fuelPricePerLitreAdapter = new ArrayAdapter(this, R.layout.fuelstat_listview, populateFuelPricePerLitreList());
//        fuelPricePerLitreAdapter.setDropDownViewResource(R.layout.fuelstat_listview);
//
//        pricePerLitreListView.setAdapter(fuelPricePerLitreAdapter);
//        pricePerLitreListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                // When clicked, show a toast with the TextView text
//                Toast.makeText(getApplicationContext(),
//                        ((TextView) view).getText(), Toast.LENGTH_LONG).show();
//            }
//        });
//
//        ArrayAdapter fuelLitresAdapter = new ArrayAdapter(this, R.layout.fuelstat_listview, populateFuelLitresList());
//        fuelLitresAdapter.setDropDownViewResource(R.layout.fuelstat_listview);
//
//        litresListView.setAdapter(fuelLitresAdapter);
//        litresListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                // When clicked, show a toast with the TextView text
//                Toast.makeText(getApplicationContext(),
//                        ((TextView) view).getText(), Toast.LENGTH_LONG).show();
//            }
//        });
//
//        ArrayAdapter fuelFuelCostAdapter = new ArrayAdapter(this, R.layout.fuelstat_listview, populateFuelFuelCostList());
//        fuelFuelCostAdapter.setDropDownViewResource(R.layout.fuelstat_listview);
//
//        fuelCostListView.setAdapter(fuelFuelCostAdapter);
//        fuelCostListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                // When clicked, show a toast with the TextView text
//                Toast.makeText(getApplicationContext(),
//                        ((TextView) view).getText(), Toast.LENGTH_LONG).show();
//            }
//        });
//
//        dateListView.setClickable(false);
//        locationListView.setClickable(false);
//        pricePerLitreListView.setClickable(false);
//        litresListView.setClickable(false);
//        fuelCostListView.setClickable(false);
//        fuelStatLinear.setClickable(false);
//
//    }
//
//
//    public ArrayList<String> populateFuelDateList() {
//        ArrayList<String> fuelDateList = new ArrayList<>();
//        for (int i = 0; i < SelectVehicleActivity.getTempVehicle().getFuelTransList().size(); i++) {
//            ArrayList<FuelTransaction> tempFuelList = SelectVehicleActivity.getTempVehicle().getFuelTransList();
//            fuelDateList.add(tempFuelList.get(i).getTransactionDate().toString());
//        }
//        return fuelDateList;
//    }
//
//    public ArrayList<String> populateFuelLocationList() {
//        ArrayList<String> fuelLocationList = new ArrayList<>();
//        for (int i = 0; i < SelectVehicleActivity.getTempVehicle().getFuelTransList().size(); i++) {
//            ArrayList<FuelTransaction> tempFuelList = SelectVehicleActivity.getTempVehicle().getFuelTransList();
//            fuelLocationList.add(tempFuelList.get(i).getLocation());
//        }
//        return fuelLocationList;
//    }
//
//    public ArrayList<Double> populateFuelPricePerLitreList() {
//        ArrayList<Double> fuelPricePerLitreList = new ArrayList<>();
//        for (int i = 0; i < SelectVehicleActivity.getTempVehicle().getFuelTransList().size(); i++) {
//            ArrayList<FuelTransaction> tempFuelList = SelectVehicleActivity.getTempVehicle().getFuelTransList();
//            fuelPricePerLitreList.add(Double.valueOf(tempFuelList.get(i).getPricePerLitre()));
//        }
//        return fuelPricePerLitreList;
//    }
//
//    public ArrayList<Double> populateFuelLitresList() {
//        ArrayList<Double> fuelLitresList = new ArrayList<>();
//        for (int i = 0; i < SelectVehicleActivity.getTempVehicle().getFuelTransList().size(); i++) {
//            ArrayList<FuelTransaction> tempFuelList = SelectVehicleActivity.getTempVehicle().getFuelTransList();
//            fuelLitresList.add(Double.valueOf(tempFuelList.get(i).getLitres()));
//        }
//        return fuelLitresList;
//    }
//
//    public ArrayList<Double> populateFuelFuelCostList() {
//        ArrayList<Double> fuelFuelCostList = new ArrayList<>();
//        for (int i = 0; i < SelectVehicleActivity.getTempVehicle().getFuelTransList().size(); i++) {
//            ArrayList<FuelTransaction> tempFuelList = SelectVehicleActivity.getTempVehicle().getFuelTransList();
//            fuelFuelCostList.add(Double.valueOf(tempFuelList.get(i).getFuelTotal()));
//        }
//        return fuelFuelCostList;
//    }

    }
}
