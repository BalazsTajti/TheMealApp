package hu.tajti.themealapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
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
    var ingredients: String? = null,
    @ColumnInfo(name = "measures")
    var measures: String? = null
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
            meal.measures = randomMealDto.getMeasuresString()
            return meal
        }
    }
}