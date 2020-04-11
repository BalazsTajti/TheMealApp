package hu.tajti.themealapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import hu.tajti.themealapp.model.Ingredient
import hu.tajti.themealapp.model.RandomMealDto

@Entity(tableName = Meal.TABLE_NAME)
class Meal(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "mealId")
    var mealId: Long? = null,
    @ColumnInfo(name = "mealName")
    var mealName: String? = null,
    @ColumnInfo(name = "drinkAlternateName")
    var drinkAlternateName: String? = null,
    @ColumnInfo(name = "category")
    var category: String? = null,
    @ColumnInfo(name = "area")
    var area: String? = null,
    @ColumnInfo(name = "instructions")
    var instructions: String? = null,
    @ColumnInfo(name = "mealThumbnailUrl")
    var mealThumbnailUrl: String? = null,
    @ColumnInfo(name = "ingredients")
    var ingredients: String? = null
) {
    companion object {
        const val TABLE_NAME = "meals"
        fun from(randomMealDto: RandomMealDto): Meal {
            val meal = Meal()
            meal.mealName = randomMealDto.strMeal
            meal.drinkAlternateName = randomMealDto.strDrinkAlternate
            meal.category = randomMealDto.strCategory
            meal.area = randomMealDto.strArea
            meal.instructions = randomMealDto.strInstructions
            meal.mealThumbnailUrl = randomMealDto.strMealThumb
            meal.ingredients = randomMealDto.getIngredientsString()
            return meal
        }
    }

    fun toMeal(): hu.tajti.themealapp.model.Meal {
        val meal = hu.tajti.themealapp.model.Meal()
        meal.area = this.area
        meal.category = this.category
        meal.drinkAlternateName = this.drinkAlternateName
        meal.mealId = this.mealId
        meal.mealName = this.mealName
        meal.mealThumbnailUrl = this.mealThumbnailUrl
        meal.instructions = this.instructions
        meal.ingredients = this.ingredients?.split(",")?.map {
            val ingredient = Ingredient()
            val split = it.split("|")
            ingredient.ingredientName = split[1].trim()
            val lastDigitIndex = split[0].indexOfLast { c -> c.isDigit() }
            if (lastDigitIndex == -1) {
                ingredient.unit = split[0].trim()
            } else {
                ingredient.amount = split[0].substring(0, lastDigitIndex + 1).trim().toInt()
                ingredient.unit = split[0].substring(lastDigitIndex + 1)
            }
            ingredient
        }?.toMutableList()
        return meal
    }
}