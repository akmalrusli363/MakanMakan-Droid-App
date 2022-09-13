package com.tilikki.makanmakanapp.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tilikki.makanmakanapp.R
import com.tilikki.makanmakanapp.model.FeaturedFoodModel
import com.tilikki.makanmakanapp.view.list.ListItemMenu

@Composable
fun FoodCard(title: String, description: String? = null, foodList: List<FeaturedFoodModel>) {
  GenericCard(title = title, description = description, onClickActionButton = {}) {
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