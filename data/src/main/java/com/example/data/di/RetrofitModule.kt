package com.example.data.di

import com.example.data.retrofit.UserService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

val HOST = "http://192.168.1.197:8080"
@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    @Provides
    fun provideOkHttpClient() :OkHttpClient{
        return OkHttpClient.Builder().build()
    }

    @Provides
    fun provideRetrofit(client:OkHttpClient): Retrofit {
        val converterFactory = Json {
            ignoreUnknownKeys = true
        }.asConverterFactory(contentType = "application/json; charset=UTF-8".toMediaType())
        return Retrofit.Builder()
            .baseUrl("$HOST/api/")
            .addConverterFactory(converterFactory) // JSON serialize
            .client(client)
            .build()
    }

    @Provides
    fun provideUserService(retrofit: Retrofit) : UserService{
        return retrofit.create(UserService::class.java)
    }
}