package com.example.movieapp.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.neoleaf.credit.model.MovieData
import com.example.movieapp.Repository.MovieRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieListViewModel @Inject constructor(val movieRepository: MovieRepository) : ViewModel() {

    private val _movieListData: MutableLiveData<MovieData> = MutableLiveData()
    var movieListData = _movieListData


    fun getPopularList(page:Int) = viewModelScope.launch{
        movieRepository.getPopularRepository(page).collect{
            _movieListData.value = it
        }

    }

}