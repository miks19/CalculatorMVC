package com.example.calculatormvc

import Models.CalculatorModel
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculatormvc.ui.theme.CalculatorMVCTheme

class MainActivity : ComponentActivity() {
    //private val CalcModel = CalculatorModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //get input from UI
        val txtnum1 = findViewById<EditText>(R.id.editTextNumber)
        val txtnum2 = findViewById<EditText>(R.id.editTextNumber2)
        val btnAdd = findViewById<Button>(R.id.plus_button)
        val btnSubtract = findViewById<Button>(R.id.minus_button)
        val btnMultiply = findViewById<Button>(R.id.times_button)
        val btnDivide = findViewById<Button>(R.id.divide_button)
        val btnClear = findViewById<Button>(R.id.clear_button)
        val answer = findViewById<TextView>(R.id.textViewAnswer)
        val btnHistory = findViewById<Button>(R.id.buttonHistory)

        //intent itutuloy
        btnHistory.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }


        btnAdd.setOnClickListener {
            CalculatorModel.num1 = txtnum1.text.toString().toDoubleOrNull() ?: 0.0
            CalculatorModel.num2 = txtnum2.text.toString().toDoubleOrNull() ?: 0.0
            //use the model
            val result= CalculatorModel.add().toString()
            //print answer to UI TextView
            answer.text= "Answer: $result"
            CalculatorModel.addHistory(calculation = "${txtnum1.toString()} + ${txtnum2.toString()} = ${result}")


        }
        btnSubtract.setOnClickListener {
            CalculatorModel.num1 = txtnum1.text.toString().toDoubleOrNull() ?: 0.0
            CalculatorModel.num2 = txtnum2.text.toString().toDoubleOrNull() ?: 0.0
            //use the model
            val result= CalculatorModel.subtract().toString()
            //print answer to UI TextView
            answer.text= "Answer: $result"
            CalculatorModel.addHistory(calculation = "${txtnum1.text.toString()} - ${txtnum2.text.toString()} = ${result}")
        }
        btnMultiply.setOnClickListener {
            CalculatorModel.num1 = txtnum1.text.toString().toDoubleOrNull() ?: 0.0
            CalculatorModel.num2 = txtnum2.text.toString().toDoubleOrNull() ?: 0.0
            //use the model
            val result= CalculatorModel.multiply().toString()
            //print answer to UI TextView
            answer.text= "Answer: $result"
            CalculatorModel.addHistory(calculation = "${txtnum1.text.toString()} * ${txtnum2.text.toString()} = ${result}")
        }
        btnDivide.setOnClickListener {
            CalculatorModel.num1 = txtnum1.text.toString().toDoubleOrNull() ?: 0.0
            CalculatorModel.num2 = txtnum2.text.toString().toDoubleOrNull() ?: 0.0
            //use the model
            val result= CalculatorModel.divide().toString()
            //print answer to UI TextView
            answer.text= "Answer: $result"
            CalculatorModel.addHistory(calculation = "${txtnum1.text.toString()} / ${txtnum2.text.toString()} = ${result}")
        }
        btnClear.setOnClickListener {
            answer.text= " 0.0"
            txtnum1.text.clear()
            txtnum2.text.clear()
        }

    }
}
