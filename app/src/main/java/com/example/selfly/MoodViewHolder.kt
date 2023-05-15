package com.example.selfly

import androidx.recyclerview.widget.RecyclerView
import com.example.selfly.databinding.ListItemLayoutMoodsBinding

class MoodViewHolder(val binding: ListItemLayoutMoodsBinding) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var currentMood: Mood

    fun bindMood(mood: Mood) {
        currentMood = mood
        binding.textViewMood.text = currentMood.mood
        binding.imageViewMood.setImageResource(currentMood.resourceID)
        binding.moodDate.text = currentMood.month.toString() + "/" + currentMood.day.toString() + "/" + currentMood.year.toString()
    }
}