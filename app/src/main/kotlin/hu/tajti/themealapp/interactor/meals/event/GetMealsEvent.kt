package hu.tajti.themealapp.interactor.meals.event

import hu.tajti.themealapp.model.Meal

data class GetMealsEvent(var meals: List<Meal>? = listOf())