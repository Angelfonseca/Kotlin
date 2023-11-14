package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity6 : AppCompatActivity() {

    private val historial = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        val n1 = findViewById<EditText>(R.id.no1)
        val n2 = findViewById<EditText>(R.id.no2)
        val n3 = findViewById<EditText>(R.id.no3)
        val r1 = findViewById<RadioButton>(R.id.suma)
        val r2 = findViewById<RadioButton>(R.id.resta)
        val r3 = findViewById<RadioButton>(R.id.mult)
        val r4 = findViewById<RadioButton>(R.id.divi)
        val tv1 = findViewById<TextView>(R.id.resultado)
        val tvHistorial = findViewById<TextView>(R.id.historial)
        val button = findViewById<Button>(R.id.action)

        button.setOnClickListener {
            tv1.text = ""

            val num1 = n1.text.toString().toIntOrNull()
            val num2 = n2.text.toString().toIntOrNull()
            val num3 = n3.text.toString().toIntOrNull()

            if (num1 != null && num2 != null && num3 != null) {
                if (r1.isChecked) {
                    val resultado = num1 + num2 + num3
                    tv1.text = "Resultado: $resultado"
                    agregarAlHistorial(resultado)
                }
                if (r2.isChecked) {
                    val resultado = num1 - num2 - num3
                    tv1.text = "Resultado: $resultado"
                    agregarAlHistorial(resultado)
                }
                if (r3.isChecked) {
                    val resultado = num1 * num2 * num3
                    tv1.text = "Resultado: $resultado"
                    agregarAlHistorial(resultado)
                }
                if (r4.isChecked && num2 != 0) {
                    val resultado = num1 / num2
                    tv1.text = "Resultado: $resultado"
                    agregarAlHistorial(resultado)
                } else if (r4.isChecked) {
                    tv1.text = "Error: n2 cannot be 0"
                }

                n1.text.clear()
                n2.text.clear()
                n3.text.clear()
            } else {
                tv1.text = "Error: Ingrese valores válidos en todos los campos"
            }

            tvHistorial.text = "Historial:\n${historial.joinToString("\n")}"
            hideKeyboard()
        }
    }

    private fun agregarAlHistorial(resultado: Int) {
        historial.add("Resultado: $resultado")
    }

    private fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}
