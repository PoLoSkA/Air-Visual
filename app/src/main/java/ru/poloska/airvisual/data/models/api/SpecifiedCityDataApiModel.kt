package ru.poloska.airvisual.data.models.api
import com.google.gson.annotations.SerializedName
import ru.poloska.airvisual.data.models.api.CityDataApiModel

data class SpecifiedCityDataApiModel(
    @SerializedName("data")
    val cityDataModel: CityDataApiModel,
    @SerializedName("status")
    val status: String
)