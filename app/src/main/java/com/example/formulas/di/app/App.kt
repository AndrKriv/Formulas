package com.example.formulas.di.app

import android.app.Application
import com.example.formulas.di.component.AppComponent
import com.example.formulas.di.component.DaggerAppComponent

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