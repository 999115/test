package com.example.myapplication

import com.example.myapplication.Calculator.Companion.lastResultValue

class DivideOperation() : AbstractOperation() {
    override fun calculate(num1: Double, operator: String, num2: Double) {
        lastResultValue = num1 / num2
        if (num2 != 0.0) {
            println(lastResultValue)
        } else {
            println("0으로 나눌 수 없습니다.")
        }
    }
}