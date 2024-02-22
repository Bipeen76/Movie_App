package com.app.neoleaf.credit.network

import android.text.TextUtils
import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response


class LogInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            val builder = request.newBuilder()
            if(!TextUtils.isEmpty(request.url.toString())){
                Log.d("OKHTTP", "${request.url.host}${request.url.encodedPath}")
            }
            return chain.proceed(builder.build())
        }
    }