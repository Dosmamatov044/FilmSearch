package com.example.filmsearch

import android.app.Application
import com.example.filmsearch.room.DocDao
import com.example.filmsearch.room.DocDatabase
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class App : Application() {
    private lateinit var retrofit: Retrofit
    override fun onCreate() {
        super.onCreate()
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(logger).build()


        retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL).client(okHttpClient)//Базовая часть адреса
            .addConverterFactory(GsonConverterFactory.create(gson)) //Конвертер, необходимый для преобразования JSON'а в объекты
            .build()
        api =
            retrofit.create(FilmSearchApi::class.java) //Создаем объект, при помощи которого будем выполнять запросы


      val getDatabase= DocDatabase.invoke(this)

        getDao=getDatabase.getDocDao()
    }
    companion object {
        var api: FilmSearchApi? = null
            private set

        lateinit var getDao:DocDao
    }



}