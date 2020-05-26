package com.example.appeva2josegonzalez

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class Person_adapter(var context: Context,
                     var arrayList: ArrayList<Person>,
                     val clickListener: (Person) -> Unit)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): RecyclerView.ViewHolder {
        var personView = LayoutInflater.from(context).inflate(R.layout.person_row, parent, false)
        return PersonViewHolder(personView)
    }

    override fun getItemCount() = arrayList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PersonViewHolder).initializeUiComponents(arrayList[position].rut, arrayList[position].nombre)
        (holder as PersonViewHolder).bind(arrayList[position], clickListener)
    }

    inner class PersonViewHolder(
        MyView: View) : RecyclerView.ViewHolder(MyView){
        var pRutTV = MyView.findViewById<TextView>(R.id.rv_row_rut)
        var pnombreTV = MyView.findViewById<TextView>(R.id.rv_row_nombre)

        fun initializeUiComponents(prut: String, pnombre: String ){
            pRutTV.text = prut
            pnombreTV.text = pnombre
        }

        fun bind(person : Person , clickListener: (Person) -> Unit){
            itemView.setOnClickListener{clickListener(person)}
        }
    }

}

