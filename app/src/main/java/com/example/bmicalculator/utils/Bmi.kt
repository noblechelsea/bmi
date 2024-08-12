package com.example.bmicalculator.utils

class Bmi {

    fun calculateBmi(weight: Float, height: Float): Float {
        return weight / (height * 2)
    }
}