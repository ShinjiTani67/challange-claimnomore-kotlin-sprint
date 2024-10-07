package com.example.challange_sprint01_claimnomore

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Agenda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda)

        val actionBar = supportActionBar

        if(actionBar != null){
            actionBar.title = "Agenda"
        }
        actionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}