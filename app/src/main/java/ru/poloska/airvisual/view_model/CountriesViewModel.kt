package ru.poloska.airvisual.view_model

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.poloska.airvisual.data.AirVisualRepository
import ru.poloska.airvisual.data.models.app_model.CountriesList

/**
 * User: yakimov
 * Date: 2020-02-13
 * Time: 15:39
 */
class CountriesViewModel: BaseViewModel() {
    private val repo = AirVisualRepository()

    fun getCountriesList(): Single<CountriesList>{
        showProgress(true)
        return repo.getCountriesList().subscribeOn(Schedulers.io()).doOnSuccess {
            showProgress(false)
        }
    }
}