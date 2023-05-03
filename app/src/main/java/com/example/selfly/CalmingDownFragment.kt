package com.example.selfly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.selfly.databinding.FragmentCalmingDownBinding
import com.example.selfly.databinding.FragmentChooseJournalBinding

class CalmingDownFragment : Fragment() {

    private var _binding: FragmentCalmingDownBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalmingDownBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.circle.setOnClickListener {

            binding.circle.animate().apply {
                duration = 1000
                rotationYBy(360f)
                rotationXBy(360f)
            }.start()

        }

        return rootView
    }

}