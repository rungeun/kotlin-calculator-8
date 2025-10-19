package calculator

import calculator.controller.CalculatorController

fun main() {
    try {
        CalculatorController().run()
    } catch (e: IllegalArgumentException) {
        throw (e)
    }
}