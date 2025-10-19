package calculator.controller

import calculator.view.ConsoleInputView

class CalculatorController {
    fun run() {
        val inputString = ConsoleInputView().readString()
        // TODO: 커스텀 문자 처리
        val splitText = SplitController().splitText(inputString, ">") //커스텀 문자를 ">"로 입시 지정
    }
}