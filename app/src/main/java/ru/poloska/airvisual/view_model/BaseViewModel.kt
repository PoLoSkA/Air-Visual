package ru.poloska.airvisual.view_model

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

open class BaseViewModel {

    private val progressSubject = PublishSubject.create<Boolean>()
    val progressObserver: Observable<Boolean>
        get() = progressSubject

    fun showProgress(flag: Boolean) = progressSubject.onNext(flag)
}