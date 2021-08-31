package com.health.jokes.model

import retrofit2.http.GET
import retrofit2.http.Query

interface RestApis {


    @GET("random_ten")
    suspend fun getJoke(): ArrayList<Joke>?


}