package com.example.selfly

import androidx.recyclerview.widget.RecyclerView
import com.example.selfly.databinding.ListItemLayoutJournalBinding

class EntryViewHolder(val binding: ListItemLayoutJournalBinding) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var currentEntry: Entry

    fun bindEntry(entry: Entry) {
        currentEntry = entry
        binding.titleOfEntry.text = currentEntry.title
        binding.textView.text = currentEntry.entryText
        binding.dateTextView.text = currentEntry.month.toString() + "/" + currentEntry.day.toString() + "/" + currentEntry.year.toString()
    }
}