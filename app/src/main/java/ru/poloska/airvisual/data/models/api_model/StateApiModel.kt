package ru.poloska.airvisual.data.models.api_model


import com.google.gson.annotations.SerializedName

data class StateApiModel(
    @SerializedName("state")
    val state: String
)