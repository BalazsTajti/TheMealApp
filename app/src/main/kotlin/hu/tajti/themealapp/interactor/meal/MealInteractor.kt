package hu.tajti.themealapp.interactor.meal

import hu.tajti.themealapp.data.MealDao
import javax.inject.Inject

class MealInteractor @Inject constructor(private val mealDao: MealDao) {
    fun getMeal(mealId: Long) {
        mealDao.getMealById(mealId)
    }

    fun deleteMeal(mealId: Long) {
        mealDao.deleteMealById(mealId)
    }
}