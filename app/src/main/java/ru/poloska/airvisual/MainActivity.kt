package ru.poloska.airvisual

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.poloska.airvisual.data.AirVisualRepository


class MainActivity : AppCompatActivity() {

    val LOG_TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.base_activity,
                CountriesFragment()
            ).commit()
        }
    }
}
