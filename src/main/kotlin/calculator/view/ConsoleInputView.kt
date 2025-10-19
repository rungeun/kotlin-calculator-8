package calculator.view

import camp.nextstep.edu.missionutils.Console

class ConsoleInputView : InputView {
    override fun readString(): String {
        return Console.readLine()
    }
}