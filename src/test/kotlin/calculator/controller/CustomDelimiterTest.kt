package calculator.controller

import calculator.main
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CustomDelimiterTest : NsTest() {

    @Nested
    @DisplayName("Model 클래스 테스트")
    inner class ControllerTest {
        @Test
        fun `커스텀 구분자 사용`() {
            val inputString = "//>\\n1>2>3"

            val delimiterController = CustomDelimiterController(inputString)
            val (customDelimiter, checkedString) = delimiterController.extraction()

            Assertions.assertThat(customDelimiter).isEqualTo(">")
        }

        @Test
        fun `커스텀 구분자를 포함한 split`() {
            val inputString = "//.\\n1.2.3"

            val delimiterController = CustomDelimiterController(inputString)
            val (customDelimiter, checkedString) = delimiterController.extraction()

            Assertions.assertThat(customDelimiter).isEqualTo(".")
        }

        @Test
        fun `커스텀 구분자로 숫자가 올 경우 예외 처리`() {
            val inputString = "//1\\n1.2.3"

            assertThrows<IllegalArgumentException> {
                val delimitercontroller = CustomDelimiterController(inputString)
                delimitercontroller.extraction()
            }
        }
    }

    override fun runMain() {
        main()
    }
}