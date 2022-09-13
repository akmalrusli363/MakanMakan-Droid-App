package com.tilikki.makanmakanapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.tilikki.makanmakanapp.adapter.CategoryAdapter
import com.tilikki.makanmakanapp.adapter.FoodMenuAdapter
import com.tilikki.makanmakanapp.adapter.RestaurantListAdapter
import com.tilikki.makanmakanapp.databinding.FragmentHomeBinding
import com.tilikki.makanmakanapp.model.CategoryModel
import com.tilikki.makanmakanapp.model.FeaturedFoodModel
import com.tilikki.makanmakanapp.model.RestaurantModel
import com.tilikki.makanmakanapp.view.CategoryCard
import com.tilikki.makanmakanapp.view.FoodCard
import com.tilikki.makanmakanapp.view.GenericCard
import com.tilikki.makanmakanapp.view.HomeHeading
import com.tilikki.makanmakanapp.view.item.ItemRestaurant

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

  private object MockHomeFragmentData {
    fun getCategoriesList(): List<CategoryModel> {
      val chickenModel = CategoryModel(1, "Chicken", R.drawable.chicken)
      val dishModel = CategoryModel(2, "Dish", R.drawable.dish)
      val donutModel = CategoryModel(3, "Donut", R.drawable.donut)
      val hamburgerModel = CategoryModel(4, "Hamburger", R.drawable.hamburger)
      val ramenModel = CategoryModel(5, "Ramen", R.drawable.ramen)
      val saladModel = CategoryModel(6, "Salad", R.drawable.salad)

      return listOf(chickenModel, dishModel, donutModel, hamburgerModel, ramenModel, saladModel)
    }

    fun getFeaturedFoodList(): List<FeaturedFoodModel> {
      return listOf(
        FeaturedFoodModel(1, "Odading mang oleh", R.drawable.odading, 10000, 2.4, 4.5f),
        FeaturedFoodModel(2, "Bakso goyang lidah", R.drawable.bakso, 17000, 0.8, 4.3f),
        FeaturedFoodModel(3, "Nasi Padang Arema", R.drawable.padang, 21000, 1.4, 4.8f)
      )
    }

    fun getFavoriteFoodList(): List<FeaturedFoodModel> {
      return listOf(
        FeaturedFoodModel(1, "Telor goreng maria", R.drawable.cakue, 8000, 6.1, 4.4f),
        FeaturedFoodModel(2, "Kopi Pletok Sinabung", R.drawable.pletok, 23000, 3.3, 4.8f),
        FeaturedFoodModel(3, "Boba maniak", R.drawable.boba, 22000, 4.0, 4.6f),
        FeaturedFoodModel(4, "Bakso Biru", R.drawable.bakso, 14000, 0.8, 4.75f),
      )
    }

    fun getNewRestaurantList(): List<RestaurantModel> {
      return listOf(
        RestaurantModel(
          1, "Resto Sate Pak Kumis", "Bogor Timur", "Sate", 2.8, 4.8f, 10, R.drawable.sate
        ), RestaurantModel(
          2, "Soto Mie Bogor Asli", "Bogor Selatan", "Bakmi & Soto", 3.0, 4.8f, 10, R.drawable.soto
        ), RestaurantModel(
          3, "Ichibang Sushi", "Bogor Barat", "Sushi", 5.0, 4.9f, 29, R.drawable.sushi
        ), RestaurantModel(
          4, "Ayam Goreng Kapechi", "Bogor Timur", "Cepat Saji", 3.0, 4.3f, 55, R.drawable.ayam
        ), RestaurantModel(
          5, "Es Cendol Dawet Ambyar", "Cibinong", "Minuman", 4.1, 4.7f, 33, R.drawable.cendol
        )
      )
    }

    fun getUserData(): Pair<String, String> {
      val username = "Budi Kurniawan"
      val address = "Jl. Kemuliaan II no 39, Bogor Timur, Bogor, Jawa Barat"
      return Pair(username, address)
    }
  }

  private lateinit var binding: FragmentHomeBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View {
    binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
    //    return binding.root
    return ComposeView(requireContext()).apply {
      setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
      setContent {
        MaterialTheme {
          HomeView()
        }
      }
    }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.rvCategory.layoutManager =
      LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    binding.rvFeaturedFood.layoutManager =
      LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

    val categories = MockHomeFragmentData.getCategoriesList()
    val featuredFoodList = MockHomeFragmentData.getFeaturedFoodList()
    val favoriteFoodList = MockHomeFragmentData.getFavoriteFoodList()
    val newRestaurantList = MockHomeFragmentData.getNewRestaurantList()
    val userData = MockHomeFragmentData.getUserData()

    binding.rvCategory.adapter = CategoryAdapter(categories)
    binding.rvFeaturedFood.adapter = FoodMenuAdapter(featuredFoodList)
    binding.rvFavoriteFood.adapter = FoodMenuAdapter(favoriteFoodList)
    binding.rvNewRestaurant.adapter = RestaurantListAdapter(newRestaurantList)
    binding.tvHello.text = getString(R.string.hello_message, userData.first)
    binding.tvLocation.text = userData.second
  }

  @Composable
  private fun HomeView() {
    val userData = MockHomeFragmentData.getUserData()
    val categories = MockHomeFragmentData.getCategoriesList()
    val featuredFoodList = MockHomeFragmentData.getFeaturedFoodList()
    val favoriteFoodList = MockHomeFragmentData.getFavoriteFoodList()
    val newRestaurantList = MockHomeFragmentData.getNewRestaurantList()
    LazyColumn(
      modifier = Modifier
        .background(colorResource(id = R.color.white))
    ) {
      item { HomeHeading(username = userData.first, address = userData.second) }
      item { CategoryCard(title = "Categories", categoryList = categories) }
      item {
        FoodCard(
          title = stringResource(id = R.string.popular_food), foodList = featuredFoodList
        )
      }
      item {
        FoodCard(
          title = stringResource(id = R.string.recent_food),
          description = stringResource(id = R.string.recent_food_description),
          foodList = favoriteFoodList
        )
      }
      item {
        val title = stringResource(id = R.string.new_restaurants)
        val description = stringResource(id = R.string.new_restaurant_desc)
        GenericCard(title = title, description = description, onClickActionButton = {}) {}
      }
      items(newRestaurantList) { resto ->
        ItemRestaurant(
          restaurant = resto,
          modifier = Modifier.padding(top = 8.dp, start = 24.dp, end = 24.dp)
        )
      }
    }
  }

  @Composable
  @Preview
  fun PreviewHomeView() {
    HomeView()
  }

  companion object {
    @JvmStatic
    fun newInstance() = HomeFragment().apply {
      arguments = Bundle().apply {}
    }
  }
}