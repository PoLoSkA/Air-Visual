package ru.poloska.airvisual.view_model

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.poloska.airvisual.data.AirVisualRepository

/**
 * User: yakimov
 * Date: 2020-02-18
 * Time: 17:48
 */
class StatesViewModel: BaseViewModel() {
    private val repository = AirVisualRepository.getRepository()

    fun getStatesList(country: String): Single<List<String>> {
        updateProgressStatus(true)
    return repository.getStatesList(country).subscribeOn(Schedulers.io())
        .map { it.stateList }.doOnSuccess {
        updateProgressStatus(false)
    }
    }
}
