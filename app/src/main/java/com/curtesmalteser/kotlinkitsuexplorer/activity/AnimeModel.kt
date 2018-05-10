package com.curtesmalteser.kotlinkitsuexplorer.activity

import io.reactivex.Observable

/**
 * Created by António "Curtes Malteser" Bastião on 10/05/2018.
 */

class AnimeModel(private val repository: Repository) : AnimeMVP.Model {

    override fun result(): Observable<AnimeViewModel> {
        return repository.resultData.map { data ->
            AnimeViewModel(data.attributes.titles.enJp,
                    data.attributes.averageRating,
                    data.attributes.posterImage.tiny)
        }
    }
}
