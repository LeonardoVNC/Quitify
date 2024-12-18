package com.example.noodlenetworkplus

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.noodlenetworkplus.databinding.ActivityRegisterTimeBinding
import java.time.LocalDateTime

class RegisterTimeActivity : AppCompatActivity() {
    companion object {
        val APP_PREFERENCES = "app_preferences"
        val BEGIN_DATE = "begin_date"
        val FIRST_DATE = "first_date"
    }

    private lateinit var binding: ActivityRegisterTimeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterTimeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sharedPreferences = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)

        binding.regtimeButtonNext.setOnClickListener{ setViewDate() }
        binding.regtimeButtonBack.setOnClickListener{ setViewHour() }
        binding.regtimeButtonEnd.setOnClickListener{
            val beginDate: LocalDateTime = LocalDateTime.of(
                binding.regtimeDatepicker.year,
                binding.regtimeDatepicker.month+1,  //Corrección en el mes usado
                binding.regtimeDatepicker.dayOfMonth,
                binding.regtimeTimepicker.hour,
                binding.regtimeTimepicker.minute,
                0
            )
            sharedPreferences.edit().putString(BEGIN_DATE, beginDate.toString()).apply()    //Guarda la última fecha de inicio
            sharedPreferences.edit().putString(FIRST_DATE, beginDate.toString()).apply()    //Guarda la primera fecha de inicio
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    //Establece la vista para mostrar el selector de fechas
    private fun setViewDate () {
        binding.regtimeTextDate.visibility= View.GONE
        binding.regtimeDatepicker.visibility= View.GONE
        binding.regtimeTextHour.visibility= View.VISIBLE
        binding.regtimeTimepicker.visibility= View.VISIBLE
        binding.regtimeButtonBack.visibility= View.VISIBLE
        binding.regtimeButtonNext.visibility= View.GONE
        binding.regtimeButtonEnd.visibility= View.VISIBLE
    }
    //Establece la vista para mostrar el selector de horas
    private fun setViewHour() {
        binding.regtimeTextDate.visibility= View.VISIBLE
        binding.regtimeDatepicker.visibility= View.VISIBLE
        binding.regtimeTextHour.visibility= View.GONE
        binding.regtimeTimepicker.visibility= View.GONE
        binding.regtimeButtonBack.visibility= View.GONE
        binding.regtimeButtonNext.visibility= View.VISIBLE
        binding.regtimeButtonEnd.visibility= View.GONE
    }
}