package ru.poloska.airvisual.data.models.app_model

data class CityData(
    val city: String,
    val country: String,
    val weather: CityWeather,
    val pollution: CityPollution,
    val location: CityLocation
)