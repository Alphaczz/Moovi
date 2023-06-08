package com.example.moovi.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moovi.domain.usecase.getMovieUseCase
import com.example.moovi.domain.usecase.updateMovieUseCase

class viewModelFactory (private val getMovieUseCase: getMovieUseCase,
                        private val updateMovieUseCase: updateMovieUseCase
):ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMovieUseCase,updateMovieUseCase)as T
    }
}