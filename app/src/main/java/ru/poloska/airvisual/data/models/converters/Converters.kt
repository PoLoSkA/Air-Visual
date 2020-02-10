package ru.poloska.airvisual.data.models.converters

import ru.poloska.airvisual.data.models.api_model.*
import ru.poloska.airvisual.data.models.app_model.*

/**
 * User: yakimov
 * Date: 2020-02-10
 * Time: 14:26
 */
object ConvertToAppModel {

    fun citiesList(citiesListApiModel: CitiesListApiModel): CitiesList {

        val citiesList = ArrayList<String>()

        citiesListApiModel.citiesList.forEach {
            citiesList.add(it.city)
        }

        return CitiesList(citiesList)
    }

    fun countriesList(countriesListApiModel: CountriesListApiModel): CountriesList{

        val countriesList = ArrayList<String>()

        countriesListApiModel.countriesList.forEach {
            countriesList.add(it.country)
        }

        return CountriesList(countriesList)
    }

    fun statesList(statesListApiModel: StatesListApiModel): StatesList{

        val statesList = ArrayList<String>()

        statesListApiModel.statesList.forEach {
            statesList.add(it.state)
        }

        return StatesList(statesList)
    }

    fun cityData(cityDataApiModel: CityDataApiModel): CityData{
        return CityData(
            cityDataApiModel.city,
            cityDataApiModel.country,
            weather(cityDataApiModel.current.weather),
            pollution(cityDataApiModel.current.pollutionModel),
            location(cityDataApiModel.locationApiModel)
        )
    }

    private fun location(locationApiModel: LocationApiModel): CityLocation {
    return CityLocation(
        locationApiModel.coordinates,
        locationApiModel.type
    )
    }

    private fun pollution(pollutionModel: PollutionApiModel): CityPollution {
        return CityPollution(
            pollutionModel.aqiValueChinese,
            pollutionModel.aqiValueUS,
            pollutionModel.mainPollutantChinese,
            pollutionModel.mainPollutantUsAqi,
            pollutionModel.timeStamp
        )
    }

    private fun weather(weatherApiModel: WeatherApiModel): CityWeather {
    return CityWeather(
        weatherApiModel.humidity,
        weatherApiModel.weatherIconCode,
        weatherApiModel.pressure,
        weatherApiModel.temperature,
        weatherApiModel.timeStamp,
        weatherApiModel.windDirection,
        weatherApiModel.windSpeed
    )
    }
}
