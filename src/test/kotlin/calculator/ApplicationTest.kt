package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `커스텀 구분자 사용`() {
        assertSimpleTest {
            run("//;\\n1")
            assertThat(output()).contains("결과 : 1")
        }
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }
    }

    @Test
    fun `1-음수 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1") }
        }
    }

    @Test
    fun `2-빈 문자 커스텀 구분자 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//\\n123") }
        }
    }

    @Test
    fun `3-문자열 중간에서 커스텀 구분자를 지정 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1:2://>\\n1>2") }
        }
    }

    @Test
    fun `4-정수 커스텀 구분자 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//1\\n2") }
        }
    }

    @Test
    fun `5-역슬래시 커스텀 구분자`() {
        assertSimpleTest {
            run("//\\\\n1\\2\\3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `6-슬래시 커스텀 구분자`() {
        assertSimpleTest {
            run("///\\n1/2/3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `7-닷 커스텀 구분자`() {
        assertSimpleTest {
            run("//.\\n1.2.3")
            assertThat(output()).contains("결과 : 6")
        }
    }


    @Test
    fun `8-연속 구분자`() {
        assertSimpleTest {
            run("1:2:::3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `9-1-구분자만`() {
        assertSimpleTest {
            run(":")
            assertThat(output()).contains("결과 : 0")
        }
    }

    @Test
    fun `9-2-구분자만`() {
        assertSimpleTest {
            run("::,,")
            assertThat(output()).contains("결과 : 0")
        }
    }

    @Test
    fun `10-1-커스텀 구분자만`() {
        assertSimpleTest {
            run("//>\\n")
            assertThat(output()).contains("결과 : 0")
        }
    }

    @Test
    fun `10-2-커스텀 구분자만`() {
        assertSimpleTest {
            run("//>\\n>>")
            assertThat(output()).contains("결과 : 0")
        }
    }

    @Test
    fun `11-공백 커스텀 구분자`() {
        assertSimpleTest {
            run("// \\n1 2 3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `12-탭 커스텀 구분자`() {
        assertSimpleTest {
            run("//\t\\n1\t2\t3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `13-커스텀 구분자 + 기본 구분자`() {
        assertSimpleTest {
            run("//+\\n1,2:3+4")
            assertThat(output()).contains("결과 : 10")
        }
    }

    @Test
    fun `14-두자리 이상 양수 덧셈`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1:11:222") }
        }
    }

    @Test
    fun `15-빈 문자`() {
        assertSimpleTest {
            run("\n")
            assertThat(output()).contains("결과 : 0")
        }
    }

    override fun runMain() {
        main()
    }
}
