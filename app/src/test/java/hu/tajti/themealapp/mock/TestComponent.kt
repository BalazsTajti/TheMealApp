package hu.tajti.themealapp.mock

import dagger.Component
import hu.tajti.themealapp.TheMealAppApplicationComponent
import hu.tajti.themealapp.interactor.InteractorModule
import hu.tajti.themealapp.mock.network.MockNetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, TestModule::class, InteractorModule::class])
interface TestComponent : TheMealAppApplicationComponent {

}