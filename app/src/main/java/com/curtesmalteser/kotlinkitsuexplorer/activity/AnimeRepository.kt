package com.curtesmalteser.kotlinkitsuexplorer.activity

import com.curtesmalteser.kotlinkitsuexplorer.api.KitsuAPI
import com.curtesmalteser.kotlinkitsuexplorer.api.model_anime.Data
import com.curtesmalteser.kotlinkitsuexplorer.api.model_anime.ModelAnime

import java.util.ArrayList

import io.reactivex.Observable
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function

/**
 * Created by António "Curtes Malteser" Bastião on 10/05/2018.
 */
class AnimeRepository(private val kitsuAPI: KitsuAPI) : Repository {
    private val dataList: MutableList<Data>

    private var timestamp: Long = 0

    private val isUpToDate: Boolean
        get() = System.currentTimeMillis() - timestamp < STALE_MS

    override val dataFromMemory: Observable<Data>
        get() {

            if (isUpToDate) {
                return Observable.fromIterable<Data>(dataList)
            } else {
                timestamp = System.currentTimeMillis()
                dataList.clear()
                return Observable.empty<Data>()
            }
        }

    override val dataFromNetwork: Observable<Data>
        get() = kitsuAPI.getAnimeObservable().concatMap(Function<ModelAnime, Observable<Data>> {
            modelAnime -> Observable.fromIterable(modelAnime.getData()) })
                .doOnNext(Consumer<Data> { data -> dataList.add(data) })

    override val resultData: Observable<Data>
        get() = dataFromMemory.switchIfEmpty(dataFromNetwork)

    init {
        this.timestamp = System.currentTimeMillis()
        dataList = ArrayList<Data>()
    }

    companion object {
        private val STALE_MS = (20 * 1000).toLong() // Data is stale after 20 seconds
    }
}
