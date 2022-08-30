package com.tilikki.makanmakanapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tilikki.makanmakanapp.databinding.ItemRestoBinding
import com.tilikki.makanmakanapp.model.RestaurantModel

class RestaurantListAdapter(private val restaurantList: List<RestaurantModel>) :
  RecyclerView.Adapter<RestaurantListAdapter.ViewHolder>() {

  inner class ViewHolder(val binding: ItemRestoBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(restaurantModel: RestaurantModel) {
      binding.tvRestaurant.text =
        String.format("%s, %s", restaurantModel.name, restaurantModel.address)
      binding.tvCategory.text = restaurantModel.category
      binding.tvRange.text = String.format("%.1f km", restaurantModel.range)
      binding.ivPhoto.setImageResource(restaurantModel.imageUrl)
    }
  }

  override fun onCreateViewHolder(
    parent: ViewGroup, viewType: Int
  ): RestaurantListAdapter.ViewHolder {
    val inflatedView = ItemRestoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ViewHolder(inflatedView)
  }

  override fun onBindViewHolder(holder: RestaurantListAdapter.ViewHolder, position: Int) {
    holder.bind(restaurantList[position])
  }

  override fun getItemCount(): Int {
    return restaurantList.size
  }
}