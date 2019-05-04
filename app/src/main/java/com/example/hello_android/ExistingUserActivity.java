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

public class ExistingUserActivity extends AppCompatActivity implements Parcelable {
    private Button selectUserButton;
    private VehicleOwner tempOwner;
    private Spinner userSpinner;

    private ExistingUserActivity(Parcel in) {
        this.tempOwner = new VehicleOwner(in.readString());
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.tempOwner.getOwnerName());
    }

    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<ExistingUserActivity> CREATOR = new Parcelable.Creator<ExistingUserActivity>() {
        public ExistingUserActivity createFromParcel(Parcel in) {
            return new ExistingUserActivity(in);
        }

        public ExistingUserActivity[] newArray(int size) {
            return new ExistingUserActivity[size];
        }
    };

    public ExistingUserActivity(){
        
    }

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
                setOwner(getVehicleOwner(userSpinner.getSelectedItem().toString()));
                Intent intent = new Intent(ExistingUserActivity.this, VehicleMenuActivity.class);
                intent.putParcelableArrayListExtra("vehicleList", tempOwner.vehicleList);
                //intent.putParcelableArrayListExtra("tempOwner", this.tempOwner );
                startActivity(intent);
            }
        });
    }

    public void setOwner(VehicleOwner owner) {
        this.tempOwner = owner;
    }

    public VehicleOwner getVehicleOwner (String ownerName) {
        for (int i = 0; i < MainActivity.ownerList.size(); i++) {
            if (MainActivity.ownerList.get(i).getOwnerName().equals(ownerName)) {
                return MainActivity.ownerList.get(i);
            }
        }
        return null;
    }
}
