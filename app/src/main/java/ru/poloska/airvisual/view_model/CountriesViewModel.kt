package ru.poloska.airvisual.view_model

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import ru.poloska.airvisual.data.AirVisualRepository

/**
 * User: yakimov
 * Date: 2020-02-13
 * Time: 15:39
 */
class CountriesViewModel : BaseViewModel() {

    private val repository = AirVisualRepository.getRepository()


    fun getCountriesList(): Observable<List<String>> {
        updateProgressStatus(true)
        return repository.getCountriesList().subscribeOn(Schedulers.io()).map {
            it.countriesList
        }
            .doOnComplete {
                updateProgressStatus(false)
            }
            .doOnError {
                updateProgressStatus(false)
            }  .observeOn(AndroidSchedulers.mainThread())

    }
}