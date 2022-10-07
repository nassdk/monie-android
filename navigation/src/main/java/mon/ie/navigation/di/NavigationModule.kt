package ru.kcenter.navigation.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.Module
import dagger.Provides
import ru.kcenter.navigation.holder.LocalCiceroneHolder
import ru.kcenter.navigation.router.KCRouter
import ru.kcenter.navigation.router.KCRouterImpl
import javax.inject.Singleton

@Module
object NavigationModule {

    private val cicerone = Cicerone.create(KCRouterImpl())

    @Provides
    @Singleton
    fun provideRouter(): KCRouter = cicerone.router

    @Provides
    @Singleton
    fun provideNavigatorHolder(): NavigatorHolder = cicerone.getNavigatorHolder()

    @Provides
    @Singleton
    fun provideCiceroneHolder() = LocalCiceroneHolder()
}