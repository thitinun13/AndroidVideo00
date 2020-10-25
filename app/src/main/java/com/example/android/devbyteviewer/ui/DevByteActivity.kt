package com.example.android.devbyteviewer.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.devbyteviewer.R
import com.example.android.devbyteviewer.databinding.ActivityDevByteViewerBinding
import kotlinx.android.synthetic.main.activity_dev_byte_viewer.*

class DevByteActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDevByteViewerBinding>(this,
            R.layout.activity_dev_byte_viewer)

        drawerLayout = binding.drawerLayout
        val navController = this.findNavController(R.id.my_nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.my_nav_host_fragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}
