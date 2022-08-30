package com.tilikki.makanmakanapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val gotoRelativeActivity = findViewById<Button>(R.id.btn_relative_activity)
    val gotoConstraintActivity = findViewById<Button>(R.id.btn_constraint_activity)

    gotoRelativeActivity.setOnClickListener {
      val intent = Intent(this@MainActivity, RelativeActivity::class.java)
      startActivity(intent)
    }
    gotoConstraintActivity.setOnClickListener {
      val intent = Intent(this@MainActivity, ConstraintActivity::class.java)
      startActivity(intent)
    }
  }
}