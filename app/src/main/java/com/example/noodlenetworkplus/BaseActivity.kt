package com.example.noodlenetworkplus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.noodlenetworkplus.RegisterTimeActivity.Companion.APP_PREFERENCES

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedPreferences = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
        val savedTheme = sharedPreferences.getInt("selected_theme", R.style.Theme_DarkTur)
        setTheme(savedTheme)
        super.onCreate(savedInstanceState)
    }
}