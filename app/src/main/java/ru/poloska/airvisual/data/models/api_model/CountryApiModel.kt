package ru.poloska.airvisual.data.models.api_model

import com.google.gson.annotations.SerializedName

data class CountryApiModel(
    @SerializedName("country")
    val country: String
)