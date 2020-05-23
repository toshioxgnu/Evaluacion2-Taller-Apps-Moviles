package com.example.appeva2josegonzalez

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.appeva2josegonzalez.R.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        val btn_ingresa = findViewById<Button>(id.Ingresa)
        btn_ingresa.setOnClickListener{
            var txtrut = findViewById<EditText>(id.txtrut)
            var rut = txtrut.text.toString()
            val alerta = AlertDialog.Builder(this)
            if(rut ==""){
                alerta.setMessage("Porfavor Ingrese Rut")
                alerta.show()
            }else{
                Ingresa(rut, alerta)
            }
        }
    }

    fun Ingresa(rut: String, alerta: AlertDialog.Builder){
        var intent = Intent( this, listView::class.java )
        if (valida(rut)){
            startActivity(intent)
        }else{
            alerta.setMessage("Rut Incorrecto")
            alerta.show()
        }
    }

}
