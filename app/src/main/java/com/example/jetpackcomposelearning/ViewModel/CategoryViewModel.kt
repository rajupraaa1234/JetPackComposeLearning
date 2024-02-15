package com.example.jetpackcomposelearning.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposelearning.Repository.TweetRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repo: TweetRepo) : ViewModel(){
    val categories : StateFlow<List<String>>
        get() = repo.categories

    init {
        viewModelScope.launch {
            repo.getCategories()
        }
    }
}