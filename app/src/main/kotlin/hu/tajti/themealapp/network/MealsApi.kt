package hu.tajti.themealapp.network

import hu.tajti.themealapp.model.RandomMealDto
import retrofit2.Call
import retrofit2.http.GET

interface MealsApi {
    @GET("random.php")
    fun getRandomMeal(): Call<RandomMealDto>
}