package ru.poloska.airvisual

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.poloska.airvisual.navgation.Router


class MainActivity : AppCompatActivity() {

    val LOG_TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRouter()

        Router.navigateTo(CountriesFragment(), "CountriesFragment")
    }

    private fun initRouter() {
        Router.setFragmentFrame(R.id.fragment_frame)
        Router.initFragmentManager(this)
    }
}
