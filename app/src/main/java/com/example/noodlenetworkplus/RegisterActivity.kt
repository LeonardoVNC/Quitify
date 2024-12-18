package com.example.noodlenetworkplus
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    // Instancia de FirebaseAuth para crear nuevos usuarios
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Inicializamos FirebaseAuth
        auth = FirebaseAuth.getInstance()

        // Referencias a los elementos del layout
        val usernameEditText = findViewById<EditText>(R.id.etUsernameRegister) // Nombre de usuario
        val emailEditText = findViewById<EditText>(R.id.etEmailRegister) // Correo electrónico
        val passwordEditText = findViewById<EditText>(R.id.etPasswordRegister) // Contraseña
        val confirmPasswordEditText = findViewById<EditText>(R.id.etConfirmPasswordRegister) // Confirmar contraseña
        val registerButton = findViewById<Button>(R.id.btnRegister) // Botón de registro
        val loginRedirectTextView = findViewById<TextView>(R.id.tvLoginRedirect) // Texto para redirigir al login

        // Configuración del clic para redirigir al login
        loginRedirectTextView.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // Configuración del botón de registro
        registerButton.setOnClickListener {
            val username = usernameEditText.text.toString() // Obtener nombre de usuario
            val email = emailEditText.text.toString() // Obtener correo electrónico
            val password = passwordEditText.text.toString() // Obtener contraseña
            val confirmPassword = confirmPasswordEditText.text.toString() // Obtener confirmación de contraseña

            // Validar campos y contraseñas
            if (username.isNotEmpty() && email.isNotEmpty() && password.length >= 6 && password == confirmPassword) {
                // Crear usuario en Firebase Authentication
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // Guardar el nombre de usuario en SharedPreferences
                            val sharedPref = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
                            with(sharedPref.edit()) {
                                putString("username", username) // Almacenar el nombre de usuario
                                apply()
                            }

                            // Mostrar éxito y redirigir a la actividad principal
                            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, PrincipalActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                        } else {
                            // Mostrar error si ocurre un fallo
                            Toast.makeText(this, "Error: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                // Validar entradas no válidas
                Toast.makeText(this, "Datos inválidos o contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
