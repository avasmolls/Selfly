package com.example.selfly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.selfly.databinding.FragmentMoodTrackerBinding

class MoodTrackerFragment : Fragment() {

    private var _binding: FragmentMoodTrackerBinding? = null
    private val binding get() = _binding!!

    // properties
    lateinit var currentMood: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoodTrackerBinding.inflate(inflater, container, false)
        val rootView = binding.root

        setUpSpinner()

        val tempMoods = listOf(Mood("happy", R.drawable.ic_baseline_sentiment_satisfied_alt_24, 3, 4, 2023),
        Mood("sad", R.drawable.ic_baseline_sentiment_dissatisfied_24, 4, 5, 2023),
        Mood("very happy",R.drawable.ic_baseline_tag_faces_24, 5, 2, 2023),
        Mood("calm", R.drawable.ic_baseline_sentiment_satisfied_24, 5, 3, 2023))

        val myAdapter = MoodAdapter(tempMoods)
        binding.recyclerViewMood.adapter = myAdapter

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