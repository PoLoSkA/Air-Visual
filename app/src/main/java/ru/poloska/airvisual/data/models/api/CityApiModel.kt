package ru.poloska.airvisual.data.models.api


import com.google.gson.annotations.SerializedName

data class CityApiModel(
    @SerializedName("city")
    val city: String
)