package com.example.selfly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.selfly.databinding.FragmentAnxietyTipsBinding
import com.example.selfly.databinding.FragmentSelfLoveTipsBinding

class SelfLoveTipsFragment : Fragment() {

    private var _binding: FragmentSelfLoveTipsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSelfLoveTipsBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.backButton8.setOnClickListener {
            rootView.findNavController().navigateUp()
        }

        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}