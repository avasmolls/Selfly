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

        var entries = mutableListOf<Entry>()

        val myAdapter = EntryAdapter(entries)
        binding.recyclerView.adapter = myAdapter

        binding.imageButton2.setOnClickListener {
            val action = ChooseJournalFragmentDirections.actionChooseJournalFragmentToJournalWritingFragment("", "")
            rootView.findNavController().navigate(action)
        }

        binding.delete.setOnClickListener {
            dbRef.child("entries").removeValue()
        }

       // setFragmentResultListener("REQUESTING_JOURNAL_KEY") { requestkey : String, bundle: Bundle ->
         //   val result = bundle.getBundle("JOURNAL_KEY")
       // }

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                //ACCESS OBJECT WITH ALL ENTRIES WITHIN THE DATABASE
                val allDBEntries = dataSnapshot.children

                var numOfTeachersAdded = 0
                // ACCESS EACH VALUE IN DB, AND ADD TO ARRAYLIST
                for (allTeacherEntries in allDBEntries) {
                    for (singleTeacherEntry in allTeacherEntries.children) {
                        numOfTeachersAdded++
                        val title = singleTeacherEntry.child("title").getValue().toString()
                        val entryText = singleTeacherEntry.child("entryText").getValue().toString()
                        val date = singleTeacherEntry.child("date").getValue().toString()
                        val currentEntry = Entry(title, entryText, date)
                        entries.add(currentEntry)

                        //Update recyclerview now that teacherList has data in it
                        myAdapter.notifyDataSetChanged()
                    }
                }
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