package hu.tajti.themealapp.ui.meal

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import hu.tajti.themealapp.R
import hu.tajti.themealapp.injector
import hu.tajti.themealapp.model.Meal
import hu.tajti.themealapp.ui.meals.MealsActivity
import kotlinx.android.synthetic.main.activity_meal.*
import javax.inject.Inject

class MealActivity: AppCompatActivity(), MealScreen {
    private var meal: Meal? = null
    private var ingredientAdapter: MealIngredientAdapter? = null

    @Inject
    lateinit var mealPresenter: MealPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_meal)

        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)

        ingredientAdapter = MealIngredientAdapter(this@MealActivity)
        val llm = LinearLayoutManager(this@MealActivity)
        llm.orientation = LinearLayoutManager.VERTICAL
        recyclerViewMealIngredients.layoutManager = llm
        recyclerViewMealIngredients.isNestedScrollingEnabled = false
        recyclerViewMealIngredients.adapter = ingredientAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.meal_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_delete -> {
            deleteMeal()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
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
        tvMealInstructions.text = meal?.instructions
        tvMealName.text = meal?.mealName
        tvMealArea.text = meal?.area
        tvMealCategory.text = meal?.category
        meal?.mealThumbnailUrl?.let {
            val thumbnailUrl = meal.mealThumbnailUrl!!
            if (thumbnailUrl.isNotEmpty()) {
                Glide.with(applicationContext).load(thumbnailUrl).into(mealImage)
            }
        }
        MealIngredientAdapter.ingredients = meal?.ingredients!!
        supportActionBar?.title = meal.mealName
        ingredientAdapter?.notifyDataSetChanged()
    }

    override fun deleteMeal() {
        mealPresenter.deleteMeal(meal?.mealId)
    }

    override fun navigateBack() {
        onBackPressed()
    }
}