package com.tilikki.makanmakanapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tilikki.makanmakanapp.R
import com.tilikki.makanmakanapp.model.CategoryModel
import com.tilikki.makanmakanapp.view.list.ListItemCategory

@Composable
fun CategoryCard(title: String, categoryList: List<CategoryModel>) {
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
    }
    ListItemCategory(categoryList, padding = PaddingValues(top = 8.dp, start = 24.dp, end = 24.dp))
  }
}

@Composable
@Preview
fun PreviewCategoryCard() {
  val categoryList = listOf(
    CategoryModel(1, "Chicken", R.drawable.chicken),
    CategoryModel(2, "Dish", R.drawable.dish),
    CategoryModel(3, "Donut", R.drawable.donut),
    CategoryModel(4, "Hamburger", R.drawable.hamburger),
    CategoryModel(5, "Ramen", R.drawable.ramen),
    CategoryModel(6, "Salad", R.drawable.salad)
  )
  CategoryCard(title = "Categories", categoryList = categoryList)
}