package ru.poloska.airvisual.data.models.api


import com.google.gson.annotations.SerializedName

data class StateApiModel(
    @SerializedName("state")
    val state: String
)