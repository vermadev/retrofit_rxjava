package com.triarc.tutorial.android.retrofit_rxjava.dependency

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.triarc.tutorial.android.retrofit_rxjava.BuildConfig
import com.triarc.tutorial.android.retrofit_rxjava.common.EndPoints
import com.triarc.tutorial.android.retrofit_rxjava.intf.MazeShowApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Devanshu Verma on 5/2/19
 */
@Module
class RetrofitServiceModule {

    private object Config {
        const val READ_TIMEOUT    = 20L
        const val WRITE_TIMEOUT   = 20L
        const val CONNECT_TIMEOUT = 15L
    }

    private object Date {
        const val FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    }

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().setDateFormat(Date.FORMAT).create()

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(Config.CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(Config.READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(Config.WRITE_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory = GsonConverterFactory.create(gson)

    @Provides
    @Singleton
    fun provideRxJavaCallAdapterFactory(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @Provides
    @Singleton
    fun provideRetrofitBuilder(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory, rxJavaCallAdapterFactory: RxJava2CallAdapterFactory): Retrofit.Builder = Retrofit.Builder()
        .addConverterFactory(gsonConverterFactory)
        .addCallAdapterFactory(rxJavaCallAdapterFactory)
        .client(okHttpClient)

    @Provides
    @Singleton
    fun provideMazeShowApi(builder: Retrofit.Builder): MazeShowApi = builder.baseUrl(EndPoints.SERVER).build().create(MazeShowApi::class.java)
}