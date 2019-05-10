package com.example.hello_android;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ExportDataMenuActivity extends AppCompatActivity {
    private Button export_button;
    private PrintWriter writer;
    private VehicleOwner current_owner;
    private Vehicle current_vehicle;
    private ArrayList<FuelTransaction> mFuelTransactions;
    private StringBuilder sb = new StringBuilder();
    private PrintWriter write;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_export_data_menu);

        export_button = findViewById(R.id.export_to_csv_button);

        export_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               current_vehicle = SelectVehicleActivity.getTempVehicle();
                File data_file = new File(getFilesDir(),"guzzle.csv");
                try{
                    if(data_file.createNewFile()){
                        //create new file
                    }else{
                        //file already exists
                    }
                    FileOutputStream fos = new FileOutputStream(data_file);
                    OutputStreamWriter osw = new OutputStreamWriter(fos);
                    BufferedWriter bw = new BufferedWriter(osw);
                    bw.write(current_vehicle.toString());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        });


    }


}
