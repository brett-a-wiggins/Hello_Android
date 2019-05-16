package com.example.hello_android;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class SearchResultsActivity extends Activity {
    private RecyclerView searchRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        final ArrayList<FuelTransaction> data = ViewFuelStatisticsActivity.getTempFuelList();


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.search_recycler_view);
        Recycler_View_Adapter_Fuel_Statistics adapter = new Recycler_View_Adapter_Fuel_Statistics(data, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
