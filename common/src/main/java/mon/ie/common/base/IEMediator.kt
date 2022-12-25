package mon.ie.common.base

abstract class IEMediator {
    abstract val feature: FeatureFacade<*>
    abstract fun clearFeature()
}