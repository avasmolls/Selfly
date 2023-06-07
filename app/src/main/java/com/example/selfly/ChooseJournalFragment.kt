package com.example.selfly

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import com.example.selfly.databinding.FragmentChooseJournalBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

class ChooseJournalFragment : Fragment() {

    private var _binding: FragmentChooseJournalBinding? = null
    private val binding get() = _binding!!
    lateinit var dbRef: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseJournalBinding.inflate(inflater, container, false)
        val rootView = binding.root

        dbRef = Firebase.database.reference
        setHasOptionsMenu(true)

        var entries = mutableListOf<Entry>()

        val myAdapter = EntryAdapter(entries)
        binding.recyclerView.adapter = myAdapter

        binding.backButton3.setOnClickListener {
            rootView.findNavController().navigateUp()
        }

        binding.imageButton2.setOnClickListener {
            val action =
                ChooseJournalFragmentDirections.actionChooseJournalFragmentToJournalWritingFragment()
            rootView.findNavController().navigate(action)
        }

        binding.delete.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme)
                .setTitle(getString(R.string.dialogue_title))
                .setMessage(getString(R.string.delete_all))
                .setPositiveButton(getString(R.string.yes)) { dialog, which ->
                    dbRef.child("entries").removeValue()
                    val action = ChooseJournalFragmentDirections.actionChooseJournalFragmentToMainFragment()
                    rootView.findNavController().navigate(action)
                }
                .setNegativeButton(getString(R.string.no)) { dialog, which ->

                }
                .show()

        }


        dbRef.child("entries").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val allDBEntries = dataSnapshot.children

                var numOfEntriesAdded = 0
                for (singleEntryEntry in allDBEntries) {
                    numOfEntriesAdded++
                    val title = singleEntryEntry.child("title").getValue().toString()
                    val entryText = singleEntryEntry.child("entryText").getValue().toString()
                    val date = singleEntryEntry.child("date").getValue().toString()
                    val currentEntry = Entry(title, entryText, date)
                    entries.add(currentEntry)

                }
                myAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("MainFragment", "Failed to read value.", error.toException())
            }
        })

        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}