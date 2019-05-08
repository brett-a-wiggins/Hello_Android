package com.example.hello_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ViewFuelPurchasesActivity extends AppCompatActivity {
    private RecyclerView fuelPurchaseRecycleList;
    private RecyclerView.Adapter fuelListAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fuel_purchases);
        fuelPurchaseRecycleList = (RecyclerView) findViewById(R.id.fuel_purchases_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        fuelPurchaseRecycleList.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        fuelPurchaseRecycleList.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        fuelListAdapter = new FuelViewAdapter(SelectVehicleActivity.getTempVehicle().getFuelTransList());
        fuelPurchaseRecycleList.setAdapter(fuelListAdapter);
    }
    // ...
}


