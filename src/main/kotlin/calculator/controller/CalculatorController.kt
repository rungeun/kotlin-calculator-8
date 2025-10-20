package calculator.controller

import calculator.model.domain.Add
import calculator.model.domain.Converter
import calculator.view.ConsoleInputView

class CalculatorController {
    fun run() {
        val inputString = ConsoleInputView().readString()
        val (delimiter, checkedString) = CustomDelimiterController(inputString).extraction()
        val splitText = SplitController().splitText(checkedString, delimiter)

        val converter = Converter().toNumber(splitText)
        val sum = Add().number(converter)
    }
}