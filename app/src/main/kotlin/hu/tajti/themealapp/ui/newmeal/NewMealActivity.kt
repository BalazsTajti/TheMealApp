package hu.tajti.themealapp.ui.newmeal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hu.tajti.themealapp.injector
import javax.inject.Inject

class NewMealActivity : AppCompatActivity(), NewMealScreen {

    @Inject
    lateinit var newMealPresenter: NewMealPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
    }

    override fun onStart() {
        super.onStart()
        newMealPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        newMealPresenter.detachScreen()
    }

    override fun createMeal() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addIngredient() {
        TODO("Not yet implemented")
    }

    override fun navigateBack() {
        TODO("Not yet implemented")
    }

}