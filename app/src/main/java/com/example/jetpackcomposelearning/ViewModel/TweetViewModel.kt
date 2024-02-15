package com.example.jetpackcomposelearning.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

import com.example.jetpackcomposelearning.Repository.TweetRepo;
import com.example.jetpackcomposelearning.models.TweetListItems
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


@HiltViewModel
public class TweetViewModel @Inject constructor(private val repo:TweetRepo) : ViewModel(){
    val tweets : StateFlow<List<TweetListItems>>
        get() = repo.tweets

    init {
        viewModelScope.launch {
            repo.getTweets("Technology")
        }
    }
}
