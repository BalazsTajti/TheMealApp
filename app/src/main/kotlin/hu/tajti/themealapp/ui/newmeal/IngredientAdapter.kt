package hu.tajti.themealapp.ui.newmeal

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import hu.tajti.themealapp.R
import hu.tajti.themealapp.model.Ingredient
import hu.tajti.themealapp.ui.utils.invisible
import kotlinx.android.synthetic.main.ingredient_row.view.*


class IngredientAdapter constructor(
    private val context: Context,
    private val newMealPresenter: NewMealPresenter): RecyclerView.Adapter<IngredientAdapter.ViewHolder>() {

    companion object {
        var ingredients: MutableList<Ingredient> = mutableListOf()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ingredientName: EditText = view.etIngredientName
        var ingredientUnit: EditText = view.etIngredientUnit
        var ingredientAmount: EditText = view.etIngredientAmount
        var addIngredientFab: FloatingActionButton = view.addIngredientFab

        init {
            val etIngredientName: EditText = view.findViewById(R.id.etIngredientName)
            val etIngredientAmount: EditText = view.findViewById(R.id.etIngredientAmount)
            val etIngredientUnit: EditText = view.findViewById(R.id.etIngredientUnit)

            etIngredientName.addTextChangedListener(object: TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    ingredients[adapterPosition].ingredientName = etIngredientName.text.toString()
                }
            })

            etIngredientUnit.addTextChangedListener(object: TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    ingredients[adapterPosition].unit = etIngredientUnit.text.toString()
                }
            })

            etIngredientAmount.addTextChangedListener(object: TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    ingredients[adapterPosition].amount = etIngredientAmount.text.toString().toDouble()
                }
            })
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val ingredientView = LayoutInflater.from(context).inflate(R.layout.ingredient_row, viewGroup, false)
        return ViewHolder(ingredientView)
    }

    override fun getItemCount() = ingredients.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ingredient = ingredients[position]

        holder.ingredientName.setText(ingredient.ingredientName)
        holder.ingredientAmount.setText(ingredient.amount.toString())
        holder.ingredientUnit.setText(ingredient.unit)
        holder.addIngredientFab.setOnClickListener {
            newMealPresenter.addIngredient()
        }
        if (position == 0) {
            holder.addIngredientFab.show()
        } else {
            holder.addIngredientFab.invisible()
        }
    }
}