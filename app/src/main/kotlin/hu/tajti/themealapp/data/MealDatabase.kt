package hu.tajti.themealapp.data

import android.content.Context
import android.os.AsyncTask
import androidx.annotation.VisibleForTesting
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hu.tajti.themealapp.DaggerTheMealAppApplicationComponent
import hu.tajti.themealapp.TheMealAppApplication
import hu.tajti.themealapp.TheMealAppApplicationComponent
import hu.tajti.themealapp.network.MealsApi
import hu.tajti.themealapp.ui.UIModule
import javax.inject.Inject

@Database(entities = [Meal::class], version = 1)
abstract class MealDatabase: RoomDatabase() {

    abstract fun mealDao(): MealDao

    companion object {
        private var INSTANCE: MealDatabase? = null

        fun getInstance(context: Context): MealDatabase {
            val injector = DaggerTheMealAppApplicationComponent.builder()
                .uIModule(UIModule(context as TheMealAppApplication))
                .dataModule(DataModule(context))
                .build()
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    MealDatabase::class.java, "meal.db")
                    .build()
                INSTANCE!!.initializeData(injector)
            }
            return INSTANCE!!
        }

        fun destroyInstance(context: Context) {
            INSTANCE = null
        }
    }

    @VisibleForTesting
    private fun switchToInMemoryDb(context: Context) {
        INSTANCE = Room.inMemoryDatabaseBuilder(context.applicationContext, MealDatabase::class.java).build()
    }

    private fun initializeData(injector: TheMealAppApplicationComponent) {
        AsyncTask.execute {
            if (mealDao().countMeals() == 0L) {
                runInTransaction {
                    val meals = mutableListOf<Meal>()
                    for (i in 1..10) {
                        val randomMeal = injector.mealsApi().getRandomMeal().execute().body()
                        meals.add(Meal.from(randomMeal!!))
                    }
                    mealDao().insertMeals(*meals.toTypedArray())
                }
            }
        }
    }
}