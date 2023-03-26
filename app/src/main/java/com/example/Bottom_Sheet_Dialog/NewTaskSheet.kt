package com.example.Bottom_Sheet_Dialog

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.example.Bottom_Sheet_Dialog.databinding.FragmentNewTaskSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NewTaskSheet : BottomSheetDialogFragment()

{

    private lateinit var binding: FragmentNewTaskSheetBinding
    private lateinit var taskViewModel: TaskViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity()
        taskViewModel = ViewModelProvider(activity).get(TaskViewModel::class.java)
        binding.btnSave.setOnClickListener{
            saveAction()
        }
    }

    private fun saveAction() {
        taskViewModel.name.value = binding.name.text.toString()
        taskViewModel.desc.value = binding.Desc.text.toString()
        binding.name.setText("")
        binding.Desc.setText("")
        dismiss()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {

        binding = FragmentNewTaskSheetBinding.inflate(inflater,container,false)
        return binding.root
    }

}