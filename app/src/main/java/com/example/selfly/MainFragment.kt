package com.example.selfly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.selfly.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.tipsVector.setOnClickListener {
            rootView.findNavController()
                .navigate(R.id.action_mainFragment_to_chooseTipFragment)
        }

        binding.moodVector.setOnClickListener {
            rootView.findNavController()
                .navigate(R.id.action_mainFragment_to_moodTrackerFragment)
        }

        binding.journalVector.setOnClickListener {
            rootView.findNavController()
                .navigate(R.id.action_mainFragment_to_chooseJournalFragment)
        }

        binding.calmVector.setOnClickListener {
            rootView.findNavController()
                .navigate(R.id.action_mainFragment_to_calmingDownFragment)
        }
        return rootView
    }

}