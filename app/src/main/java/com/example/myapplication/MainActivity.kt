package com.example.myapplication

import android.content.Intent // Импортируем Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button: Button = findViewById(R.id.button)
        val editTextBrand: EditText = findViewById(R.id.editTextText)
        val editTextModel: EditText = findViewById(R.id.editTextText2)
        val editTextYear: EditText = findViewById(R.id.editTextNumber)
        val editTextSpeed: EditText = findViewById(R.id.editTextNumber2)

        button.setOnClickListener {
            val brand = editTextBrand.text.toString()
            val model = editTextModel.text.toString()
            val year = editTextYear.text.toString().toIntOrNull() ?: 0
            val speed = editTextSpeed.text.toString().toIntOrNull() ?: 0

            // Создаем объект Car
            val car = Car(brand, model, year, speed)

            // Переключаемся на SecondActivity и передаем данные
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("BRAND", car.brand)
                putExtra("MODEL", car.model)
                putExtra("YEAR", car.year)
                putExtra("SPEED", car.speed)
            }
            startActivity(intent)
        }
    }
}

interface TransportVehicle {
    val speed: Int
    val brand: String
    fun move()
}

class Car(override val brand: String, val model: String, val year: Int, override val speed: Int) : TransportVehicle {
    override fun move() {
        println("$brand $model ($year) движется со скоростью $speed км/ч.")
    }
}
