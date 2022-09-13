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
import com.tilikki.makanmakanapp.view.list.ListItemMenu

@Composable
fun FoodCard(title: String, description: String? = null, foodList: List<FeaturedFoodModel>) {
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
    if (!description.isNullOrBlank()) {
      Text(
        text = description, style = TextStyle(
          fontSize = 14.sp
        ), modifier = Modifier.padding(start = 24.dp, end = 24.dp)
      )
    }
    ListItemMenu(foodList, padding = PaddingValues(top = 8.dp, start = 24.dp, end = 24.dp))
  }
}

@Composable
@Preview
private fun PreviewFoodCardNoDescription() {
  val title = stringResource(id = R.string.popular_food)
  val featuredFoodList = listOf(
    FeaturedFoodModel(1, "Odading mang oleh", R.drawable.odading, 10000, 2.4, 4.5f),
    FeaturedFoodModel(2, "Bakso goyang lidah", R.drawable.bakso, 17000, 0.8, 4.3f),
    FeaturedFoodModel(3, "Nasi Padang Arema", R.drawable.padang, 21000, 1.4, 4.8f)
  )
  FoodCard(title = title, description = null, foodList = featuredFoodList)
}

@Composable
@Preview
private fun PreviewFoodCard() {
  val title = stringResource(id = R.string.recent_food)
  val description = stringResource(id = R.string.recent_food_description)
  val favoriteFoodList = listOf(
    FeaturedFoodModel(1, "Telor goreng maria", R.drawable.cakue, 8000, 6.1, 4.4f),
    FeaturedFoodModel(2, "Kopi Pletok Sinabung", R.drawable.pletok, 23000, 3.3, 4.8f),
    FeaturedFoodModel(3, "Boba maniak", R.drawable.boba, 22000, 4.0, 4.6f),
    FeaturedFoodModel(4, "Bakso Biru", R.drawable.bakso, 14000, 0.8, 4.75f),
  )
  FoodCard(title = title, description = description, foodList = favoriteFoodList)
}