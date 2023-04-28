package com.example.selfly

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.selfly.databinding.ListItemLayoutJournalBinding

class EntryAdapter(val entryList: List<Entry>) : RecyclerView.Adapter<EntryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        val binding = ListItemLayoutJournalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EntryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        val currentEntry = entryList[position]
        holder.bindEntry(currentEntry)
    }

    override fun getItemCount(): Int {
        return entryList.size
    }
}