package com.example.data.di

import android.app.Application
import com.example.data.local_data_base.app_data_base.AppDataBase
import org.koin.dsl.module

internal val dbModule = module {
    single {
        val application: Application = get()
        AppDataBase.getInstance(application)
    }
    single { get<AppDataBase>().profileDao() }
    single { get<AppDataBase>().eventDao() }
    single { get<AppDataBase>().communityDao() }
    single { get<AppDataBase>().tagsDao() }
}