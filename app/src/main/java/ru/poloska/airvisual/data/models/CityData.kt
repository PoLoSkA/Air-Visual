package ru.poloska.airvisual.data.models
import com.google.gson.annotations.SerializedName

data class CityData(
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("current")
    val current: PollutionAndWeather,
    @SerializedName("location")
    val location: Location,
    @SerializedName("state")
    val state: String
)