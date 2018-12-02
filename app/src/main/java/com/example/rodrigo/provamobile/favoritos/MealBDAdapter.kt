package com.example.rodrigo.provamobile.favoritos

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rodrigo.provamobile.DAO.MealBD
import com.example.rodrigo.provamobile.R
import com.example.rodrigo.provamobile.utils.GlideApp
import kotlinx.android.synthetic.main.mealbd_item.view.*

class MealBDAdapter(val context: Context, val meals: List<MealBD>)
    : RecyclerView.Adapter<MealBDAdapter.ViewHolder>() {

    //salva a função do clique no item
    var clickListener: ((index: Int) -> Unit)? = null
    //salva a função do clique longo do item
    var cliqueLongoListener: ((index: Int) -> Boolean)? = null

    //método responsável por inflar as views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mealbd_item, parent, false)
        return ViewHolder(view)
    }

    //retorna a quantidade de itens na lista
    override fun getItemCount(): Int {
        return meals.size
    }

    //popula o ViewHolder com as informações do contatinho
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, meals[position], clickListener, cliqueLongoListener)
    }

    //configuração a função de clique nos itens
    fun setOnItemClickListener(clique: ((index: Int) -> Unit)){
        this.clickListener = clique
    }

    fun configuraCliqueLongo(cliqueLongo: ((index: Int) -> Boolean)){
        this.cliqueLongoListener = cliqueLongo
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context,
                     meal: MealBD,
                     clickListener: ((index: Int) -> Unit)?,
                     cliqueLongoListener: ((index: Int) -> Boolean)?) {
            itemView.tvNomeFavoritos.text = meal.strMeal

            val thumbnail = GlideApp.with(context)
                .load(R.drawable.no_image)
                .centerCrop()

            GlideApp.with(context)
                .load(meal.strMealThumb)
                .thumbnail(thumbnail)
                .centerCrop()
                .into(itemView.imgFotoFavoritos)

            if(clickListener != null) {
                itemView.setOnClickListener {
                    clickListener.invoke(adapterPosition)
                }
            }

            if(cliqueLongoListener != null){
                itemView.setOnLongClickListener{
                    cliqueLongoListener.invoke((adapterPosition))
                }
            }

        }

    }
}