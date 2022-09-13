package com.tilikki.makanmakanapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tilikki.makanmakanapp.databinding.ItemCategoryBinding
import com.tilikki.makanmakanapp.model.CategoryModel

class CategoryAdapter(private val categories: List<CategoryModel>) :
  RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

  inner class ViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(categoryModel: CategoryModel) {
      binding.tvCategory.text = categoryModel.categoryName
      binding.ivCategory.setImageResource(categoryModel.categoryImage)
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val inflatedView =
      ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ViewHolder(inflatedView)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val categoryModel = categories[position]
    holder.bind(categoryModel)
  }

  override fun getItemCount(): Int {
    return categories.size
  }
}