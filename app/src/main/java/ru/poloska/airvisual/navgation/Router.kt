package ru.poloska.airvisual.navgation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import ru.poloska.airvisual.CityFragment
import ru.poloska.airvisual.CountriesFragment
import ru.poloska.airvisual.MainActivity
import ru.poloska.airvisual.StatesFragment

object Router {
    private val bundle = Bundle()
    private lateinit var manager: FragmentManager
    private var FRAGMENT_FRAME: Int = 0

    fun initFragmentManager(activity: MainActivity) {
        manager = activity.supportFragmentManager
    }

    fun getFM():FragmentManager = manager

    fun setFragmentFrame(@IdRes frame: Int) {
        FRAGMENT_FRAME = frame
    }

    fun goToCountriesFragment() {
        navigateTo(CountriesFragment(), CountriesFragment::class.java.simpleName)
    }

    fun goToStatesFragment(country: String) {

        bundle.putString("CountryKey", country)
        navigateWithBundle(StatesFragment(), bundle, StatesFragment::class.java.simpleName).addToBackStack(null).commit()
    }

    fun goToCityFragment(state: String, country: String){
        bundle.putString("CountryKey", country)
        bundle.putString("StateKey", state)
        navigateWithBundle(CityFragment(), bundle, CityFragment::class.java.simpleName).addToBackStack("City").commit()

    }

    private fun navigateTo(fragment: Fragment, tag: String) {
        manager.beginTransaction().add(FRAGMENT_FRAME, fragment, tag).commit()
    }

    private fun navigateWithBundle(fragment: Fragment, bundle: Bundle, tag: String): FragmentTransaction {
        fragment.arguments = bundle
       return manager.beginTransaction().replace(FRAGMENT_FRAME, fragment, tag)
    }

    fun navigateAndReplace() {}
}