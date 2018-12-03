package com.example.rodrigo.provamobile.scenarios_main
import com.example.rodrigo.provamobile.entities.MealList
import com.example.rodrigo.provamobile.network.RetrofitInicializer

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view : MainContract.View) : MainContract.Presenter {

    override fun onLoadLatestList() {
        view.showLoading()

        val mealService = RetrofitInicializer().createMealService()
        val call = mealService.getLatestMeal()

        call.enqueue(object : Callback<MealList>{
            override fun onFailure(call: Call<MealList>, t: Throwable) {
                view.hideLoading()
                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }

            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                view.hideLoading()
                if(response.body() != null){
                    view.showList(response.body()!!.meals)
                }else{
                    view.showMessage("Sem receitas ):")
                }
            }
        })
    }

    override fun onLoadList(){
        view.showLoading()

        val mealService = RetrofitInicializer().createMealService()
        val call = mealService.getRandomMeal()

        call.enqueue(object : Callback<MealList>{
            override fun onFailure(call: Call<MealList>, t: Throwable) {
                view.hideLoading()
                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }

            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                view.hideLoading()
                if(response.body() != null){
                    view.showList(response.body()!!.meals)
                }else{
                    view.showMessage("Sem receitas ):")
                }
            }
        })

    }


}