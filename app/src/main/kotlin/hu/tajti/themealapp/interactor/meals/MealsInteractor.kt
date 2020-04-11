package hu.tajti.themealapp.interactor.meals

import hu.tajti.themealapp.data.MealDao
import hu.tajti.themealapp.interactor.meals.event.GetMealsEvent
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class MealsInteractor @Inject constructor(private val mealDao: MealDao) {
    fun getMeals() {
        val event = GetMealsEvent()
        val allMeals = mealDao.getAllMeals()
        event.meals = allMeals.map { it.toMeal() }
        EventBus.getDefault().post(event)
    }
}