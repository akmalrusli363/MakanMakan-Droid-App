package com.tilikki.makanmakanapp.helper

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

object ViewHelper {
  @Composable
  fun spToDp(sp: TextUnit): Dp {
    return with(LocalDensity.current) {
      sp.toDp()
    }
  }
}