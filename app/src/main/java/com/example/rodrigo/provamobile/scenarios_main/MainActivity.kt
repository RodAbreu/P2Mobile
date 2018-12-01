package com.example.rodrigo.provamobile.scenarios_main

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.rodrigo.provamobile.R
import com.example.rodrigo.provamobile.entities.Meal
import com.example.rodrigo.provamobile.entities.MealAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter : MainContract.Presenter = MainPresenter(this)
        presenter.onLoadList()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        when (item.itemId) {
            R.id.menuGeral-> {
//                showHelp()
                return true
            }
            R.id.menuRecentes -> {
                val presenter : MainContract.Presenter = MainPresenter(this)
                presenter.onLoadLatestList()
                return true
            }
            R.id.menuFavoritos -> {
//                showHelp()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun showList(list: List<Meal>) {

        val adapter = MealAdapter(this, list)
        adapter.setOnItemClickListener {position ->
            val openBrowser = Intent(Intent.ACTION_VIEW)
            openBrowser.data = Uri.parse(list.get(position).strSource)
            startActivity(openBrowser)
        }

        rvListMeals.adapter = adapter
        rvListMeals.layoutManager = LinearLayoutManager(this)
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
    

}
