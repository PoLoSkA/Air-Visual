package ru.poloska.airvisual.data.models
import com.google.gson.annotations.SerializedName
import ru.poloska.airvisual.data.models.Pollution
import ru.poloska.airvisual.data.models.Weather

data class PollutionAndWeather(
    @SerializedName("pollution")
    val pollution: Pollution,
    @SerializedName("weather")
    val weather: Weather
)