package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class TotalTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 이름_정상적인_입력_영어() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,nuri", "3");
                    assertThat(output()).contains("pobi : -", "nuri : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름_정상적인_입력_한글() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("포비,워니", "3");
                    assertThat(output()).contains("포비 : -", "워니 : ", "최종 우승자 : 포비");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름_정상적인_입력_숫자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123,456", "3");
                    assertThat(output()).contains("123 : -", "456 : ", "최종 우승자 : 123");
                },
                MOVING_FORWARD, STOP
        );
    }


    @Test
    void 이름_개수가_모자라는_경우() {
        assertThatThrownBy(() -> runException("nuri", "3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TestErrorCode.TEST_VALIDATE_CARS_MIN_COUNT.getMessage());
    }

    @Test
    void 이름_개수가_초과하는_경우() {
        assertThatThrownBy(() -> runException("1,2,3,4,5,6,7,8,9,10,11", "3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TestErrorCode.TEST_VALIDATE_CARS_MAX_COUNT.getMessage());
    }

    @Test
    void 이름이_아무것도_없는_경우() {
        assertThatThrownBy(() -> runException("", "3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TestErrorCode.TEST_VALIDATE_NAME_BLANK.getMessage());
    }


    @Test
    void 시도횟수에서_잘못된_입력_소수() {
        assertThatThrownBy(() -> runException("pobi,woni", "3.5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TestErrorCode.TEST_VALIDATE_TRY_NOT_INTEGER.getMessage());
    }

    @Test
    void 시도횟수에서_문자가_입력() {
        assertThatThrownBy(() -> runException("pobi,woni", "abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TestErrorCode.TEST_VALIDATE_TRY_NOT_INTEGER.getMessage());
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }


}
