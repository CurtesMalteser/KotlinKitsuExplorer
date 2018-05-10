package com.curtesmalteser.kotlinkitsuexplorer.application

import com.curtesmalteser.kotlinkitsuexplorer.activity.AnimeModule
import com.curtesmalteser.kotlinkitsuexplorer.activity.MainActivity
import com.curtesmalteser.kotlinkitsuexplorer.api.KitsuModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by António "Curtes Malteser" Bastião on 09/05/2018.
 */

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, KitsuModule::class, AnimeModule::class))
interface ApplicationComponent {
    fun inject(target: MainActivity)
}