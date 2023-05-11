package com.example.selfly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.selfly.databinding.FragmentChooseTipBinding
import com.example.selfly.databinding.FragmentMainBinding

class ChooseTipFragment : Fragment() {

    private var _binding: FragmentChooseTipBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseTipBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.anxiety.setOnClickListener {
            rootView.findNavController()
                .navigate(R.id.action_chooseTipFragment_to_anxietyTipsFragment)
        }

        binding.sleep.setOnClickListener {
            rootView.findNavController()
                .navigate(R.id.action_chooseTipFragment_to_sleepTipsFragment)
        }

        binding.selfcare.setOnClickListener {
            rootView.findNavController()
                .navigate(R.id.action_chooseTipFragment_to_selfCareTipsFragment)
        }

        binding.selflove.setOnClickListener {
            rootView.findNavController()
                .navigate(R.id.action_chooseTipFragment_to_selfLoveTipsFragment)
        }

        return rootView
    }

}