package com.example.myapplication

class Calculator(private var operation: AbstractOperation) {
    fun calculate(num1: Double, operator: String, num2: Double)  {
        return operation.calculate(num1, operator, num2)
    }
    companion object {
        var lastResultValue = 0.0
    }
}