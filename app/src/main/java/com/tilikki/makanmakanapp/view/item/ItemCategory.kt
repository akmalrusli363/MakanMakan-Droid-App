package com.tilikki.makanmakanapp.view.item

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tilikki.makanmakanapp.R

@Composable
fun ItemCategory(category: String, @DrawableRes imageResource: Int, modifier: Modifier = Modifier) {
  Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.padding(8.dp)) {
    Box(
      modifier = Modifier
        .width(75.dp)
        .height(75.dp)
        .background(
          colorResource(id = R.color.orange_1), shape = RoundedCornerShape(CornerSize(4.dp))
        ), contentAlignment = Alignment.Center
    ) {
      Image(
        painter = painterResource(id = imageResource),
        contentDescription = category,
        Modifier
          .width(40.dp)
          .height(40.dp)
      )
    }
    Text(
      text = category,
      style = TextStyle(fontSize = 16.sp, color = colorResource(id = R.color.black_2)),
      modifier = Modifier.padding(top = 16.dp)
    )
  }
}

@Preview
@Composable
private fun DisplayItemCategory() {
  ItemCategory(category = "Donut", imageResource = R.drawable.donut)
}