package com.example.selfly

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.selfly.databinding.FragmentAnxietyTipsBinding
import com.example.selfly.databinding.FragmentSelfCareTipsBinding

class SelfCareTipsFragment : Fragment() {

    private var _binding: FragmentSelfCareTipsBinding? = null
    private val binding get() = _binding!!

    var place = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        _binding = FragmentSelfCareTipsBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.tip.text = getString(R.string.care1)

        binding.backButton7.setOnClickListener {
            rootView.findNavController().navigateUp()
        }


        binding.toWebsite.setOnClickListener {
            openWebPage("https://www.wellnessworkdays.com/post/five-self-care-practices-for-every-area-of-your-life")
        }

        binding.clickFor.setOnClickListener {
            if (place == 0) {
                binding.tip.text = getString(R.string.care1)
                place++
            } else if (place == 1) {
                binding.tip.text = getString(R.string.care2)
                place++
            } else if (place == 2) {
                binding.tip.text = getString(R.string.care3)
                place++
            } else if (place == 3) {
                binding.tip.text = getString(R.string.care4)
                place++
            } else {
                binding.tip.text = getString(R.string.care5)
                place = 0
            }
        }

        return rootView

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("SuspiciousIndentation")
    fun openWebPage(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        startActivity(intent)
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