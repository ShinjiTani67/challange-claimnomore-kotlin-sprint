package com.example.challange_sprint01_claimnomore

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val entrarFuncionarioBtn: Button = findViewById(R.id.entrarFuncionarioBtn)
        entrarFuncionarioBtn.setOnClickListener() {
            val intent = Intent(this, UsuarioFragment::class.java)
            startActivity(intent)

            val entrarDentistaBtn: Button = findViewById(R.id.entrarDentistaBtn)
            entrarDentistaBtn.setOnClickListener() {
                val intent = Intent(this, UsuarioFragment   ::class.java)
                startActivity(intent)
            }
        }
    }




}