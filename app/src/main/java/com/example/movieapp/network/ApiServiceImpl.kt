package com.app.neoleaf.credit.network

import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val apiService: ApiService) {
    suspend fun getPopularMovieList(page: Int) =
        apiService.getPopularMovieList(
            "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2MzNlYmUxZjE3ZWY2YWU3M2MxMDE1MTNlZTliZDVlZCIsInN1YiI6IjY1Y2UzNjQ1YjA0NjA1MDE4M2RiMjQxOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.HbrbU1kKTzHGWYgZYXk0-Yg4AtCeeGYr0h0d-E4vDNw",
            page
        )

    suspend fun getTopRatedMovies(page: Int) =
        apiService.getPopularMovieList(
            "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2MzNlYmUxZjE3ZWY2YWU3M2MxMDE1MTNlZTliZDVlZCIsInN1YiI6IjY1Y2UzNjQ1YjA0NjA1MDE4M2RiMjQxOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.HbrbU1kKTzHGWYgZYXk0-Yg4AtCeeGYr0h0d-E4vDNw",
            page
        )
}