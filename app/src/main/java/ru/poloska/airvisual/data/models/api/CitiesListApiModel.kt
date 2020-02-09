package ru.poloska.airvisual.data.models.api


import com.google.gson.annotations.SerializedName

data class CitiesListApiModel(
    @SerializedName("data")
    val citiesList: List<CityApiModel>,
    @SerializedName("status")
    val status: String
)