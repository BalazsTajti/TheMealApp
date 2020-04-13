package hu.tajti.themealapp.ui.meal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hu.tajti.themealapp.injector
import hu.tajti.themealapp.model.Meal
import hu.tajti.themealapp.ui.meals.MealsActivity
import javax.inject.Inject

class MealActivity: AppCompatActivity(), MealScreen {
    private var meal: Meal? = null

    @Inject
    lateinit var mealPresenter: MealPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
    }

    override fun onStart() {
        super.onStart()
        mealPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        mealPresenter.detachScreen()
    }

    override fun onResume() {
        super.onResume()
        mealPresenter.loadMeal(intent.getLongExtra(MealsActivity.MEAL_ID, 0L))
    }

    override fun showMeal(meal: Meal?) {
        this.meal = meal
    }

    override fun deleteMeal() {
        mealPresenter.deleteMeal(meal?.mealId)
    }

    override fun navigateBack() {
        onBackPressed()
    }
}