package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class MainActivity8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)
        val boton1 = findViewById<Button>(R.id.acerca)
        boton1.setOnClickListener {
            val intento1 = Intent(this, MainActivity9::class.java)
            startActivity(intento1)
        }
    }
}