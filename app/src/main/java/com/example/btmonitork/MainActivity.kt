package com.example.btmonitork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.btmonitork.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var number1: Int = 0
    var number2: Int = 0
    var res = 0
    var sign = ""
    var temp = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun rec () {
        number1 = binding.edInput.text.toString().toInt()
        binding.edInput.text.clear()
    }
    fun onClickPlus (view: View){
        rec()
        sign = "+"
    }
    fun onClickMinus (view: View){
        rec()
        sign = "-"
    }
    fun onClickMult (view: View){
        rec()
        sign = "*"
    }
    fun onClickDiv (view: View){
        rec()
        sign = "/"
    }

    fun onResult (view: View){
        number2 = binding.edInput.text.toString().toInt()
        if (sign == "+"){
            res = number1 + number2
            binding.edInput.setText(res)
        }else if (sign == "-") {
            res = number1 - number2
            binding.edInput.setText(res)
        }else if (sign == "*") {
            res = number1 * number2
            binding.edInput.setText(res)
        }else if (sign == "/") {
            res = number1 / number2
            binding.edInput.setText(res)
        }

        }
    fun onClear(view: View){
        binding.edInput.text.clear()
        number1 = 0
        number2 = 0
        res = 0
        sign = ""
    }


}