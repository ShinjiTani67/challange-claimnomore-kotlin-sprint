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

        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    private fun createAccount() {

        val nome = binding.EditTextnomeEditText.text.toString()
        val rg = binding.enderecoEditText.text.toString()
        val cpf = binding.cpfEditText.text.toString()
        val numero = binding.numeroEditText.toString()
        val email = binding.emailEditText.text.toString()
        val funcao = binding.funcaoEditText.text.toString()
        val senha = binding.senhaEditText.text.toString()

        lifecycleScope.launch {
            try {
                val result = auth.createUserWithEmailAndPassword(email, rg, cpf, numero, funcao, senha).await()
                val currentUser = result.user

                if (currentUser != null) {
                    val profileRequest = userProfileChangeRequest {
                        displayName = nome
                    }
                    currentUser.updateProfile(profileRequest).await()
                    findNavController().navigate(R.id.usuario)
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