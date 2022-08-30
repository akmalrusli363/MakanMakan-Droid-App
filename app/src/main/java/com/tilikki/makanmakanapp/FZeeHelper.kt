package com.tilikki.makanmakanapp

import kotlinx.coroutines.delay

object FZeeHelper {
  suspend fun fetchData(index: Int) {
    delay(10000)
    if (index % 2 == 0) {
      throw Exception("whoa, error!")
    }
  }

  enum class DownloadState {
    DOWNLOADED, DOWNLOADING, NOT_DOWNLOADED
  }
}