package calculator.controller

import calculator.model.domain.TextData

interface TextController {
    fun splitText(inputString: String, customDelimiter: String): List<String>
}

class SplitController : TextController {
    override fun splitText(inputString: String, customDelimiter: String): List<String> {
        val delimiters = arrayOf(",", ":", customDelimiter)
        val textData = TextData(inputString)
        return textData.splitByDelimiter(delimiters)
    }
}