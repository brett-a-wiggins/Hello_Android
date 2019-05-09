package com.example.hello_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ExportDataMenuActivity extends AppCompatActivity {
    Button export_button;
    PrintWriter writer;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        export_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
        try {
            writer = new PrintWriter(new File("guzzle.csv"));
            StringBuilder sb = new StringBuilder();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}
