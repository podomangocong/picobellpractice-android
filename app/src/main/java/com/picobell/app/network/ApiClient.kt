package com.picobell.app.network

import com.picobell.app.model.Category
import com.picobell.app.model.CategoryDetail
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET("categories.json")
    suspend fun getCategories(): List<Category>

    @GET("fashion_outer.json")
    suspend fun getCategoryDetail(): CategoryDetail


    companion object {

        private const val baseUrl = "https://picobell-af081-default-rtdb.asia-southeast1.firebasedatabase.app"

        fun create(): ApiClient {

            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiClient::class.java)
        }
    }
}