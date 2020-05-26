package com.example.appeva2josegonzalez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Edit_personActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_person)
        var rut = intent.getStringExtra("RUT")
        var txtrut = findViewById<TextView>(R.id.txtrut)
        txtrut.text = rut


    }
}
