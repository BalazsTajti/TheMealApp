package hu.tajti.themealapp.ui.meals

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hu.tajti.themealapp.R
import hu.tajti.themealapp.data.MealDao
import hu.tajti.themealapp.injector
import hu.tajti.themealapp.ui.meal.MealActivity
import javax.inject.Inject

class MealsActivity : AppCompatActivity(), MealsScreen {

    @Inject
    lateinit var mealsPresenter: MealsPresenter
    @Inject
    lateinit var mealDao: MealDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meals)
        injector.inject(this)
    }

    override fun onStart() {
        super.onStart()
        mealsPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        mealsPresenter.detachScreen()
    }

    override fun showMeals() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMeal(mealId: Long) {
        val intent = Intent(this, MealActivity::class.java)
        intent.putExtra(MEAL_ID, mealId)
        startActivity(intent)
    }

    companion object {
        const val MEAL_ID = "MEAL_ID"
    }
}