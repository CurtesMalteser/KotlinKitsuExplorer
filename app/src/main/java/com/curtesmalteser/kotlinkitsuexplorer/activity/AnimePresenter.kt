package com.curtesmalteser.kotlinkitsuexplorer.activity

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by António "Curtes Malteser" Bastião on 10/05/2018.
 */

class AnimePresenter(private val model: AnimeMVP.Model) : AnimeMVP.Presenter {

    private var view: AnimeMVP.View? = null
    private var disposable: DisposableObserver<*>? = null

    override fun loadData() {

        disposable = model.result()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<AnimeViewModel>() {

                    override fun onNext(animeViewModel: AnimeViewModel) {
                        if (view != null) {
                            view!!.updateData(animeViewModel)
                        }
                    }

                    override fun onError(e: Throwable) {
                        if (view != null) {
                            view!!.showSnackbar("Error getting animes")
                        }
                    }

                    override fun onComplete() {

                    }
                })

    }

    override fun rxUnsubscribe() {
        if (disposable != null) {
            if (!disposable!!.isDisposed) {
                disposable!!.dispose()
            }
        }
    }

    override fun setView(view: AnimeMVP.View) {
        this.view = view
    }
}
