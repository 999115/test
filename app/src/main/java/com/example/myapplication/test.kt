package com.example.myapplication

fun main() {

    println("첫번째 숫자를 입력해주세요.")
    var userNum1 = 0.0
    while (true) {
        try {
            userNum1 = readLine()!!.toDouble()
            break
        } catch (e: NumberFormatException) {
            println("숫자만 입력해주세요.")
        }
    }

    var userOperator = ""
    var userNum2 = 0.0

    while (true) {

        println("두번째 숫자를 입력해주세요.")
        while (true) {
            try {
                userNum2 = readLine()!!.toDouble()
                break
            } catch (e: NumberFormatException) {
                println("숫자만 입력해주세요.")
            }
        }

        println("계산을 그만하려면 -1을, 아니라면 연산자를 입력해주세요.")
        userOperator = readLine()!!
        val content = when (userOperator) {
            "-1" -> break
            "+" -> Calculator(AddOperation(userNum1, userOperator, userNum2))
            "-" -> Calculator(SubtractOperation(userNum1, userOperator, userNum2))
            "*" -> Calculator(MultiplyOperation(userNum1, userOperator, userNum2))
            "/" -> Calculator(DivideOperation(userNum1, userOperator, userNum2))
            "%" -> Calculator(OddOperation(userNum1, userOperator, userNum2))
            else -> Calculator(ElseOperation(userNum1, userOperator, userNum2))
        }

        content.calculate()

        userNum1 = Calculator.lastResultValue
    }
}

class Calculator(private var operator: AbstractOperation) {
    fun calculate() {
        return operator.calculate()
    }
    companion object {
        var lastResultValue = 0.0
    }
}

abstract class AbstractOperation(num1: Double, operator: String, num2: Double) {
    abstract var num1: Double
    abstract var num2: Double
    abstract var result: Double

    abstract fun calculate()
}

class AddOperation(override var num1: Double, operator: String, override var num2: Double) :
    AbstractOperation(num1, operator, num2) {
    override var result = (num1 + num2).also { Calculator.lastResultValue = it }

    override fun calculate() {
        println(result)
    }
}

class SubtractOperation(override var num1: Double, operator: String, override var num2: Double) :
    AbstractOperation(num1, operator, num2) {
    override var result = (num1 - num2).also { Calculator.lastResultValue = it }

    override fun calculate() {
        println(result)
    }
}

class MultiplyOperation(override var num1: Double, operator: String, override var num2: Double) :
    AbstractOperation(num1, operator, num2) {
    override var result = (num1 * num2).also { Calculator.lastResultValue = it }

    override fun calculate() {
        println(result)
    }
}

class DivideOperation(override var num1: Double, operator: String, override var num2: Double) :
    AbstractOperation(num1, operator, num2) {
    override var result = (num1 / num2).also { Calculator.lastResultValue = it }

    override fun calculate() {
        if (num2 != 0.0) {
            println(result)
        } else {
            println("0으로 나눌 수 없습니다. 두번째 숫자와 연산자 입력이 초기화됩니다.")
        }
    }
}

class OddOperation(override var num1: Double, operator: String, override var num2: Double) :
    AbstractOperation(num1, operator, num2) {
    override var result = (num1 % num2).also { Calculator.lastResultValue = it }

    override fun calculate() {
        if (num2 != 0.0) {
            println(result)
        } else {
            println("0으로 나눌 수 없습니다. 두번째 숫자와 연산자 입력이 초기화됩니다.")
        }
    }
}

class ElseOperation(override var num1: Double, operator: String, override var num2: Double) :
    AbstractOperation(num1, operator, num2) {
    override var result = 0.0

    override fun calculate() {
        //        super.calculate()
        println("잘못된 입력입니다. 두번째 숫자 입력을 초기화합니다.")
    }
}