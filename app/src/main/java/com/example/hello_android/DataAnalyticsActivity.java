package com.example.hello_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAnalyticsActivity extends AppCompatActivity {
    private TextView averageFuelPriceTextView;
    private TextView averageLitresTextView;
    private TextView averageTotalCostTextView;
    private TextView kilometersTravelledTextView;
    private TextView totalSpentOnFuelTextView;
    private TextView totalLitresPurchasedTextView;
    private TextView averageServiceCostTextView;
    private TextView totalSpentOnServicesTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_analytics_view);

        averageFuelPriceTextView = (TextView) findViewById(R.id.average_fuel_price_text_view);
        averageLitresTextView = findViewById(R.id.average_litres_textview);
        averageTotalCostTextView = findViewById(R.id.average_total_cost_textview);
        kilometersTravelledTextView = findViewById(R.id.total_spent_on_fuel_textview);
        totalSpentOnFuelTextView = findViewById(R.id.total_spent_on_fuel_textview);
        totalLitresPurchasedTextView = findViewById(R.id.total_litres_purchased_textview);
        averageServiceCostTextView = findViewById(R.id.average_service_cost_textview);
        totalSpentOnServicesTextView = findViewById(R.id.service_total_textview);
        setTextViews();

    }

    public void setTextViews() {
        ArrayList<FuelTransaction> data = SelectVehicleActivity.getTempVehicle().getFuelTransList();
        ArrayList<ServiceTransaction> serviceData = SelectVehicleActivity.getTempVehicle().getServiceTransList();
        averageFuelPriceTextView.setText(String.format("$%.2f", getAverageFuelPrice(data)));
        averageLitresTextView.setText(String.format("%.2f", getAverageLitresPurchased(data)));
        averageTotalCostTextView.setText(String.format("$%.2f", getAverageTotalCost(data)));
        kilometersTravelledTextView.setText(String.format("%6d" , getKilometersTravelled(SelectVehicleActivity.getTempVehicle())));
        totalSpentOnFuelTextView.setText(String.format("$%.2f", getTotalSpentOnFuel(data)));
        totalLitresPurchasedTextView.setText(String.format("%.2f", getTotalLitresPurchased(data)));
        averageServiceCostTextView.setText(String.format("$%.2f", getAverageServiceCost(serviceData)));
        totalSpentOnServicesTextView.setText(String.format("$%.2f", getTotalSpentOnServices(serviceData)));
    }

    public double getAverageFuelPrice(ArrayList<FuelTransaction> fuelTrans) {
        double averageFuelPrice, totalAll = 0;
        for (int i = 0; i < fuelTrans.size(); i++){
            totalAll += fuelTrans.get(i).getPricePerLitre();
        }
        averageFuelPrice = totalAll / fuelTrans.size();
        return averageFuelPrice;
    }

    public double getAverageLitresPurchased(ArrayList<FuelTransaction> fuelTrans) {
        double averageLitres, totalAll = 0;
        for (int i = 0; i < fuelTrans.size(); i++){
            totalAll += fuelTrans.get(i).getLitres();
        }
        averageLitres = totalAll / fuelTrans.size();
        return averageLitres;
    }

    public double getAverageTotalCost(ArrayList<FuelTransaction> fuelTrans) {
        double averageTotalCost, totalAll = 0;
        for (int i = 0; i < fuelTrans.size(); i++){
            totalAll += fuelTrans.get(i).getFuelTotal();
        }
        averageTotalCost = totalAll / fuelTrans.size();
        return averageTotalCost;
    }

    public int getKilometersTravelled(Vehicle tempVeh) {
        int odometerStart, odometerCurrent;
        odometerCurrent = tempVeh.getOdometer();
        odometerStart = tempVeh.getStartOdometer();
        return odometerCurrent - odometerStart;
    }

    public double getTotalSpentOnFuel(ArrayList<FuelTransaction> fuelTrans) {
        double totalAll = 0;
        for (int i = 0; i < fuelTrans.size(); i++){
            totalAll += fuelTrans.get(i).getFuelTotal();
        }
        return totalAll;
    }

    public double getTotalLitresPurchased(ArrayList<FuelTransaction> fuelTrans) {
        double totalAll = 0;
        for (int i = 0; i < fuelTrans.size(); i++){
            totalAll += fuelTrans.get(i).getLitres();
        }
        return totalAll;
    }

    public double getAverageServiceCost(ArrayList<ServiceTransaction> serviceTrans) {
        double averageTotalCost, totalAll = 0;
        for (int i = 0; i < serviceTrans.size(); i++){
            totalAll += serviceTrans.get(i).getTotalCost();
        }
        averageTotalCost = totalAll / serviceTrans.size();
        return averageTotalCost;
    }

    public double getTotalSpentOnServices(ArrayList<ServiceTransaction> serviceTrans) {
        double totalAll = 0;
        for (int i = 0; i < serviceTrans.size(); i++){
            totalAll += serviceTrans.get(i).getTotalCost();
        }
        return totalAll;
    }
}
