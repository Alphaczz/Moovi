package com.example.moovi.presentation.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    appModule::class,
    cacheDataModule::class,
    databaseModule::class,
    localDataModule::class,
     NetModule::class,
     remotedataModule::class,
     repositoryModule::class,
    usecaseModule::class,
])
interface AppComponent {
    fun movieSubComponent():MovieSubcomponent.Factory
}