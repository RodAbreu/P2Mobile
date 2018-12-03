package com.example.rodrigo.provamobile.favoritos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.rodrigo.provamobile.DAO.MealBD
import com.example.rodrigo.provamobile.R
import com.example.rodrigo.provamobile.entities.Meal
import com.example.rodrigo.provamobile.utils.GlideApp
import kotlinx.android.synthetic.main.activity_info_meals.*

class InfoMealsFavoritosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_meals)

        val recebeIntent = getIntent()
        val parametros = recebeIntent.getExtras()

        val meal: MealBD
        if (parametros != null ) {
            meal = parametros.getSerializable("objeto") as MealBD

            nomeMeal.setText(meal.strMeal)

            infoIntrucoes.setText(meal.strInstructions)

            val ingredientes = mutableListOf(meal.strIngredient1, meal.strIngredient2,
                meal.strIngredient3,meal.strIngredient4,meal.strIngredient5,meal.strIngredient6,
                meal.strIngredient7,meal.strIngredient8,meal.strIngredient9,meal.strIngredient10,
                meal.strIngredient11,meal.strIngredient12,meal.strIngredient13,meal.strIngredient14,
                meal.strIngredient15,meal.strIngredient16,meal.strIngredient17,meal.strIngredient18,
                meal.strIngredient19)

            val medidas = mutableListOf(meal.strMeasure1, meal.strMeasure2,
                meal.strMeasure3,meal.strMeasure4,meal.strMeasure5,meal.strMeasure6,
                meal.strMeasure7,meal.strMeasure8,meal.strMeasure9,meal.strMeasure10,
                meal.strMeasure11,meal.strMeasure12,meal.strMeasure13,meal.strMeasure14,
                meal.strMeasure15,meal.strMeasure16,meal.strMeasure17,meal.strMeasure18,
                meal.strMeasure19)

            val ingredientsIterator = ingredientes.listIterator()
            val quantityIterator = medidas.listIterator()
            val stringIngredient = java.lang.StringBuilder()
            val stringQuantity = StringBuilder()

            for(item in ingredientsIterator){
                if(!item.isNullOrBlank()){
                    stringIngredient.append(item).append('\n').append('\n')
                }
            }
            for(item in quantityIterator){
                if(!item.isNullOrBlank()){
                    stringQuantity.append(item).append('\n').append('\n')
                }
            }

            test.text = stringIngredient
            test2.text = stringQuantity


            GlideApp.with(this)
                .load(meal.strMealThumb)
                .placeholder(R.drawable.no_image)
                .centerCrop()
                .into(imgFoto)

        }

    }
}
