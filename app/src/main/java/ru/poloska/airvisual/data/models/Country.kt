package ru.poloska.airvisual.data.models

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("country")
    val country: String
)