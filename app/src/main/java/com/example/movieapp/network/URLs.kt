package com.app.neoleaf.credit.network

interface URLs {

    companion object {
        // Movie app list api
        const val popular = "popular"
        const val top_rated = "top_rated"
        const val movie_image_base="https://image.tmdb.org/t/p/w500"
        const val BASE_URL="https://api.themoviedb.org/3/movie/"
        const val TIMEOUT_API = 120
    }
}