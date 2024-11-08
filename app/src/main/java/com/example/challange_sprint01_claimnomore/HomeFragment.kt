package com.example.challange_sprint01_claimnomore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class HomeFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private var _biding:UsuarioFragment? = null
    private val binding get() =_biding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
    }
    private fun doLogin() = lifecycleScope.launch {
        val email = binding.editTextEmailAddress.text.toString()
        val password = binding.editTextPassword.text.toString()

        try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            val currentUser = result.user

            if (currentUser != null) {
                Toast.makeText(
                    requireContext(),
                    "Olá ${currentUser.displayName}!",
                    Toast.LENGTH_LONG
                ).show()
                findNavController().navigate(R.id.homeFragment)
            } else {
                Toast.makeText(
                    requireContext(),
                    "Não foi possível fazer o login",
                    Toast.LENGTH_LONG
                ).show()
            }
        } catch (ex: Exception) {
            Toast.makeText(
                requireContext(),
                ex.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_dentista, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _biding = null
    }
}