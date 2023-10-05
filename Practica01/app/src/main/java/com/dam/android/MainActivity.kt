package com.dam.android

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var numero1: EditText
    private lateinit var numero2: EditText
    private lateinit var suma: Button
    private lateinit var resta: Button
    private lateinit var multiplicacion: Button
    private lateinit var division: Button
    private lateinit var resultado: TextView
    //correct2
//test
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numero1 = findViewById(R.id.numero1)
        numero2 = findViewById(R.id.numero2)
        suma = findViewById(R.id.suma)
        resta = findViewById(R.id.resta)
        multiplicacion = findViewById(R.id.multiplicacion)
        division = findViewById(R.id.division)
        resultado = findViewById(R.id.resultado)

        suma.setOnClickListener {
            Operacion("+")
        }

        resta.setOnClickListener {
            Operacion("-")
        }

        multiplicacion.setOnClickListener {
            Operacion("*")
        }

        division.setOnClickListener {
            Operacion("/")
        }
    }

    private fun Operacion(operador: String) {
        val num1 = numero1.text.toString().toDouble()
        val num2 = numero2.text.toString().toDouble()
        var resOperacion: Double=0.0

        when (operador) {
            "+" -> resOperacion = num1 + num2
            "-" -> resOperacion = num1 - num2
            "*" -> resOperacion = num1 * num2
            "/" -> resOperacion = num1 / num2
            else -> return
        }

        resultado.text = "Resultado: $resOperacion"
    }
}
