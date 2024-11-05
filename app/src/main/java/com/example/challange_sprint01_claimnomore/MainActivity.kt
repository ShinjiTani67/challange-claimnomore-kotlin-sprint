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

        val entrarFuncionarioBtn: Button = findViewById (R.id.entrarFuncionarioBtn)
        entrarFuncionarioBtn.setOnClickListener() {
            val intent = Intent(this, User::class.java)
            startActivity(intent)

            val entrarDentistaBtn: Button = findViewById (R.id.entrarDentistaBtn)
            entrarDentistaBtn.setOnClickListener() {
                val intent = Intent(this, User::class.java)
                startActivity(intent)
            }
        }
    }
    class MainActivity : AppCompatActivity(), AgendaFragment.OnFragmentInteractionListener {
        fun onFragmentInteraction(message: String?) {
            // Lida com a mensagem recebida do Fragment
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

    class MainActivity : AppCompatActivity(), DentistaFragment.OnFragmentInteractionListener {
        fun onFragmentInteraction(message: String?) {
            // Lida com a mensagem recebida do Fragment
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

    class MainActivity : AppCompatActivity(), NotaFiscalFragment.OnFragmentInteractionListener {
        fun onFragmentInteraction(message: String?) {
            // Lida com a mensagem recebida do Fragment
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

    class MainActivity : AppCompatActivity(), UsuarioFragment.OnFragmentInteractionListener {
        fun onFragmentInteraction(message: String?) {
            // Lida com a mensagem recebida do Fragment
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

}