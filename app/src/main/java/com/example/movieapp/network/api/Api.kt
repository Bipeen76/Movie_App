package com.app.neoleaf.credit.network.api

import com.app.neoleaf.credit.network.URLs
import com.app.neoleaf.credit.network.errorhandling.ResultCallAdapterFactory
import com.app.neoleaf.credit.network.LogInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Api : URLs {
    private var retrofit: Retrofit? = null

    @JvmStatic
    fun getClient(time_out: Int): ApiInterface {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(LogInterceptor())
            .callTimeout(time_out.toLong(), TimeUnit.SECONDS)
            .connectTimeout(time_out.toLong(), TimeUnit.SECONDS)
            .readTimeout(time_out.toLong(), TimeUnit.SECONDS)
            .writeTimeout(time_out.toLong(), TimeUnit.SECONDS)
            .build()

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl("https://api.themoviedb.org/3/movie/")
                .addCallAdapterFactory(ResultCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        //Creating object for our interface
        return retrofit!!.create(
            ApiInterface::class.java
        ) // return the APIInterface object
    }
}