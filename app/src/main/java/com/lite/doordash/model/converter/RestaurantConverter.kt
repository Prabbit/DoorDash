package com.lite.doordash.model.converter

import com.lite.doordash.model.homescreen.RestaurantModel
import com.lite.doordash.network.restaurants.RestaurantResponse
import com.lite.doordash.network.restaurants.toRestaurantModel

class RestaurantConverter {
    fun convertRestaurantResponse(restaurantResponse: List<RestaurantResponse>?) : List<RestaurantModel> {
        return restaurantResponse?.map { it.toRestaurantModel() }.orEmpty()
    }
}