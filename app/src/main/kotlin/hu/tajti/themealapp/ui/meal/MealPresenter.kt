package hu.tajti.themealapp.ui.meal

import hu.tajti.themealapp.interactor.meal.MealInteractor
import hu.tajti.themealapp.interactor.meal.event.GetMealEvent
import hu.tajti.themealapp.interactor.newmeal.event.DeleteMealEvent
import hu.tajti.themealapp.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class MealPresenter @Inject constructor(private val executor: Executor, private val mealInteractor: MealInteractor): Presenter<MealScreen>() {

    override fun attachScreen(screen: MealScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun loadMeal(mealId: Long?) {
        if (mealId != null) {
            executor.execute {
                mealInteractor.getMeal(mealId)
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onGetMealEventMainThread(event: GetMealEvent) {
        screen?.showMeal(event.meal)
    }

    fun deleteMeal(mealId: Long?) {
        if (mealId != null) {
            executor.execute {
                mealInteractor.deleteMeal(mealId)
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onDeleteMealEventMainThread(event: DeleteMealEvent) {
        screen?.navigateBack()
    }
}