package com.curtesmalteser.kotlinkitsuexplorer.application

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by António "Curtes Malteser" Bastião on 09/05/2018.
 */

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return application
    }
}