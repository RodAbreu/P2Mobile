package com.example.rodrigo.provamobile

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



//      //https:www.themealdb.com/images/media/meals/usuqtp1511385394.jpg
        val a1 = Meal(
                idMeal = "52857",
                strMeal = "Pumpkin Pie",
                strCategory = "Desert",
                strArea ="American",
                strInstructions = "Place the pumpkin in a large saucepan, cover with water and bring to the boil. Cover with a lid and simmer for 15 mins or until tender. Drain pumpkin; let cool.\r\nHeat oven to 180C/160C fan/gas 4. Roll out the pastry on a lightly floured surface and use it to line a 22cm loose-bottomed tart tin. Chill for 15 mins. Line the pastry with baking parchment and baking beans, then bake for 15 mins. Remove the beans and paper, and cook for a further 10 mins until the base is pale golden and biscuity. Remove from the oven and allow to cool slightly.\r\nIncrease oven to 220C/200C fan/gas 7. Push the cooled pumpkin through a sieve into a large bowl. In a separate bowl, combine the sugar, salt, nutmeg and half the cinnamon. Mix in the beaten eggs, melted butter and milk, then add to the pumpkin pur\u00e9e and stir to combine. Pour into the tart shell and cook for 10 mins, then reduce the temperature to 180C/160C fan/gas 4. Continue to bake for 35-40 mins until the filling has just set.\r\nLeave to cool, then remove the pie from the tin. Mix the remaining cinnamon with the icing sugar and dust over the pe. Serve chilled.",
                strMealThumb = "https://www.themealdb.com/images/media/meals/usuqtp1511385394.jpg", strTags = "Halloween,Pie,Desert",
                strYoutube = "https://www.youtube.com/watch?v=hpapqEeb36k",
                strIngredient1 = "Pumpkin", strIngredient2 ="Shortcrust Pastry", strIngredient3 = "Plain Flour",
                strIngredient4 = "Caster Sugar", strIngredient5 = "Salt", strIngredient6 = "Nutmeg",
                strIngredient7 = "Cinnamon", strIngredient8="Eggs", strIngredient9="Butter",
                strIngredient10 = "Milk", strIngredient11 = "Icing Sugar", strIngredient12= "",strIngredient13 = "", strIngredient14 ="",
                strIngredient15 = "", strIngredient16 = "",strIngredient17 ="", strIngredient18="", strIngredient19="",strIngredient20="",
                strMeasure1 = "750g", strMeasure2 = "350g", strMeasure3="Dusting", strMeasure4="140g", strMeasure5="\u00bd tsp", strMeasure6 = "\u00bd tsp",
                strMeasure7="1 tsp ",strMeasure8="2 Beaten ",strMeasure9="25g",strMeasure10="175g",
                strMeasure11 = "1 tblsp ", strMeasure12 = "", strMeasure13= "", strMeasure14= "", strMeasure15 ="",strMeasure16="",
                strMeasure17 = "", strMeasure18 ="",strMeasure19 = "", strMeasure20 = "",
                strSource = "https://www.bbcgoodfood.com/recipes/1742633/pumpkin-pie",
                dateModified = "null"
        )


        val testList = listOf(a1)

        exibeLista(testList)



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
//            R.id.menuSalvar -> Favoritos()
        }
        return super.onOptionsItemSelected(item)
    }

    fun exibeLista(list: List<Meal>) {

        val adapter = MealAdapter(this, list)
        adapter.setOnItemClickListener {position ->
            val openBrowser = Intent(Intent.ACTION_VIEW)
            openBrowser.data = Uri.parse(list.get(position).strSource)
            startActivity(openBrowser)
        }

        rvListMeals.adapter = adapter
        rvListMeals.layoutManager = LinearLayoutManager(this)
    }

}
