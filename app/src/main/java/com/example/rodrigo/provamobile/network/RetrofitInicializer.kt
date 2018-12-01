package com.example.rodrigo.provamobile.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInicializer {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.themealdb.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        //cria um objeto e salva a variavel retrofit
        .build()

    fun createMealService() = retrofit.create(MealService::class.java)


}