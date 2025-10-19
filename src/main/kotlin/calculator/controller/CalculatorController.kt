package calculator.controller

import calculator.view.ConsoleInputView

class CalculatorController {
    fun run() {
        val inputString = ConsoleInputView().readString()
        val (delimiter, checkedString) = CustomDelimiterController(inputString).extraction()
        val splitText = SplitController().splitText(checkedString, delimiter)
    }
}