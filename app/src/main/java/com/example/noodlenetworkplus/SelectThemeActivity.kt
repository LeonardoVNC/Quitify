package com.example.noodlenetworkplus

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.noodlenetworkplus.databinding.ActivityPrincipalBinding
import com.example.noodlenetworkplus.databinding.ActivitySelectThemeBinding

class SelectThemeActivity : BaseActivity() {
    private lateinit var binding: ActivitySelectThemeBinding

    private var tema: Int = R.style.Theme_DarkTur

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectThemeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sharedPreferences = getSharedPreferences("app_preferences", MODE_PRIVATE)
        tema = sharedPreferences.getInt("selected_theme", R.style.Theme_DarkTur)

        //Para cualquier tema que se agregue a la aplicación, se debe añadir su configuracion aqui.
        binding.selectThemeButtonDarkTur.setOnClickListener {
            tema = R.style.Theme_DarkTur
            binding.selectThemeDescSave.text = getString(R.string.theme_dark_tur)
            binding.selectThemeDescSave.visibility = View.VISIBLE
        }
        binding.selectThemeButtonDarkPurple.setOnClickListener {
            tema = R.style.Theme_DarkPurple
            binding.selectThemeDescSave.text = getString(R.string.theme_dark_purple)
            binding.selectThemeDescSave.visibility = View.VISIBLE
        }
        binding.selectThemeButtonDark.setOnClickListener {
            tema = R.style.Theme_Dark
            binding.selectThemeDescSave.text = getString(R.string.theme_dark)
            binding.selectThemeDescSave.visibility = View.VISIBLE
        }
        binding.selectThemeButtonLight.setOnClickListener {
            tema = R.style.Theme_Light
            binding.selectThemeDescSave.text = getString(R.string.theme_light)
            binding.selectThemeDescSave.visibility = View.VISIBLE
        }

        binding.selectThemeButtonSave.setOnClickListener {
            sharedPreferences.edit().putInt("selected_theme", tema).apply()
            recreate()
        }

        binding.selectThemeButtonBack.setOnClickListener { onBackPressed() }
    }
}