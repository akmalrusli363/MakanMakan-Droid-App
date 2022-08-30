package com.tilikki.makanmakanapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tilikki.makanmakanapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
  private lateinit var binding: ActivityHomeBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityHomeBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.bottomNavigation.setOnItemSelectedListener {
      when (it.itemId) {
        R.id.menu_home -> {
          Toast.makeText(this, "Home screen", Toast.LENGTH_SHORT).show()
          showHomeFragment()
        }
        R.id.menu_explore -> {
          Toast.makeText(this, "Explore screen", Toast.LENGTH_SHORT).show()
          showExploreFragment()
        }
        R.id.menu_favourites -> {
          Toast.makeText(this, "Favorites screen", Toast.LENGTH_SHORT).show()
          showFavoritesFragment()
        }
        R.id.menu_settings -> {
          Toast.makeText(this, "Settings screen", Toast.LENGTH_SHORT).show()
          showSettingsFragment()
        }
      }
      return@setOnItemSelectedListener true
    }

    showHomeFragment()
  }

  private fun showHomeFragment() {
    val homeFragment = HomeFragment.newInstance()
    supportFragmentManager.beginTransaction().replace(R.id.container, homeFragment).commit()
  }

  private fun showExploreFragment() {
    val exploreFragment = ExploreFragment.newInstance()
    supportFragmentManager.beginTransaction().replace(R.id.container, exploreFragment).commit()
  }

  private fun showFavoritesFragment() {
    val favoritesFragment = FavoritesFragment.newInstance()
    supportFragmentManager.beginTransaction().replace(R.id.container, favoritesFragment).commit()
  }

  private fun showSettingsFragment() {
    val settingsFragment = SettingsFragment.newInstance()
    supportFragmentManager.beginTransaction().replace(R.id.container, settingsFragment).commit()
  }
}