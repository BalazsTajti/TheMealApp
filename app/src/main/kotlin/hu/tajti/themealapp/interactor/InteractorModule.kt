package hu.tajti.themealapp.interactor

import dagger.Module
import dagger.Provides
import hu.tajti.themealapp.interactor.meal.MealInteractor
import hu.tajti.themealapp.interactor.meals.MealsInteractor
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideMealsInteractor() = MealsInteractor()

    @Provides
    @Singleton
    fun provideMealInteractor() = MealInteractor()
}