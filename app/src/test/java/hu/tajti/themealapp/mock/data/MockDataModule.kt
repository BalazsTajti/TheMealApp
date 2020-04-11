package hu.tajti.themealapp.mock.data

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.tajti.themealapp.data.MealDao
import javax.inject.Singleton

@Module
class MockDataModule(private val context: Context) {
    @Singleton
    @Provides
    fun providesMealDatabase(): MockMealDatabase {
        return MockMealDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun providesMealDao(mealDatabase: MockMealDatabase): MealDao {
        return mealDatabase.mealDao()
    }
}