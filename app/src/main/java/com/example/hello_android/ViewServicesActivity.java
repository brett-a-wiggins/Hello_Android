package com.example.hello_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewServicesActivity extends AppCompatActivity {
    private ListView serviceLogListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_services);
        serviceLogListView = findViewById(R.id.service_log_listview);
        ArrayAdapter servicesAdapter = new ArrayAdapter(this,  android.R.layout.simple_expandable_list_item_1, populateServicesList());
        servicesAdapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);

        serviceLogListView.setAdapter(servicesAdapter);
        serviceLogListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_LONG).show();
            }
        });

    }

    public ArrayList<String> populateServicesList() {
        ArrayList<String> servicesList = new ArrayList<>();
        for (int i = 0; i < SelectVehicleActivity.getTempVehicle().getServiceTransList().size(); i++) {
            ArrayList<ServiceTransaction> tempServiceList = SelectVehicleActivity.getTempVehicle().getServiceTransList();
            servicesList.add(tempServiceList.get(i).getServiceTransactionString());
        }
        return servicesList;
    }
    // ...
}
