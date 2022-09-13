package com.tilikki.makanmakanapp.view.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tilikki.makanmakanapp.R
import com.tilikki.makanmakanapp.model.CategoryModel
import com.tilikki.makanmakanapp.view.item.ItemCategory

@Composable
fun ListItemCategory(
  categoryList: List<CategoryModel>,
  modifier: Modifier = Modifier,
  padding: PaddingValues? = null
) {
  LazyRow(modifier = modifier, contentPadding = padding ?: PaddingValues(0.dp)) {
    items(categoryList) { category ->
      ItemCategory(category = category.categoryName, imageResource = category.categoryImage)
    }
  }
}

@Preview
@Composable
private fun DisplayListItemCategory() {
  val categoryList = listOf(
    CategoryModel(1, "Chicken", R.drawable.chicken),
    CategoryModel(2, "Dish", R.drawable.dish),
    CategoryModel(3, "Donut", R.drawable.donut),
    CategoryModel(4, "Hamburger", R.drawable.hamburger),
    CategoryModel(5, "Ramen", R.drawable.ramen),
    CategoryModel(6, "Salad", R.drawable.salad)
  )
  ListItemCategory(categoryList = categoryList)
}