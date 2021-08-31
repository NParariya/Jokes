package com.health.jokes.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.health.jokes.R
import com.health.jokes.databinding.ListviewBinding
import com.health.jokes.model.Joke

internal class JokesAdapter
    (private var jokeList : ArrayList<Joke>) :
    RecyclerView.Adapter<JokesAdapter.MyViewHolder>() {



        internal inner class MyViewHolder( val binding: ListviewBinding) : RecyclerView.ViewHolder(binding.root)


        fun updateJokeList(newJokeList : ArrayList<Joke>) {
            jokeList.clear()
            jokeList.addAll(newJokeList)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesAdapter.MyViewHolder {


            return MyViewHolder(ListviewBinding.inflate((LayoutInflater.from(parent.context)), parent, false))
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val jokes = jokeList[position]
            holder.binding.tvSetup.text = jokes.setup
            holder.binding.tvSetup.text = jokes.punchline
        }

        override fun getItemCount(): Int {
            return jokeList.size
        }
    }
