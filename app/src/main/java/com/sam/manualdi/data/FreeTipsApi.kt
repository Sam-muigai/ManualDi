package com.sam.manualdi.data

import com.sam.manualdi.model.FreeTips
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface FreeTipsApi {

    @GET("free")
    suspend fun getFreeTips(): FreeTips

    companion object {
        const val BASE_URL = "https://us-central1-tiktok-b6aed.cloudfunctions.net/trial/"
        val getTips: FreeTipsApi by lazy {
            Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FreeTipsApi::class.java)
        }
    }
}