package com.example.jetpackcomposelearning.Repository

import com.example.jetpackcomposelearning.Api.TweestyApi
import com.example.jetpackcomposelearning.models.TweetListItems
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepo @Inject constructor(private val tweestyApi: TweestyApi){
    private val category = MutableStateFlow<List<String>>(emptyList());
    val categories : StateFlow<List<String>>
        get() = category


    private val tweet = MutableStateFlow<List<TweetListItems>>(emptyList());
    val tweets : StateFlow<List<TweetListItems>>
        get() = tweet

    suspend fun getCategories(){
        val response = tweestyApi.getCategories()
        if(response.isSuccessful && response.body()!=null){
            category.emit(response.body()!!)
        }
    }

    suspend fun getTweets(category: String){
        val response = tweestyApi.getTweets("tweets[?(@.category==\"${category}\")]")
        if(response.isSuccessful && response.body()!=null){
            tweet.emit(response.body()!!)
        }
    }

}