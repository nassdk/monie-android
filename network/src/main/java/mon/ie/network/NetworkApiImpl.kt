package mon.ie.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Lazy
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Inject

internal class NetworkApiImpl @Inject constructor() : NetworkApi {

    init {
        NetworkWrapper.getComponent().inject(this)
    }

    @Inject lateinit var json: Lazy<Json>
    @Inject lateinit var okhttp3Client: Lazy<OkHttpClient>

    override fun <T> provideApiClass(interfaceClass: Class<T>): T {
        return Retrofit.Builder()
            .baseUrl("www.pornhub.com")
            .client(okhttp3Client.get())
            .addConverterFactory(json.get().asConverterFactory("application/json".toMediaType()))
            .build()
            .create(interfaceClass)
    }
}