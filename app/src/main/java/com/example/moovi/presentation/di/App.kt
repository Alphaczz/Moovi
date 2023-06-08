package com.example.moovi.presentation.di

import android.app.Application
import com.bumptech.glide.module.AppGlideModule
import com.example.moovi.BuildConfig


class App:Application(),Injector
{
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
         appComponent= DaggerAppComponent.builder().appModule(appModule(applicationContext)).netModule(NetModule(BuildConfig.BASE_URL))
             .remotedataModule(remotedataModule(BuildConfig.API_KEY)).build()
    }


    override fun createMovieSubComponent(): MovieSubcomponent {
        return appComponent.movieSubComponent().create()    }
}

