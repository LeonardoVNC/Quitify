package com.example.noodlenetworkplus

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.noodlenetworkplus.RegisterTimeActivity.Companion.APP_PREFERENCES
import com.example.noodlenetworkplus.databinding.ActivityRegisterAdictionBinding

class RegisterAdictionActivity : AppCompatActivity() {
    companion object {
        val USER_ADDICTION = "adiccion"
    }

    private lateinit var binding: ActivityRegisterAdictionBinding
    private var adiccion: String = ""
    private var onEditText: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterAdictionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sharedPreferences = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)

        //Selecciona una de las adicciones pre-establecidas
        binding.regaddRadioGroup.setOnCheckedChangeListener { group, checkedID ->
            when(checkedID) {
                R.id.regadd_radio_button_drunk -> {
                    adiccion = getString(R.string.reg_add_drunk)
                }
                R.id.regaddradio_button_smoke -> {
                    adiccion = getString(R.string.reg_add_smoke)
                }
                R.id.regaddradio_button_drugs -> {
                    adiccion = getString(R.string.reg_add_drugs)
                }
                R.id.regaddradio_button_other -> {
                    onEditText = true
                    showOther()
                } else -> {
                    adiccion = ""
                }
            }
        }

        //Cambia la vista de vuelta a las opciones
        binding.regaddButtonBack.setOnClickListener {
            onEditText = false
            binding.regaddRadioGroup.visibility = View.VISIBLE
            binding.regaddEditAddiction.text.clear()
            binding.regaddEditAddiction.visibility = View.GONE
            binding.regaddButtonBack.visibility = View.GONE
        }

        //Guarda la adicción pre-establecida o la detallada en el editText
        binding.regaddButtonEnd.setOnClickListener {
            var editAdiccion = binding.regaddEditAddiction.text.toString()
            if (onEditText && editAdiccion.isNotEmpty()) {
                adiccion = editAdiccion
            }
            if (adiccion.isNotEmpty()) {
                sharedPreferences.edit().putString(USER_ADDICTION, adiccion).apply()
                val intent = Intent(this, RegisterTimeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    //Cambia la vista al editText
    private fun showOther() {
        binding.regaddRadioGroup.visibility = View.GONE
        binding.regaddEditAddiction.visibility = View.VISIBLE
        binding.regaddButtonBack.visibility = View.VISIBLE
    }
}