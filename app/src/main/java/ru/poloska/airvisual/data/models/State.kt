package ru.poloska.airvisual.data.models


import com.google.gson.annotations.SerializedName

data class State(
    @SerializedName("state")
    val state: String
)