package com.health.jokes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.health.jokes.model.RetrofitBuilder
import com.health.jokes.repository.MainRepoImpl

class ViewModelFactory () : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepoImpl(RetrofitBuilder.apiService)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}


