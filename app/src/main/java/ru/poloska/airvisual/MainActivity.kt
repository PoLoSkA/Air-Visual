package ru.poloska.airvisual

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import ru.poloska.airvisual.data.AirVisualRepository


class MainActivity : AppCompatActivity() {

    val LOG_TAG = MainActivity::class.java.simpleName

    val repo = AirVisualRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            repo.getCountriesList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({
                Log.d(LOG_TAG, it.toString())
            },
                {
                    Log.d(LOG_TAG, "OnError $it")
                })
        }
    }
}
