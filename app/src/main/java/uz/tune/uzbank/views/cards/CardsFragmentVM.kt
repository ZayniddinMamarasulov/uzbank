package uz.tune.uzbank.views.cards

import android.os.Handler
import android.provider.Telephony.Mms.Rate
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.tune.uzbank.BaseVM
import uz.tune.uzbank.models.RateModel
import uz.tune.uzbank.network.ApiClient
import uz.tune.uzbank.services.ExchangeRateService

class CardsFragmentVM(
    handle: SavedStateHandle
) : BaseVM() {

    private val userName = handle.get<String>("user_name")
    private val userAge = handle.get<Int>("user_age")

    val userNameLiveData: MutableLiveData<String?> = MutableLiveData()
    val userAgeLiveData: MutableLiveData<Int?> = MutableLiveData()

    val ratesLiveData: MutableLiveData<List<RateModel>> = MutableLiveData()

    init {
        userNameLiveData.value = userName
        userAgeLiveData.value = userAge

        Handler().postDelayed({
            userAgeLiveData.value = 100
        }, 2000)

        hideLiveData.value = Unit

        getRates()
    }


    private fun getRates() {
        ApiClient.getRetrofit().create(ExchangeRateService::class.java).getRates()
            .enqueue(object : Callback<List<RateModel>> {
                override fun onResponse(
                    call: Call<List<RateModel>>,
                    response: Response<List<RateModel>>
                ) {
                    if (response.isSuccessful) {
                        ratesLiveData.value = response.body()
                    }
                }

                override fun onFailure(call: Call<List<RateModel>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }


}