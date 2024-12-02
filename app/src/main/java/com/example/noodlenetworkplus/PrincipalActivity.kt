package com.example.noodlenetworkplus

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.noodlenetworkplus.databinding.ActivityPrincipalBinding
import java.time.LocalDateTime

class PrincipalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPrincipalBinding
    private val handler = Handler(Looper.getMainLooper())
    private lateinit var runnable: Runnable

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

        runnable = object : Runnable {
            override fun run() {
                actualizarContador()
                handler.postDelayed(this, 1000)
            }
        }
        calcularTiempoTranscurrido(LocalDateTime.now())
        visibilidadContador()
        runnable.run()
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
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

    private fun mostrarContador() {
        binding.textViewCountSecond.text = " $timerSeconds ${getString(R.string.countSecond)}"
        binding.progressBarCountSecond.progress = timerSeconds
        binding.textViewCountMinute.text = " $timerMinutes ${getString(R.string.countMinute)}"
        binding.progressBarCountMinute.progress = timerMinutes
        binding.textViewCountHour.text = " $timerHours ${getString(R.string.countHour)}"
        binding.progressBarCountHour.progress = timerHours
        binding.textViewCountDay.text = " $timerDays ${getString(R.string.countDay)}"
        binding.progressBarCountDay.progress = timerDays
        binding.textViewCountMonth.text = " $timerMonths ${getString(R.string.countMonth)}"
        binding.progressBarCountMonth.progress = timerMonths
        binding.textViewCountYear.text = " $timerYears ${getString(R.string.countYear)}"
        binding.progressBarCountYear.progress = timerYears
    }

    private fun visibilidadContador() {
        if(timerYears>0) {
            binding.counterYear.visibility = View.VISIBLE
            binding.counterMonth.visibility = View.VISIBLE
            binding.counterDay.visibility = View.VISIBLE
            binding.counterHour.visibility = View.VISIBLE
            binding.counterMinute.visibility = View.VISIBLE
        } else if (timerMonths>0) {
            binding.counterMonth.visibility = View.VISIBLE
            binding.counterDay.visibility = View.VISIBLE
            binding.counterHour.visibility = View.VISIBLE
            binding.counterMinute.visibility = View.VISIBLE
        } else if (timerDays>0){
            binding.counterDay.visibility = View.VISIBLE
            binding.counterHour.visibility = View.VISIBLE
            binding.counterMinute.visibility = View.VISIBLE
        } else if (timerHours>0) {
            binding.counterHour.visibility = View.VISIBLE
            binding.counterMinute.visibility = View.VISIBLE
        } else if (timerMinutes>0) {
            binding.counterMinute.visibility = View.VISIBLE
        }
    }

    private fun actualizarContador() {
        timerSeconds++
        if (timerSeconds == 60) {
            timerSeconds = 0
            timerMinutes++
            binding.counterMinute.visibility = View.VISIBLE
        }
        if (timerMinutes == 60) {
            timerMinutes = 0
            timerHours++
            binding.counterHour.visibility = View.VISIBLE
        }
        if (timerHours == 24) {
            timerHours = 0
            timerDays++
            binding.counterDay.visibility = View.VISIBLE
        }
        if (timerDays == 30) {
            timerDays = 0
            timerMonths++
            binding.counterMonth.visibility = View.VISIBLE
        }
        if (timerMonths == 12) {
            timerMonths = 0
            timerYears++
            binding.counterYear.visibility = View.VISIBLE
        }
        mostrarContador()
    }
}