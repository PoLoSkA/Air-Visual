package ru.poloska.airvisual.data.models


import com.google.gson.annotations.SerializedName

data class StatesList(
    @SerializedName("data")
    val statesList: List<State>,
    @SerializedName("status")
    val status: String
)