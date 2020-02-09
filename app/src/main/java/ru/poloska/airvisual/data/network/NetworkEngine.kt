package ru.poloska.airvisual.data.network

import io.reactivex.Single
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.GET
import ru.poloska.airvisual.BuildConfig
import ru.poloska.airvisual.data.models.api.*
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
        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).baseUrl(URL)
            .client(getOkHttpClient()).build()

        return retrofit
    }

    private val apiAirVisual = getRetrofit(BASE_URL).create(AirVisualAPI::class.java)

    private fun getApi() : AirVisualAPI{
        return apiAirVisual
    }

}
private val API_KEY = "6c483487-b2ce-4688-9b47-3e4772b9760b"
interface AirVisualAPI{

    @GET("countries")
    fun getCountryList(
        @Field("key") apiKey: String
    ) : Single<CountriesListApiModel>

    @GET("states")
    fun getStatesList(
        @Field("counry") countryApiModel: CountryApiModel,
        @Field("key") apiKey: String
    ) : Single<StatesListApiModel>

    @GET("cities")
    fun getCitiesList(
        @Field("state") stateApiModel: StateApiModel,
        @Field("country") countryApiModel: CountryApiModel,
        @Field("key") apiKey: String
    ) : Single<CitiesListApiModel>

    @GET("city")
    fun getSpecifiedCityData(
        @Field("city") cityApiModel: CityApiModel,
        @Field("state") stateApiModel: StateApiModel,
        @Field("country") countryApiModel: CountryApiModel,
        @Field("key") apiKey: String
    ): Single<SpecifiedCityDataApiModel>

    @GET("nearest_city")
    fun getDataByGps(
        @Field("lat") state: Double,
        @Field("lon") country: Double,
        @Field("key") apiKey: String
    ) : Single<SpecifiedCityDataApiModel>


}