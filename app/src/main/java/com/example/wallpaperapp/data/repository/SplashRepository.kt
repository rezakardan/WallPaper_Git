package com.example.wallpaperapp.data.repository

import com.example.wallpaperapp.data.network.ApiServices
import javax.inject.Inject

class SplashRepository @Inject constructor(private val api: ApiServices) {
    suspend fun getRandomPhoto() = api.getRandomPhoto()
}