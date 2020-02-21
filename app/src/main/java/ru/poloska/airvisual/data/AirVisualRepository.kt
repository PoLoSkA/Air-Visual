package ru.poloska.airvisual.data

import io.reactivex.Observable
import io.reactivex.Single
import ru.poloska.airvisual.data.models.app_model.CitiesList
import ru.poloska.airvisual.data.models.app_model.CityData
import ru.poloska.airvisual.data.models.app_model.CountriesList
import ru.poloska.airvisual.data.models.app_model.StatesList
import ru.poloska.airvisual.data.models.converters.ConvertToAppModel
import ru.poloska.airvisual.data.network.NetworkEngine

/**
 * User: yakimov
 * Date: 2020-02-10
 * Time: 16:12
 */

class AirVisualRepository private constructor(){
    private val api = NetworkEngine.getInstance()
    private val API_KEY = "6c483487-b2ce-4688-9b47-3e4772b9760b"

    companion object{
        private var airVisualRepository: AirVisualRepository? = null

        fun getRepository(): AirVisualRepository{
            if (airVisualRepository == null){
                airVisualRepository = AirVisualRepository()
            }
            return airVisualRepository!!
        }
    }

    fun getCountriesList(): Observable<CountriesList> = api.getCountriesList(API_KEY).map {
        ConvertToAppModel.countriesList(it)
    }

    fun getStatesList(country: String): Single<StatesList> = api.getStatesList(country, API_KEY).map {
        ConvertToAppModel.statesList(it)
    }

    fun getCitiesList(state: String, country: String): Single<CitiesList> =
        api.getCitiesList(state, country, API_KEY).map {
            ConvertToAppModel.citiesList(it)
        }

    fun getSpecifiedCityData(city: String, state: String, country: String): Single<CityData> =
        api.getSpecifiedCityData(city, state, country, API_KEY).map {
            ConvertToAppModel.cityData(it.cityDataModel)
        }

    fun getDataByGps(lat: Double, lon: Double): Single<CityData> = api.getDataByGps(lat, lon, API_KEY).map {
        ConvertToAppModel.cityData(it.cityDataModel)
    }
}
