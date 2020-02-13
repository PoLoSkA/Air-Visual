package ru.poloska.airvisual.data.models.api_model
import com.google.gson.annotations.SerializedName

data class CityDataApiModel(
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("current")
    val current: PollutionAndWeatherApiModel,
    @SerializedName("location")
    val locationApiModel: LocationApiModel,
    @SerializedName("state")
    val state: String
)