package com.sam.manualdi

import android.app.Application

class ManualDiApplication:Application(){

    lateinit var container:AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}