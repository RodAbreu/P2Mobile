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

            setTitle(meal.strMeal)

            infoIntrucoes.setText(meal.strInstructions)

            if (meal.strIngredient1 != "") {
                ingrediente1.setText(meal.strIngredient1)
            }
            if (meal.strIngredient2 != "") {
                ingrediente2.setText(meal.strIngredient2)
            }
            if (meal.strIngredient3 != "") {
                ingrediente3.setText(meal.strIngredient3)
            }
            if (meal.strIngredient4 != "") {
                ingrediente4.setText(meal.strIngredient4)
            }
            if (meal.strIngredient5 != "") {
                ingrediente5.setText(meal.strIngredient5)
            }
            if (meal.strIngredient6 != "") {
                ingrediente6.setText(meal.strIngredient6)
            }
            if (meal.strIngredient7 != "") {
                ingrediente7.setText(meal.strIngredient7)
            }
            if (meal.strIngredient8 != "") {
                ingrediente8.setText(meal.strIngredient8)
            }
            if (meal.strIngredient9 != "") {
                ingrediente9.setText(meal.strIngredient9)
            }
            if (meal.strIngredient10 != "") {
                ingrediente10.setText(meal.strIngredient10)
            }
            if (meal.strIngredient11 != "") {
                ingrediente11.setText(meal.strIngredient11)
            }
            if (meal.strIngredient12 != "") {
                ingrediente12.setText(meal.strIngredient12)
            }
            if (meal.strIngredient13 != "") {
                ingrediente13.setText(meal.strIngredient13)
            }
            if (meal.strIngredient14 != "") {
                ingrediente14.setText(meal.strIngredient14)
            }
            if (meal.strIngredient15 != "") {
                ingrediente15.setText(meal.strIngredient15)
            }
            if (meal.strIngredient16 != "") {
                ingrediente16.setText(meal.strIngredient16)
            }
            if (meal.strIngredient17 != "") {
                ingrediente17.setText(meal.strIngredient17)
            }
            if (meal.strIngredient18 != "") {
                ingrediente18.setText(meal.strIngredient18)
            }
            if (meal.strIngredient19 != "") {
                ingrediente19.setText(meal.strIngredient19)
            }

            if (meal.strMeasure1 != "") {
                medida1.setText(meal.strMeasure1)
            }
            if (meal.strMeasure2 != "") {
                medida2.setText(meal.strMeasure2)
            }
            if (meal.strMeasure3 != "") {
                medida3.setText(meal.strMeasure3)
            }
            if (meal.strMeasure4 != "") {
                medida4.setText(meal.strMeasure4)
            }
            if (meal.strMeasure5 != "") {
                medida5.setText(meal.strMeasure5)
            }
            if (meal.strMeasure6 != "") {
                medida6.setText(meal.strMeasure6)
            }
            if (meal.strMeasure7 != "") {
                medida7.setText(meal.strMeasure7)
            }
            if (meal.strMeasure8 != "") {
                medida8.setText(meal.strMeasure8)
            }
            if (meal.strMeasure9 != "") {
                medida9.setText(meal.strMeasure9)
            }
            if (meal.strMeasure10 != "") {
                medida10.setText(meal.strMeasure10)
            }
            if (meal.strMeasure11 != "") {
                medida11.setText(meal.strMeasure11)
            }
            if (meal.strMeasure12 != "") {
                medida12.setText(meal.strMeasure12)
            }
            if (meal.strMeasure13 != "") {
                medida13.setText(meal.strMeasure13)
            }
            if (meal.strMeasure14 != "") {
                medida14.setText(meal.strMeasure14)
            }
            if (meal.strMeasure15 != "") {
                medida15.setText(meal.strMeasure15)
            }
            if (meal.strMeasure16 != "") {
                medida16.setText(meal.strMeasure16)
            }
            if (meal.strMeasure17 != "") {
                medida17.setText(meal.strMeasure17)
            }
            if (meal.strMeasure18 != "") {
                medida18.setText(meal.strMeasure18)
            }
            if (meal.strMeasure19 != "") {
                medida19.setText(meal.strMeasure19)
            }


            GlideApp.with(this)
                .load(meal.strMealThumb)
                .placeholder(R.drawable.no_image)
                .centerCrop()
                .into(imgFoto)

        }

    }
}
