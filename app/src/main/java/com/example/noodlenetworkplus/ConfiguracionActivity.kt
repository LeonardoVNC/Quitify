package com.example.noodlenetworkplus

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
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

        binding.configButtonBack.setOnClickListener{onBackPressed()}        //Salida a la pantalla anterior
        binding.configButtonAccount.setOnClickListener{
            val intent = Intent(this, DetallesCuentaActivity::class.java)
            startActivity(intent)                                           //Carga los detalles de la cuenta Activity
        }
        binding.configButtonTheme.setOnClickListener{
            val intent = Intent(this, SelectThemeActivity::class.java)
            startActivity(intent)                                           //Carga el selector de temas Activity
        }
        binding.configButtonCloseAccount.setOnClickListener{
                showConfirmarCierreSesion()                                 //Espera de confirmación para el cierre de sesión
        }
    }

    //Función para evitar el cierre accidental de la sesión actual
    private fun showConfirmarCierreSesion() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.closeAccountTitle))
        builder.setMessage(getString(R.string.closeAccountContent))

        //Espera la confirmación o cancelación de la solicitud al cierre de sesión
        builder.setPositiveButton(getString(R.string.closeAccountPositive)) { dialog, which ->
            auth.signOut()          //Cierre de sesión FireBase
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK     //Borra el BackStack, cierre total de la sesión
            startActivity(intent)
        }
        builder.setNegativeButton(getString(R.string.closeAccountNegative)) { dialog, which ->
            dialog.dismiss()        //Cancela la solicitud
        }
        val dialog = builder.create()       //Se crea y se muestra el mensaje emergente
        dialog.show()
    }
}