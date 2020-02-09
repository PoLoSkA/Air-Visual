package ru.poloska.airvisual.data.models
import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("hu")
    val humidity: Int,
    @SerializedName("ic")
    val weatherIconCode: String,
    @SerializedName("pr")
    val pressure: Int,
    @SerializedName("tp")
    val temperature: Int,
    @SerializedName("ts")
    val timeStamp: String,
    @SerializedName("wd")
    val windDirection: Int,
    @SerializedName("ws")
    val windSpeed: Double
)