package com.example.hw4_666

import android.app.Application
import com.example.hw4_666.data.dataModule
import com.example.hw4_666.ui.screens.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(dataModule)
            modules(uiModule)
        }
    }
}