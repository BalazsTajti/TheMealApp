package hu.tajti.themealapp.data

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hu.tajti.themealapp.DaggerTheMealAppApplicationComponent
import hu.tajti.themealapp.TheMealAppApplication
import hu.tajti.themealapp.TheMealAppApplicationComponent
import hu.tajti.themealapp.ui.UIModule

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

    private fun initializeData(injector: TheMealAppApplicationComponent) {
        AsyncTask.execute {
            if (mealDao().countMeals() == 0L) {
                runInTransaction {
                    val meals = mutableListOf<Meal>()
                    while (meals.size < 10) {
                        val randomMeal = injector.mealsApi().getRandomMeal().execute().body()?.meals?.get(0)
                        if (!randomMeal?.hasValidMeasures()!!) {
                            continue
                        }
                        meals.add(Meal.from(randomMeal))
                    }
                    mealDao().insertMeals(*meals.toTypedArray())
                }
            }
        }
    }
}