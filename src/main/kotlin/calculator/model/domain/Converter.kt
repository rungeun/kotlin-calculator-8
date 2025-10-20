package calculator.model.domain

import calculator.model.repository.ConverterRepository

class Converter : ConverterRepository {
    override fun toNumber(list: List<String>): List<Int> {
        var tempList: MutableList<Int> = mutableListOf()
        for (arg in list) {
            require(arg.toIntOrNull() in 0..9 || arg == "") { "숫자로 변환 실패" }
            tempList.add(
                if (arg.isNotEmpty())
                    arg.toInt()
                else 0
            )
        }
        return tempList
    }
}