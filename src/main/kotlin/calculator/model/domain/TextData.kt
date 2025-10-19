package calculator.model.domain

import calculator.model.repository.TextRepository

class TextData(val content: String) : TextRepository {

    override fun splitByDelimiter(delimiter: Array<String>): List<String> {
        val delimitered = content.split(*delimiter)
        return delimitered.filter { it.isNotEmpty() }
    }
}