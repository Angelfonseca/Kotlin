package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class MainActivity9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)
        val botonsalir =findViewById<Button>(R.id.salir)
        botonsalir.setOnClickListener{
            finish()
        }
    }
}
