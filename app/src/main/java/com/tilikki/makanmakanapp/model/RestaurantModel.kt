package com.tilikki.makanmakanapp.model

import androidx.annotation.DrawableRes

data class RestaurantModel(
  val id: Int,
  val name: String,
  val address: String,
  val category: String,
  val range: Double,
  val rating: Float,
  val reviewer: Int,
  @DrawableRes val imageUrl: Int
)
