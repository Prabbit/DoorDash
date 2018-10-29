package com.lite.doordash

import com.lite.doordash.model.converter.RestaurantConverter
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class RestaurantResponseConverterTest {

    @Test
    fun `converter returns non null list when response is null`() {
        val restaurantConverter = RestaurantConverter()
        val result = restaurantConverter.convertRestaurantResponse(null)
        assertNotNull("converter returns null for null response",result)
    }

    @Test
    fun `converter returns empty list when response is null`() {
        val restaurantConverter = RestaurantConverter()
        val result = restaurantConverter.convertRestaurantResponse(null)
        val actual = result.size
        val expected = 0
        assertEquals("converter doesn't return empty list for null response",expected, actual)
    }
}