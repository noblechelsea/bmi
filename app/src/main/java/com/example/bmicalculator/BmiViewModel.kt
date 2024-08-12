package com.example.bmicalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BmiViewModel: ViewModel() {
    private val _bmi = MutableLiveData<Float>()
    val bmi: LiveData<Float> get() = _bmi

    fun calculateBmi(weight: Float, height: Float) {
        _bmi.value = weight / (height * 2)
    }
}