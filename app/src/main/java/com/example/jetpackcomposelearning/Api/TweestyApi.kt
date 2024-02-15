package com.example.jetpackcomposelearning.Api

import com.example.jetpackcomposelearning.models.TweetListItems
import dagger.Provides
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers


interface TweestyApi {
    @GET("/v3/b/65bb8fe21f5677401f2956aa?meta=false")
    suspend  fun getTweets(@Header("X-JSON-Path") category: String): Response<List<TweetListItems>>

    @GET("/v3/b/65bb8fe21f5677401f2956aa?meta=false")
    @Headers("X-JSON-Path:tweets..category", "Content-Type:application/json")
    suspend fun getCategories(): Response<List<String>>


}