package com.example.appeva2josegonzalez

import android.app.AlertDialog
import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_list_view.*
import kotlinx.android.synthetic.main.person_row.*
import kotlinx.android.synthetic.main.person_row.view.*


class listView : AppCompatActivity(){
    var PersonList = ArrayList<Person>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        var personsURL = "http://192.168.1.81:5000/api/v1/resources/persons"

        var request0 = Volley.newRequestQueue(this@listView)
        var jsonAR = JsonArrayRequest(Request.Method.GET, personsURL, null, Response.Listener {
            response ->
            for( jsonObject in 0.until(response.length()) ){
                PersonList.add(Person(response.getJSONObject(jsonObject).getString("RUT"),
                    response.getJSONObject(jsonObject).getString("NOMBRE"),
                    response.getJSONObject(jsonObject).getString("TELEFONO"),
                    response.getJSONObject(jsonObject).getString("MAIL")))
            }
            RV_Persons.layoutManager = LinearLayoutManager(this@listView)
            var rvAdapater = Person_adapter(this@listView, PersonList , {person: Person -> PersonClicked(person)})
            RV_Persons.adapter = rvAdapater

        }, Response.ErrorListener{
            error  ->
            val alerta = AlertDialog.Builder(this)
            alerta.setTitle("Error")
            alerta.setMessage(error.message)
            alerta.show()
        })
        request0.add(jsonAR)
    }

    private fun PersonClicked(person : Person){
        var intent = Intent(this, Edit_personActivity::class.java)
        intent.putExtra("RUT",person.rut)
        startActivity(intent)
    }
}
