package com.example.wb_homework.app

import android.app.Application
import com.example.wb_homework.di.appModule
import com.example.wb_homework.di.dataModule
import com.example.wb_homework.di.domainModule
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(level = Level.DEBUG)
            modules(
                listOf(appModule, dataModule, domainModule)
            )
        }
    }
}