package mon.ie.android.mediator

import mon.ie.common.base.BaseMediator
import mon.ie.common.base.FeatureFacade
import mon.ie.common.extensions.nullable
import mon.ie.splash.SplashApi
import mon.ie.splash.SplashFeature

class SplashMediator : BaseMediator() {

    private var featureInternal: FeatureFacade<SplashApi>? by nullable {
        SplashFeature()
    }

    override val feature
        get() = requireNotNull(featureInternal)

    override fun clearFeature() {
        featureInternal = null
    }
}