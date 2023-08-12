package com.maid.connectedlingo;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText emailAddress = findViewById(R.id.emailAddress);
        EditText password = findViewById(R.id.password);
        TextView register = findViewById(R.id.register);
        TextView needHelp = findViewById(R.id.needHelp);
        ImageView backButton = findViewById(R.id.backButton);
        Button login = findViewById(R.id.login);
        DatabaseHelper db = new DatabaseHelper(this);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (emailAddress.getText().toString().isEmpty() || password.getText().toString().isEmpty())
                {
                    Toast.makeText(Login.this,"Please fill out empty field(s).",Toast.LENGTH_SHORT).show();
                    return;
                }
                Cursor res = db.getAccount();

                if (res.getCount() == 0)
                {
                    Toast.makeText(Login.this,"No entry exists",Toast.LENGTH_SHORT).show();
                }

                else{
                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext())
                    {
                        if (res.getString(1).equals(emailAddress.getText().toString())
                        &&  res.getString(3).equals(password.getText().toString())){

                            Account account = new Account(res.getString(2),res.getString(1),res.getString(3));
                            Intent intent = new Intent(Login.this, Translation.class);
                            intent.putExtra("account", account);
                            Toast.makeText(Login.this,"Successfully logged in.",Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                            return;
                        }
                    }

                    Toast.makeText(Login.this,"Incorrect email address or password. ",Toast.LENGTH_SHORT).show();

                }
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Registration.class);
                startActivity(intent);
            }
        });

        needHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                builder.setCancelable(true);
                builder.setMessage("In order to use this app, please login or register for an account.");
                builder.show();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
