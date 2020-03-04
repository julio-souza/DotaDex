package com.codingwolf.dotadex

import android.app.Application
import com.codingwolf.dotadex.di.DaggerAppComponent
import com.facebook.stetho.Stetho

class App : Application() {

    val appComponent by lazy { DaggerAppComponent.factory().create(applicationContext) }

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)
    }
}
