package com.tilikki.makanmakanapp.view.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tilikki.makanmakanapp.R
import com.tilikki.makanmakanapp.model.FeaturedFoodModel
import com.tilikki.makanmakanapp.view.item.ItemMenu

@Composable
fun ListItemMenu(
  menuList: List<FeaturedFoodModel>,
  modifier: Modifier = Modifier,
  padding: PaddingValues? = null
) {
  LazyRow(modifier = modifier, contentPadding = padding ?: PaddingValues(0.dp)) {
    items(menuList) { menu ->
      ItemMenu(itemMenu = menu)
    }
  }
}

@Preview
@Composable
private fun DisplayListItemMenu() {
  val menuList = listOf(
    FeaturedFoodModel(1, "Telor goreng maria", R.drawable.cakue, 8000, 6.1, 4.4f),
    FeaturedFoodModel(2, "Kopi Pletok Sinabung", R.drawable.pletok, 23000, 3.3, 4.8f),
    FeaturedFoodModel(3, "Boba maniak", R.drawable.boba, 22000, 4.0, 4.6f),
    FeaturedFoodModel(4, "Bakso Biru", R.drawable.bakso, 14000, 0.8, 4.75f),

    )
  ListItemMenu(menuList = menuList)
}