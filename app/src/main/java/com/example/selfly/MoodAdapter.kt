package com.example.selfly

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.selfly.databinding.ListItemLayoutMoodsBinding

class MoodAdapter (val moodList: List<Mood>) : RecyclerView.Adapter<MoodViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoodViewHolder {
        val binding = ListItemLayoutMoodsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoodViewHolder, position: Int) {
        val currentMood = moodList[position]
        holder.bindMood(currentMood)
    }

    override fun getItemCount(): Int {
        return moodList.size
    }
}

