package calculator.model.repository

interface AddSome {
    fun number(numbers: List<Int>): String
    fun safeCheck(x: Int, y: Int): Boolean
}