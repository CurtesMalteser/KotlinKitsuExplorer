package com.curtesmalteser.kotlinkitsuexplorer.application

import android.app.Application
import com.curtesmalteser.kotlinkitsuexplorer.api.KitsuModule

/**
 * Created by António "Curtes Malteser" Bastião on 09/05/2018.
 */


class App : Application() {

    var component: ApplicationComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .kitsuModule(KitsuModule())
                .build()
    }

    // todo -> check if everything is ok! Other way check the Java class
}
