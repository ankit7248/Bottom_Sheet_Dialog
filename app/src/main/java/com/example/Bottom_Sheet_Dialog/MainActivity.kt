package com.example.Bottom_Sheet_Dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.Bottom_Sheet_Dialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        binding.newTaskButton.setOnClickListener {

            NewTaskSheet().show(supportFragmentManager, "new Task")
        }

        // set the text in  main activity

        taskViewModel.name.observe(this) {
            binding.taskname.text = String.format("Task name: %s", it)

            taskViewModel.desc.observe(this) {
                binding.taskdesc.text = String.format("Task desc: %s", it)
            }
        }
    }
}
