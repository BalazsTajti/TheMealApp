package hu.tajti.themealapp.test

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import hu.tajti.themealapp.interactor.meals.MealsInteractor
import hu.tajti.themealapp.mock.data.MockMealDatabase
import hu.tajti.themealapp.ui.meals.MealsPresenter
import hu.tajti.themealapp.ui.meals.MealsScreen
import hu.tajti.themealapp.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.concurrent.Executors

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class MealsTest {

    lateinit var mealsPresenter: MealsPresenter
    lateinit var context: Context
    lateinit var mockMealDatabase: MockMealDatabase

    private lateinit var mealsScreen: MealsScreen

    @Before
    @Throws(Exception::class)
    fun setup() {
        mealsScreen = mock()
        context = InstrumentationRegistry.getInstrumentation().context
        val executor = Executors.newSingleThreadExecutor()
        mockMealDatabase = MockMealDatabase.getInstance(context)
        mealsPresenter = MealsPresenter(executor, MealsInteractor(mockMealDatabase.mealDao()))
        mockMealDatabase.mealDao().insertMeals(hu.tajti.themealapp.data.Meal())
        mealsPresenter.attachScreen(mealsScreen)
    }

    @Test
    fun testShowMeal() {
        val mealId = 1L
        mealsPresenter.showMeal(mealId)
        verify(mealsScreen).showMeal(mealId)
    }

    @After
    fun tearDown() {
        MockMealDatabase.destroyInstance(context)
    }
}