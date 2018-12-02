package com.example.rodrigo.provamobile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_info_meals.*
import com.example.rodrigo.provamobile.entities.Meal
import kotlinx.android.synthetic.main.meal_item.view.*
import android.widget.ArrayAdapter
import com.example.rodrigo.provamobile.scenarios_main.MainContract
import com.example.rodrigo.provamobile.scenarios_main.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class InfoMealsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_meals)



        val recebeIntent = getIntent()
        val parametros = recebeIntent.getExtras()

        if (parametros != null ){
            val meal: Meal
            meal = parametros.getSerializable("objeto") as Meal

            infoIntrucoes.setText(meal.strInstructions)

            if (meal.strIngredient1!=""){ingrediente1.setText(meal.strIngredient1)}
            if (meal.strIngredient2!=""){ingrediente2.setText(meal.strIngredient2)}
            if (meal.strIngredient3!=""){ingrediente3.setText(meal.strIngredient3)}
            if (meal.strIngredient4!=""){ingrediente4.setText(meal.strIngredient4)}
            if (meal.strIngredient5!=""){ingrediente5.setText(meal.strIngredient5)}
            if (meal.strIngredient6!=""){ingrediente6.setText(meal.strIngredient6)}
            if (meal.strIngredient7!=""){ingrediente7.setText(meal.strIngredient7)}
            if (meal.strIngredient8!=""){ingrediente8.setText(meal.strIngredient8)}
            if (meal.strIngredient9!=""){ingrediente9.setText(meal.strIngredient9)}
            if (meal.strIngredient10!=""){ingrediente10.setText(meal.strIngredient10)}
            if (meal.strIngredient11!=""){ingrediente11.setText(meal.strIngredient11)}
            if (meal.strIngredient12!=""){ingrediente12.setText(meal.strIngredient12)}
            if (meal.strIngredient13!=""){ingrediente13.setText(meal.strIngredient13)}
            if (meal.strIngredient14!=""){ingrediente14.setText(meal.strIngredient14)}
            if (meal.strIngredient15!=""){ingrediente15.setText(meal.strIngredient15)}
            if (meal.strIngredient16!=""){ingrediente16.setText(meal.strIngredient16)}
            if (meal.strIngredient17!=""){ingrediente17.setText(meal.strIngredient17)}
            if (meal.strIngredient18!=""){ingrediente18.setText(meal.strIngredient18)}
            if (meal.strIngredient19!=""){ingrediente19.setText(meal.strIngredient19)}

            if (meal.strMeasure1!=""){medida1.setText(meal.strMeasure1)}
            if (meal.strMeasure2!=""){medida2.setText(meal.strMeasure2)}
            if (meal.strMeasure3!=""){medida3.setText(meal.strMeasure3)}
            if (meal.strMeasure4!=""){medida4.setText(meal.strMeasure4)}
            if (meal.strMeasure5!=""){medida5.setText(meal.strMeasure5)}
            if (meal.strMeasure6!=""){medida6.setText(meal.strMeasure6)}
            if (meal.strMeasure7!=""){medida7.setText(meal.strMeasure7)}
            if (meal.strMeasure8!=""){medida8.setText(meal.strMeasure8)}
            if (meal.strMeasure9!=""){medida9.setText(meal.strMeasure9)}
            if (meal.strMeasure10!=""){medida10.setText(meal.strMeasure10)}
            if (meal.strMeasure11!=""){medida11.setText(meal.strMeasure11)}
            if (meal.strMeasure12!=""){medida12.setText(meal.strMeasure12)}
            if (meal.strMeasure13!=""){medida13.setText(meal.strMeasure13)}
            if (meal.strMeasure14!=""){medida14.setText(meal.strMeasure14)}
            if (meal.strMeasure15!=""){medida15.setText(meal.strMeasure15)}
            if (meal.strMeasure16!=""){medida16.setText(meal.strMeasure16)}
            if (meal.strMeasure17!=""){medida17.setText(meal.strMeasure17)}
            if (meal.strMeasure18!=""){medida18.setText(meal.strMeasure18)}
            if (meal.strMeasure19!=""){medida19.setText(meal.strMeasure19)}


            val ingredientes = arrayOf<String>(
                meal.strIngredient1, meal.strMeasure1,
                meal.strIngredient2, meal.strMeasure2,
                meal.strIngredient3, meal.strMeasure3,
                meal.strIngredient4, meal.strMeasure4,
                meal.strIngredient5, meal.strMeasure5,
                meal.strIngredient6, meal.strMeasure6,
                meal.strIngredient7, meal.strMeasure7,
                meal.strIngredient8, meal.strMeasure8,
                meal.strIngredient9, meal.strMeasure9,
                meal.strIngredient10, meal.strMeasure10,
                meal.strIngredient11, meal.strMeasure11,
                meal.strIngredient12, meal.strMeasure12,
                meal.strIngredient13, meal.strMeasure13,
                meal.strIngredient14, meal.strMeasure14,
                meal.strIngredient15, meal.strMeasure15,
                meal.strIngredient16, meal.strMeasure16,
                meal.strIngredient17, meal.strMeasure17,
                meal.strIngredient18, meal.strMeasure18,
                meal.strIngredient19, meal.strMeasure19
            )

            val medidas = arrayOf<String>(
                meal.strMeasure1, meal.strMeasure2, meal.strMeasure3,
                meal.strMeasure4, meal.strMeasure5, meal.strMeasure6,
                meal.strMeasure7, meal.strMeasure8, meal.strMeasure9,
                meal.strMeasure10, meal.strMeasure11, meal.strMeasure12,
                meal.strMeasure13, meal.strMeasure14, meal.strMeasure15,
                meal.strMeasure16, meal.strMeasure17, meal.strMeasure18,
                meal.strMeasure19
            )


            GlideApp.with(this)
                .load(meal.strMealThumb)
                .placeholder(R.drawable.no_image)
                .centerCrop()
                .into(imgFoto)

        }

//        val expandableTextView = findViewById<View>(R.id.expand_text_view) as ExpandableTextView
//        expandable_text.setText(parametros.getString("intrucoes"))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_receita, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menuSalvar -> {
                return true
            }
            else -> return super.onOptionsItemSelected(item)

        }
    }
}
