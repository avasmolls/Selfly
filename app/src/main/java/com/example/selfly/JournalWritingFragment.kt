package com.example.selfly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController
import com.example.selfly.databinding.FragmentJournalWritingBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class JournalWritingFragment : Fragment() {

    private var _binding: FragmentJournalWritingBinding? = null
    private val binding get() = _binding!!

    lateinit var dbRef : DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJournalWritingBinding.inflate(inflater, container, false)
        val rootView = binding.root

        val args = JournalWritingFragmentArgs.fromBundle(requireArguments())
        binding.editTextTitle.setText(args.titleArg)
        binding.editTextEntry.setText(args.entryArg)

        binding.enterButton.setOnClickListener {
            val title = binding.editTextTitle.text.toString()
            val entry  = binding.editTextEntry.text.toString()
            val newEntry = Entry(title, 1, 1, 1, entry)
            setFragmentResult("REQUESTING_JOURNAL_KEY", bundleOf("JOURNAL_KEY" to newEntry))
            rootView.findNavController().navigateUp()
        }

        dbRef = Firebase.database.reference

        return rootView
    }
}