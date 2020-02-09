package ru.poloska.airvisual.data.models
import com.google.gson.annotations.SerializedName

data class SpecifiedCityData(
    @SerializedName("data")
    val cityData: CityData,
    @SerializedName("status")
    val status: String
)