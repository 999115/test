package com.example.myapplication

fun main() {

    println("첫번째 숫자를 입력해주세요.")
    var userNum1 = readLine()!!.toDouble()
    println("연산자를 입력해주세요.")
    var userOperator = readLine()!!

    while (true){

        println("두번째 숫자를 입력해주세요.")
        var userNum2 = readLine()!!.toDouble()

        var content = when(userOperator) {
            "+" -> AddOperation(userNum1, userOperator, userNum2)
            "-" -> SubtractOperation(userNum1, userOperator, userNum2)
            "*" -> MultiplyOperation(userNum1, userOperator, userNum2)
            "/" -> DivideOperation(userNum1, userOperator, userNum2)
            "%" -> OddOperation(userNum1, userOperator, userNum2)
            else -> ElseOperation(userNum1, userOperator, userNum2)
        }
        content.calculate()

        println("계산을 그만하려면 -1을, 아니라면 추가 연산자를 입력해주세요.")
        userOperator = readLine()!!
        if (userOperator == "-1"){
            break
        }else {
            userNum1 = Calculator(userNum1, userOperator, userNum2).result.toDouble()
        }
    }

}

open class Calculator(num1 : Double, operator : String, num2 : Double) {
    var num1 : Double = num1
    var operator : String = operator
    var num2 : Double = num2
    var result : Any = ""

    init {
        this.result  = result
    }

    open fun calculate() {
        println(result)
    }

}

class AddOperation(num1 : Double, operator : String, num2 : Double) : Calculator(num1, operator, num2) {
    init {
        result = num1+num2
    }

    override fun calculate() {
//        super.calculate()
        println(result)
    }
}

class SubtractOperation(num1 : Double, operator : String, num2 : Double) : Calculator(num1, operator, num2) {

    init {
        result = num1-num2
    }
    override fun calculate() {
//        super.calculate()
        println(result)
    }
}

class MultiplyOperation(num1 : Double, operator : String, num2 : Double) : Calculator(num1, operator, num2) {
    init {
        result = num1*num2
    }

    override fun calculate() {
//        super.calculate()
        println(result)
    }
}

class DivideOperation(num1 : Double, operator : String, num2 : Double) : Calculator(num1, operator, num2) {
    init {
        result = if (num2 != 0.0){
            num1/num2
        }else {
            "0으로 나눌 수 없습니다."
        }
    }

    override fun calculate() {
//        super.calculate()
        println(result)
    }
}

class OddOperation(num1 : Double, operator : String, num2 : Double) : Calculator(num1, operator, num2) {
    init {
        result = num1%num2
    }

    override fun calculate() {
//        super.calculate()
        println(result)
    }
}

class ElseOperation(num1 : Double, operator : String, num2 : Double) : Calculator(num1, operator, num2) {
    init {
        result = "잘못된 연산자입니다."
    }

    override fun calculate() {
//        super.calculate()
        println(result)
    }
}