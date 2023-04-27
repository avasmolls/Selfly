package com.example.selfly

import androidx.recyclerview.widget.RecyclerView
import com.example.selfly.databinding.ListItemLayoutJournalBinding

class EntryViewHolder(val binding: ListItemLayoutJournalBinding) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentEntry: Entry
}