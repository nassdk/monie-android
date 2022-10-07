package ru.kcenter.navigation.holder

import com.github.terrakok.cicerone.Cicerone
import ru.kcenter.navigation.router.KCRouterImpl
import javax.inject.Inject

class LocalCiceroneHolder @Inject constructor() {

    private val containers = hashMapOf<String, Cicerone<KCRouterImpl>>()

    fun getCicerone(containerTag: String): Cicerone<KCRouterImpl> {
        return containers.getOrPut(
            key = containerTag,
            defaultValue = {
                Cicerone.create(KCRouterImpl())
            }
        )
    }
}