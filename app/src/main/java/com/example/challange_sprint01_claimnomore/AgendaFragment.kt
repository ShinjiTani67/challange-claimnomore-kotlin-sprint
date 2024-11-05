package com.example.challange_sprint01_claimnomore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class AgendaFragment : Fragment() {
    private AgendaFragmentBiding biding;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState) {

        var binding = FragmentExampleBinding.inflate(inflater, container, false);

        binding.fragmentTextView.setText("Texto atualizado no Fragment");

        return binding.getRoot();
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_agenda, container, false)
    }
}