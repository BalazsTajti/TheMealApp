package hu.tajti.themealapp.interactor.meals

import hu.tajti.themealapp.data.MealDao
import javax.inject.Inject

class MealsInteractor @Inject constructor(private val mealDao: MealDao) {
    fun getMeals() {
        mealDao.getAllMeals()
    }
}