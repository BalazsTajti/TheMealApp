package hu.tajti.themealapp.ui.meals

import hu.tajti.themealapp.interactor.meals.MealsInteractor
import hu.tajti.themealapp.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class MealsPresenter @Inject constructor(private val executor: Executor, private val mealsInteractor: MealsInteractor): Presenter<MealsScreen>() {

    override fun attachScreen(screen: MealsScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun refreshMeals() {
        executor.execute {
            mealsInteractor.getMeals()
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onGetMealsEventMainThread(event: Any) {

    }

    fun showMeal(mealId: Long) {
        screen?.showMeal(mealId)
    }
}