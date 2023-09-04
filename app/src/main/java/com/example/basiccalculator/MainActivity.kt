package com.example.basiccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nomor1 = findViewById<EditText>(R.id.nomor1)
        val Operator = findViewById<Spinner>(R.id.operator)
        val nomor2 = findViewById<EditText>(R.id.nomor2)
        val btnResult = findViewById<Button>(R.id.btnResult)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        val operators = resources.getStringArray(R.array.operators)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, operators)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        Operator.adapter = adapter

        btnResult.setOnClickListener {
            val num1 = nomor1.text.toString().toDouble()
            val num2 = nomor2.text.toString().toDouble()
            val operator = Operator.selectedItem.toString()

            val result = when(operator){
                "+"-> num1 + num2
                "-"-> num1 - num2
                "*"-> num1 * num2
                "/"-> num1 / num2
                else -> 0.0
            }

            tvResult.text = "Hasil: $result"
        }
    }
}