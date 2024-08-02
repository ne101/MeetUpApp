package com.example.wb_homework.di

import com.example.data.di.dataModule
import com.example.domain.di.domainModule
import org.koin.dsl.module

val uiModule = module {
    includes(viewModelsModule)
}
val appModule = module {
    includes(uiModule, domainModule, dataModule)
}


