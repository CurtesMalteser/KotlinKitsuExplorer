package com.curtesmalteser.kotlinkitsuexplorer.api

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by António "Curtes Malteser" Bastião on 09/05/2018.
 */

@Module
class KitsuModule {
    val baseURL = "https://kitsu.io/api/edge/"

    @Provides
    fun provideClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
                .build()
    }

    @Provides
    fun provideRetrofit(baseURL: String, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    fun provideApiService(): KitsuAPI {
        return provideRetrofit(baseURL, provideClient()).create(KitsuAPI::class.java)
    }

}