package com.example.hello_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class NewUserActivity extends AppCompatActivity {
    private Button addUserButton;
    private TextView userNameText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);


        userNameText = findViewById(R.id.owner_name_text);

        addUserButton = findViewById(R.id.add_user_button);
        addUserButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String userName = userNameText.getText().toString();
                MainActivity.ownerList.add(new VehicleOwner(userName));
                Intent intent = new Intent(NewUserActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
