package ru.poloska.airvisual.data.models

import com.google.gson.annotations.SerializedName

data class CountriesList(
    @SerializedName("data")
    val countriesList: List<Country>,
    @SerializedName("status")
    val status: String
)