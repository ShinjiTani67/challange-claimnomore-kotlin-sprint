package com.example.challange_sprint01_claimnomore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class DentistaFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private var _biding:DentistaFragment? = null
    private val binding get() =_biding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_dentista, container, false)
    }

    val notaFiscalBtn: Button = findViewById (R.id.notafiscal_btn)
    entrarDentistaBtn.setOnClickListener() {
        val intent = Intent(this, User::class.java)
        startFragment(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _biding = null
    }

}