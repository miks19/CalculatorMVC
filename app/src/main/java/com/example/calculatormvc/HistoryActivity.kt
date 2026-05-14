package com.example.calculatormvc

import Models.CalculatorModel
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HistoryActivity : ComponentActivity() {
    private lateinit var adapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_history)

        val btnHistory = findViewById<Button>(R.id.btn_calculator)
        val listViewHistory = findViewById<ListView>(R.id.listViewHistory)
        //intent itutuloy
        btnHistory.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, CalculatorModel.getHistory())
        listViewHistory.adapter = adapter

        listViewHistory.setOnItemLongClickListener { _, _, position, _ ->
            CalculatorModel.deleteHistory(position)
            adapter.notifyDataSetChanged()
            true
        }
    }

    }
