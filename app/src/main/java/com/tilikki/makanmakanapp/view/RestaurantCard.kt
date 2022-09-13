package com.tilikki.makanmakanapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tilikki.makanmakanapp.R
import com.tilikki.makanmakanapp.model.RestaurantModel
import com.tilikki.makanmakanapp.view.list.ListItemRestaurant

@Composable
fun RestaurantCard(title: String, description: String, restoList: List<RestaurantModel>) {
  Column {
    Row(
      horizontalArrangement = Arrangement.SpaceBetween,
      modifier = Modifier
        .padding(horizontal = 16.dp)
        .fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = title, style = TextStyle(
          fontSize = 18.sp,
          color = colorResource(id = R.color.black_primary),
          fontWeight = FontWeight.Bold
        ), modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp)
      )
      TextButton(onClick = {}) {
        Text(
          stringResource(id = R.string.see_all),
          style = TextStyle(
            color = colorResource(id = R.color.orange_primary),
            fontWeight = FontWeight.Bold
          )
        )
      }
    }
    Text(
      text = description, style = TextStyle(
        fontSize = 14.sp
      ), modifier = Modifier.padding(start = 24.dp, end = 24.dp)
    )
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