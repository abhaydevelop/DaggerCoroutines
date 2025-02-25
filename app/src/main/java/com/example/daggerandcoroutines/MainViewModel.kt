package com.example.daggerandcoroutines

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(application: Application, private val repository: Repository) : AndroidViewModel(application) {

    val eventUpcommingApiData = MutableStateFlow(NetworkStatus(Status.LOADING, Country(), null))

    fun getEventUpcommingListApiData(cityId: String, CatId: String, eventName: String, stageType: String) {
        eventUpcommingApiData.value = NetworkStatus.loading()
        viewModelScope.launch {
            repository.getEventUpCommingListData("382449", "", "", "", "1").catch { error ->
                eventUpcommingApiData.value = NetworkStatus.error(error.message.toString())
            }.collect {
                if (it.data?.status == true) {
                    eventUpcommingApiData.value = NetworkStatus.success(it.data)
                } else {
                    if (it.data?.auth_code == "100100") {
                        eventUpcommingApiData.value = NetworkStatus.error(it.data?.auth_code.toString())
                    } else {
                        eventUpcommingApiData.value = NetworkStatus.error(it.data?.message.toString())
                    }
                }
            }
        }
    }
}
