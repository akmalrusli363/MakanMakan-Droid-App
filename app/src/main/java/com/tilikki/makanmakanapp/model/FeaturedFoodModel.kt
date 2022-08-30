package com.tilikki.makanmakanapp.model

import androidx.annotation.DrawableRes

data class FeaturedFoodModel(
  val restaurantId: Int,
  val foodName: String,
  @DrawableRes val foodImageUrl: Int,
  val price: Int,
  val range: Double,
  val rating: Float,
) {
  constructor(restaurant: RestaurantModel, food: FoodModel) : this(
    restaurantId = restaurant.id,
    foodName = food.name,
    foodImageUrl = food.imageUrl,
    price = food.price,
    range = restaurant.range,
    rating = restaurant.rating
  )
}
