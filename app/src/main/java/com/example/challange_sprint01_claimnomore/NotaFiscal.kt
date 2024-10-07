package com.example.challange_sprint01_claimnomore

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NotaFiscal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_nota_fiscal)

            val actionBar = supportActionBar

            if(actionBar != null){
                actionBar.title = "NotaFiscal"
            }
            actionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    }