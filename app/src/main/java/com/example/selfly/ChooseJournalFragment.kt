package com.example.selfly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import com.example.selfly.databinding.FragmentChooseJournalBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

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

        var entries = mutableListOf<Entry>()

        val myAdapter = EntryAdapter(entries)
        binding.recyclerView.adapter = myAdapter

        binding.imageButton2.setOnClickListener {
            val action = ChooseJournalFragmentDirections.actionChooseJournalFragmentToJournalWritingFragment("", "")
            rootView.findNavController().navigate(action)
        }

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val allDBEntries = dataSnapshot.children
                var numOfTeachersAdded = 0
                for (allEntryEntries in allDBEntries) {
                    for (singleTeacherEntry in allEntryEntries.children) {
                        numOfTeachersAdded++
                        val name = singleTeacherEntry.child("name").getValue().toString()
                        val subject = singleTeacherEntry.child("subject").getValue().toString()
                        val yearsString = singleTeacherEntry.child("yearsIn").getValue().toString()
                        val years = Integer.parseInt(yearsString)
                        val currentTeacher = Entry(name, subject, years)
                        entries.add(currentTeacher)

                        //Update recyclerview now that teacherList has data in it
                        myAdapter.notifyDataSetChanged()
                    }
                }
            }


        setFragmentResultListener("REQUESTING_JOURNAL_KEY") { requestKey : String, bundle: Bundle ->
            val result = bundle.getBundle("JOURNAL_KEY")
        }

        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    }

}