package com.example.btmonitork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.btmonitork.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            b0.setOnClickListener { textAdd("0") }
            b1.setOnClickListener { textAdd("1") }
            b2.setOnClickListener { textAdd("2") }
            b3.setOnClickListener { textAdd("3") }
            b4.setOnClickListener { textAdd("4") }
            b5.setOnClickListener { textAdd("5") }
            b6.setOnClickListener { textAdd("6") }
            b7.setOnClickListener { textAdd("7") }
            b8.setOnClickListener { textAdd("8") }
            b9.setOnClickListener { textAdd("9") }
            bPlus.setOnClickListener { textAdd("+") }
            bMinus.setOnClickListener { textAdd("-") }
            bMult.setOnClickListener { textAdd("*") }
            bDiv.setOnClickListener { textAdd("/") }
            bPercent.setOnClickListener { textAdd("%") }
            b000.setOnClickListener { textAdd("000") }
            bPoint.setOnClickListener { textAdd(".") }
            bClear.setOnClickListener {
                tvInput.text = ""
                tvResult.text = ""
            }
            bBackspace.setOnClickListener {
                val str = tvInput.text.toString()
                if (str.isNotEmpty())
                    tvInput.text = str.substring(0, str.length -1)
                tvResult.text = ""
            }
            bResult.setOnClickListener {
                try {
                    // классы и функции из добавленной нами библиотеки exp4j
                    val ex = ExpressionBuilder(tvInput.text.toString()).build()
                    val result = ex.evaluate()

                    val longRes = result.toInt()
                    if (result == longRes.toDouble())
                        tvResult.text = longRes.toString()
                    else tvResult.text = result.toString()

                }catch (e:Exception){
                    Toast.makeText(this@MainActivity, "${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
    fun textAdd (str: String){
        if (binding.tvResult.text != "") {
            binding.tvInput.text = binding.tvResult.text
            binding.tvResult.text = ""
        }
        binding.tvInput.append(str)
    }

}