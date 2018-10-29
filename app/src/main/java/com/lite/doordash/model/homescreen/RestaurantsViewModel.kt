package com.lite.doordash.model.homescreen


import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.lite.doordash.model.common.NetworkState
import com.lite.doordash.model.converter.RestaurantConverter
import com.lite.doordash.network.restaurants.RestaurantApi
import com.lite.doordash.network.restaurants.RestaurantResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestaurantsViewModel(private val restaurantApi: RestaurantApi, private val converter: RestaurantConverter) : ViewModel() {
    private var restaurantAPIState = MutableLiveData<NetworkState>()

    fun getRestaurantList(): LiveData<NetworkState> {
        restaurantAPIState.value = NetworkState.Loading()
        restaurantApi.getRestaurants(mapOf("lat" to 37.422740, "lng" to -122.139956)).enqueue(object : Callback<List<RestaurantResponse>>{
            override fun onFailure(call: Call<List<RestaurantResponse>>, t: Throwable) {
               restaurantAPIState.value = NetworkState.Error()
            }

            override fun onResponse(call: Call<List<RestaurantResponse>>, response: Response<List<RestaurantResponse>>) {
                if(response.isSuccessful) {
                    val restaurantList = converter.convertRestaurantResponse(response.body())
                    restaurantAPIState.value = NetworkState.Success(restaurantList)
                }
            }

        })
        return restaurantAPIState
    }
}