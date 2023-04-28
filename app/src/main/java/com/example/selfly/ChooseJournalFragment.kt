package com.example.selfly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.selfly.databinding.FragmentChooseJournalBinding
import com.example.selfly.databinding.FragmentChooseTipBinding

class ChooseJournalFragment : Fragment() {

    private var _binding: FragmentChooseJournalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseJournalBinding.inflate(inflater, container, false)
        val rootView = binding.root

        val tempEntries = listOf(Entry("temp one", 3, 28, 2023, "this is an entry"),
            Entry("temp two", 4, 4, 2023, "this is an entry"),
            Entry("temp three", 4, 16, 2023, "this is an entry"),
            Entry("temp four", 4, 21, 2023, "this is an entry"))

        val myAdapter = EntryAdapter(tempEntries)
        binding.recyclerView.adapter = myAdapter

        return rootView
    }

}