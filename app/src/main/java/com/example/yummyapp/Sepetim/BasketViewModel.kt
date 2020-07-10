package com.example.yummyapp.Sepetim

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.yummyapp.MainPage.Model.BasketModel
import com.example.yummyapp.Profile.Model.FavoriteRestaurantModel
import com.example.yummyapp.Profile.Model.HistoricOrderModel
import com.example.yummyapp.Sepetim.model.BasketCompleteDetailModel

class BasketViewModel(application: Application) : AndroidViewModel(application) {

    val repository = BasketRepository(application)
    val basket: LiveData<BasketModel>
    val deleteBasketModel: LiveData<DeleteBasketModel>
    val detailBasket: LiveData<BasketProductDetailModel>
    val basketCompleteResponse: LiveData<BasketCompleteModel>
    val basketCompleteDetailModel: LiveData<BasketCompleteDetailModel>
    val historicOrders: LiveData<HistoricOrderModel>
    val favoriteRestaurants: LiveData<FavoriteRestaurantModel>


    init {
        this.basket = repository.basket
        this.deleteBasketModel = repository.deleteBasketModel
        this.detailBasket = repository.detailBasket
        this.basketCompleteResponse = repository.basketCompleteResponse
        this.basketCompleteDetailModel = repository.basketCompleteDetailModel
        this.historicOrders = repository.historicOders
        this.favoriteRestaurants = repository.favoriteRestaurant
    }

    fun getBasket(token: String) {

        repository.getBasket(token)

    }

    fun DeleteBasket(token: String, restaurantId: String) {


        repository.deleteBasket(token, restaurantId)

    }


    fun getBasketDetail(token: String, restaurantId: String) {

        repository.getBasketDetail(token, restaurantId)

    }


    fun completeBasket(token: String, restaurantId: String, day: String, time: String) {


        repository.completeBasket(token, restaurantId, time, day)


    }

    fun getCompleteBasketDetail(token: String, id: String) {


        repository.getCompleteBasketDetail(token, id)
    }


    fun getHistoricOrders(token: String) {

        repository.getHistoricOrder(token)

    }

    fun getFavoritesrestaurants(token: String) {

        repository.getFavoriteRestaurant(token)

    }
}