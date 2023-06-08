package com.example.moovi.presentation.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubcomponent::class])
class appModule(private val context:Context) {
    @Singleton
    @Provides
    fun provideApplicationContext():Context
    {
        return context.applicationContext
    }
}