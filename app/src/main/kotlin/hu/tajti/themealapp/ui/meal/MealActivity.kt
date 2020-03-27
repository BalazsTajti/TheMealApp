package hu.tajti.themealapp.ui.meal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hu.tajti.themealapp.injector
import javax.inject.Inject

class MealActivity: AppCompatActivity(), MealScreen {
    @Inject
    lateinit var mealPresenter: MealPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
    }

    override fun onStart() {
        super.onStart()
        mealPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        mealPresenter.detachScreen()
    }

    override fun showMeal() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteMeal() {
        TODO("Not yet implemented")
    }

    override fun navigateBack() {
        TODO("Not yet implemented")
    }
}