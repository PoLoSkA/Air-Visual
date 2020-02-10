package ru.poloska.airvisual.data.models.api_model


import com.google.gson.annotations.SerializedName

data class StatesListApiModel(
    @SerializedName("data")
    val statesList: List<StateApiModel>,
    @SerializedName("status")
    val status: String
)