package com.example.selfly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.selfly.databinding.FragmentJournalWritingBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*


class JournalWritingFragment : Fragment() {

    private var _binding: FragmentJournalWritingBinding? = null
    private val binding get() = _binding!!

    lateinit var dbRef : DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJournalWritingBinding.inflate(inflater, container, false)
        val rootView = binding.root

        dbRef = Firebase.database.reference

        binding.enterButton.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme)
                .setTitle(getString(R.string.dialogue_title))
                .setMessage(getString(R.string.dialogue_text))
                .setPositiveButton(getString(R.string.yes)) { dialog, which ->
                    val title = binding.editTextTitle.text.toString()
                    val entry  = binding.editTextEntry.text.toString()
                    val date = getCurrentDateTime().toString("yyyy/MM/dd HH:mm:ss")
                    val newEntry = Entry(title, entry, date)
                    dbRef.child("entries").push().setValue(newEntry)
                    val action = JournalWritingFragmentDirections.actionJournalWritingFragmentToChooseJournalFragment()
                    rootView.findNavController().navigate(action)
                }
                .show()
        }

        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }
}