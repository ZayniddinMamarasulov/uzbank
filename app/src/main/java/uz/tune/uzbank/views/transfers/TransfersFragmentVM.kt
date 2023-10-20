package uz.tune.uzbank.views.transfers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TransfersFragmentVM : ViewModel() {

    private val tempTextLiveData: MutableLiveData<String> = MutableLiveData()

    fun setTemp(value: String) {
        tempTextLiveData.value = value
    }

    fun getTemp(): LiveData<String> {
        return tempTextLiveData
    }

}