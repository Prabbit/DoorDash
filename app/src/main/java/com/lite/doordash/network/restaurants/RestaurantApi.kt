package com.lite.doordash.network.restaurants

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface RestaurantApi {
    @GET("v2/restaurant/?offset=0&limit=50")
    fun getRestaurants(@QueryMap options: Map<String, Double>): Call<List<RestaurantResponse>>
}