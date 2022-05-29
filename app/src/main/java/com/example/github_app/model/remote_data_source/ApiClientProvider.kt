package com.example.github_app.model.remote_data_source

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

import javax.inject.Inject

class ApiClientProvider @Inject constructor(){
    companion object {
        private const val API_END_POINT = "https://api.github.com/"
    }

    private val json = Json {
        ignoreUnknownKeys = true
    }

    /**
     * return [ApiClient]
     */
    @ExperimentalSerializationApi
    fun provide(): ApiClient {
        return Retrofit.Builder()
            .baseUrl(API_END_POINT)
            .addConverterFactory(
                json.asConverterFactory(
                    "application/json".toMediaType()
                ),
            )
            .build()
            .create(ApiClient::class.java)
    }
}