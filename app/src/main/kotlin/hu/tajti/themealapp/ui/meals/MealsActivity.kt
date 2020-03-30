package hu.tajti.themealapp.ui.meals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hu.tajti.themealapp.injector
import javax.inject.Inject

class MealsActivity : AppCompatActivity(), MealsScreen {

    @Inject
    lateinit var mealsPresenter: MealsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
    }

    override fun onStart() {
        super.onStart()
        mealsPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        mealsPresenter.detachScreen()
    }

    override fun showMeals() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMeal(mealId: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}