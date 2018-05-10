package com.curtesmalteser.kotlinkitsuexplorer.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.curtesmalteser.kotlinkitsuexplorer.R
import com.curtesmalteser.kotlinkitsuexplorer.api.KitsuAPI
import com.curtesmalteser.kotlinkitsuexplorer.application.App
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
import javax.inject.Inject

class MainActivity : AppCompatActivity(), AnimeMVP.View {

    @Inject
    lateinit var presenter: AnimeMVP.Presenter

    private var animeListAdapter: AnimeListAdapter? = null
    private val resultList = ArrayList<AnimeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).component!!.inject(this@MainActivity)

        animeListAdapter = AnimeListAdapter(this, resultList)
        recyclerView.adapter = animeListAdapter
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.setView(this)
        presenter.loadData()
    }

    override fun onStop() {
        super.onStop()
        presenter.rxUnsubscribe()
        resultList.clear()
        animeListAdapter!!.notifyDataSetChanged()
    }

    override fun updateData(animeViewModel: AnimeViewModel) {
        resultList.add(animeViewModel)
        animeListAdapter!!.notifyItemInserted(resultList.size - 1)
    }

    override fun showSnackbar(msg: String) {
        Snackbar.make(rootLayout, msg, Snackbar.LENGTH_SHORT).show()

    }
}
