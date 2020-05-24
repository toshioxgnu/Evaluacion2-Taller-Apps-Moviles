package com.example.appeva2josegonzalez

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.person_row.view.*

class Person_adapter(var context: Context,var arrayList: ArrayList<Person> ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var personView = LayoutInflater.from(context).inflate(R.layout.person_row, parent, false)
        return PersonViewHolder(personView)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PersonViewHolder).initializeUiComponents(arrayList[position].rut, arrayList[position].nombre)
    }

    inner class PersonViewHolder(MyView: View) : RecyclerView.ViewHolder(MyView) {
        var pRutTV = MyView.findViewById<TextView>(R.id.rv_row_rut)
        var pnombreTV = MyView.findViewById<TextView>(R.id.rv_row_nombre)

        fun initializeUiComponents(prut: String, pnombre: String ){
            pRutTV.text = prut
            pnombreTV.text = pnombre
        }
    }
}