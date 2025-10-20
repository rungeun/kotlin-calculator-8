package calculator.model.repository

interface AddSome {
    fun number(numbers: List<Int>): Int
    fun safeCheck (x: Int, y: Int): Boolean
}