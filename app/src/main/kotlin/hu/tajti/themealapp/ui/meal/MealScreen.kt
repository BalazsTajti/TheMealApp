package hu.tajti.themealapp.ui.meal

import hu.tajti.themealapp.model.Meal

interface MealScreen {
    fun showMeal(meal: Meal?)
    fun deleteMeal()
    fun navigateBack()
}