package com.health.jokes.repository

import com.health.jokes.model.Joke

interface MainRepo {

    suspend fun getJoke(): ArrayList<Joke>?


}