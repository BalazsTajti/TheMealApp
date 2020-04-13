package hu.tajti.themealapp.model

import com.google.gson.annotations.SerializedName

data class MealsResponse(
    @SerializedName("meals")
    var meals: List<RandomMealDto>? = listOf()
)