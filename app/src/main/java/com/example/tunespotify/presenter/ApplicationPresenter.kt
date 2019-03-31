package com.example.tunespotify.presenter

import com.example.tunespotify.TuneSpotifyApp
import com.example.tunespotify.TuneSpotifyApp.Companion.BEARER_TOKEN
import com.example.tunespotify.repository.TokenAuthenticator
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApplicationPresenter {

    fun createOkHttpClient(): OkHttpClient {
        val stetho = StethoInterceptor()
        return OkHttpClient.Builder()
            .addInterceptor { t ->
                val original = t.request()
                val requestBuilder = original.newBuilder().header("Authorization", "Bearer " + BEARER_TOKEN)
                t.proceed(requestBuilder.build())
            }
            .cache(provideCache())
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .addNetworkInterceptor(stetho)
            .authenticator(TokenAuthenticator())
            .build()
    }

    fun provideCache(): Cache {
        val cacheSize = 10 * 1024 * 1024L // 10 MB
        return Cache(TuneSpotifyApp.INSTANCE.cacheDir, cacheSize)
    }


    inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
        val gson = GsonBuilder()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
        return retrofit.create(T::class.java)
    }
}