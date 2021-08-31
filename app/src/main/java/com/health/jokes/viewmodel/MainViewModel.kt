package com.health.jokes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.health.jokes.model.Joke
import com.health.jokes.repository.MainRepo
import kotlinx.coroutines.launch

class MainViewModel  (private val repo: MainRepo) : ViewModel() {

    private var _joke : MutableLiveData<ArrayList<Joke>?> = MutableLiveData()
    var joke : LiveData<ArrayList<Joke>?> = _joke

    fun refresh(){
        getJokeFromServer()
    }


    fun getJokeFromServer() {
        viewModelScope.launch {
            _joke.value = repo.getJoke()
        }
    }
}