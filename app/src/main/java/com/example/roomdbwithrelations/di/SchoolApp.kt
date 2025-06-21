package com.example.roomdbwithrelations.di

import android.app.Application

class SchoolApp : Application() {
     lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}