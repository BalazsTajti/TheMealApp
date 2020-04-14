package hu.tajti.themealapp.mock.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hu.tajti.themealapp.data.Meal
import hu.tajti.themealapp.data.MealDao

@Database(entities = [Meal::class], version = 1)
abstract class MockMealDatabase: RoomDatabase() {

    abstract fun mealDao(): MealDao

    companion object {
        private var INSTANCE: MockMealDatabase? = null

        fun getInstance(context: Context): MockMealDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.inMemoryDatabaseBuilder(context.applicationContext,
                    MockMealDatabase::class.java).allowMainThreadQueries().build()
            }
            return INSTANCE!!
        }

        fun destroyInstance(context: Context) {
            INSTANCE = null
        }
    }

}