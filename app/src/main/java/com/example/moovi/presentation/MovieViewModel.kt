package com.example.moovi.presentation

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moovi.domain.usecase.getMovieUseCase
import com.example.moovi.domain.usecase.updateMovieUseCase

class MovieViewModel(private val getMovieUseCase: getMovieUseCase,
    private val updateMovieUseCase: updateMovieUseCase):ViewModel()
{
        fun getMovies()= liveData {
            val movieList=getMovieUseCase.execute()
            emit(movieList)
        }
    fun updateMovies()= liveData {
        val movieList=updateMovieUseCase.execute()
        emit(movieList)
    }
}
