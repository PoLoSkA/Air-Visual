package ru.poloska.airvisual.data.models.api_model
import com.google.gson.annotations.SerializedName

data class PollutionAndWeatherApiModel(
    @SerializedName("pollution")
    val pollutionModel: PollutionApiModel,
    @SerializedName("weather")
    val weather: WeatherApiModel
)