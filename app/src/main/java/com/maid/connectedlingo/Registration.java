package com.maid.connectedlingo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.io.Serializable;


public class Registration extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText emailAddress;
    private Button button;
    private DatabaseHelper db;
    private Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        emailAddress = findViewById(R.id.emailAddress);
        button = findViewById(R.id.button);
        db = new DatabaseHelper(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                account =new Account (username.getText().toString(),emailAddress.getText().toString(),
                        password.getText().toString());

                boolean checkInsert = db.create(account);
                if (checkInsert){
                    Intent intent = new Intent(Registration.this, Menu.class);
                    intent.putExtra("account", account);
                    startActivity(intent);
                }
                else
                {
                    Log.d("ERROR","Failed to insert user");
                }
             //
             //
            }
        });

    }
}
