package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val textViewDetails: TextView = findViewById(R.id.textViewDetails)
        val buttonBack: Button = findViewById(R.id.buttonBack)

        // Получаем данные из Intent
        val brand = intent.getStringExtra("BRAND") ?: "Неизвестно"
        val model = intent.getStringExtra("MODEL") ?: "Неизвестно"
        val year = intent.getIntExtra("YEAR", 0)
        val speed = intent.getIntExtra("SPEED", 0)

        // Отображаем данные на экране
        textViewDetails.text = "Марка: $brand\nМодель: $model\nГод: $year\nСкорость: $speed км/ч"

        // Обработка нажатия кнопки "Назад"
        buttonBack.setOnClickListener {
            finish() // Закрывает текущее Activity и возвращает на предыдущий экран
        }
    }
}
