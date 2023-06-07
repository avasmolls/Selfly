package com.example.selfly

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.selfly.databinding.FragmentShowEntryBinding
import com.google.firebase.database.DatabaseReference


class ShowEntryFragment : Fragment() {

    private var _binding: FragmentShowEntryBinding? = null
    private val binding get() = _binding!!

    lateinit var dbRef : DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        _binding = FragmentShowEntryBinding.inflate(inflater, container, false)
        val rootView = binding.root

        val args = ShowEntryFragmentArgs.fromBundle(requireArguments())

        binding.textViewTitle.text = args.titleArg
        binding.textViewEntry.text = args.entryTextArg

        binding.backButton9.setOnClickListener {
            rootView.findNavController().navigateUp()
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