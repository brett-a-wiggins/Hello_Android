package com.example.hello_android;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.util.ArrayList;

public class ExportDataMenuActivity extends AppCompatActivity {
    private Button export_button;
    private VehicleOwner current_owner;
    private Vehicle current_vehicle;
    private ArrayList<FuelTransaction> mFuelTransactions;
    private ArrayList<ServiceTransaction> mServiceTransactions;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_export_data_menu);

        export_button = findViewById(R.id.export_to_csv_button);

        export_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //current_vehicle = SelectVehicleActivity.getTempVehicle();
                Intent intent = new Intent(ExportDataMenuActivity.this, DirectoryPicker.class);
                startActivity(intent);
               /* try{
                    String rootPath = Environment.getExternalStorageDirectory()
                            .getAbsolutePath() + "/GUZZLE/";
                    File root = new File(rootPath);
                    if (!root.exists()) {
                        root.mkdirs();
                    }
                    File new_file = new File(rootPath + "guzzle.csv");
                    if (new_file.exists()) {
                        new_file.delete();
                    }
                    new_file.createNewFile();
                    FileOutputStream fos = new FileOutputStream(new_file);
                    OutputStreamWriter osw = new OutputStreamWriter(fos);
                    BufferedWriter bw = new BufferedWriter(osw);
                    mFuelTransactions = current_vehicle.getFuelTransList();
                    for(FuelTransaction ft:mFuelTransactions){
                        bw.write(String.valueOf(ft.getPricePerLitre()));
                        bw.write(",");
                        bw.write(String.valueOf(ft.getLitres()));
                        bw.write(",");
                        bw.write(String.valueOf(ft.getOdometer()));
                        bw.write(",");
                        bw.write(String.valueOf(ft.getTotalCost()));
                        bw.write(",");
                        bw.write(ft.getLocation());
                        bw.write(",");
                        bw.write(String.valueOf(ft.getTransactionDate()));
                        bw.write(",");
                        bw.write(ft.getTransaction());
                        bw.write(",");
                        bw.write(String.valueOf(ft.getFuelTotal()));
                        bw.newLine();
                    }
                    bw.flush();
                    bw.close();
                }catch(IOException e){
                    e.printStackTrace();
                }*/
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == DirectoryPicker.PICK_DIRECTORY && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            String path = (String) extras.get(DirectoryPicker.CHOSEN_DIRECTORY);

        }
    }
}
