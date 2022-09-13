package com.tilikki.makanmakanapp.view.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tilikki.makanmakanapp.R
import com.tilikki.makanmakanapp.model.RestaurantModel
import com.tilikki.makanmakanapp.view.item.ItemRestaurant

@Composable
fun ListItemRestaurant(
  restaurantList: List<RestaurantModel>,
  modifier: Modifier = Modifier,
  padding: PaddingValues? = null
) {
  LazyColumn(modifier = modifier.padding(padding ?: PaddingValues(0.dp))) {
    items(restaurantList) { resto ->
      ItemRestaurant(restaurant = resto)
    }
  }
}

@Preview
@Composable
private fun DisplayListItemRestaurant() {
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
  ListItemRestaurant(restaurantList = restoList)
}