package com.lite.doordash.di.homescreen

import com.lite.doordash.model.converter.RestaurantConverter
import com.lite.doordash.network.restaurants.RestaurantApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class HomeFragmentModule {
    @Provides
    fun providesRestaurantApi(retrofit: Retrofit): RestaurantApi = retrofit.create(RestaurantApi::class.java)

    @Provides
    fun providesRestaurantConverter() = RestaurantConverter()

}