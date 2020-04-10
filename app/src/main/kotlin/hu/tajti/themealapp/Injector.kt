package hu.tajti.themealapp

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.room.RoomDatabase


val Activity.injector: TheMealAppApplicationComponent
    get() {
        return (this.applicationContext as TheMealAppApplication).injector
    }

val Fragment.injector: TheMealAppApplicationComponent
    get() {
        return (this.context!!.applicationContext as TheMealAppApplication).injector
    }