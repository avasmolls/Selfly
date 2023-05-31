package com.example.selfly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.selfly.databinding.FragmentShowEntryBinding
import com.google.firebase.database.DatabaseReference


class ShowEntryFragment : Fragment() {

    private var _binding: FragmentShowEntryBinding? = null
    private val binding get() = _binding!!

    lateinit var dbRef : DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShowEntryBinding.inflate(inflater, container, false)
        val rootView = binding.root

        val args = ShowEntryFragmentArgs.fromBundle(requireArguments())

        binding.textViewTitle.text = args.titleArg
        binding.textViewEntry.text = args.entryTextArg

        binding.backButton9.setOnClickListener {
            rootView.findNavController().navigateUp()
        }


        return rootView
    }

}