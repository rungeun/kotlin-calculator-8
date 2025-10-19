package calculator.view

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import calculator.view.ConsoleInputView

class InputTest : NsTest() {
    @Test
    fun `사용자 입력`() {
        assertSimpleTest {
            run("1,2,3")
        }
    }

    override fun runMain() {
        val inputView = ConsoleInputView()
        val result = inputView.readString()
        assertThat(result).isEqualTo("1,2,3")
    }
}