package com.example.wallpaperapp.data.repository

import com.example.wallpaperapp.data.network.ApiServices
import javax.inject.Inject

class DetailRepository @Inject constructor(private val api: ApiServices) {
    suspend fun getDetailPhoto(id: String) = api.getDetailPhoto(id)
}