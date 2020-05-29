package com.example.appeva2josegonzalez

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_edit_person.*
import kotlinx.android.synthetic.main.activity_list_view.*
import org.json.JSONObject

class Edit_personActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_person)
        var rut = intent.getStringExtra("RUT")
        var personsURL = "http://192.168.1.81:5000/api/v1/resources/persons/select?RUT="+rut

        var person: Person

        var txtrut = findViewById<EditText>(R.id.textrut)
        var txtnombre = findViewById<EditText>(R.id.textnombre)
        var txttelefono = findViewById<EditText>(R.id.texttelefono)
        var txtmail = findViewById<EditText>(R.id.textmail)
        var person = Person(rut,"","","")

        var btn_edita = findViewById<Button>(R.id.btn_editar)
        var btn_elimina = findViewById<Button>(R.id.btn_eliminar)

        var request0 = Volley.newRequestQueue(this@Edit_personActivity)
        var jsonAR = JsonObjectRequest(Request.Method.GET, personsURL, null, Response.Listener {
                response ->
                    person = Person(response.getString("RUT"),
                    response.getString("NOMBRE"),
                    response.getString("TELEFONO"),
                    response.getString("MAIL"))

            textrut.setText(person.rut)
            textnombre.setText(person.nombre)
            texttelefono.setText(person.telefono)
            textmail.setText(person.mail)

        }, Response.ErrorListener{
                error  ->
            val alerta = AlertDialog.Builder(this)
            alerta.setTitle("Error")
            alerta.setMessage(error.message)
            alerta.show()
        })
        request0.add(jsonAR)

        btn_edita.setOnClickListener{
            edita(rut, textnombre.getText().toString() , texttelefono.getText().toString(),textmail.getText().toString())
            var returnIntent = Intent()
            setResult(Activity.RESULT_CANCELED,returnIntent)
            finish()
        }
        btn_elimina.setOnClickListener{
            elimina(rut)
            finish()
        }


    }

    fun edita(rut: String, nombre: String ,telefono :String, mail :String){
        var personsURL = "http://192.168.1.81:5000/api/v1/resources/persons/update?RUT="+rut+"&NOMBRE="+replaceSpaces(nombre)+
                "&TELEFONO="+telefono+"&MAIL="+mail
        var request0 = Volley.newRequestQueue(this@Edit_personActivity)
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

    fun elimina (rut: String){
        var personsURL = "http://192.168.1.81:5000/api/v1/resources/persons/delete?RUT="+rut
        var request0 = Volley.newRequestQueue(this@Edit_personActivity)
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
