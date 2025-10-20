package calculator.view

object ConsoleOutputView : OutputView {
    private const val RESULT_GUIDE = "결과 : "

    override fun printString(s: String) {
        println(RESULT_GUIDE + s)
    }
}