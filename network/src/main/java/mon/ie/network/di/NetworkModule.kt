package mon.ie.network.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import kotlinx.serialization.json.Json
import mon.ie.network.NetworkApi
import mon.ie.network.NetworkApiImpl
import okhttp3.OkHttpClient

@Module
internal abstract class NetworkModule {

    @Binds
    @NetworkScope
    abstract fun bindModuleApi(impl: NetworkApiImpl): NetworkApi

    companion object {

        @Provides
        @Reusable
        fun provideOkHttp3(): OkHttpClient = OkHttpClient.Builder().build()

        @Provides
        @Reusable
        fun provideJson(): Json {
            return Json(Json) {
                isLenient = true
                ignoreUnknownKeys = true
            }
        }
    }
}