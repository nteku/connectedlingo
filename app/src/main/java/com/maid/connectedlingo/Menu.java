package com.maid.connectedlingo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.TranslatorOptions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Menu extends AppCompatActivity {

    private String selectedInput;
    private String selectedOutput;
    private String sourceText;
    private boolean isModelDownloaded;
    private Translator translator;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TextView message = findViewById(R.id.openingmessage);
        EditText input = findViewById(R.id.inputText);
        EditText result = findViewById(R.id.result);
        Button translate = findViewById(R.id.translate);
        Spinner inputDropdownMenu = findViewById(R.id.dropdown_menu);
        Spinner outputDropdownMenu = findViewById(R.id.dropdown_menu2);


        List <String> languageKeys = new ArrayList<>();
        List <String> languages = new ArrayList<>();
        selectedInput = "";
        selectedOutput = "";
        index = 0;
        Intent intent = getIntent();

        if (intent != null)
        {
            Account account = (Account) intent.getSerializableExtra("account");
            message.setText("Hello " + account.getUsername() + ".");
        }

        try {
            initializeLanguages(languageKeys,languages);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> inputAdapter = new ArrayAdapter(this, R.layout.black_text, languages.toArray());
        ArrayAdapter<String> outputAdapter = new ArrayAdapter(this, R.layout.black_text, languages.toArray());

        inputAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        outputAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        inputDropdownMenu.setAdapter(inputAdapter);

        inputDropdownMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedInput = (String) parent.getItemAtPosition(position);
                Log.d("DEBUG",selectedInput);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do something when nothing is selected, if needed
            }
        });


        outputDropdownMenu.setAdapter(inputAdapter);

        outputDropdownMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedOutput  = (String) parent.getItemAtPosition(position);
                Log.d("DEBUG",selectedOutput);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do something when nothing is selected, if needed
            }
        });





        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(input.getText().toString())) {
                    Toast.makeText(Menu.this, "Please enter text,", Toast.LENGTH_SHORT);
                } else{

                    if (!isModelDownloaded) {
                        TranslatorOptions options = new TranslatorOptions.Builder().
                                setTargetLanguage(languageKeys.get(languages.indexOf(selectedOutput))).
                                setSourceLanguage(languageKeys.get(languages.indexOf(selectedInput))).build();
                        translator = Translation.getClient(options);
                        sourceText = input.getText().toString();
                        ProgressDialog progressDialog = new ProgressDialog(Menu.this);
                        progressDialog.setMessage("Downloading the translation model ...");
                        progressDialog.setCancelable(false);
                        progressDialog.show();
                        isModelDownloaded = true;

                        translator.downloadModelIfNeeded().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                progressDialog.dismiss();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.dismiss();
                            }
                        });
                    }
                    else{
                        Task<String> resultText = translator.translate(sourceText).addOnSuccessListener(new OnSuccessListener<String>() {
                            @Override
                            public void onSuccess(String s) {
                                result.setText(s);
                            }
                        });
                    }


                    }
                }
        });

    }


    public void initializeLanguages(List <String> languageKeys, List <String> languages) throws IOException {
        DataInputStream languageKeyStream = new DataInputStream(getAssets().open(String.format(getResources().getString(R.string.languageKeys))));
        Scanner inputKeys = new Scanner(languageKeyStream);

        DataInputStream languageStream = new DataInputStream(getAssets().open(String.format(getResources().getString(R.string.languages))));
        Scanner inputLanguages = new Scanner(languageStream);
        while (inputKeys.hasNextLine() && inputLanguages.hasNextLine())
        {
            // capturing line
            String languageKey = inputKeys.nextLine();
            String language = inputLanguages.nextLine();

            languageKeys.add(languageKey);
            languages.add(language);

          //  Log.d("DEBUG",languageKey + " " + language);
        }

        inputKeys.close();
        inputLanguages.close();
    }
}
