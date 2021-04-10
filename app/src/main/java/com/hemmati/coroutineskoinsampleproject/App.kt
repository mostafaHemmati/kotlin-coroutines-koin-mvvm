package com.hemmati.coroutineskoinsampleproject

import android.app.Application
import com.hemmati.coroutineskoinsampleproject.di.NetworkModule
import com.hemmati.coroutineskoinsampleproject.di.VideosModule
import com.hemmati.coroutineskoinsampleproject.di.profileModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(VideosModule,NetworkModule,profileModule))
        }


    }
}