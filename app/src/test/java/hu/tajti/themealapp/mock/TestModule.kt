package hu.tajti.themealapp.mock

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.tajti.themealapp.interactor.meal.MealInteractor
import hu.tajti.themealapp.interactor.meals.MealsInteractor
import hu.tajti.themealapp.mock.utils.UiExecutor
import hu.tajti.themealapp.ui.meal.MealPresenter
import hu.tajti.themealapp.ui.meals.MealsPresenter
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class TestModule(private val context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideMealsPresenter(executor: Executor, mealsInteractor: MealsInteractor) = MealsPresenter(executor, mealsInteractor)

    @Provides
    @Singleton
    fun provideMealPresenter(executor: Executor, mealInteractor: MealInteractor) = MealPresenter(executor, mealInteractor)

    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor = UiExecutor()
}