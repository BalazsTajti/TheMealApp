package hu.tajti.themealapp.ui.newmeal

import hu.tajti.themealapp.interactor.newmeal.NewMealInteractor
import hu.tajti.themealapp.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class NewMealPresenter @Inject constructor(private val executor: Executor,
                                           private val newMealInteractor: NewMealInteractor): Presenter<NewMealScreen>() {

    override fun attachScreen(screen: NewMealScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun createMeal() {
        executor.execute {
            newMealInteractor.createMeal()
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onCreateMealEventMainThread(event: Any) {
        screen?.navigateBack()
    }

    fun addIngredient() {
        screen?.addIngredient()
    }
}