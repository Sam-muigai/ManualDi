package com.sam.manualdi.data

import com.google.gson.Gson
import com.sam.manualdi.model.FreeTip
import com.sam.manualdi.model.FreeTips
import junit.framework.Assert
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.assertEquals
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class FreeTipsApiTest{

    private lateinit var server:MockWebServer
    private lateinit var api: FreeTipsApi

    @Before
    fun setup(){
        server = MockWebServer()
        api = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FreeTipsApi::class.java)
    }

    @After
    fun tearDown(){
        server.shutdown()
    }

    @Test
    fun `getFreeTips returns expected response`(){
        val expectedResult = FreeTips(
            freeTips = listOf(
                FreeTip(
                    country = "Turkiye",
                    league = "Super Lig",
                    match = "Umraniyespor vs Besiktas",
                    outcome = " Away Win Either Half (Yes)",
                    time = "Apr 22 5:00PM"
                )
            )
        )
        val json = Gson().toJson(expectedResult)
        server.enqueue(MockResponse().setBody(json))
        val actualResponse = runBlocking { api.getFreeTips() }
        assertEquals(actualResponse,expectedResult)
    }
}
