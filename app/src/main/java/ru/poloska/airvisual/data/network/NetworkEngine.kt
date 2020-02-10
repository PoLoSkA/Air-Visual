package ru.poloska.airvisual.data.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.poloska.airvisual.BuildConfig
import java.util.concurrent.TimeUnit

class NetworkEngine private constructor() {
    private val BASE_URL = "https://api.airvisual.com/v2/"

    companion object {
        private var airApi: AirVisualAPI? = null
        fun getInstance(): AirVisualAPI {
            if (airApi == null) {
                airApi = NetworkEngine().getApi()
            }
            return airApi!!
        }
    }

    private fun getOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder().callTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            client.addInterceptor(getClientWithLog())
        }

        return client.build()
    }

    private fun getClientWithLog(): Interceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private fun getRetrofit(URL: String): Retrofit {

        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).baseUrl(URL)
            .client(getOkHttpClient()).build()
    }

    private val apiAirVisual = getRetrofit(BASE_URL).create(AirVisualAPI::class.java)

    private fun getApi() : AirVisualAPI{
        return apiAirVisual
    }

}
