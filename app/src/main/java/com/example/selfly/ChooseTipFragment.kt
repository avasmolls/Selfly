package com.example.selfly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        return rootView
    }

}