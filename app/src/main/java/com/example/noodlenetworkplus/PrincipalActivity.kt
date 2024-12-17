package com.example.noodlenetworkplus

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.noodlenetworkplus.RegisterAdictionActivity.Companion.USER_ADDICTION
import com.example.noodlenetworkplus.RegisterTimeActivity.Companion.APP_PREFERENCES
import com.example.noodlenetworkplus.RegisterTimeActivity.Companion.BEGIN_DATE
import com.example.noodlenetworkplus.databinding.ActivityPrincipalBinding
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.Random

class PrincipalActivity : BaseActivity() {
    private lateinit var binding: ActivityPrincipalBinding
    private val handler = Handler(Looper.getMainLooper())
    private lateinit var runnable: Runnable
    private lateinit var beginDate: LocalDateTime

    private var timerSeconds: Int = 0;
    private var timerMinutes: Int = 0;
    private var timerHours: Int = 0;
    private var timerDays: Int = 0;
    private var timerMonths: Int = 0;
    private var timerYears: Int = 0;
    private var totalDays: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sharedPreferences = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
        val beginDateString = sharedPreferences.getString(BEGIN_DATE, LocalDateTime.now().toString())
        val adictionString = sharedPreferences.getString(USER_ADDICTION, "una adicción")

        beginDate = LocalDateTime.parse(beginDateString)

        runnable = object : Runnable {
            override fun run() {
                actualizarContador()
                handler.postDelayed(this, 1000)
            }
        }
        calcularTiempoTranscurrido(LocalDateTime.now())
        elegirMotivacion()
        visibilidadContador()
        runnable.run()

        binding.principalTextCountmsg.text = "${getString(R.string.countMessage)} $adictionString"
        binding.principalTextCountDays.text = "$totalDays ${getString(R.string.countDay)}"
        binding.principalButtonReset.setOnClickListener{
            showConfirmarReinicio()
        }

        binding.principalButtonMenu.setOnClickListener{
            val intent = Intent(this, ConfiguracionActivity::class.java)
            startActivity(intent)
        }

        binding.principalButtonTask.setOnClickListener{
            val intent = Intent(this, MenuActividadesActivity::class.java)
            startActivity(intent)
        }
        binding.principalButtonCommunity.setOnClickListener{
            val intent = Intent(this, ForoDeComunidadActivity::class.java)
            startActivity(intent)
        }
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
        totalDays = ChronoUnit.DAYS.between(beginDate, LocalDateTime.now()).toInt()
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
            if (timerMinutes == 60) {
                timerMinutes = 0
                timerHours++
                binding.counterHour.visibility = View.VISIBLE
                if (timerHours == 24) {
                    timerHours = 0
                    timerDays++
                    totalDays++
                    binding.counterDay.visibility = View.VISIBLE
                    if (timerDays == 30) {
                        timerDays = 0
                        timerMonths++
                        binding.counterMonth.visibility = View.VISIBLE
                        if (timerMonths == 12) {
                            timerMonths = 0
                            timerYears++
                            binding.counterYear.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
        mostrarContador()
    }

    fun reiniciarTiempo () {
        getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE).edit().putString(BEGIN_DATE, LocalDateTime.now().toString()).apply()
        timerSeconds= 0;
        timerMinutes= 0;
        timerHours= 0;
        timerDays= 0;
        timerMonths= 0;
        timerYears= 0;
        binding.counterYear.visibility = View.GONE
        binding.counterMonth.visibility = View.GONE
        binding.counterDay.visibility = View.GONE
        binding.counterHour.visibility = View.GONE
        binding.counterMinute.visibility = View.GONE
        totalDays = 0
        binding.principalTextCountDays.text = "$totalDays ${getString(R.string.countDay)}"
        mostrarContador()
    }

    private fun showConfirmarReinicio() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.showConfirmationTitle))
        builder.setMessage(getString(R.string.showConfirmationContent))

        builder.setPositiveButton(getString(R.string.showConfirmationPositive)) { dialog, which ->
            reiniciarTiempo()
        }
        builder.setNegativeButton(getString(R.string.showConfirmationNegative)) { dialog, which ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }

    private fun elegirMotivacion() {
        val motivacion = listOf(
            R.string.motivation1,
            R.string.motivation2,
            R.string.motivation3,
            R.string.motivation4,
            R.string.motivation5,
            R.string.motivation6,
            R.string.motivation7,
            R.string.motivation8,
            R.string.motivation9,
            R.string.motivation10,
            R.string.motivation11,
            R.string.motivation12,
            R.string.motivation13,
            R.string.motivation14,
            R.string.motivation15
        )
        binding.principalTextMotivation.text = getString(motivacion.random())
    }
}