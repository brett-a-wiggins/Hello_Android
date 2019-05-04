package com.example.hello_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class ExistingUserActivity extends AppCompatActivity {
    private Button selectUserButton;
    private VehicleOwner owner;
    private Spinner userSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_user);
        //this.ownerList = getIntent().getStringArrayListExtra("ownerList");
//        ownerList = MainActivity.ownerList;
        userSpinner = this.findViewById(R.id.user_spinner);
        ArrayAdapter userListAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, MainActivity.ownerList);
        userListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MainActivity.addOwner("Default");
        MainActivity.ownerList.add("Default2");

        userSpinner.setAdapter(userListAdapter);



        selectUserButton = findViewById(R.id.select_user_button);
        selectUserButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //String userName = userSpinner.getItemAtPosition(pos).toString();

               // ownerList.get(new VehicleOwner(userName));
                Intent intent = new Intent(ExistingUserActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
