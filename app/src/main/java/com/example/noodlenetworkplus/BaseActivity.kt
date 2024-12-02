package com.example.noodlenetworkplus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedPreferences = getSharedPreferences("app_preferences", MODE_PRIVATE)
        val savedTheme = sharedPreferences.getInt("selected_theme", R.style.Theme_DarkTur)
        setTheme(savedTheme)
        super.onCreate(savedInstanceState)
    }
}