package com.example.myapplication

fun main() {

    println("첫번째 숫자를 입력해주세요.")
    var userNum1 = 0.0
    while (true){
        try {
            userNum1 = readLine()!!.toDouble()
            break
        }
        catch (e : NumberFormatException){
            println("숫자만 입력해주세요.")
        }
    }

    var userOperator = ""
    var userNum2 = 0.0

    while (true){

        println("두번째 숫자를 입력해주세요.")
        while (true){
            try {
                userNum2 = readLine()!!.toDouble()
                break
            }
            catch (e : NumberFormatException){
                println("숫자만 입력해주세요.")
            }
        }

        println("계산을 그만하려면 -1을, 아니라면 연산자를 입력해주세요.")
        userOperator = readLine()!!
        val content = when(userOperator) {
            "-1" -> break
            "+" -> AddOperation(userNum1, userOperator, userNum2)
            "-" -> SubtractOperation(userNum1, userOperator, userNum2)
            "*" -> MultiplyOperation(userNum1, userOperator, userNum2)
            "/" -> DivideOperation(userNum1, userOperator, userNum2)
            "%" -> OddOperation(userNum1, userOperator, userNum2)
            else -> ElseOperation(userNum1, userOperator, userNum2)
        }

        content.calculate()

        when(userOperator) {
            "+" -> userNum1 = AddOperation(userNum1, userOperator, userNum2).result
            "-" -> userNum1 = SubtractOperation(userNum1, userOperator, userNum2).result
            "*" -> userNum1 = MultiplyOperation(userNum1, userOperator, userNum2).result
            "/" -> userNum1 = DivideOperation(userNum1, userOperator, userNum2).result
            "%" -> userNum1 = OddOperation(userNum1, userOperator, userNum2).result
            else -> print("")
        }
    }
}
class Calculator(private var operator : AbstractOperation) {
    fun calculate() {
        return operator.calculate()
    }
}

abstract class AbstractOperation(num1 : Double, operator : String, num2 : Double) {
    abstract var num1 : Double
    abstract var num2 : Double
    abstract var result : Double

    abstract fun calculate()
}

class AddOperation(override var num1 : Double, operator : String, override var num2 : Double) : AbstractOperation(num1, operator, num2) {
    override var result = num1+num2

    override fun calculate() {
        println(result)
    }
}
class SubtractOperation(override var num1 : Double, operator : String, override var num2 : Double) : AbstractOperation(num1, operator, num2) {
    override var result = num1-num2

    override fun calculate() {
        println(result)
    }
}
class MultiplyOperation(override var num1 : Double, operator : String, override var num2 : Double) : AbstractOperation(num1, operator, num2) {
    override var result = num1*num2

    override fun calculate() {
        println(result)
    }
}
class DivideOperation(override var num1 : Double, operator : String, override var num2 : Double) : AbstractOperation(num1, operator, num2) {
    override var result = num1 / num2

    override fun calculate() {
        if(num2 != 0.0){
            println(result)
        }else {
            println("0으로 나눌 수 없습니다. 두번째 숫자와 연산자 입력이 초기화됩니다.")
        }
    }
}
class OddOperation(override var num1 : Double, operator : String, override var num2 : Double) : AbstractOperation(num1, operator, num2) {
    override var result = num1%num2

    override fun calculate() {
        if(num2 != 0.0){
            println(result)
        }else {
            println("0으로 나눌 수 없습니다. 두번째 숫자와 연산자 입력이 초기화됩니다.")
        }
    }
}
class ElseOperation(override var num1 : Double, operator : String, override var num2 : Double) : AbstractOperation(num1, operator, num2) {
    override var result = 0.0

    override fun calculate() {
        //        super.calculate()
        println("잘못된 입력입니다. 두번째 숫자 입력을 초기화합니다.")
    }
}