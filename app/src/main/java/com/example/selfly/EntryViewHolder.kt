package com.example.selfly

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.selfly.databinding.ListItemLayoutJournalBinding

class EntryViewHolder(val binding: ListItemLayoutJournalBinding) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var currentEntry: Entry

    init {
        binding.root.setOnClickListener { view ->
            val action = ChooseJournalFragmentDirections.actionChooseJournalFragmentToShowEntryFragment(currentEntry.title, currentEntry.entryText)
            view.findNavController().navigate(action)
        }
    }

    fun bindEntry(entry: Entry) {
        currentEntry = entry
        binding.titleOfEntry.text = currentEntry.title
        binding.textView.text = currentEntry.entryText
        binding.dateTextView.text = currentEntry.date
    }
}