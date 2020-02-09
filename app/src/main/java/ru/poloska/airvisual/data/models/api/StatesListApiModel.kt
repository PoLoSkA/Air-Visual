package ru.poloska.airvisual.data.models.api


import com.google.gson.annotations.SerializedName
import ru.poloska.airvisual.data.models.api.StateApiModel

data class StatesListApiModel(
    @SerializedName("data")
    val statesList: List<StateApiModel>,
    @SerializedName("status")
    val status: String
)