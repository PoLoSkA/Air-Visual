package ru.poloska.airvisual.navgation

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import ru.poloska.airvisual.MainActivity

object Router {
    private lateinit var manager: FragmentManager
    private var FRAGMENT_FRAME: Int = 0

    fun initFragmentManager(activity: MainActivity){
        manager = activity.supportFragmentManager
    }

    fun setFragmentFrame(@IdRes frame: Int){
        FRAGMENT_FRAME = frame
    }

    fun navigateTo(fragment: Fragment, tag: String){
        manager.beginTransaction().add(FRAGMENT_FRAME, fragment, tag).commit()
    }

    fun navigateWithBundle(){}
}