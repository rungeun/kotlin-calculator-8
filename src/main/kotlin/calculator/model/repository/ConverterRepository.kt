package calculator.model.repository

interface ConverterRepository {
    fun toNumber(list : List<String>) : List<Int>
}