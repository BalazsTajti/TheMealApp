package hu.tajti.themealapp.data

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataModule(private val context: Context) {
    @Singleton
    @Provides
    fun providesMealDatabase(): MealDatabase {
        return MealDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun providesMealDao(mealDatabase: MealDatabase): MealDao {
        return mealDatabase.mealDao()
    }
}