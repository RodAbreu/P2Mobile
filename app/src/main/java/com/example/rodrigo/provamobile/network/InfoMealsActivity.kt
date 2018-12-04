package com.example.rodrigo.provamobile.network

import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.rodrigo.provamobile.DAO.AppDatabase
import com.example.rodrigo.provamobile.DAO.MealBD
import com.example.rodrigo.provamobile.DAO.MealDAO
import kotlinx.android.synthetic.main.activity_info_meals.*
import com.example.rodrigo.provamobile.entities.Meal
import com.example.rodrigo.provamobile.R
import com.example.rodrigo.provamobile.scenarios_main.MainActivity
import com.example.rodrigo.provamobile.utils.GlideApp
import org.jetbrains.anko.*


@Suppress("DEPRECATION")
class InfoMealsActivity : AppCompatActivity() {

    companion object {
        public const val MEAL: String = "Mealbd" //para putExtra entre activities
    }


    var mealbd: MealBD? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_meals)


        val recebeIntent = getIntent()
        val parametros = recebeIntent.getExtras()

        val meal: Meal
        if (parametros != null ){
            meal = parametros.getSerializable("objeto") as Meal

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

            idIngredientes.text = stringIngredient
            idMedidas.text = stringQuantity


            GlideApp.with(this)
                .load(meal.strMealThumb)
                .placeholder(R.drawable.no_image)
                .centerCrop()
                .into(imgFoto)

            mealbd = MealBD(meal.idMeal, meal.strMeal, meal.strCategory, meal.strArea,
                meal.strInstructions, meal.strMealThumb, meal.strTags, meal.strYoutube,
                meal.strIngredient1,meal.strIngredient2,meal.strIngredient3,meal.strIngredient4,
                meal.strIngredient5,meal.strIngredient6,meal.strIngredient7,meal.strIngredient8,
                meal.strIngredient9,meal.strIngredient10,meal.strIngredient11,meal.strIngredient12,
                meal.strIngredient13,meal.strIngredient14,meal.strIngredient15,meal.strIngredient16,
                meal.strIngredient17,meal.strIngredient18,meal.strIngredient19, meal.strIngredient20,
                meal.strMeasure1,meal.strMeasure2,meal.strMeasure3,meal.strMeasure4,meal.strMeasure5,
                meal.strMeasure6,meal.strMeasure7,meal.strMeasure8,meal.strMeasure9,meal.strMeasure10,
                meal.strMeasure11,meal.strMeasure12,meal.strMeasure13,meal.strMeasure14,meal.strMeasure15,
                meal.strMeasure16,meal.strMeasure17,meal.strMeasure18,meal.strMeasure19,meal.strMeasure20,
                meal.strSource,meal.dateModified)


            GlideApp.with(this)
                .load("")
                .placeholder(R.drawable.icons8youtube48)
                .centerCrop()
                .into(idYoutube)


            idYoutube.setOnClickListener(){
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(meal.strYoutube))
                startActivity(browserIntent)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_receita, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menuSalvar -> salvaMeal()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun salvaMeal() {

        val mealDAO: MealDAO = AppDatabase.getInstance(this).mealDAO()

        doAsync {
            mealDAO.insert(mealbd!!)
            uiThread {
                finish()
            }

        }
        Toast.makeText(this,"Receita adicionada aos favoritos", Toast.LENGTH_LONG).show()
    }
}

