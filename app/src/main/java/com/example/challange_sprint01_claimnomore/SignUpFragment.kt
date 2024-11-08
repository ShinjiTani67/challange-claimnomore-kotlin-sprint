package com.example.challange_sprint01_claimnomore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.challange_sprint01_claimnomore.databinding.FragmentSignUpBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.userProfileChangeRequest
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class SignUpFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private var _biding: SignUpFragment? = null
    private val binding get() = _biding!!

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    auth = Firebase.auth
}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _biding = FragmentSignUpBinding.inflate(inflater, container, false)

        return binding.root
    }

    private fun createAccount() {
        val nome = binding.editTextName.text.toString()
        val email = binding.editTextEmailAddress.text.toString()
        val senha = binding.editTextPassword.text.toString()

        lifecycleScope.launch {
            try {
                val result = auth.createUserWithEmailAndPassword(email, password).await()
                val currentUser = result.user

                if (currentUser != null) {
                    val profileRequest = userProfileChangeRequest {
                        displayName = name
                    }
                    currentUser.updateProfile(profileRequest).await()
                    findNavController().navigate(R.id.homeFragment)
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Não foi possível criar sua conta",
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _biding = null
    }
}