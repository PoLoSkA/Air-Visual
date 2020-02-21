package ru.poloska.airvisual.view_model

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

open class BaseViewModel {
    object AlertSignal

    private val progressSubject = PublishSubject.create<Boolean>()
    val retrySubject = PublishSubject.create<Boolean>()

    val progressObserver: Observable<Boolean>
        get() = progressSubject
    val retryObservable: Observable<Boolean>
        get() = retrySubject

    fun updateProgressStatus(flag: Boolean) = progressSubject.onNext(flag)

    fun startRetry() = retrySubject.onNext(true)
}