package calculator.model

import calculator.controller.CustomDelimiterController
import calculator.main
import calculator.model.domain.Converter
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NumberConverterTest : NsTest() {
    @Nested
    @DisplayName("Model 클래스 테스트")
    inner class TextDataTest {
        @Test
        fun `자연수 변환기`() {
            val converter = Converter()
            val result = converter.toNumber(listOf("1", "2"))

            assertThat(result).containsExactly(1, 2)
        }

        @Test
        fun `두자리 수`() {
            val converter = Converter()

            assertThrows<IllegalArgumentException> {
                converter.toNumber(listOf("10", "2"))
            }
        }

        @Test fun`공백 전달`(){
            val converter = Converter()
            val result = converter.toNumber(listOf(""))

            assertThat(result).containsExactly(0)
        }

        @Test fun`공백과 숫자 전달`(){
            val converter = Converter()
            val result = converter.toNumber(listOf("", "1", "", "2", "", "3"))

            assertThat(result).containsExactly(0, 1, 0, 2, 0, 3)
        }
    }



    override fun runMain() {
        main()
    }
}
