package com.example.wallpaperapp.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpaperapp.data.model.detail.ResponseDetail
import com.example.wallpaperapp.data.repository.DetailRepository
import com.example.wallpaperapp.utils.network.NetworkRequest
import com.example.wallpaperapp.utils.network.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: DetailRepository) : ViewModel() {
    //Random
    private val _detailData = MutableLiveData<NetworkRequest<ResponseDetail>>()
    val detailData: LiveData<NetworkRequest<ResponseDetail>> = _detailData

    fun callDetailApi(id: String) = viewModelScope.launch {
        _detailData.value = NetworkRequest.Loading()
        val response = repository.getDetailPhoto(id)
        _detailData.value = NetworkResponse(response).generateResponse()
    }
}