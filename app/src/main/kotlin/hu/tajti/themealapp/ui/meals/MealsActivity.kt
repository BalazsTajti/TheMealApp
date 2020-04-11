package hu.tajti.themealapp.ui.meals

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hu.tajti.themealapp.R
import hu.tajti.themealapp.data.MealDao
import hu.tajti.themealapp.injector
import hu.tajti.themealapp.model.Meal
import hu.tajti.themealapp.ui.meal.MealActivity
import javax.inject.Inject

class MealsActivity : AppCompatActivity(), MealsScreen {

    private val displayedMeals: MutableList<Meal> = mutableListOf()
    private var mealsAdapter: MealsAdapter? = null

    @Inject
    lateinit var mealsPresenter: MealsPresenter
    @Inject
    lateinit var mealDao: MealDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meals)
        mealsAdapter = MealsAdapter(applicationContext, displayedMeals)
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

    override fun onResume() {
        super.onResume()
        mealsPresenter.refreshMeals()
    }

    override fun showMeals(meals: List<Meal>?) {
        displayedMeals.clear()
        if (meals != null) {
            displayedMeals.addAll(meals)
        }
        mealsAdapter?.notifyDataSetChanged()
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