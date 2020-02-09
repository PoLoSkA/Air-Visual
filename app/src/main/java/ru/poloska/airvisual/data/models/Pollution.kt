package ru.poloska.airvisual.data.models
import com.google.gson.annotations.SerializedName

data class Pollution(
    @SerializedName("aqicn")
    val aqiValueChinese: Int,
    @SerializedName("aqius")
    val aqiValueUS: Int,
    @SerializedName("maincn")
    val mainPollutantChinese: String,
    @SerializedName("mainus")
    val mainPollutantUsAqi: String,
    @SerializedName("ts")
    val timeStamp: String
)

//"units": { //object containing units information
//    "p2": "ugm3", //pm2.5
//    "p1": "ugm3", //pm10
//    "o3": "ppb", //Ozone O3
//    "n2": "ppb", //Nitrogen dioxide NO2
//    "s2": "ppb", //Sulfur dioxide SO2
//    "co": "ppm" //Carbon monoxide CO
//}