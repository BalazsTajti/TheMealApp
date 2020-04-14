package hu.tajti.themealapp.test

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import hu.tajti.themealapp.interactor.newmeal.NewMealInteractor
import hu.tajti.themealapp.mock.data.MockMealDatabase
import hu.tajti.themealapp.ui.newmeal.NewMealPresenter
import hu.tajti.themealapp.ui.newmeal.NewMealScreen
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
class NewMealTest {

    lateinit var newMealPresenter: NewMealPresenter
    lateinit var context: Context
    lateinit var mockMealDatabase: MockMealDatabase

    private lateinit var newMealScreen: NewMealScreen

    @Before
    @Throws(Exception::class)
    fun setup() {
        newMealScreen = mock()
        context = InstrumentationRegistry.getInstrumentation().context
        val executor = Executors.newSingleThreadExecutor()
        mockMealDatabase = MockMealDatabase.getInstance(context)
        newMealPresenter = NewMealPresenter(executor, NewMealInteractor(mockMealDatabase.mealDao()))
        newMealPresenter.attachScreen(newMealScreen)
    }

    @Test
    fun testAddIngredient() {
        newMealPresenter.addIngredient()

        verify(newMealScreen).addIngredient()
    }

    @After
    fun tearDown() {
        MockMealDatabase.destroyInstance(context)
    }

}