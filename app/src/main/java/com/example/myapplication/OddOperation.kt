package com.example.myapplication

import com.example.myapplication.Calculator.Companion.lastResultValue

class OddOperation() : AbstractOperation() {
    override fun calculate(num1: Double, operator: String, num2: Double) {
        lastResultValue = num1 % num2
        if (num2 != 0.0) {
            println(lastResultValue)
        } else {
            println("0으로 나눌 수 없습니다. 두번째 숫자와 연산자 입력이 초기화됩니다.")
        }
    }
}