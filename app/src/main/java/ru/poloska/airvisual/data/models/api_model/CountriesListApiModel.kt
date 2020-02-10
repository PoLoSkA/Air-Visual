package ru.poloska.airvisual.data.models.api_model

import com.google.gson.annotations.SerializedName

data class CountriesListApiModel(
    @SerializedName("data")
    val countriesList: List<CountryApiModel>,
    @SerializedName("status")
    val status: String
)