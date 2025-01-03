package com.example.wallpaperapp.data.network

import com.example.wallpaperapp.data.model.detail.ResponseDetail
import com.example.wallpaperapp.data.model.home.ResponseCategories
import com.example.wallpaperapp.data.model.home.ResponsePhotos
import com.example.wallpaperapp.data.model.search.ResponseSearch
import com.example.wallpaperapp.data.model.splash.ResponseRandom
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {
    @GET("photos/random")
    suspend fun getRandomPhoto(): Response<ResponseRandom>

    @GET("photos")
    suspend fun getNewestPhotos(): Response<ResponsePhotos>

    @GET("topics")
    suspend fun getCategoriesList(): Response<ResponseCategories>

    @GET("topics/{id}/photos")
    suspend fun getCategoryPhotos(@Path("id") id: String, @Query("page") page: Int): Response<ResponsePhotos>

    @GET("search/photos")
    suspend fun getSearchPhotos(@Query("query") query: String, @Query("page") page: Int): Response<ResponseSearch>

    @GET("photos/{id}")
    suspend fun getDetailPhoto(@Path("id") id: String): Response<ResponseDetail>
}