package com.example.selfly

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.selfly.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.tipsVector.setOnClickListener {
            rootView.findNavController()
                .navigate(R.id.action_mainFragment_to_chooseTipFragment)
        }

        binding.moodVector.setOnClickListener {
            rootView.findNavController()
                .navigate(R.id.action_mainFragment_to_moodTrackerFragment)
        }

        binding.journalVector.setOnClickListener {
            rootView.findNavController()
                .navigate(R.id.action_mainFragment_to_chooseJournalFragment)
        }

        binding.calmVector.setOnClickListener {
            rootView.findNavController()
                .navigate(R.id.action_mainFragment_to_calmingDownFragment)
        }
        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
                onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}