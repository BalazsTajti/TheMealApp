package hu.tajti.themealapp.ui.meals

import hu.tajti.themealapp.model.Meal

interface MealsScreen {
    fun showMeals(meals: List<Meal>?)
    fun showMeal(mealId: Long)
}