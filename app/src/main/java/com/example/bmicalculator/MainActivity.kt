package com.example.bmicalculator

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bmiViewModel: BmiViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bmiViewModel = ViewModelProvider(this)[BmiViewModel::class.java]
        bmiViewModel.bmi.observe(this) { bmi ->
            showBmiResultDialog(bmi)
        }

        binding.btnCalculate.setOnClickListener {
            val height = binding.etHeight.text.toString().toFloatOrNull()
            val weight = binding.etWeight.text.toString().toFloatOrNull()
            if (height != null && weight != null) {
                bmiViewModel.calculateBmi(weight, height)
                // val bmi = Bmi().calculateBmi(weight, height)
                // showBmiResultDialog(bmi)
            }
        }
    }

    private fun showBmiResultDialog(bmi: Float) {
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.bmi_result))
            .setMessage(getString(R.string.bmi_is, bmi.toString()))
            .setPositiveButton(getString(R.string.ok), null)
            .show()
    }
}