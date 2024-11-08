package com.example.challange_sprint01_claimnomore

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.storage.storage
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.util.UUID


class NotaFiscalFragment : Fragment() {
    
    //nota fiscal faz requisição em banco de dado

    private lateinit var auth: FirebaseAuth
    private var _biding:NotaFiscalFragment? = null
    private val binding get() =_biding!!

    private val storage = Firebase.storage
    private val firestore = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_dentista, container, false)
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
                // Faz o upload da imagem para o Firebase Storage
                storageRef.putFile(imageUri).await()
                // Obtém a URL de download da imagem
                val downloadUrl = storageRef.downloadUrl.await()

                // Salva a URL da imagem no Firestore
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
        _biding = null
    }

}