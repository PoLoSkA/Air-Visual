package ru.poloska.airvisual.data.models


import com.google.gson.annotations.SerializedName

data class CitiesList(
    @SerializedName("data")
    val citiesList: List<City>,
    @SerializedName("status")
    val status: String
)