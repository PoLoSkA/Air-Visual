package ru.poloska.airvisual.data.models.api_model
import com.google.gson.annotations.SerializedName

data class SpecifiedCityDataApiModel(
    @SerializedName("data")
    val cityDataModel: CityDataApiModel,
    @SerializedName("status")
    val status: String
)