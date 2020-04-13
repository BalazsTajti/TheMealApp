package hu.tajti.themealapp.ui.meal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hu.tajti.themealapp.R
import hu.tajti.themealapp.model.Ingredient
import kotlinx.android.synthetic.main.meal_ingredient_row.view.*

class MealIngredientAdapter constructor(private val context: Context): RecyclerView.Adapter<MealIngredientAdapter.ViewHolder>() {

    companion object {
        var ingredients: MutableList<Ingredient> = mutableListOf()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ingredientText: TextView = view.mealIngredientText
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val ingredientView = LayoutInflater.from(context).inflate(R.layout.meal_ingredient_row, viewGroup, false)
        return ViewHolder(ingredientView)
    }

    override fun getItemCount() = ingredients.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ingredient = ingredients[position]

        holder.ingredientText.text = "- ${ingredient.ingredientName}: ${ingredient.amount} ${ingredient.unit}"
    }
}