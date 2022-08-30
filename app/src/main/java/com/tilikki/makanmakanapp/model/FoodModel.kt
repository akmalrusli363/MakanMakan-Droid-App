package com.tilikki.makanmakanapp.model

import androidx.annotation.DrawableRes

data class FoodModel(
  val id: Int,
  val name: String,
  @DrawableRes val imageUrl: Int,
  val price: Int,
)
