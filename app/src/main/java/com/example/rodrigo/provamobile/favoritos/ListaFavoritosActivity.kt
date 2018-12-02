package com.example.rodrigo.provamobile.favoritos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.example.rodrigo.provamobile.DAO.AppDatabase
import com.example.rodrigo.provamobile.DAO.MealBD
import com.example.rodrigo.provamobile.R
import com.example.rodrigo.provamobile.entities.Meal
import com.example.rodrigo.provamobile.network.InfoMealsActivity
import com.example.rodrigo.provamobile.scenarios_main.MainActivity
import com.example.rodrigo.provamobile.scenarios_main.MainContract
import com.example.rodrigo.provamobile.scenarios_main.MainPresenter
import kotlinx.android.synthetic.main.activity_lista_favoritos.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.activityUiThreadWithContext
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class ListaFavoritosActivity : AppCompatActivity() {

    companion object {
        private const val REQUEST_CADASTRO: Int = 1 //para executar o cadastro de contatinho
        private const val LISTA = "ListaMeals" //para salvar e restaurar a lista quando necessário
    }

    //lista para armazenar contatinhos adicionados
    var listaMeals: MutableList<MealBD> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_favoritos)

//        //abre a activity de cadastro de contatinho e aguarda um resultado para adicioná-lo na lista
//        btnAddContatinho.setOnClickListener(){
//            val cadastrarContatinho = Intent(this,CadastraContatinhoActivity::class.java)
//            startActivity(cadastrarContatinho)
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_favoritos, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        when (item.itemId) {
            R.id.menuPesquisar -> {
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    //carrega a lista sempre que a activity é atualizada
    override fun onResume() {
        super.onResume()
        carregaLista()
    }

    //salva a lista caso o Android venha a destruir a activity
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putSerializable(LISTA, listaMeals as ArrayList<String>)
    }

    //restaura a lista caso o Android venha a destruir a activity
    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null)
            listaMeals = savedInstanceState.getSerializable(LISTA) as MutableList<MealBD>
    }

    //configura os componentes necesário para utilizar a RecyclerView
    fun carregaLista() {

        val contaitnhoDao = AppDatabase.getInstance(this).mealDAO()
        doAsync {
            listaMeals = contaitnhoDao.getAll() as MutableList<MealBD>

            activityUiThreadWithContext {
                val adapter = MealBDAdapter(this, listaMeals)

//                configura o clique em cada item do RecyclerView
                adapter.setOnItemClickListener { indexContatinhoClicado ->
                    val visualizaMealBD = Intent(this, InfoMealsActivity::class.java)
                    visualizaMealBD.putExtra(InfoMealsActivity.MEAL, listaMeals.get(indexContatinhoClicado))
                    startActivity(visualizaMealBD)
                }

                adapter.configuraCliqueLongo { indexContatinhoClicado ->
                    doAsync {
                        contaitnhoDao.delete(listaMeals.get(indexContatinhoClicado))
                        uiThread {
                            carregaLista()
                        }
                    }
                    true
                }

                val layoutManager = LinearLayoutManager(this)

                rvFavoritos.adapter = adapter
                rvFavoritos.layoutManager = layoutManager
            }
        }
    }
}



