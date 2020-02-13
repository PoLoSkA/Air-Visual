package ru.poloska.airvisual.data.models.app_model

data class CityWeather(
    val humidity: Int,
    val weatherIcon: String,
    val pressure: Int,
    val temperature: Int,
    val timeStamp: String,
    val windDirection: Int,
    val windSpeed: Double
)
