package com.example.noodlenetworkplus

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    // Instancia de FirebaseAuth para manejar la autenticación
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inicializamos FirebaseAuth
        auth = FirebaseAuth.getInstance()

        // Referencias a los elementos del layout
        val emailEditText = findViewById<EditText>(R.id.etEmailLogin) // correo
        val passwordEditText = findViewById<EditText>(R.id.etPasswordLogin) // contraseña
        val loginButton = findViewById<Button>(R.id.btnLogin) // Botón de inicio de sesión
        val registerTextView = findViewById<TextView>(R.id.tvRegisterRedirect) // Texto para redirigir al registro

        // Configuración del clic en el botón de inicio de sesión
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString() // Obtener correo electrónico
            val password = passwordEditText.text.toString() // Obtener contraseña

            // Validar que los campos no estén vacíos
            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Iniciar sesión con Firebase
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // Si el inicio de sesión es exitoso
                            Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, PrincipalActivity::class.java)
                            startActivity(intent)
                            finish() // Finaliza esta actividad
                        } else {
                            // Si ocurre un error, mostrar mensaje en consola
                            Log.e("LoginActivity", "Error: ${task.exception?.message}")
                            Toast.makeText(this, "Error: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                // Si los campos están vacíos
                Toast.makeText(this, "Completa los campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Configuración del clic en el texto para redirigir al registro
        registerTextView.setOnClickListener {
            val intent = Intent(this, IntroActivity::class.java) // Redirige a la pantalla de introducción
            startActivity(intent)
        }
    }
}

