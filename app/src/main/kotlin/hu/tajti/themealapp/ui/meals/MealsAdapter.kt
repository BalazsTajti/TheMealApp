package hu.tajti.themealapp.ui.meals

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import hu.tajti.themealapp.model.Meal

class MealsAdapter constructor(
    private val context: Context,
    private val meals: List<Meal>): RecyclerView.Adapter<MealsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ivImage: ImageView? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount() = meals.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val meal = meals[position]
    }
}