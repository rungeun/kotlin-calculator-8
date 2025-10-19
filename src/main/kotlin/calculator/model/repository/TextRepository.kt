package calculator.model.repository

interface TextRepository {
    fun splitByDelimiter(delimiter: Array<String>): List<String>
}