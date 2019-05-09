package com.example.hello_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewFuelPurchasesActivity extends AppCompatActivity {
   private ListView fuelPurchaseListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fuel_purchases);
        fuelPurchaseListView = findViewById(R.id.fuel_purchases_listview);
        ArrayAdapter fuelPurchasesAdapter = new ArrayAdapter(this,  android.R.layout.simple_expandable_list_item_1, populateFuelPurchasesList());
        fuelPurchasesAdapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);

        fuelPurchaseListView.setAdapter(fuelPurchasesAdapter);

    }

    public ArrayList<String> populateFuelPurchasesList() {
        ArrayList<String> fuelPurchasesList = new ArrayList<>();
        for (int i = 0; i < SelectVehicleActivity.getTempVehicle().getFuelTransList().size(); i++) {
            ArrayList<FuelTransaction> tempFuelList = SelectVehicleActivity.getTempVehicle().getFuelTransList();
            fuelPurchasesList.add(tempFuelList.get(i).getFuelTransactionString());
        }
        return fuelPurchasesList;
    }
    // ...
}


