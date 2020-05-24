package com.example.appeva2josegonzalez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Person_ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person__view)
        var rut = getIntent().getStringExtra("RUT")

        var txrut = findViewById<TextView>(R.id.txrut)
    }
}
