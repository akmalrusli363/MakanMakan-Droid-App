package com.tilikki.makanmakanapp.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tilikki.makanmakanapp.R
import com.tilikki.makanmakanapp.model.RestaurantModel
import com.tilikki.makanmakanapp.view.list.ListItemRestaurant

@Composable
fun RestaurantCard(title: String, description: String, restoList: List<RestaurantModel>) {
  GenericCard(title = title, description = description, onClickActionButton = {}) {
    ListItemRestaurant(restoList, padding = PaddingValues(top = 8.dp, start = 24.dp, end = 24.dp))
  }
}

@Preview @Composable
private fun PreviewRestaurantCard() {
  val title = stringResource(id = R.string.new_restaurants)
  val description = stringResource(id = R.string.new_restaurant_desc)
  val restoList = listOf(
    RestaurantModel(
      1, "Resto Sate Pak Kumis", "Bogor Timur", "Sate", 2.8, 4.8f, 10, R.drawable.sate
    ), RestaurantModel(
      2, "Soto Mie Bogor Asli", "Bogor Selatan", "Bakmi & Soto", 3.0, 4.8f, 10, R.drawable.soto
    ), RestaurantModel(
      3, "Ichibang Sushi", "Bogor Barat", "Sushi", 5.0, 4.9f, 29, R.drawable.sushi
    ), RestaurantModel(
      4, "Ayam Goreng Kapechi", "Bogor Timur", "Cepat Saji", 3.0, 4.3f, 55, R.drawable.ayam
    ), RestaurantModel(
      5, "Es Cendol Dawet Ambyar", "Cibinong", "Minuman", 4.1, 4.7f, 33, R.drawable.cendol
    )
  )
  RestaurantCard(title = title, description = description, restoList = restoList)
}