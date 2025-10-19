package calculator.model

import calculator.main
import calculator.model.domain.TextData
import calculator.controller.SplitController
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class SplitTest : NsTest() {
    @Nested
    @DisplayName("TextData 클래스 테스트")
    inner class TextDataTest {
        @Test
        fun `기본 구분자 사용`() {
            val text = TextData("1,2:3")
            val result = text.splitByDelimiter(arrayOf(",", ":"))

            assertThat(result).containsExactly("1", "2", "3")
        }

        @Test
        fun `커스텀 구분자를 포함한 split`() {
            val text = TextData("1>2>3")
            val result = text.splitByDelimiter(arrayOf(",", ":", ">"))

            assertThat(result).containsExactly("1", "2", "3")
        }
    }

    @Nested
    @DisplayName("SplitController 클래스 테스트")
    inner class SplitControllerTest {
        @Test
        fun `기본 구분자 + 커스텀 구분자`() {
            val inputString = "1:2>3,4"
            val result = SplitController().splitText(inputString, ">")

            assertThat(result).containsExactly("1", "2", "3", "4")
        }

        @Test
        fun `연속된 구분자`() {
            val inputString = "1:2:::3"
            val result = SplitController().splitText(inputString, ">")

            assertThat(result).containsExactly("1", "2", "3")
        }
    }

    override fun runMain() {
        main()
    }
}
