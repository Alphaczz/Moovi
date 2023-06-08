package com.example.moovi.presentation.di

import com.example.moovi.data.api.tmdbService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class NetModule(private val baseURL:String) {
@Singleton
@Provides
fun provideRetrofit():Retrofit{
    return Retrofit.Builder().addConverterFactory(GsonConverterFactory.
    create()).baseUrl(baseURL).build()
}
    @Singleton
    @Provides
    fun providesTMDBService(retrofit: Retrofit):tmdbService
    {
        return  retrofit.create(tmdbService::class.java)
    }
}