package com.example.hello_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   private Button newUserButton;
   private Button existingUserButton;
   private static ArrayList ownerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ownerList = new ArrayList();

        this.newUserButton = findViewById(R.id.new_user_button);
        this.newUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NewUserActivity.class);
                startActivity(intent);
            }
        });
        this.existingUserButton = findViewById(R.id.existing_user_button);
        this.existingUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ExistingUserActivity.class);
                startActivity(intent);
            }
        });
    }

    public static ArrayList getOwnerList(){
        return ownerList;
    }

}
