package hu.tajti.themealapp.ui.newmeal

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import hu.tajti.themealapp.R
import hu.tajti.themealapp.injector
import hu.tajti.themealapp.model.Ingredient
import hu.tajti.themealapp.model.Meal
import kotlinx.android.synthetic.main.activity_new_meal.*
import javax.inject.Inject

class NewMealActivity : AppCompatActivity(), NewMealScreen {

    private var meal: Meal? = null
    private var ingredientAdapter: IngredientAdapter? = null

    @Inject
    lateinit var newMealPresenter: NewMealPresenter

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_new_meal)

        val actionbar = supportActionBar
        actionbar?.title = "Create meal"
        actionbar?.setDisplayHomeAsUpEnabled(true)

        meal = Meal()
        val ingredient = Ingredient()
        ingredient.amount = 0.0
        meal?.ingredients?.add(ingredient)
        ingredientAdapter = IngredientAdapter(this@NewMealActivity, newMealPresenter)
        IngredientAdapter.ingredients = meal?.ingredients!!
        val llm = LinearLayoutManager(this@NewMealActivity)
        llm.orientation = LinearLayoutManager.VERTICAL
        recyclerViewIngredients.layoutManager = llm
        recyclerViewIngredients.isNestedScrollingEnabled = false
        recyclerViewIngredients.adapter = ingredientAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.new_meal_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_create -> {
            createMeal()
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
        if (TextUtils.isEmpty(etMealName.text)) {
            etMealName.error = "Meal name is required!"
        }
        if (TextUtils.isEmpty(etMealCategory.text)) {
            etMealCategory.error = "Meal category is required!"
        }
        if (TextUtils.isEmpty(etArea.text)) {
            etArea.error = "Meal area is required!"
        }
        if (TextUtils.isEmpty(etInstructions.text)) {
            etInstructions.error = "Meal instructions is required!"
        }

        if (TextUtils.isEmpty(etMealName.text) || TextUtils.isEmpty(etMealCategory.text) ||
            TextUtils.isEmpty(etArea.text) || TextUtils.isEmpty(etInstructions.text)) {
            return
        }
        meal?.mealName = etMealName.text.toString()
        meal?.area = etArea.text.toString()
        meal?.category = etMealCategory.text.toString()
        meal?.instructions = etInstructions.text.toString()
        newMealPresenter.createMeal(meal)
    }

    override fun addIngredient() {
        val ingredient = Ingredient()
        ingredient.amount = 0.0
        meal?.ingredients?.add(ingredient)
        ingredientAdapter?.notifyDataSetChanged()
    }

    override fun navigateBack() {
        onBackPressed()
    }

}