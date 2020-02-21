package ru.poloska.airvisual.view_model

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.poloska.airvisual.data.AirVisualRepository

/**
 * User: yakimov
 * Date: 2020-02-19
 * Time: 13:16
 */
class CityViewModel : BaseViewModel() {
    private val repository = AirVisualRepository.getRepository()

    fun getCity(state: String, country: String): Single<List<String>> {
        updateProgressStatus(true)
        return repository.getCitiesList(state, country).subscribeOn(Schedulers.io()).doOnSuccess {
            updateProgressStatus(false)
        }.map {
            it.citiesList
        }
    }
}