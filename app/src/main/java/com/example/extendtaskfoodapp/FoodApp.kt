package com.example.extendtaskfoodapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@HiltAndroidApp
class FoodApp : Application() {
//    override fun onCreate() {
//        super.onCreate()
//        startKoin {
//            androidLogger()
//            androidContext(this@FoodApp)
//            modules(modules = module)
//        }
//    }
}