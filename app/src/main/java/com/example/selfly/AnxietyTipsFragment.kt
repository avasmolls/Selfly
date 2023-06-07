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
import com.example.selfly.databinding.FragmentCalmingDownBinding


class AnxietyTipsFragment : Fragment() {

    private var _binding: FragmentAnxietyTipsBinding? = null
    private val binding get() = _binding!!

    var place = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)

        _binding = FragmentAnxietyTipsBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.tip.text = getString(R.string.tip1)

        binding.backButton2.setOnClickListener {
            rootView.findNavController().navigateUp()
        }

        binding.toWebsite.setOnClickListener {
            openWebPage("https://www.mayoclinichealthsystem.org/hometown-health/speaking-of-health/11-tips-for-coping-with-an-anxiety-disorder")
        }

        binding.clickFor.setOnClickListener {
            if(place == 0) {
                binding.tip.text = getString(R.string.tip1)
                place++
            }
            else if(place == 1) {
                binding.tip.text = getString(R.string.tip2)
                place++
            }
            else if(place == 2) {
                binding.tip.text = getString(R.string.tip3)
                place++
            }
            else if(place == 3) {
                binding.tip.text = getString(R.string.tip4)
                place++
            }
            else if(place == 4) {
                binding.tip.text = getString(R.string.tip5)
                place++
            }
            else if(place == 5) {
                binding.tip.text = getString(R.string.tip6)
                place++
            }
            else if(place == 6) {
                binding.tip.text = getString(R.string.tip7)
                place++
            }
            else if(place == 7) {
                binding.tip.text = getString(R.string.tip8)
                place++
            }
            else if(place == 8) {
                binding.tip.text = getString(R.string.tip9)
                place++
            }
            else if(place == 9) {
                binding.tip.text = getString(R.string.tip10)
                place++
            }
            else {
                binding.tip.text = getString(R.string.tip11)
                place = 0
            }

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

    @SuppressLint("SuspiciousIndentation")
    fun openWebPage(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
    }

}