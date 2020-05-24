package com.example.appeva2josegonzalez

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list_view.*

class listView : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        fun onAttachFragment(fragment: PersonFragment){
            if (fragment is PersonFragment) {
                fragment.OnListFragnentInteractonListener(listView())
            }
        }

    }

}
