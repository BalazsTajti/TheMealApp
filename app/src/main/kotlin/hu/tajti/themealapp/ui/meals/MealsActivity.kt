package hu.tajti.themealapp.ui.meals

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import hu.tajti.themealapp.R
import hu.tajti.themealapp.data.MealDao
import hu.tajti.themealapp.injector
import hu.tajti.themealapp.model.Meal
import hu.tajti.themealapp.ui.meal.MealActivity
import hu.tajti.themealapp.ui.newmeal.NewMealActivity
import hu.tajti.themealapp.ui.utils.hide
import hu.tajti.themealapp.ui.utils.show
import kotlinx.android.synthetic.main.activity_meals.*
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
        injector.inject(this)
        setContentView(R.layout.activity_meals)
        mealsAdapter = MealsAdapter(applicationContext, displayedMeals, mealsPresenter)
        val llm = LinearLayoutManager(applicationContext)
        llm.orientation = LinearLayoutManager.VERTICAL
        recyclerViewMeals.layoutManager = llm
        recyclerViewMeals.adapter = mealsAdapter

        swipeRefreshLayoutMeals.setOnRefreshListener {
            mealsPresenter.refreshMeals()
        }

        fab.setOnClickListener {
            val intent = Intent(this, NewMealActivity::class.java)
            startActivity(intent)
        }

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
        swipeRefreshLayoutMeals.isRefreshing = false
        displayedMeals.clear()
        if (meals != null) {
            displayedMeals.addAll(meals)
        }
        mealsAdapter?.notifyDataSetChanged()
        if (displayedMeals.isEmpty()) {
            recyclerViewMeals.hide()
            tvEmpty.show()
        } else {
            recyclerViewMeals.show()
            tvEmpty.hide()
        }
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