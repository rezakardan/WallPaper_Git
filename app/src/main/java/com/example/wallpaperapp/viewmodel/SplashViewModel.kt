package com.example.wallpaperapp.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpaperapp.data.model.splash.ResponseRandom
import com.example.wallpaperapp.data.repository.SplashRepository
import com.example.wallpaperapp.utils.network.NetworkRequest
import com.example.wallpaperapp.utils.network.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val repository: SplashRepository) : ViewModel() {
    //Random
    private val _randomData = MutableLiveData<NetworkRequest<ResponseRandom>>()
    val randomData: LiveData<NetworkRequest<ResponseRandom>> = _randomData

    fun callRandomApi() = viewModelScope.launch {
        _randomData.value = NetworkRequest.Loading()
        val response = repository.getRandomPhoto()
        _randomData.value = NetworkResponse(response).generateResponse()
    }
}