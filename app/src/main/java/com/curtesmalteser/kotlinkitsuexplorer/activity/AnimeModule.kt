package com.curtesmalteser.kotlinkitsuexplorer.activity

import com.curtesmalteser.kotlinkitsuexplorer.api.KitsuAPI

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

/**
 * Created by António "Curtes Malteser" Bastião on 10/05/2018.
 */

@Module
class AnimeModule {
    @Provides
    fun provideAnimePresenter(animeModel: AnimeMVP.Model): AnimeMVP.Presenter {
        return AnimePresenter(animeModel)
    }

    @Provides
    fun provideAnimeModel(repository: Repository): AnimeMVP.Model {
        return AnimeModel(repository)
    }

    @Singleton
    @Provides
    fun provideRepository(kitsuAPI: KitsuAPI): Repository {
        return AnimeRepository(kitsuAPI)
    }
}
