package com.lite.doordash.network.restaurants

import com.lite.doordash.model.homescreen.RestaurantModel

data class RestaurantResponse(
    val address: Address,
    val asap_time: Any?,
    val average_rating: Double,
    val business: Business,
    val business_id: Int,
    val composite_score: Int,
    val cover_img_url: String,
    val delivery_fee: Int,
    val description: String,
    val extra_sos_delivery_fee: Int,
    val featured_category_description: Any,
    val header_img_url: String,
    val id: Int,
    val is_newly_added: Boolean,
    val is_only_catering: Boolean,
    val is_time_surging: Boolean,
    val max_composite_score: Int,
    val max_order_size: Any,
    val menus: List<Menu>,
    val merchant_promotions: List<MerchantPromotion>,
    val name: String,
    val number_of_ratings: Int,
    val price_range: Int,
    val promotion: Any,
    val service_rate: Double,
    val slug: String,
    val status: String,
    val status_type: String,
    val tags: List<String>,
    val url: String,
    val yelp_rating: Double,
    val yelp_review_count: Int
) {

    data class Menu(
        val id: Int,
        val is_catering: Boolean,
        val name: String,
        val popular_items: List<PopularItem>,
        val subtitle: String
    )

    data class PopularItem(
        val description: String,
        val id: Int,
        val img_url: String,
        val name: String,
        val price: Int
    )

    data class MerchantPromotion(
        val delivery_fee: Any,
        val delivery_fee_monetary_fields: DeliveryFeeMonetaryFields,
        val id: Int,
        val minimum_subtotal: Any,
        val minimum_subtotal_monetary_fields: MinimumSubtotalMonetaryFields,
        val new_store_customers_only: Boolean
    )

    data class MinimumSubtotalMonetaryFields(
        val currency: String,
        val decimal_places: Int,
        val display_string: String,
        val unit_amount: Any
    )

    data class DeliveryFeeMonetaryFields(
        val currency: String,
        val decimal_places: Int,
        val display_string: String,
        val unit_amount: Any
    )

    data class Address(
        val city: String,
        val lat: Double,
        val lng: Double,
        val printable_address: String,
        val state: String,
        val street: String
    )

    data class Business(
        val id: Int,
        val name: String
    )
}

internal fun RestaurantResponse.toRestaurantModel() : RestaurantModel {
    val name = business.name
    val type = description
    val status = asap_time?:"closed"
    val url = cover_img_url
    return RestaurantModel(name, type, status.toString(), url)
}