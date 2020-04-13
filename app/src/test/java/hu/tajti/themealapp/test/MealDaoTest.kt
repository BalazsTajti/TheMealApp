package hu.tajti.themealapp.test

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import hu.tajti.themealapp.data.Meal
import hu.tajti.themealapp.mock.data.MockMealDatabase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.util.concurrent.BackgroundExecutor
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [29])
class MealDaoTest {

    lateinit var context: Context
    lateinit var mockMealDatabase: MockMealDatabase

    @Before
    @Throws(Exception::class)
    fun setup() {
        context = InstrumentationRegistry.getInstrumentation().context
        mockMealDatabase = MockMealDatabase.getInstance(context)
    }

    @Test
    fun testDao() {
        BackgroundExecutor.runInBackground {
            assert(mockMealDatabase.mealDao().countMeals() == 0L)
            assert(mockMealDatabase.mealDao().getAllMeals().isEmpty())
            val meal = Meal()
            meal.mealName = "testMeal"
            mockMealDatabase.mealDao().insertMeals(meal)
            assert(mockMealDatabase.mealDao().countMeals() == 1L)
            val allMeals = mockMealDatabase.mealDao().getAllMeals()
            assert(allMeals.isNotEmpty())
            assert(mockMealDatabase.mealDao().getMealById(allMeals.first().mealId!!).mealName == "testMeal")
            mockMealDatabase.mealDao().deleteMealById(allMeals.first().mealId!!)
            assert(mockMealDatabase.mealDao().countMeals() == 0L)
            assert(mockMealDatabase.mealDao().getAllMeals().isEmpty())
        }
    }

    @After
    fun tearDown() {
        MockMealDatabase.destroyInstance(context)
    }

}