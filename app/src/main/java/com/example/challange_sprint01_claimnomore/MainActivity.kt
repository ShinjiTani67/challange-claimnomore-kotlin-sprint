package com.example.challange_sprint01_claimnomore

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity


class MainActivity :  AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usuarioEditText = findViewById<EditText>(R.id.usuario)
        val senhaEditText = findViewById<EditText>(R.id.senha)
        val entrarFuncionarioBtnButton = findViewById<Button>(R.id.entrarFuncionarioBtn) //somente para teste
        val entrarDentistaBtnButton: Button = findViewById(R.id.entrarDentistaBtn) //somente para teste


        entrarFuncionarioBtnButton.setOnClickListener() {
            val intent = Intent(this, UsuarioFragment::class.java)
            startActivity(intent)
            }
        entrarDentistaBtnButton.setOnClickListener(){
            val intent = Intent(this, DentistaFragment::class.java)
            startActivity(intent)
        }
        }
    }