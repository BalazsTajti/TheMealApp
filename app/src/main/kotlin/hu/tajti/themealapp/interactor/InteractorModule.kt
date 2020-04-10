package hu.tajti.themealapp.interactor

import dagger.Module
import dagger.Provides
import hu.tajti.themealapp.data.MealDao
import hu.tajti.themealapp.interactor.meal.MealInteractor
import hu.tajti.themealapp.interactor.meals.MealsInteractor
import hu.tajti.themealapp.interactor.newmeal.NewMealInteractor
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideMealsInteractor(mealDao: MealDao) = MealsInteractor(mealDao)

    @Provides
    @Singleton
    fun provideMealInteractor(mealDao: MealDao) = MealInteractor(mealDao)

    @Provides
    @Singleton
    fun newMealInteractor(mealDao: MealDao) = NewMealInteractor(mealDao)
}