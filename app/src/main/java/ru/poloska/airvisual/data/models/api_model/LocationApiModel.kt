package ru.poloska.airvisual.data.models.api_model
import com.google.gson.annotations.SerializedName

data class LocationApiModel(
    @SerializedName("coordinates")
    val coordinates: List<Double>,
    @SerializedName("type")
    val type: String
)