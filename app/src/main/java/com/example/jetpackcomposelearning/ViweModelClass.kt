package com.example.jetpackcomposelearning

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ViweModelClass(
    private val name : String
) : ViewModel() {
    var customName by mutableStateOf("Raju kumar")
        private set

    fun changeUserName(){
        customName = "rahul kumar gupta ${name}"
    }
}