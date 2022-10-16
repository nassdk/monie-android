package mon.ie.navigation.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.Module
import dagger.Provides
import mon.ie.navigation.holder.LocalCiceroneHolder
import mon.ie.navigation.router.MonieRouter
import mon.ie.navigation.router.MonieRouterImpl
import javax.inject.Singleton

@Module
object NavigationModule {

  private val cicerone = Cicerone.create(MonieRouterImpl())

  @Provides
  @Singleton
  fun provideRouter(): MonieRouter = cicerone.router

  @Provides
  @Singleton
  fun provideNavigatorHolder(): NavigatorHolder = cicerone.getNavigatorHolder()

  @Provides
  @Singleton
  fun provideCiceroneHolder() = LocalCiceroneHolder()
}