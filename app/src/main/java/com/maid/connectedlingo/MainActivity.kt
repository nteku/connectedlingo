package com.maid.connectedlingo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var registerLink : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        registerLink = findViewById(R.id.register)



    }
}