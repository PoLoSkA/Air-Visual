package ru.poloska.airvisual

import android.app.Application
import android.content.Context
import ru.poloska.airvisual.navgation.Router

class App: Application() {

    init {
        instance = this
    }

    companion object {
        var instance: App? = null

        fun appContext(): Context {
            return instance!!.applicationContext
        }
    }
}