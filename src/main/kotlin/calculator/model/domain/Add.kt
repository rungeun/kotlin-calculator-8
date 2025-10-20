package calculator.model.domain

import calculator.model.repository.AddSome

class Add : AddSome {
    override fun number(numbers: List<Int>): Int {
        var sum = 0
        for (element in numbers) {
            require(safeCheck(sum, element)) { "오버플로우" }
            sum += element
        }
        return sum
    }

    override fun safeCheck(x: Int, y: Int): Boolean = x <= Int.MAX_VALUE - y

}