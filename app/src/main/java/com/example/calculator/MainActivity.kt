package com.example.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var ifade=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sayiButonlari = listOf(
            binding.button0, binding.button1, binding.button2,
            binding.button3, binding.button4, binding.button5,
            binding.button6, binding.button7, binding.button8,
            binding.button9
        )

        for (buton in sayiButonlari) {
            buton.setOnClickListener {
                ifade += buton.text
                binding.textViewSonuc.text = ifade
            }
        }

        binding.buttonToplama.setOnClickListener {
            ifade += "+"
            binding.textViewSonuc.text = ifade
        }

        binding.buttonCikarma.setOnClickListener {
            ifade += "-"
            binding.textViewSonuc.text = ifade
        }

        binding.buttonCarpma.setOnClickListener {
            ifade += "*"
            binding.textViewSonuc.text = ifade
        }

        binding.buttonBolum.setOnClickListener {
            ifade += "/"
            binding.textViewSonuc.text = ifade
        }

        binding.buttonAc.setOnClickListener {
            ifade = ""
            binding.textViewSonuc.text = "0"
        }

        binding.buttonSonuc.setOnClickListener {
            try {
                val sonuc = ifadeHesapla(ifade)
                binding.textViewSonuc.text = sonuc.toString()
                ifade = sonuc.toString()
            } catch (e: Exception) {
                binding.textViewSonuc.text = "Hata"
                ifade = ""
            }
        }
    }

    private fun ifadeHesapla(ifade: String): Double {
        val temizIfade = ifade.replace("x", "*").replace("÷", "/")
        val result = ExpressionBuilder(temizIfade).build().evaluate()
        return result
    }

}












