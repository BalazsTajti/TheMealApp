package hu.tajti.themealapp.ui

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.tajti.themealapp.interactor.meal.MealInteractor
import hu.tajti.themealapp.interactor.meals.MealsInteractor
import hu.tajti.themealapp.interactor.newmeal.NewMealInteractor
import hu.tajti.themealapp.ui.meal.MealPresenter
import hu.tajti.themealapp.ui.meals.MealsPresenter
import hu.tajti.themealapp.ui.newmeal.NewMealPresenter
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun mealsPresenter(executor: Executor, mealsInteractor: MealsInteractor) = MealsPresenter(executor, mealsInteractor)

    @Provides
    @Singleton
    fun mealPresenter(executor: Executor, mealInteractor: MealInteractor) = MealPresenter(executor, mealInteractor)

    @Provides
    @Singleton
    fun newMealPresenter(executor: Executor, newMealInteractor: NewMealInteractor) = NewMealPresenter(executor, newMealInteractor)

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)

}