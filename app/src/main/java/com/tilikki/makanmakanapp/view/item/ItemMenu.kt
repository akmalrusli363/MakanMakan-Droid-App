package com.tilikki.makanmakanapp.view.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tilikki.makanmakanapp.R
import com.tilikki.makanmakanapp.model.FeaturedFoodModel
import java.util.Locale

@Composable
fun ItemMenu(itemMenu: FeaturedFoodModel, modifier: Modifier = Modifier) {
  Card(
    elevation = 8.dp,
    modifier = modifier
      .padding(8.dp)
      .width(150.dp),
    shape = RoundedCornerShape(CornerSize(8.dp))
  ) {
    Column {
      Image(
        painter = painterResource(id = itemMenu.foodImageUrl),
        contentDescription = itemMenu.foodName,
        Modifier
          .width(150.dp)
          .height(100.dp)
      )
      Text(
        text = itemMenu.foodName,
        style = TextStyle(fontSize = 16.sp, color = colorResource(id = R.color.black_2)),
        modifier = Modifier
          .padding(top = 8.dp, start = 8.dp, end = 8.dp)
          .fillMaxWidth()
      )
      Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
        Text(
          text = String.format(Locale("in", "ID"), "Rp %,d", itemMenu.price), style = TextStyle(
            fontSize = 14.sp,
            color = colorResource(id = R.color.black_2),
            fontWeight = FontWeight.Bold
          ), modifier = Modifier.padding(8.dp)
        )
        Text(
          text = String.format("%.1f km", itemMenu.range),
          style = TextStyle(fontSize = 14.sp, color = colorResource(id = R.color.black_2)),
          modifier = Modifier.padding(8.dp)
        )
      }
    }
  }
}

@Preview
@Composable
private fun DisplayItemMenu() {
  ItemMenu(FeaturedFoodModel(1, "Telor goreng maria", R.drawable.cakue, 8000, 6.1, 4.4f))
}

