package com.example.noodlenetworkplus
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.noodlenetworkplus.RegisterTimeActivity.Companion.APP_PREFERENCES
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    companion object {
        val USERNAME = "username"
    }

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        val usernameEditText = findViewById<EditText>(R.id.etUsernameRegister)
        val emailEditText = findViewById<EditText>(R.id.etEmailRegister)
        val passwordEditText = findViewById<EditText>(R.id.etPasswordRegister)
        val confirmPasswordEditText = findViewById<EditText>(R.id.etConfirmPasswordRegister)
        val registerButton = findViewById<Button>(R.id.btnRegister)
        val loginRedirectTextView = findViewById<TextView>(R.id.tvLoginRedirect)

        loginRedirectTextView.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        registerButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (username.isNotEmpty() && email.isNotEmpty() && password.length >= 6 && password == confirmPassword) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val sharedPref = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
                            with(sharedPref.edit()) {
                                putString(USERNAME, username)
                                apply()
                            }

                            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, PrincipalActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "Error: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Datos inválidos o contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
