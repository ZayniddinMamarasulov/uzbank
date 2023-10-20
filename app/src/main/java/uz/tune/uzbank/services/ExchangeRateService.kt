package uz.tune.uzbank.services

import retrofit2.Call
import retrofit2.http.GET
import uz.tune.uzbank.models.RateModel

interface ExchangeRateService {

    @GET("arkhiv-kursov-valyut/json/")
    fun getRates(): Call<List<RateModel>>
}