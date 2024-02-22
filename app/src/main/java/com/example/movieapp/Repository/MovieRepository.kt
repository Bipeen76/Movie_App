package com.example.movieapp.Repository

import com.app.neoleaf.credit.model.MovieData
import com.app.neoleaf.credit.network.ApiServiceImpl
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class MovieRepository @Inject constructor(val apiServiceImpl: ApiServiceImpl) {
    fun getPopularRepository(page: Int): Flow<MovieData> = flow {
        apiServiceImpl.getPopularMovieList(page).onSuccess {
            emit(it)
        }.onFailure {
            var res = MovieData()
            if (it is HttpException) {
                try {
                    res =
                        Gson().fromJson(
                            it.response()!!.errorBody()!!.charStream(),
                            MovieData::class.java
                        ) as MovieData
                } catch (e: Exception) {

                }
            } else {

            }
            emit(res)
        }
    }
}