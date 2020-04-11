package hu.tajti.themealapp.interactor.meal.event

import hu.tajti.themealapp.model.Meal

data class GetMealEvent(var meal: Meal? = null)