package com.fzellner.pokedex.data.api

import android.util.Log
import com.fzellner.pokedex.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitIntegration {
    private val baseUrl = BuildConfig.API_URL
    private const val NETWORK_LAYER_TAG = "NetworkLayer"
    private const val APPLICATION_LAYER_TAG = "ApplicationLayer"

    private fun getHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        val networkLogging = HttpLoggingInterceptor { message ->
            Log.d(NETWORK_LAYER_TAG, message)
        }
        val appLogging = HttpLoggingInterceptor { message ->
            Log.d(APPLICATION_LAYER_TAG, message)
        }

        networkLogging.level = HttpLoggingInterceptor.Level.BODY
        appLogging.level = HttpLoggingInterceptor.Level.BODY
        client.interceptors().add(appLogging)
        client.addNetworkInterceptor(networkLogging)

        return client.build()
    }

    fun <T> builder(
        endpoint: Class<T>
    ): T {

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(getGsonBuilder()))
            .client(getHttpClient())
            .build()
            .create(endpoint)
    }

    private fun getGsonBuilder(): Gson {
        return GsonBuilder()
            .create()
    }

}
