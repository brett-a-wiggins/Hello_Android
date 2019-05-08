package com.example.hello_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewUserActivity extends AppCompatActivity {
    private Button addUserButton;
    private EditText userNameText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);


        userNameText = findViewById(R.id.owner_name_text);


        addUserButton = findViewById(R.id.add_user_button);
        addUserButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String userName =  userNameText.getText().toString();
                MainIntentActivity.ownerList.add(new VehicleOwner(userNameText.getText().toString()));
                Intent intent = new Intent(NewUserActivity.this, MainIntentActivity.class);
                startActivity(intent);
            }
        });
    }
}
