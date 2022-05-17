package de.stollenmayer.philipp.Pop_1_1_Androi.data

import android.content.Context
import android.webkit.WebView
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiFactory(val context: Context) {

    private val BASE_URL = "https://hgfmjh6704.xyz/"

    fun create() : ApiService {
        val userAgent = WebView(context).settings.userAgentString
        val client = OkHttpClient.Builder().addInterceptor {
            val request = it.request().newBuilder()
                .header("User-Agent", userAgent)
                .build()
            it.proceed(request)
        }.build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client)
            .build()
        return retrofit.create(ApiService::class.java)
    }
}