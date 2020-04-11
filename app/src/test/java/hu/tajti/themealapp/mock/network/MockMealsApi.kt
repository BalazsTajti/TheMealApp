package hu.tajti.themealapp.mock.network

import hu.tajti.themealapp.model.RandomMealDto
import hu.tajti.themealapp.network.MealsApi
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MockMealsApi: MealsApi {
    override fun getRandomMeal(): Call<RandomMealDto> {
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

        return object : Call<RandomMealDto> {
            @Throws(IOException::class)
            override fun execute(): Response<RandomMealDto> {
                return Response.success(mealResult)
            }

            override fun enqueue(callback: Callback<RandomMealDto>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<RandomMealDto> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }
    }
}