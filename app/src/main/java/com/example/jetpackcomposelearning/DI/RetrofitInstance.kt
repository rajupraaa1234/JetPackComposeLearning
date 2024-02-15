package com.example.jetpackcomposelearning.DI

import com.example.jetpackcomposelearning.Api.TweestyApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private
    const val BASE_URL = "https://api.jsonbin.io/"
    val api: TweestyApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(TweestyApi::class.java)
    }
}