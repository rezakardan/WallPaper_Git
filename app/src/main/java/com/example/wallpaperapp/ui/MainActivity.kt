package com.example.wallpaperapp.ui

import android.graphics.Color
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import com.example.wallpaperapp.R
import com.example.wallpaperapp.databinding.ActivityMainBinding
import com.example.wallpaperapp.utils.base.BaseActivity
import com.example.wallpaperapp.utils.setStatusBarIconsColor
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity() {
    //Binding
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Transparent status bar
        window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            statusBarColor = Color.TRANSPARENT
            //Change color of status bar icons
            setStatusBarIconsColor(true)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}