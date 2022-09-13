package com.tilikki.makanmakanapp.view.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tilikki.makanmakanapp.R
import com.tilikki.makanmakanapp.helper.ViewHelper
import com.tilikki.makanmakanapp.model.RestaurantModel

@Composable
fun ItemRestaurant(restaurant: RestaurantModel, modifier: Modifier = Modifier) {
  Card(
    elevation = 2.dp,
    modifier = modifier
      .padding(horizontal = 8.dp, vertical = 12.dp)
      .fillMaxWidth(),
    shape = RoundedCornerShape(CornerSize(8.dp))
  ) {
    Row {
      Image(
        painterResource(id = R.drawable.ayam),
        contentDescription = restaurant.name,
        modifier = Modifier
          .width(100.dp)
          .height(100.dp)
          .padding(end = 4.dp),
        contentScale = ContentScale.Crop
      )
      Column {
        Text(
          text = restaurant.name,
          maxLines = 2,
          modifier = Modifier
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            .fillMaxWidth()
            .height(ViewHelper.spToDp(sp = 36.sp)),
          style = TextStyle(
            color = colorResource(id = R.color.black_2),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
          )
        )
        Text(
          text = restaurant.category,
          modifier = Modifier
            .padding(top = 4.dp, start = 8.dp, end = 8.dp)
            .fillMaxWidth(),
          style = TextStyle(
            color = colorResource(id = R.color.black_2), fontSize = 14.sp
          )
        )
        Text(
          text = String.format("%.1f km", restaurant.range),
          modifier = Modifier
            .padding(top = 4.dp, start = 8.dp, end = 8.dp)
            .fillMaxWidth(),
          style = TextStyle(
            color = colorResource(id = R.color.black_2), fontSize = 14.sp
          )
        )
      }
    }
  }
}

@Preview
@Composable
private fun DisplayItemRestaurant() {
  ItemRestaurant(
    restaurant = RestaurantModel(
      1, "Resto Sate Pak Kumis", "Bogor Timur", "Sate", 2.8, 4.8f, 10, R.drawable.sate
    )
  )
}