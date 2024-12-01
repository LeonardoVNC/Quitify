package com.example.noodlenetworkplus

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.noodlenetworkplus.databinding.ActivityPrincipalBinding
import java.time.LocalDateTime

class PrincipalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPrincipalBinding

    private val beginDate: LocalDateTime = LocalDateTime.of(2024, 4, 17, 8,21,0)
    //private val beginDate: LocalDateTime = LocalDateTime.of(2024, 5, 19, 21,23,0)

    private var timerSeconds: Int = 0;
    private var timerMinutes: Int = 0;
    private var timerHours: Int = 0;
    private var timerDays: Int = 0;
    private var timerMonths: Int = 0;
    private var timerYears: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        calcularTiempoTranscurrido(LocalDateTime.now())
        actualizarContador()

        binding.buttonMenu.setOnClickListener{
            binding.testButton.text = "Funciona"
            //binding.progressBar.progress++
        }
    }

    fun calcularTiempoTranscurrido (actualDate: LocalDateTime) {
        var second = actualDate.second
        var minute = actualDate.minute
        var hour = actualDate.hour
        var day = actualDate.dayOfMonth
        var month = actualDate.monthValue
        var year = actualDate.year
        if (second < beginDate.second) {
            minute--
            second+=60
        }
        if (minute < beginDate.minute) {
            hour--
            minute+=60
        }
        if (hour < beginDate.hour) {
            day--
            hour+=24
        }
        if (day < beginDate.dayOfMonth) {
            month--
            day+=30
        }
        if (month < beginDate.monthValue) {
            year--
            month+=12
        }
        timerSeconds = second-beginDate.second
        timerMinutes = minute-beginDate.minute
        timerHours = hour-beginDate.hour
        timerDays = day-beginDate.dayOfMonth
        timerMonths = month-beginDate.monthValue
        timerYears = year-beginDate.year
    }

    fun actualizarContador() {
        binding.textViewCountSecond.text = " $timerSeconds ${getString(R.string.countSecond)}"
        binding.progressBarCountSecond.progress = timerSeconds
        if(timerMinutes>0) {
            binding.textViewCountMinute.text = " $timerMinutes ${getString(R.string.countMinute)}"
            binding.counterMinute.visibility = View.VISIBLE
            binding.progressBarCountMinute.progress = timerMinutes
        }
        if(timerHours>0) {
            binding.textViewCountHour.text = " $timerHours ${getString(R.string.countHour)}"
            binding.counterHour.visibility = View.VISIBLE
            binding.progressBarCountHour.progress = timerHours
        }
        if(timerDays>0) {
            binding.textViewCountDay.text = " $timerDays ${getString(R.string.countDay)}"
            binding.counterDay.visibility = View.VISIBLE
            binding.progressBarCountDay.progress = timerDays
        }
        if(timerMonths>0) {
            binding.textViewCountMonth.text = " $timerMonths ${getString(R.string.countMonth)}"
            binding.counterMonth.visibility = View.VISIBLE
            binding.progressBarCountMonth.progress = timerMonths
        }
        if(timerYears>0) {
            binding.textViewCountYear.text = " $timerYears ${getString(R.string.countYear)}"
            binding.counterYear.visibility = View.VISIBLE
            binding.progressBarCountYear.progress = timerYears
        }
    }
}