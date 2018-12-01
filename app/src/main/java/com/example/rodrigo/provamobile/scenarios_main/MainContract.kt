package com.example.rodrigo.provamobile.scenarios_main

import com.example.rodrigo.provamobile.entities.Meal

interface MainContract {

    interface View{
        fun showMessage(msg: String)
        fun showList(meals: List<Meal>)

    }

    interface Presenter{
        fun onLoadList()
        fun onLoadLatestList()
    }


}