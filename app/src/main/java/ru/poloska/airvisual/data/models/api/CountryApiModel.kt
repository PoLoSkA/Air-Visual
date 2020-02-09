package ru.poloska.airvisual.data.models.api

import com.google.gson.annotations.SerializedName

data class CountryApiModel(
    @SerializedName("country")
    val country: String
)