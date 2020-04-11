package hu.tajti.themealapp.interactor.meal

import hu.tajti.themealapp.data.MealDao
import hu.tajti.themealapp.interactor.meal.event.GetMealEvent
import hu.tajti.themealapp.interactor.newmeal.event.DeleteMealEvent
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class MealInteractor @Inject constructor(private val mealDao: MealDao) {
    fun getMeal(mealId: Long) {
        val event = GetMealEvent()
        val mealById = mealDao.getMealById(mealId)
        event.meal = mealById.toMeal()
        EventBus.getDefault().post(event)
    }

    fun deleteMeal(mealId: Long) {
        val event = DeleteMealEvent()
        mealDao.deleteMealById(mealId)
        EventBus.getDefault().post(event)
    }
}