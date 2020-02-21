package ru.poloska.airvisual.data.network

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.poloska.airvisual.data.models.api_model.CitiesListApiModel
import ru.poloska.airvisual.data.models.api_model.CountriesListApiModel
import ru.poloska.airvisual.data.models.api_model.SpecifiedCityDataApiModel
import ru.poloska.airvisual.data.models.api_model.StatesListApiModel

/**
 * User: yakimov
 * Date: 2020-02-10
 * Time: 15:16
 */

interface AirVisualAPI {
    @GET("states")
    fun getStatesList(
        @Query("country") country: String,
        @Query("key") apiKey: String
    ): Single<StatesListApiModel>

    @GET("countries")
    fun getCountriesList(
        @Query("key") apiKey: String
    ): Observable<CountriesListApiModel>

    @GET("cities")
    fun getCitiesList(
        @Query("state") state: String,
        @Query("country") country: String,
        @Query("key") apiKey: String
    ): Single<CitiesListApiModel>

    @GET("city")
    fun getSpecifiedCityData(
        @Query("city") city: String,
        @Query("state") state: String,
        @Query("country") country: String,
        @Query("key") apiKey: String
    ): Single<SpecifiedCityDataApiModel>

    @GET("nearest_city")
    fun getDataByGps(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("key") apiKey: String
    ): Single<SpecifiedCityDataApiModel>
}