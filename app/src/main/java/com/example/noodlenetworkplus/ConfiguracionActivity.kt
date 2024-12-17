package com.example.noodlenetworkplus

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.noodlenetworkplus.databinding.ActivityConfiguracionBinding
import com.google.firebase.auth.FirebaseAuth

class ConfiguracionActivity : BaseActivity() {
    private lateinit var binding: ActivityConfiguracionBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfiguracionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        auth = FirebaseAuth.getInstance()

        binding.configButtonBack.setOnClickListener{onBackPressed()}
        binding.configButtonAccount.setOnClickListener{
            val intent = Intent(this, DetallesCuentaActivity::class.java)
            startActivity(intent)
        }
        binding.configButtonTheme.setOnClickListener{
            val intent = Intent(this, SelectThemeActivity::class.java)
            startActivity(intent)
        }
        binding.configButtonCloseAccount.setOnClickListener{
                showConfirmarCierreSesion()
        }
    }

    private fun showConfirmarCierreSesion() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.closeAccountTitle))
        builder.setMessage(getString(R.string.closeAccountContent))

        builder.setPositiveButton(getString(R.string.closeAccountPositive)) { dialog, which ->
            auth.signOut()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        builder.setNegativeButton(getString(R.string.closeAccountNegative)) { dialog, which ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }
}