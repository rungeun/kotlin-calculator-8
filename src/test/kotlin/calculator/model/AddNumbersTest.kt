package calculator.model

import calculator.main
import calculator.model.domain.Add
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AddNumbersTest : NsTest() {
    @Nested
    @DisplayName("Model 클래스 테스트")
    inner class TextDataTest {
        @Test
        fun `정상적인 덧셈`() {
            val numbers = (listOf(1, 2, 3))
            val added = Add().number(numbers);

            assertThat(added).isEqualTo(6)
        }

        @Test
        fun `0 덧셈`() {
            val numbers = (listOf(0, 0))
            val added = Add().number(numbers);

            assertThat(added).isEqualTo(0)
        }

        @Test
        fun `오버플로우 덧셈`() {
            val numbers = (listOf(Int.MAX_VALUE - 1, 10))
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { Add().number(numbers); }
            }
        }
    }

    override fun runMain() {
        main()
    }
}
