package com.health.jokes.repository

import android.util.Log
import com.health.jokes.model.Joke
import com.health.jokes.model.RestApis

class MainRepoImpl
    (private val apiServiceRepo: RestApis) : MainRepo {
        override suspend fun getJoke(): ArrayList<Joke>? {
            return try {
                apiServiceRepo.getJoke( )
            } catch (e: Exception) {
                Log.e("Error", e.stackTraceToString())
                null
            }
        }

    }