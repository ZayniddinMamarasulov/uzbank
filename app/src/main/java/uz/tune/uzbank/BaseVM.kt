package uz.tune.uzbank

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseVM : ViewModel() {


    val hideLiveData = MutableLiveData<Unit>()
    val showLiveData = MutableLiveData<Unit>()

}