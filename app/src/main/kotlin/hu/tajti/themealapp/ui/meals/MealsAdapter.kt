package hu.tajti.themealapp.ui.meals

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hu.tajti.themealapp.R
import hu.tajti.themealapp.model.Meal
import kotlinx.android.synthetic.main.meal_card.view.*

class MealsAdapter constructor(
    private val context: Context,
    private val meals: List<Meal>,
    private val mealsPresenter: MealsPresenter): RecyclerView.Adapter<MealsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ivImage: ImageView = view.ivImage
        var tvName: TextView = view.tvName
        var tvCategory: TextView = view.tvCategory
        var tvArea: TextView = view.tvArea
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val mealView = LayoutInflater.from(context).inflate(R.layout.meal_card, viewGroup, false)
        return ViewHolder(mealView)
    }

    override fun getItemCount() = meals.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val meal = meals[position]

        meal.mealThumbnailUrl?.let {
            val thumbnailUrl = meal.mealThumbnailUrl!!
            if (thumbnailUrl.isNotEmpty()) {
                Glide.with(context).load(thumbnailUrl).into(holder.ivImage)
            }
        }

        holder.tvName.text = meal.mealName
        holder.tvCategory.text = meal.category
        holder.tvArea.text = meal.area

        holder.itemView.findViewById<CardView>(R.id.cardMeal).setOnClickListener {
            mealsPresenter.showMeal(meal.mealId!!)
        }
    }
}