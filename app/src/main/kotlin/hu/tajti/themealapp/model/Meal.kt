package hu.tajti.themealapp.model

import hu.tajti.themealapp.data.Meal

class Meal(
    var mealId: Long? = null,
    var mealName: String? = null,
    var drinkAlternateName: String? = null,
    var category: String? = null,
    var area: String? = null,
    var instructions: String? = null,
    var mealThumbnailUrl: String? = null,
    var ingredients: MutableList<Ingredient>? = mutableListOf()
) {
    fun toMeal(): Meal {
        val meal = Meal()
        meal.mealId = this.mealId
        meal.area = this.area
        meal.mealName = this.mealName
        meal.drinkAlternateName = this.drinkAlternateName
        meal.category = this.category
        meal.instructions = this.instructions
        meal.mealThumbnailUrl = this.mealThumbnailUrl
        meal.ingredients = this.ingredients?.joinToString(",") {
            "${it.amount} ${it.unit}|${it.ingredientName}"
        }
        return meal
    }
}