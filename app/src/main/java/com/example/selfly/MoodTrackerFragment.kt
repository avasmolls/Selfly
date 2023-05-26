package com.example.selfly

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.selfly.databinding.FragmentMoodTrackerBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat

class MoodTrackerFragment : Fragment() {

    private var _binding: FragmentMoodTrackerBinding? = null
    private val binding get() = _binding!!

    lateinit var dbRef : DatabaseReference

    // properties
    lateinit var currentMood: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoodTrackerBinding.inflate(inflater, container, false)
        val rootView = binding.root

        dbRef = Firebase.database.reference

        setUpSpinner()

        val moods = mutableListOf<Mood>()

        val myAdapter = MoodAdapter(moods)
        binding.recyclerViewMood.adapter = myAdapter

        binding.enter.setOnClickListener {
            val mood = currentMood
            var resourceID : Int = 0
            if(mood.equals("very happy")) {
                resourceID = R.drawable.ic_baseline_tag_faces_24
            }
            else if(mood.equals("happy")) {
                resourceID = R.drawable.ic_baseline_sentiment_satisfied_alt_24
            }

            else if(mood.equals("calm")) {
                resourceID = R.drawable.ic_baseline_sentiment_satisfied_24
            }

            else if(mood.equals("sad")) {
                resourceID = R.drawable.ic_baseline_sentiment_dissatisfied_24
            }

            else {
                resourceID = R.drawable.ic_baseline_sentiment_very_dissatisfied_24
            }

            val newMood = Mood(mood, resourceID)

            dbRef.child("moods").push().setValue(newMood)
        }

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                //ACCESS OBJECT WITH ALL ENTRIES WITHIN THE DATABASE
                val allDBEntries = dataSnapshot.children

                var numOfMoodsAdded = 0
                // ACCESS EACH VALUE IN DB, AND ADD TO ARRAYLIST
                for (allMoodEntries in allDBEntries) {
                    for (singleMoodEntry in allMoodEntries.children) {
                        numOfMoodsAdded++
                        val mood = singleMoodEntry.child("mood").getValue().toString()
                        val resourceID = singleMoodEntry.child("resourceID").getValue().toString().toInt()
                        val date = singleMoodEntry.child("date").getValue().toString()
                        val currentMood = Mood(mood, resourceID, date)
                        moods.add(currentMood)

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
    fun setUpSpinner() {
        val guestsArrayAdapter = ArrayAdapter.createFromResource(requireActivity(), R.array.mood_array, android.R.layout.simple_spinner_item)
        guestsArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = guestsArrayAdapter
        binding.spinner.onItemSelectedListener = object  : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>, p1: View?, p2: Int, p3: Long) {
                currentMood = p0.getItemAtPosition(p2).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}