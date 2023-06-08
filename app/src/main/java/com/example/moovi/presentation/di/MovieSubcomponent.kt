package com.example.moovi.presentation.di

import android.app.Activity
import com.example.moovi.presentation.MainActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [movieModule::class])
interface MovieSubcomponent {
    fun inject(movieActivity: MainActivity)
    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubcomponent
    }
}