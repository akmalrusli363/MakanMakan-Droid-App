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
import com.tilikki.makanmakanapp.model.FeaturedFoodModel
import com.tilikki.makanmakanapp.model.RestaurantModel
import com.tilikki.makanmakanapp.view.list.ListItemMenu
import com.tilikki.makanmakanapp.view.list.ListItemRestaurant

@Composable
fun GenericCard(
  title: String,
  description: String? = null,
  onClickActionButton: (() -> Unit)? = null,
  content: @Composable () -> Unit
) {
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
      if (onClickActionButton != null) {
        TextButton(onClick = {onClickActionButton()}) {
          Text(
            stringResource(id = R.string.see_all), style = TextStyle(
              color = colorResource(id = R.color.orange_primary), fontWeight = FontWeight.Bold
            )
          )
        }
      }
    }
    if (!description.isNullOrBlank()) {
      Text(
        text = description, style = TextStyle(
          fontSize = 14.sp
        ), modifier = Modifier.padding(start = 24.dp, end = 24.dp)
      )
    }
    content()
  }
}

@Preview
@Composable
private fun PreviewFeaturedFoodCard() {
  val title = stringResource(id = R.string.popular_food)
  val featuredFoodList = listOf(
    FeaturedFoodModel(1, "Odading mang oleh", R.drawable.odading, 10000, 2.4, 4.5f),
    FeaturedFoodModel(2, "Bakso goyang lidah", R.drawable.bakso, 17000, 0.8, 4.3f),
    FeaturedFoodModel(3, "Nasi Padang Arema", R.drawable.padang, 21000, 1.4, 4.8f)
  )
  GenericCard(title = title) {
    ListItemMenu(featuredFoodList, padding = PaddingValues(top = 8.dp, start = 24.dp, end = 24.dp))
  }
}

@Preview
@Composable
private fun PreviewFavoriteFoodCard() {
  val title = stringResource(id = R.string.recent_food)
  val description = stringResource(id = R.string.recent_food_description)
  val favoriteFoodList = listOf(
    FeaturedFoodModel(1, "Telor goreng maria", R.drawable.cakue, 8000, 6.1, 4.4f),
    FeaturedFoodModel(2, "Kopi Pletok Sinabung", R.drawable.pletok, 23000, 3.3, 4.8f),
    FeaturedFoodModel(3, "Boba maniak", R.drawable.boba, 22000, 4.0, 4.6f),
    FeaturedFoodModel(4, "Bakso Biru", R.drawable.bakso, 14000, 0.8, 4.75f),
  )
  GenericCard(title = title, description = description) {
    ListItemMenu(favoriteFoodList, padding = PaddingValues(top = 8.dp, start = 24.dp, end = 24.dp))
  }
}

@Preview(heightDp = 300)
@Composable
private fun PreviewNewRestaurantCard() {
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
  GenericCard(title = title, description = description) {}
  ListItemRestaurant(restoList, padding = PaddingValues(top = 8.dp, start = 24.dp, end = 24.dp))
}