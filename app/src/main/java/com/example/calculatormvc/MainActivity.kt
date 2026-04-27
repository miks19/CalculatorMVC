package com.example.calculatormvc

import Models.CalculatorModel
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
    private val CalcModel = CalculatorModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //get input from UI
        val num1 = findViewById<EditText>(R.id.editTextNumber)
        val num2 = findViewById<EditText>(R.id.editTextNumber2)
        val btnAdd = findViewById<Button>(R.id.plus_button)
        val btnSubtract = findViewById<Button>(R.id.minus_button)
        val btnMultiply = findViewById<Button>(R.id.times_button)
        val btnDivide = findViewById<Button>(R.id.divide_button)
        val btnClear = findViewById<Button>(R.id.clear_button)
        val answer = findViewById<TextView>(R.id.textViewAnswer)



        btnAdd.setOnClickListener {
            CalcModel.num1 = num1.text.toString().toDoubleOrNull() ?: 0.0
            CalcModel.num2 = num2.text.toString().toDoubleOrNull() ?: 0.0
            //use the model
            val result= CalcModel.add().toString()
            //print answer to UI TextView
            answer.text= "Answer: $result"
        }
        btnSubtract.setOnClickListener {
            CalcModel.num1 = num1.text.toString().toDoubleOrNull() ?: 0.0
            CalcModel.num2 = num2.text.toString().toDoubleOrNull() ?: 0.0
            //use the model
            val result= CalcModel.subtract().toString()
            //print answer to UI TextView
            answer.text= "Answer: $result"
        }
        btnMultiply.setOnClickListener {
            CalcModel.num1 = num1.text.toString().toDoubleOrNull() ?: 0.0
            CalcModel.num2 = num2.text.toString().toDoubleOrNull() ?: 0.0
            //use the model
            val result= CalcModel.multiply().toString()
            //print answer to UI TextView
            answer.text= "Answer: $result"
        }
        btnDivide.setOnClickListener {
            CalcModel.num1 = num1.text.toString().toDoubleOrNull() ?: 0.0
            CalcModel.num2 = num2.text.toString().toDoubleOrNull() ?: 0.0
            //use the model
            val result= CalcModel.divide().toString()
            //print answer to UI TextView
            answer.text= "Answer: $result"
        }
        btnClear.setOnClickListener {
            answer.text= " 0.0"
            num1.text.clear()
            num2.text.clear()
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorMVCTheme {
        Greeting("Android")
    }
}