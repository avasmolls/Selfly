package com.example.selfly

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.selfly.databinding.FragmentChooseTipBinding
import com.example.selfly.databinding.FragmentMainBinding

class ChooseTipFragment : Fragment() {

    private var _binding: FragmentChooseTipBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseTipBinding.inflate(inflater, container, false)
        val rootView = binding.root

        setHasOptionsMenu(true)

        binding.backButton4.setOnClickListener {
            rootView.findNavController().navigateUp()
        }

        binding.anxiety.setOnClickListener {
            rootView.findNavController()
                .navigate(R.id.action_chooseTipFragment_to_anxietyTipsFragment)
        }

        binding.sleep.setOnClickListener {
            rootView.findNavController()
                .navigate(R.id.action_chooseTipFragment_to_sleepTipsFragment)
        }

        binding.selfcare.setOnClickListener {
            rootView.findNavController()
                .navigate(R.id.action_chooseTipFragment_to_selfCareTipsFragment)
        }

        binding.selflove.setOnClickListener {
            rootView.findNavController()
                .navigate(R.id.action_chooseTipFragment_to_selfLoveTipsFragment)
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