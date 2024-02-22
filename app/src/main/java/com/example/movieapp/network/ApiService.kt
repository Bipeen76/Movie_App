package com.app.neoleaf.credit.network

import com.app.neoleaf.credit.model.MovieData
import retrofit2.http.*

interface ApiService {

    @Headers("application/json")
    @GET(URLs.popular)
    suspend fun getPopularMovieList(
        @Header("Authorization") token: String?,
        @Query("page") page: Int,
    ): Result<MovieData>

    @Headers("application/json")
    @GET(URLs.top_rated)
    suspend fun getTopRatedMovieList(
        @Header("Authorization") token: String?,
        @Query("page") page: Int,
    ): Result<MovieData>
}