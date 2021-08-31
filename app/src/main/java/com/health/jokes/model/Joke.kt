package com.health.jokes.model

import com.google.gson.annotations.SerializedName

class Joke(
@SerializedName("id")
val id: Int,
@SerializedName("punchline")
val punchline: String,
@SerializedName("setup")
val setup: String,
@SerializedName("type")
val type: String
)
