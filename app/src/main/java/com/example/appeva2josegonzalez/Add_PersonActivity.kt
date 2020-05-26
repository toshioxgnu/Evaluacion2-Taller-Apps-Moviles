package com.example.appeva2josegonzalez

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_edit_person.*

class Add_PersonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add__person)
        var btn_agrega = findViewById<Button>(R.id.btn_agregar)
        var txtrut = findViewById<EditText>(R.id.textrut2)
        var txtnombre = findViewById<EditText>(R.id.textnombre2)
        var txttelefono = findViewById<EditText>(R.id.texttelefono2)
        var txtmail = findViewById<EditText>(R.id.textmail2)


        btn_agrega.setOnClickListener{
            agrega(txtrut.getText().toString(), txtnombre.getText().toString() , txttelefono.getText().toString(),txtmail.getText().toString())
            finish()
        }
    }

    fun agrega(rut: String, nombre: String ,telefono :String, mail :String){
        var personsURL = "http://192.168.1.81:5000/api/v1/resources/persons/insert?RUT="+rut+"&NOMBRE="+replaceSpaces(nombre)+
                "&TELEFONO="+telefono+"&MAIL="+mail
        var request0 = Volley.newRequestQueue(this@Add_PersonActivity)
        var jsonAR = JsonObjectRequest(Request.Method.GET, personsURL, null, Response.Listener {
                response ->

        }, Response.ErrorListener{
                error  ->
            val alerta = AlertDialog.Builder(this)
            alerta.setTitle("Error")
            alerta.setMessage(error.message)
            alerta.show()
        })
        request0.add(jsonAR)
    }

    fun replaceSpaces(nombre: String): String {
        return nombre.replace(" ","+")
    }
}
