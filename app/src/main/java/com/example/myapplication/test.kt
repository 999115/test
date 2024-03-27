package com.example.myapplication

import com.example.myapplication.Calculator.Companion.lastResultValue
import kotlin.time.measureTimedValue

fun main() {
    var userNum1: Double = 0.0
    var userOperator: String = ""
    var userNum2: Double = 0.0

    println("첫번째 숫자를 입력해주세요.")
    inputWithoutException(userNum1)

    while (true) {

        println("계산을 그만하려면 -1을, 아니라면 연산자를 입력해주세요.")
        userOperator = readLine()!!
        val content = when (userOperator) {
            "-1" -> {
                println("계산이 종료됩니다.")
                break
            }

            "+" -> Calculator(AddOperation())
            "-" -> Calculator(SubtractOperation())
            "*" -> Calculator(MultiplyOperation())
            "/" -> Calculator(DivideOperation())
            "%" -> Calculator(OddOperation())
            else -> {
                println("잘못된 입력입니다.")
                continue
            }
        }

        inputWithoutException(userNum2)

        content.calculate(userNum1, userOperator, userNum2)

        userNum1 = lastResultValue
    }
}

fun inputWithoutException(num : Double) {
    while (true) {
        try {
            var num = readLine()?.toDoubleOrNull()
            break
        } catch (e: NumberFormatException) {
            println("숫자만 입력해주세요.")
        }
    }
}