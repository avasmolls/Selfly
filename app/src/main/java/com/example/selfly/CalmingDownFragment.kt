package com.example.selfly

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.view.animation.LinearInterpolator
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.selfly.databinding.FragmentCalmingDownBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CalmingDownFragment : Fragment() {

    private var _binding: FragmentCalmingDownBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalmingDownBinding.inflate(inflater, container, false)
        val rootView = binding.root
        setHasOptionsMenu(true)

        val animator : ViewPropertyAnimator = binding.circle.animate()
            .scaleX(
                if(binding.circle.scaleX>1.3) {
                    binding.breathe.text = "Breathe Out..."
                    0.5f
                }
                else {
                    binding.breathe.text = "Breathe In..."
                    1.5f
                }
                )
            .scaleY(
                if(binding.circle.scaleY>1.3) {
                    0.5f
                }
                else {
                    1.5f
                }
            )
            .setDuration(5000)
            .setInterpolator(LinearInterpolator())
            animator.setListener(@SuppressLint("SuspiciousIndentation")
            object: AnimatorListenerAdapter(){
                override fun onAnimationEnd(animation: Animator) {
                    binding.circle.animate()
                        .scaleX(
                            if(binding.circle.scaleX>1.3) {
                               binding.breathe.text = "Breathe Out..."
                                0.5f
                            }
                            else {
                                binding.breathe.text = "Breathe In..."
                                1.5f
                            }
                        )
                        .scaleY(
                            if(binding.circle.scaleY>1.3) {
                                0.5f
                            }
                            else {
                                1.5f
                            }
                        )
                        .setDuration(5000)
                        .setInterpolator(LinearInterpolator())
                        .setListener(this).start()
                }
            })

        binding.backButton.setOnClickListener {
            binding.circle.animate().cancel()
            rootView.findNavController().navigateUp()
        }

        binding.button6.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme)
                .setTitle(getString(R.string.dialogue_title))
                .setMessage(getString(R.string.calm_done))
                .setPositiveButton(getString(R.string.yes)) { dialog, which ->
                    binding.circle.animate().cancel()
                    rootView.findNavController().navigateUp()
                }
                .setNegativeButton(getString(R.string.no)) { dialog, which ->

                }
                .show()
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