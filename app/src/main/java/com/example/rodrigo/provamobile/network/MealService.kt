package com.example.rodrigo.provamobile.network

import com.example.rodrigo.provamobile.entities.MealList
import retrofit2.Call
import retrofit2.http.GET

interface MealService {

    @GET("json/v1/1/randomselection.php")
    fun getRandomMeal(): Call<MealList>

    @GET("json/v1/1/latest.php")
    fun getLatestMeal(): Call<MealList>

}