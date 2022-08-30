package com.tilikki.makanmakanapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tilikki.makanmakanapp.databinding.ItemMenuBinding
import com.tilikki.makanmakanapp.model.FeaturedFoodModel
import java.util.Locale

class FoodMenuAdapter(private val foodMenuList: List<FeaturedFoodModel>) :
  RecyclerView.Adapter<FoodMenuAdapter.ViewHolder>() {

  inner class ViewHolder(val binding: ItemMenuBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(featuredFoodModel: FeaturedFoodModel) {
      binding.tvMenu.text = featuredFoodModel.foodName
      binding.tvPrice.text = String.format(Locale("in", "ID"), "Rp %,d", featuredFoodModel.price)
      binding.tvRange.text = String.format("%.1f km", featuredFoodModel.range)
      binding.tvRating.text = String.format("%.1f", featuredFoodModel.rating)
      binding.ivPhoto.setImageResource(featuredFoodModel.foodImageUrl)
      binding.ivPhoto.contentDescription = featuredFoodModel.foodName
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val inflatedView =
      ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ViewHolder(inflatedView)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(foodMenuList[position])
  }

  override fun getItemCount(): Int {
    return foodMenuList.size
  }

}