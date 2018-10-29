package com.lite.doordash.model.homescreen

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.lite.doordash.model.converter.RestaurantConverter
import com.lite.doordash.network.restaurants.RestaurantApi
import javax.inject.Inject

class HomeFragmentViewModelFactory @Inject constructor(private val restaurantApi: RestaurantApi, private val converter: RestaurantConverter) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RestaurantsViewModel(restaurantApi, converter) as T
    }
}
