package com.example.hello_android;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ExistingUserActivity extends AppCompatActivity {
    private Button selectUserButton;
    private static VehicleOwner tempOwner;
    private Spinner userSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_user);
        userSpinner = this.findViewById(R.id.user_spinner);
        ArrayAdapter userListAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, MainActivity.ownerList);
        userListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MainActivity.addOwner("Test User");


        userSpinner.setAdapter(userListAdapter);


        selectUserButton = findViewById(R.id.select_user_button);
        selectUserButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                setOwner(retrieveVehicleOwner(userSpinner.getSelectedItem().toString()));
                Intent intent = new Intent(ExistingUserActivity.this, VehicleMenuActivity.class);
                startActivity(intent);
            }
        });
    }

    public static VehicleOwner getTempOwner() {
        return tempOwner;
    }

    public void setOwner(VehicleOwner owner) {
        this.tempOwner = owner;
    }

    public VehicleOwner retrieveVehicleOwner(String ownerName) {
        for (int i = 0; i < MainActivity.ownerList.size(); i++) {
            if (MainActivity.ownerList.get(i).getOwnerName().equals(ownerName)) {
                return MainActivity.ownerList.get(i);
            }
        }
        return null;
    }
}

