package ru.poloska.airvisual.data.models.app_model

data class CityPollution(
    val aqiValueChinese: Int,
    val aqiValueUS: Int,
    val mainPollutantChinese: String,
    val mainPollutantUsAqi: String,
    val timeStamp: String
)
