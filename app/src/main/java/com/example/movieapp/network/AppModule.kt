package com.app.neoleaf.credit.network


import com.app.neoleaf.credit.network.URLs.Companion.TIMEOUT_API
import com.app.neoleaf.credit.network.errorhandling.ResultCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesRetrofitBuilder(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(client)
            .baseUrl(URLs.BASE_URL)
            .addCallAdapterFactory(ResultCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)


    @Provides
    @Singleton
    fun providesOkHtpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(LogInterceptor())
            .readTimeout(TIMEOUT_API.toLong(), TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .connectTimeout(TIMEOUT_API.toLong(), TimeUnit.SECONDS).build()
    }

}