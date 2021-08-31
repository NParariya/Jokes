package com.health.jokes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.health.jokes.R
import com.health.jokes.databinding.ListviewBinding
import com.health.jokes.databinding.RecyleviewBinding
import com.health.jokes.model.Joke
import com.health.jokes.viewmodel.MainViewModel
import com.health.jokes.viewmodel.ViewModelFactory

class JokeActivity : AppCompatActivity() {

    lateinit var binding : RecyleviewBinding

    private val viewModel : MainViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory())
            .get(MainViewModel::class.java)
    }

    private lateinit var jokesAdapter: JokesAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = RecyleviewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        title = "Jokes"

        viewModel.refresh()
        setupUI()
    }




    private fun setupUI() {
        jokesAdapter = JokesAdapter(ArrayList())
        binding.recycle.layoutManager = LinearLayoutManager(this)
        binding.recycle.adapter = jokesAdapter

        viewModel.joke.observe(this, {joke ->
            joke?.let{jokeList ->
                binding.recycle.visibility = View.VISIBLE
                binding.progressbar.visibility = View.GONE
                jokesAdapter.updateJokeList(jokeList)
            }
        })
    }
}