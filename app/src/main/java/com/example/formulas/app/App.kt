package com.example.formulas.app

import android.app.Application
import com.example.formulas.di.AppComponent
import com.example.formulas.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .builder()
            .application(this)
            .build()
            .also { appComponent = it }
            .inject(this)
    }
}