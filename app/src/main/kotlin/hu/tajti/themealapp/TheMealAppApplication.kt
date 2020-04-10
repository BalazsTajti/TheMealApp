package hu.tajti.themealapp

import android.app.Application
import hu.tajti.themealapp.data.DataModule
import hu.tajti.themealapp.ui.UIModule

class TheMealAppApplication : Application() {
    lateinit var injector: TheMealAppApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerTheMealAppApplicationComponent.builder()
            .uIModule(UIModule(this))
            .dataModule(DataModule(this))
            .build()
    }
}