package ru.poloska.airvisual.data.models.api
import com.google.gson.annotations.SerializedName

data class PollutionAndWeatherApiModel(
    @SerializedName("pollution")
    val pollutionModel: PollutionApiModel,
    @SerializedName("weather")
    val weather: WeatherApiModel
)