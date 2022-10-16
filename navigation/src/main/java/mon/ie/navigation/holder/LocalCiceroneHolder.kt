package mon.ie.navigation.holder

import com.github.terrakok.cicerone.Cicerone
import mon.ie.navigation.router.MonieRouterImpl
import javax.inject.Inject

class LocalCiceroneHolder @Inject constructor() {

  private val containers = hashMapOf<String, Cicerone<MonieRouterImpl>>()

  fun getCicerone(containerTag: String): Cicerone<MonieRouterImpl> {
    return containers.getOrPut(
      key = containerTag,
      defaultValue = {
        Cicerone.create(MonieRouterImpl())
      }
    )
  }
}