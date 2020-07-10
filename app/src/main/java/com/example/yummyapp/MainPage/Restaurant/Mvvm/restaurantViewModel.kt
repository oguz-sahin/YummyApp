package com.example.yummyapp.MainPage.Restaurant.Mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.yummyapp.MainPage.Model.*

class restaurantViewModel(application: Application) : AndroidViewModel(application) {

    private val repository =
        restaurantRepository(
            application
        )
    val restaurantPhotos: LiveData<photosModel>
    val restaurantResponse: LiveData<restaurantResponse>
    val restaurantComment: LiveData<CommentModel>
    val restaurantMenuCategories: LiveData<CategoryModel>
    val data = MutableLiveData<Data>()
    val addFavoriteStatus: LiveData<FavoriteStatusModel>
    val deleteFavoriteStatus: LiveData<FavoriteStatusModel>

    fun putData(putteddata: Data) {
        data.value = putteddata
    }

    init {
        this.restaurantPhotos = repository.restaurantsPhotos
        this.restaurantResponse = repository.restaurantInformation
        this.restaurantComment = repository.restaurantComments
        this.restaurantMenuCategories = repository.restaurantMenuCategories
        this.addFavoriteStatus = repository.addFavoriteStatus
        this.deleteFavoriteStatus = repository.deleteFavoriteStatus
    }

    fun getRestorantsPhotosWithToken(token: String, restaurantId: String) {

        repository.getRestaurantPhotosWithToken(token, restaurantId)

    }

    fun getRestaurantInformation(token: String, restaurantId: String) {

        repository.getRestaurantInformation(token, restaurantId)

    }

    fun getRestauranComments(token: String, restaurantId: String) {

        repository.getRestaurantComments(restaurantId, token)

    }

    fun getRestaurantMenuCategories(restaurantId: String, token: String) {
        repository.getRestaurantMenuCategories(restaurantId, token)
    }

    fun addFavorite(token: String, restaurantId: String) {

        repository.addFavorite(token, restaurantId)
    }

    fun deleteFavorite(token: String, restaurantId: String) {

        repository.deleteFavorite(token, restaurantId)
    }


}