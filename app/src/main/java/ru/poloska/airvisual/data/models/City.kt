package ru.poloska.airvisual.data.models


import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("city")
    val city: String
)