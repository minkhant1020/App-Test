package mkkcom.example.apptest.api.model

import mkkcom.example.apptest.api.ApiService
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Api {

    private fun <T> createApiService(okHttpClient: OkHttpClient, url: String, clazz: Class<T>): T {
        val retrofit = Retrofit.Builder()
            .baseUrl  (url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        return retrofit.create(clazz)
    }

    fun createApiService(okHttpClient: OkHttpClient): ApiService {
           return createApiService(
               okHttpClient = okHttpClient,
               url = "https://api.themoviedb.org/3/",
               clazz = ApiService::class.java
           )

    }

     fun createOkHttpClient(
         headerInterceptor: Interceptor,
         loggingInterceptor: Interceptor
     ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(headerInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    fun getHeaderInterceptor(): Interceptor{
        return Interceptor { chain ->
            val requestBuilder = chain.request().newBuilder()
                requestBuilder.addHeader("accept", "application/json")
                requestBuilder.addHeader(
                    "Authorization",
                    "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwZWUwMTIyZWJhNWVkMjI0MWY4YWU5OWNmMGQyYTcyMyIsIm5iZiI6MTcyNDIzMDY1NS4zODA4ODEsInN1YiI6IjY2YzVhNWRjNjVmOWE3ZDRmYWY3Mzk1ZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.1B7cq3tRL0FgA75oRVIeG1s7nBEI0QfAavtkEaORgUk"
                )
            chain.proceed(requestBuilder.build())
        }
    }

    fun getLoggingInterceptor(): Interceptor{
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }
}