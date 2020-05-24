package com.example.appeva2josegonzalez

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appeva2josegonzalez.dummy.DummyContent
import kotlinx.android.synthetic.main.activity_list_view.*
import java.text.FieldPosition

class listView : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        var PersonList = ArrayList<Person>()
        PersonList.add(Person("18247430-4", "Jose Gonzalez", "99956555", "correo@correo.cl"))
        PersonList.add(Person("18247430-4", "Jose Gonzalez", "99956555", "correo@correo.cl"))
        PersonList.add(Person("18247430-4", "Jose Gonzalez", "99956555", "correo@correo.cl"))
        PersonList.add(Person("18247430-4", "Jose Gonzalez", "99956555", "correo@correo.cl"))
        PersonList.add(Person("18247430-4", "Jose Gonzalez", "99956555", "correo@correo.cl"))
        PersonList.add(Person("18247430-4", "Jose Gonzalez", "99956555", "correo@correo.cl"))
        PersonList.add(Person("18247430-4", "Jose Gonzalez", "99956555", "correo@correo.cl"))
        PersonList.add(Person("18247430-4", "Jose Gonzalez", "99956555", "correo@correo.cl"))
        PersonList.add(Person("18247430-4", "Jose Gonzalez", "99956555", "correo@correo.cl"))
        PersonList.add(Person("18247430-4", "Jose Gonzalez", "99956555", "correo@correo.cl"))
        PersonList.add(Person("18247430-4", "Jose Gonzalez", "99956555", "correo@correo.cl"))

        var rvAdapater = Person_adapter(this@listView, PersonList)
        RV_Persons.layoutManager = LinearLayoutManager(this@listView)
        RV_Persons.adapter = rvAdapater
    }

}
