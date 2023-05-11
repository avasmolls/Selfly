package com.example.selfly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.selfly.databinding.FragmentJournalWritingBinding


class JournalWritingFragment : Fragment() {

    private var _binding: FragmentJournalWritingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJournalWritingBinding.inflate(inflater, container, false)
        val rootView = binding.root

        val args = JournalWritingFragmentArgs.fromBundle(requireArguments())
        binding.editTextTitle.setText(args.titleArg)
        binding.editTextEntry.setText(args.entryArg)

        return rootView
    }
}