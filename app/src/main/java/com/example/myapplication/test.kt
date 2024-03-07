package com.example.myapplication

fun main() {

    while (true){
        println("첫번째 숫자를 입력해주세요.")
        var userNum1 = readLine()!!.toDouble()
        println("연산자를 입력해주세요.")
        var userOperator = readLine()!!
        println("두번째 숫자를 입력해주세요.")
        var userNum2 = readLine()!!.toDouble()

        var result = Calculator(userNum1, userOperator, userNum2)

        result.calculation()
    }


}

class Calculator(num1 : Double, operator : String, num2 : Double) {
    var num1 : Double = num1
    var operator : String = operator
    var num2 : Double = num2
    var content : Any = ""

    init {
        content  =
            when(operator){
                "+" -> num1+num2
                "-" -> num1-num2
                "*" -> num1*num2
                "/" -> num1/num2
                "%" -> num1%num2
                else -> "잘못된 입력입니다."
            }
    }


    fun calculation() {
        println(content)
    }

}

//class AddOperation(num1 : Int, operator : String, num2 : Int) : Calculator(num1, operator, num2) {
//
//    init {
//        content  =
//            when(operator){
//                "+" -> num1+num2
//                "-" -> num1-num2
//                "*" -> num1*num2
//                "/" -> num1/num2
//                "%" -> num1%num2
//                else -> "잘못된 입력입니다."
//            }
//    }
//}
//
//class SubstractOperation(num1 : Int, operator : String, num2 : Int) : Calculator(num1, operator, num2) {
//
//}
//
//class MultiplyOperation(num1 : Int, operator : String, num2 : Int) : Calculator(num1, operator, num2) {
//
//}
//
//class DivideOperation(num1 : Int, operator : String, num2 : Int) : Calculator(num1, operator, num2) {
//
//}