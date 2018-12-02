package com.example.rodrigo.provamobile.DAO

import android.arch.persistence.room.*

@Dao
interface MealDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(meal: MealBD)

    @Query("SELECT * FROM mealBD")
    fun getAll(): List<MealBD>

    @Delete
    fun delete(meal: MealBD)

    @Query("SELECT * FROM mealbd WHERE idBD = :mealId LIMIT 1")
    fun getMeal(mealId: Int): MealBD

    @Query("SELECT * FROM mealbd WHERE idBD like :mealNome")
    fun findByName(mealNome: String): List<MealBD>

}