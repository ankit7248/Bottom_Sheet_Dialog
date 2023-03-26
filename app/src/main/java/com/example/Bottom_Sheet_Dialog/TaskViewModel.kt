package com.example.Bottom_Sheet_Dialog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel(){

    var name = MutableLiveData<String>()
    var desc = MutableLiveData<String>()

}