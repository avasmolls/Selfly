package com.example.selfly

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewPropertyAnimator
import android.view.animation.LinearInterpolator
import androidx.navigation.findNavController
import com.example.selfly.databinding.FragmentCalmingDownBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CalmingDownFragment : Fragment() {

    private var _binding: FragmentCalmingDownBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalmingDownBinding.inflate(inflater, container, false)
        val rootView = binding.root

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
            animator.setListener(object: AnimatorListenerAdapter(){
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

}