package com.example.myapplication

import com.example.myapplication.Calculator.Companion.lastResultValue

class MultiplyOperation() : AbstractOperation() {
    override fun calculate(num1: Double, operator: String, num2: Double) {
        lastResultValue = num1 * num2
        println(lastResultValue)
    }
}