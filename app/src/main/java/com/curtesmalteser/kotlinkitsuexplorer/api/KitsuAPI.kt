package com.curtesmalteser.kotlinkitsuexplorer.api

import com.curtesmalteser.kotlinkitsuexplorer.api.model_anime.ModelAnime
import com.curtesmalteser.kotlinkitsuexplorer.api.model_manga.ModelManga
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by António "Curtes Malteser" Bastião on 09/05/2018.
 */

interface KitsuAPI {
    @GET("manga?page%5Blimit%5D=20")
    fun getMangaObservable(): Observable<ModelManga>

    @GET ("anime?page%5Blimit%5D=20")
    fun getAnimeObservable(): Observable<ModelAnime>

    // todo - add interface for genres and -> provide pagination?
}