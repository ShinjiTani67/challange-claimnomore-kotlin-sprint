package com.example.challange_sprint01_claimnomore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth


class AgendaFragment : Fragment() {

    //agenda tbm faz requisição em banco de dado
    
    private lateinit var auth: FirebaseAuth
    private var _biding:AgendaFragment?= null
    private val binding get() =_biding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_agenda, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _biding = null
    }


}