package com.curtesmalteser.kotlinkitsuexplorer.activity

import com.curtesmalteser.kotlinkitsuexplorer.api.model_anime.Data
import io.reactivex.Observable

/**
 * Created by António "Curtes Malteser" Bastião on 10/05/2018.
 */

interface Repository {
    val dataFromMemory: Observable<Data>
    val dataFromNetwork: Observable<Data>

    val resultData: Observable<Data>
}