package hu.tajti.themealapp.ui.newmeal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hu.tajti.themealapp.injector
import hu.tajti.themealapp.model.Ingredient
import hu.tajti.themealapp.model.Meal
import javax.inject.Inject

class NewMealActivity : AppCompatActivity(), NewMealScreen {

    private var meal: Meal? = null

    @Inject
    lateinit var newMealPresenter: NewMealPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
    }

    override fun onStart() {
        super.onStart()
        newMealPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        newMealPresenter.detachScreen()
    }

    override fun onResume() {
        super.onResume()
        if (meal == null) {
            meal = Meal()
        }
    }

    override fun createMeal() {
        newMealPresenter.createMeal(meal)
    }

    override fun addIngredient() {
        meal?.ingredients?.add(Ingredient())
    }

    override fun navigateBack() {
        finish()
    }

}