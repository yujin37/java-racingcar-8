package racingcar;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCarValidator;

public class RacingCarValidatorTest {
    @Test
    void 일부_이름_빈칸_테스트(){
        String[] blankNames = {"pobi", " "};

        assertThatThrownBy(() -> RacingCarValidator.validateCarName(blankNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TestErrorCode.TEST_VALIDATE_NAME_BLANK.getMessage());
    }
    @Test
    void 이름_5글자_초과_테스트(){
        String[] lengthNames = {"pobi", "yujinni"};

        assertThatThrownBy(() -> RacingCarValidator.validateCarName(lengthNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(lengthNames[1] + TestErrorCode.TEST_VALIDATE_NAME_LENGTH.getMessage());
    }
    @Test
    void 이름_중복_테스트(){
        String[] duplicateNames = {"pobi", "pobi"};

        assertThatThrownBy(() -> RacingCarValidator.validateCarName(duplicateNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(duplicateNames[1] + TestErrorCode.TEST_VALIDATE_DUPLICATION.getMessage());
    }
    @Test
    void 허용_되지_않는특수_기호_이름_테스트(){
        String[] notAllowedNames = {"pobi-","nuri"};

        assertThatThrownBy(() -> RacingCarValidator.validateCarName(notAllowedNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(notAllowedNames[0] + TestErrorCode.TEST_VALIDATE_NOT_ALLOWED_CHAR.getMessage());
    }
    @Test
    void 아무입력_없는_이름_테스트() {
        String[] blankNames = {""};
        assertThatThrownBy(() -> RacingCarValidator.validateCarName(blankNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TestErrorCode.TEST_VALIDATE_NAME_BLANK.getMessage());
    }
    @Test
    void 정상적인_자동차_입력_테스트(){
        String[] normalNames = {"pobi", "nuri", "roki"};
        assertThatCode(() -> RacingCarValidator.validateCarName(normalNames)).doesNotThrowAnyException();
    }
    @Test
    void 정상적인_자동차_입력_숫자포함_테스트(){
        String[] normalNumNames = {"pobi", "nuri", "roki2"};
        assertThatCode(() -> RacingCarValidator.validateCarName(normalNumNames)).doesNotThrowAnyException();
    }
    @Test
    void 정상적인_자동차_입력_특수기호_테스트(){
        String[] normalCharNames = {"pobi", "nuri", "rok_i"};
        assertThatCode(() -> RacingCarValidator.validateCarName(normalCharNames)).doesNotThrowAnyException();
    }
    @Test
    void 정상적인_자동차_입력_한글_테스트(){
        String[] normalKorNames = {"포비", "nuri", "로켓보이"};
        assertThatCode(() -> RacingCarValidator.validateCarName(normalKorNames)).doesNotThrowAnyException();
    }
    @Test
    void 정상적인_자동차_입력_앞뒤공백_테스트(){
        String[] normalBlankNames = {"포비", " 누리", " 로켓보이 "};
        assertThatCode(() -> RacingCarValidator.validateCarName(normalBlankNames)).doesNotThrowAnyException();
    }
    // 시도 횟수 입력 테스트
    @Test
    void 시도횟수_문자_입력_테스트() {
        String charTryCount = "a";

        assertThatThrownBy(() -> RacingCarValidator.validateTryCount(charTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TestErrorCode.TEST_VALIDATE_TRY_NOT_INTEGER.getMessage());
    }
    @Test
    void 시도횟수_음수_입력_테스트() {
        String charTryCount = "a";

        assertThatThrownBy(() -> RacingCarValidator.validateTryCount(charTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TestErrorCode.TEST_VALIDATE_TRY_NOT_INTEGER.getMessage());
    }
    @Test
    void 시도횟수_소수_입력테스트() {
        String pointTryCount = "2.5";

        assertThatThrownBy(() -> RacingCarValidator.validateTryCount(pointTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TestErrorCode.TEST_VALIDATE_TRY_NOT_INTEGER.getMessage());
    }
    @Test
    void 시도횟수_0_입력테스트() {
        String zeroTryCount = "0";

        assertThatThrownBy(() -> RacingCarValidator.validateTryCount(zeroTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TestErrorCode.TEST_VALIDATE_TRY_NOT_ZERO_AND_NEGATIVE.getMessage());
    }
    @Test
    void 시도횟수_비어있음_테스트(){
        String emptyTryCount = "";

        assertThatThrownBy(() -> RacingCarValidator.validateTryCount(emptyTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TestErrorCode.TEST_VALIDATE_TRY_EMPTY.getMessage());
    }
    @Test
    void 시도횟수_10만초과_테스트(){
        String bigTryCount = "100001";
        String bigExceptionMessage = "시도 횟수 범위가 초과되었습니다. 시도 횟수는 최대 10만 이내로만 제한합니다.";
        assertThatThrownBy(() -> RacingCarValidator.validateTryCount(bigTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TestErrorCode.TEST_VALIDATE_TRY_ALLOWED_ARRANGE.getMessage());
    }
    @Test
    void 시도횟수_자연수_입력테스트() {
        String normalTryCount = "2";
        assertThatCode(() -> RacingCarValidator.validateTryCount(normalTryCount)).doesNotThrowAnyException();
    }


}
