package calculator.controller

interface DelimiterController {
    fun extraction(): Pair<String, String>
    fun checkDelimiter(): Boolean
}

class CustomDelimiterController(private val inputString: String) : DelimiterController {

    companion object {
        private const val DEFAULT_DELIMITER = ","
        private val CUSTOM_DELIMITER_PATTERN = """//(.)\\n""".toRegex()
    }

    override fun extraction(): Pair<String, String> =
        if (CustomDelimiterController(inputString).checkDelimiter()) {
            require(!inputString[2].isDigit()) { "구분자로 정수가 올 수 없습니다." }
            Pair(inputString[2].toString(), inputString.drop(5))
        } else {
            Pair(DEFAULT_DELIMITER, inputString)
        }


    override fun checkDelimiter(): Boolean =
        CUSTOM_DELIMITER_PATTERN.containsMatchIn(inputString.take(5))
}