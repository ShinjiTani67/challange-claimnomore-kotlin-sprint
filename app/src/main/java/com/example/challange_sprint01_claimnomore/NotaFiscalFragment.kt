package com.example.challange_sprint01_claimnomore

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import com.example.challange_sprint01_claimnomore.databinding.FragmentNotaFiscalBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
//import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.storage.storage
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.util.UUID


class NotaFiscalFragment : Fragment() {


    private lateinit var auth: FirebaseAuth
    private var _binding: FragmentNotaFiscalBinding? = null
    private val binding get() =_binding!!

    private val storage = Firebase.storage
    private val firestore = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNotaFiscalBinding.inflate(inflater, container, false)
        return binding.root

    }

    private val pickImageLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK && result.data != null) {
            val imageUri = result.data?.data
            if (imageUri != null) {
                uploadImageToFirebase(imageUri)
            }
        } else {
            Toast.makeText(requireContext(), "Falha ao selecionar imagem", Toast.LENGTH_SHORT).show()
        }
    }

    private fun selectImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        pickImageLauncher.launch(intent)
    }

    private fun uploadImageToFirebase(imageUri: Uri) {
        val userId = auth.currentUser?.uid ?: return
        val fileName = "images/${userId}/${UUID.randomUUID()}.jpg"
        val storageRef = storage.reference.child(fileName)

        lifecycleScope.launch {
            try {
                storageRef.putFile(imageUri).await()
                val downloadUrl = storageRef.downloadUrl.await()

                val photoData = hashMapOf(
                    "userId" to userId,
                    "imageUrl" to downloadUrl.toString(),
                    "timestamp" to System.currentTimeMillis()
                )
                firestore.collection("userPhotos").add(photoData).await()

                Toast.makeText(requireContext(), "Foto enviada com sucesso!", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Erro: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}