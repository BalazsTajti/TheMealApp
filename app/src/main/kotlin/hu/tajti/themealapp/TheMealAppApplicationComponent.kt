package hu.tajti.themealapp

import dagger.Component
import hu.tajti.themealapp.data.DataModule
import hu.tajti.themealapp.data.MealDatabase
import hu.tajti.themealapp.interactor.InteractorModule
import hu.tajti.themealapp.network.MealsApi
import hu.tajti.themealapp.network.NetworkModule
import hu.tajti.themealapp.ui.UIModule
import hu.tajti.themealapp.ui.meal.MealActivity
import hu.tajti.themealapp.ui.meals.MealsActivity
import hu.tajti.themealapp.ui.newmeal.NewMealActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, InteractorModule::class, NetworkModule::class, DataModule::class])
interface TheMealAppApplicationComponent {
    fun inject(mealsActivity: MealsActivity)
    fun inject(mealActivity: MealActivity)
    fun inject(newMealActivity: NewMealActivity)
    fun inject(mealDatabase: MealDatabase)
    fun mealsApi(): MealsApi
}