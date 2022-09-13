package com.tilikki.makanmakanapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tilikki.makanmakanapp.R

@Composable
fun HomeHeading(username: String, address: String) {
  Column(
    modifier = Modifier
      .background(colorResource(id = R.color.orange_primary))
      .padding(24.dp)
  ) {
    Text(
      text = "Hello, $username", style = TextStyle(
        fontSize = 20.sp, fontWeight = FontWeight.Bold, color = colorResource(
          id = R.color.white
        )
      )
    )
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 8.dp)) {
      Icon(
        painter = painterResource(id = R.drawable.ic_location),
        contentDescription = null,
        tint = colorResource(id = R.color.white),
        modifier = Modifier.padding(end = 8.dp)
      )
      Text(
        text = address, style = TextStyle(
          fontSize = 14.sp,
          fontWeight = FontWeight.Bold,
          color = colorResource(id = R.color.white)
        )
      )
    }
    SearchBar(
      hint = stringResource(id = R.string.search_hint), modifier = Modifier.padding(top = 8.dp)
    )
  }
}

@Composable
private fun SearchBar(hint: String, modifier: Modifier = Modifier) {
  Card(
    modifier = modifier
      .fillMaxWidth()
      .height(45.dp), shape = RoundedCornerShape(CornerSize(8.dp))
  ) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
      Icon(
        painter = painterResource(id = R.drawable.ic_search), contentDescription = null,
        modifier = Modifier.padding(start = 4.dp)
      )
      Text(text = hint, modifier = Modifier.padding(start = 8.dp))
    }
  }
}

@Composable
@Preview
private fun PreviewHomeHeading() {
  HomeHeading(username = "Elia", address = "Jalan biru no 37")
}