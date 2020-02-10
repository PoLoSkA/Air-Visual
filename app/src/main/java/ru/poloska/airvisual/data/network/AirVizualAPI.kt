package ru.poloska.airvisual.data.network

import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.GET
import ru.poloska.airvisual.data.models.api_model.*

/**
 * User: yakimov
 * Date: 2020-02-10
 * Time: 15:16
 */

interface AirVisualAPI{

    @GET("states")
    fun getStatesList(
        @Field("counry") country: String,
        @Field("key") apiKey: String
    ) : Single<StatesListApiModel>

    @GET("countries")
    fun getCountriesList(
        @Field("key") apiKey: String
    ) : Single<CountriesListApiModel>

    @GET("cities")
    fun getCitiesList(
        @Field("state") state: String,
        @Field("country") country: String,
        @Field("key") apiKey: String
    ) : Single<CitiesListApiModel>

    @GET("city")
    fun getSpecifiedCityData(
        @Field("city") city: String,
        @Field("state") state: String,
        @Field("country") country: String,
        @Field("key") apiKey: String
    ): Single<SpecifiedCityDataApiModel>

    @GET("nearest_city")
    fun getDataByGps(
        @Field("lat") lat: Double,
        @Field("lon") lon: Double,
        @Field("key") apiKey: String
    ) : Single<SpecifiedCityDataApiModel>
}