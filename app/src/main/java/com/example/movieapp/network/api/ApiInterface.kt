package com.app.neoleaf.credit.network.api

import com.app.neoleaf.credit.network.URLs
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiInterface {
    @GET(URLs.masters)
    fun getData(
        @Header("Authorization") token: String?,
        @Header("client_code") client_code: String,
        @Path("masterName") masterName: String
    ): Call<ResponseBody>


    @GET
    fun getQuestionMaster(
        @Url urls: String,
        @Header("Authorization") token: String?,
        @Header("client_code") client_code: String
    ): Call<ResponseBody>


    @GET(URLs.presignedurl)
    fun getImageFromUrl(
        @Header("Authorization") token: String?,
        @Header("client_code") client_code: String,
        @Query("filepath") filepath: String
    ): Call<ResponseBody>

}