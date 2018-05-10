package com.curtesmalteser.kotlinkitsuexplorer.activity

import io.reactivex.Observable

/**
 * Created by anton on 10/05/2018.
 */

interface AnimeMVP {

    interface Model {
        fun result(): Observable<AnimeViewModel>
    }

    interface View {
        fun updateData(animeViewModel: AnimeViewModel)
        fun showSnackbar(msg: String)
    }

    interface Presenter {
        fun loadData()
        fun rxUnsubscribe()
        fun setView(view: AnimeMVP.View)
    }
}
