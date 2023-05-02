package com.example.selfly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.selfly.databinding.FragmentMoodTrackerBinding

class MoodTrackerFragment : Fragment() {

    private var _binding: FragmentMoodTrackerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoodTrackerBinding.inflate(inflater, container, false)
        val rootView = binding.root

        val tempMoods = listOf(Mood("happy", R.drawable.ic_baseline_sentiment_satisfied_alt_24),
        Mood("sad", R.drawable.ic_baseline_sentiment_dissatisfied_24),
        Mood("very happy",R.drawable.ic_baseline_tag_faces_24),
        Mood("calm", R.drawable.ic_baseline_sentiment_satisfied_24))

        val myAdapter = MoodAdapter(tempMoods)
        binding.recyclerViewMood.adapter = myAdapter

        return rootView
    }

}