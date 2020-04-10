package hu.tajti.themealapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MealDao {
    @Query("""SELECT COUNT(*) FROM meals""")
    fun countMeals(): Long

    @Query("SELECT * FROM meals")
    fun getAllMeals(): List<Meal>

    @Query("SELECT * FROM meals WHERE mealId = :mealId")
    fun getMealById(mealId: Long): Meal

    @Insert
    fun insertMeals(vararg meals: Meal)

    @Query("""DELETE FROM meals WHERE mealId = :mealId""")
    fun deleteMealById(mealId: Long)
}