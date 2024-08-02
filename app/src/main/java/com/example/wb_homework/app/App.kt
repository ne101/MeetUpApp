package com.example.wb_homework.app

import android.app.Application
import com.example.data.di.dataModule
import com.example.domain.di.domainModule
import com.example.wb_homework.di.appModule
import com.example.wb_homework.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@App)
            modules(appModule)
        }
    }
}