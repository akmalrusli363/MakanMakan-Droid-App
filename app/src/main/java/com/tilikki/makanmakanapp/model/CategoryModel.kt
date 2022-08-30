package layout.model

import androidx.annotation.DrawableRes
import com.tilikki.makanmakanapp.FZeeHelper

data class CategoryModel(
  val categoryId: Int,
  val categoryName: String,
  @DrawableRes val categoryImage: Int,
  var downloadState: FZeeHelper.DownloadState = FZeeHelper.DownloadState.NOT_DOWNLOADED
)
