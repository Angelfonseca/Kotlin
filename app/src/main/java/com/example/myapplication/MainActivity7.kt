package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity7 : AppCompatActivity() {

    private val usuarios = arrayOf(
        Usuario("prueba", "prueba"),
        Usuario("Ricardo", "triste"),
        Usuario("Usuario3", "Contraseña3"),
        Usuario("Usuario4", "Contraseña4"),
        Usuario("Usuario5", "Contraseña5")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        val et1 = findViewById<EditText>(R.id.nombre)
        val et2 = findViewById<EditText>(R.id.pass)
        val boton1 = findViewById<Button>(R.id.acti)

        boton1.setOnClickListener {
            val nombreUsuario = et1.text.toString()
            val contraseña = et2.text.toString()

            val usuarioValido = usuarios.any { it.nombre == nombreUsuario && it.contraseña == contraseña }

            if (nombreUsuario.isEmpty() || contraseña.isEmpty()) {
                Toast.makeText(this, "Los campos no pueden quedar vacíos", Toast.LENGTH_LONG).show()
            } else if (usuarioValido) {
                // Inicio de sesión exitoso, abrir MainActivity6
                val intent = Intent(this, MainActivity6::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_LONG).show()
            }
        }
    }

    data class Usuario(val nombre: String, val contraseña: String)
}
