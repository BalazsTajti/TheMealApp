package hu.tajti.themealapp.test

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import hu.tajti.themealapp.data.Meal
import hu.tajti.themealapp.interactor.meal.MealInteractor
import hu.tajti.themealapp.mock.data.MockMealDatabase
import hu.tajti.themealapp.ui.meal.MealPresenter
import hu.tajti.themealapp.ui.meal.MealScreen
import hu.tajti.themealapp.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.concurrent.Executors

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class MealTest {

    lateinit var mealPresenter: MealPresenter
    lateinit var context: Context
    lateinit var mockMealDatabase: MockMealDatabase

    private lateinit var mealScreen: MealScreen

    @Before
    @Throws(Exception::class)
    fun setup() {
        mealScreen = mock()
        context = InstrumentationRegistry.getInstrumentation().context
        val executor = Executors.newSingleThreadExecutor()
        mockMealDatabase = MockMealDatabase.getInstance(context)
        mealPresenter = MealPresenter(executor, MealInteractor(mockMealDatabase.mealDao()))
        mealPresenter.attachScreen(mealScreen)
    }

    @Test
    fun testDeleteMeal() {
        mockMealDatabase.mealDao().insertMeals(Meal())
        val firstMeal = mockMealDatabase.mealDao().getAllMeals().first()
        mealPresenter.deleteMeal(firstMeal.mealId)
        assert(mockMealDatabase.mealDao().countMeals() == 0L)
    }

    @After
    fun tearDown() {
        MockMealDatabase.destroyInstance(context)
    }

}