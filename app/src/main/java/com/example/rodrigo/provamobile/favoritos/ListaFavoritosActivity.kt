package com.example.rodrigo.provamobile.favoritos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.rodrigo.provamobile.DAO.AppDatabase
import com.example.rodrigo.provamobile.DAO.MealBD
import com.example.rodrigo.provamobile.R
import com.example.rodrigo.provamobile.R.id.rvFavoritos
import kotlinx.android.synthetic.main.activity_lista_favoritos.*
import org.jetbrains.anko.activityUiThreadWithContext
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class ListaFavoritosActivity : AppCompatActivity() {

    companion object {
        private const val LISTA = "ListaMeals" //para salvar e restaurar a lista quando necessário
    }

    //lista para armazenar contatinhos adicionados
    var listaMeals: MutableList<MealBD> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_favoritos)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_favoritos, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
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

        val mealDAO = AppDatabase.getInstance(this).mealDAO()
        doAsync {
            listaMeals = mealDAO.getAll() as MutableList<MealBD>

            activityUiThreadWithContext {
                val adapter = MealBDAdapter(this, listaMeals)

//                configura o clique em cada item do RecyclerView
                adapter.setOnItemClickListener { position ->
                    val passagemDeDados = Bundle()
                    passagemDeDados.putSerializable("objeto" ,listaMeals.get(position))
                    val apresentaInfosFavorito = Intent(this, InfoMealsFavoritosActivity::class.java)
                    apresentaInfosFavorito.putExtras(passagemDeDados)
                    startActivity(apresentaInfosFavorito)
                }

                adapter.configuraCliqueLongo { indexContatinhoClicado ->
                    val builder = AlertDialog.Builder(this@ListaFavoritosActivity)
                    builder.setTitle("Cuidado")
                    builder.setMessage("Você tem certeza que deseja apagar essa receita?")
                    // Set a positive button and its click listener on alert dialog
                    builder.setPositiveButton("YES"){dialog, which ->
                        Toast.makeText(this@ListaFavoritosActivity,"Receita Apagada", Toast.LENGTH_LONG).show()
                        doAsync {
                            mealDAO.delete(listaMeals.get(indexContatinhoClicado))
                            uiThread {
                                carregaLista()
                            }
                        }
                    }


                    // Display a negative button on alert dialog
                    builder.setNegativeButton("No"){dialog,which ->
                        Toast.makeText(applicationContext,"Receita mantida.",Toast.LENGTH_SHORT).show()
                    }

                    // Finally, make the alert dialog using builder
                    val dialog: AlertDialog = builder.create()

                    // Display the alert dialog on app interface
                    dialog.show()



                    true
                }

                val layoutManager = LinearLayoutManager(this)

                rvFavoritos.adapter = adapter
                rvFavoritos.layoutManager = layoutManager
            }
        }
    }
}



