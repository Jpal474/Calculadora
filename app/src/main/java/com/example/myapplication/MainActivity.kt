package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var firstValue: Double = 0.0
    var operator: Char = '0'
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.Ac.setOnClickListener{
            binding.editTextNumber.text.clear()
        }

        binding.Del.setOnClickListener{
            binding.editTextNumber.setText(binding.editTextNumber.text.dropLast(1))
        }

        binding.porcentaje.setOnClickListener {
            binding.editTextNumber.setText(porcentaje(operator))
        }

        binding.igual.setOnClickListener {
            when(operator){
                '+' -> {binding.editTextNumber.setText(
                        "${firstValue + binding.editTextNumber.text.toString().toDouble()}"
                )}
                '-' -> {binding.editTextNumber.setText(
                        "${firstValue - binding.editTextNumber.text.toString().toDouble()}"
                )}
                '*' -> {binding.editTextNumber.setText(
                        "${firstValue * binding.editTextNumber.text.toString().toDouble()}"
                )}
                '/' -> {binding.editTextNumber.setText(
                        "${firstValue / binding.editTextNumber.text.toString().toDouble()}"
                )}
                else -> binding.editTextNumber.setText("ERROR")
            }
            operator = '0'
            firstValue = 0.0
        }
    }

    fun porcentaje( operatorToUse: Char): String{
        when(operatorToUse){
            '+' -> {return "${firstValue + (firstValue*binding.editTextNumber.text.toString().toDouble()/100)}"}
            '-' -> {return "${firstValue - (firstValue*binding.editTextNumber.text.toString().toDouble()/100)}"}
            '0' -> {return "${binding.editTextNumber.text.toString().toDouble()/100}"}
            else -> {return "Error"}
        }
    }

    fun getOperator(view: View){
        val button = view as Button
        operator = button.text.get(0)
/*        operator = when (button.id){
            binding.buttonDivision.id -> {'/'}
            binding.buttonMultiplicacion.id -> {'*'}
            binding.buttonSuma.id -> {'+'}
            binding.buttonResta.id -> {'-'}
            else -> {'0'}
        }*/
        firstValue = binding.editTextNumber.text.toString().toDouble()
        binding.editTextNumber.text.clear()

    }

    fun numberButtonClicked (view : View){
        val button = view as Button

        when(button.id){
            binding.button0.id -> {binding.editTextNumber.text.append("0")}
            binding.button1.id -> {binding.editTextNumber.text.append("1")}
            binding.button2.id -> {binding.editTextNumber.text.append("2")}
            binding.button3.id -> {binding.editTextNumber.text.append("3")}
            binding.button4.id -> {binding.editTextNumber.text.append("4")}
            binding.button5.id -> {binding.editTextNumber.text.append("5")}
            binding.button6.id -> {binding.editTextNumber.text.append("6")}
            binding.button7.id -> {binding.editTextNumber.text.append("7")}
            binding.button8.id -> {binding.editTextNumber.text.append("8")}
            binding.button9.id -> {binding.editTextNumber.text.append("9")}
            binding.decimal.id -> {
                if (!binding.editTextNumber.text.contains('.')){
                    binding.editTextNumber.text.append(".")
                }}
            else -> Toast.makeText(this,"else",Toast.LENGTH_SHORT).show()
        }

    }
}
