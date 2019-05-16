package com.example.hello_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ViewFuelStatisticsActivity extends Activity {
    private RecyclerView fuelStatRecycler;
    private TextView text;
    private Button dateSortButton;
    private Button locationSortButton;
    private Button priceLitreSortButton;
    private Button totalCostSortButton;
    private Button litresSortButton;
    private Button searchButton;
    private SearchView fuelStatSearchView;
    //private static FuelTransaction searchedFuelTrans;
    private static ArrayList<FuelTransaction> tempFuelList = new ArrayList<>(SelectVehicleActivity.getTempVehicle().getFuelTransList());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_statistics_view);

        final ArrayList<FuelTransaction> data = SelectVehicleActivity.getTempVehicle().getFuelTransList();


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fuel_stat_recycler);
        Recycler_View_Adapter_Fuel_Statistics adapter = new Recycler_View_Adapter_Fuel_Statistics(data, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dateSortButton = findViewById(R.id.date_sort_button);
        locationSortButton = findViewById(R.id.location_sort_button);
        priceLitreSortButton = findViewById(R.id.price_litre_sort_button);
        totalCostSortButton = findViewById(R.id.total_cost_sort_button);
        litresSortButton = findViewById(R.id.litres_sort_button);
        searchButton = findViewById(R.id.search_button);
        fuelStatSearchView = findViewById(R.id.fuelstat_searchview);


        searchButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                if (!fuelStatSearchView.getQuery().toString().isEmpty()) {
                    tempFuelList = searchList(data, fuelStatSearchView.getQuery().toString());
                    Intent intent = new Intent(ViewFuelStatisticsActivity.this, SearchResultsActivity.class);
                    startActivity(intent);
                }
            }
        });

        locationSortButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                sortListByLocation(data);
                Intent intent = new Intent(ViewFuelStatisticsActivity.this, ViewFuelStatisticsActivity.class);
                startActivity(intent);
            }
        });

        dateSortButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                sortListByDate(data);
                Intent intent = new Intent(ViewFuelStatisticsActivity.this, ViewFuelStatisticsActivity.class);
                startActivity(intent);
            }
        });

        priceLitreSortButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                sortListByPriceLitre(data);
                Intent intent = new Intent(ViewFuelStatisticsActivity.this, ViewFuelStatisticsActivity.class);
                startActivity(intent);
            }
        });

        litresSortButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                sortListByLitres(data);
                Intent intent = new Intent(ViewFuelStatisticsActivity.this, ViewFuelStatisticsActivity.class);
                startActivity(intent);
            }
        });

        totalCostSortButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                sortListByTotalCost(data);
                Intent intent = new Intent(ViewFuelStatisticsActivity.this, ViewFuelStatisticsActivity.class);
                startActivity(intent);
            }
        });


    }
    public static ArrayList<FuelTransaction> getTempFuelList(){
        return tempFuelList;
    }

    public ArrayList<FuelTransaction> searchList (ArrayList<FuelTransaction> tempFuelList, String searchTerm) {
        ArrayList<FuelTransaction> matchingList = new ArrayList<>();
        for (int i = 0; i < tempFuelList.size(); i++) {
            if (tempFuelList.get(i).getLocation().toLowerCase().contains(searchTerm) || tempFuelList.get(i).getTransactionDate().toLowerCase().contains(searchTerm) || String.valueOf(tempFuelList.get(i).getPricePerLitre()).toLowerCase().contains(searchTerm) || String.valueOf(tempFuelList.get(i).getLitres()).toLowerCase().contains(searchTerm) || String.valueOf(tempFuelList.get(i).getFuelTotal()).toLowerCase().contains(searchTerm)) {
                matchingList.add(tempFuelList.get(i));
            }
        }
        return matchingList;
    }

    public void sortListByLocation(ArrayList<FuelTransaction> tempFuelTransactions) {
        Collections.sort(tempFuelTransactions, new Comparator<FuelTransaction>() {
            @Override
            public int compare(FuelTransaction o1, FuelTransaction o2) {
                return o1.getLocation().compareTo(o2.getLocation());
            }
        });
    }

    public void sortListByDate(ArrayList<FuelTransaction> tempFuelTransactions) {
        Collections.sort(tempFuelTransactions, new Comparator<FuelTransaction>() {
            @Override
            public int compare(FuelTransaction o1, FuelTransaction o2) {
                return o1.getTransactionDate().compareTo(o2.getTransactionDate());
            }
        });
    }

    public void sortListByPriceLitre(ArrayList<FuelTransaction> tempFuelTransactions) {
        Collections.sort(tempFuelTransactions, new Comparator<FuelTransaction>() {
            @Override
            public int compare(FuelTransaction o1, FuelTransaction o2) {
                if (o1.getPricePerLitre() > o2.getPricePerLitre()) {
                    return 1;
                }
                if (o1.getPricePerLitre() < o2.getPricePerLitre()){
                    return -1;
                }
                return 0;
            }
        });
    }

    public void sortListByLitres(ArrayList<FuelTransaction> tempFuelTransactions) {
        Collections.sort(tempFuelTransactions, new Comparator<FuelTransaction>() {
            @Override
            public int compare(FuelTransaction o1, FuelTransaction o2) {
                if (o1.getLitres() > o2.getLitres()) {
                    return 1;
                }
                if (o1.getLitres() < o2.getLitres()){
                    return -1;
                }
                return 0;
            }
        });
    }

    public void sortListByTotalCost(ArrayList<FuelTransaction> tempFuelTransactions) {
        Collections.sort(tempFuelTransactions, new Comparator<FuelTransaction>() {
            @Override
            public int compare(FuelTransaction o1, FuelTransaction o2) {
                if (o1.getFuelTotal() > o2.getFuelTotal()) {
                    return 1;
                }
                if (o1.getFuelTotal() < o2.getFuelTotal()){
                    return -1;
                }
                return 0;
            }
        });
    }


}

// Old redundant code:
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
