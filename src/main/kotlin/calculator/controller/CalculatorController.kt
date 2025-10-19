package calculator.controller

import calculator.view.ConsoleInputView

class CalculatorController {
    fun run() {
        val inputString = ConsoleInputView().readString()
    }
}