package hu.tajti.themealapp.interactor.newmeal

import hu.tajti.themealapp.data.MealDao
import hu.tajti.themealapp.interactor.newmeal.event.CreateMealEvent
import hu.tajti.themealapp.model.Meal
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class NewMealInteractor @Inject constructor(private val mealDao: MealDao) {
    fun createMeal(meal: Meal) {
        val event = CreateMealEvent()
        mealDao.insertMeals(meal.toMeal())
        EventBus.getDefault().post(event)
    }
}