package hu.tajti.themealapp.mock.network

import hu.tajti.themealapp.model.MealsResponse
import hu.tajti.themealapp.model.RandomMealDto
import hu.tajti.themealapp.network.MealsApi
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MockMealsApi: MealsApi {
    override fun getRandomMeal(): Call<MealsResponse> {
        val mealsResponse = MealsResponse()
        val mealResult = RandomMealDto()
        mealResult.strMeasure1 = "600g"
        mealResult.strIngredient1 = "testIngredient1"
        mealResult.strMeasure2 = "2 tsp"
        mealResult.strIngredient2 = "testIngredient2"
        mealResult.idMeal = "1"
        mealResult.strCategory = "testCategory"
        mealResult.strDrinkAlternate = "testDrinkAlternate"
        mealResult.strMeal = "testMeal"
        mealResult.strInstructions = "testInstructions"
        mealResult.strMealThumb = "testMealThumb"
        mealResult.strSource = "testSource"
        mealsResponse.meals?.add(mealResult)

        return object : Call<MealsResponse> {
            @Throws(IOException::class)
            override fun execute(): Response<MealsResponse> {
                return Response.success(mealsResponse)
            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<MealsResponse> {
                return this
            }

            override fun request(): Request? {
                return null
            }

            override fun enqueue(callback: Callback<MealsResponse>) {

            }
        }
    }
}