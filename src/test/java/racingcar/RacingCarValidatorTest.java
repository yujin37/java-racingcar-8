package racingcar;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RacingCarValidatorTest {
    @Test
    void 일부_이름_빈칸_테스트(){
        String[] blankNames = {"pobi", " "};
        String blankExpectedMessage = "일부 이름이 빈칸으로 주어져 있습니다.";
        assertThatThrownBy(() -> RacingCarValidator.validateCarName(blankNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(blankExpectedMessage);
    }
    @Test
    void 이름_5글자_초과_테스트(){
        String[] lengthNames = {"pobi", "yujinni"};
        String lengthExpectedMessage = " 해당 이름 길이가 5글자보다 깁니다.";
        assertThatThrownBy(() -> RacingCarValidator.validateCarName(lengthNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(lengthNames[1] + lengthExpectedMessage);
    }
    @Test
    void 이름_빈_문자열_테스트(){
        String[] emptyNames = {"pobi", " "};
        String blankExpectedMessage = "일부 이름이 빈칸으로 주어져 있습니다.";
        assertThatThrownBy(() -> RacingCarValidator.validateCarName(emptyNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(blankExpectedMessage);
    }
    @Test
    void 이름_중복_테스트(){
        String[] duplicateNames = {"pobi", "pobi"};
        String duplicateExpectedMessage = " 해당 이름이 이전에 나온 적 있습니다.";
        assertThatThrownBy(() -> RacingCarValidator.validateCarName(duplicateNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(duplicateNames[1] + duplicateExpectedMessage);
    }
    @Test
    void 허용_되지_않는특수_기호_이름_테스트(){
        String[] notAllowedNames = {"pobi-","nuri"};
        String nowAllowedExpectedMessage = " 해당 이름이 이름 규칙에 맞지 않습니다. 이름에는 숫자, 영문자, 한글, _만 나올 수 있습니다.";
        assertThatThrownBy(() -> RacingCarValidator.validateCarName(notAllowedNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(notAllowedNames[0] + nowAllowedExpectedMessage);
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
    // 시도 횟수 입력 테스트
    @Test
    void 시도횟수_문자_입력_테스트() {
        String charTryCount = "a";
        String charExceptionMessage = "시도 횟수가 허용되지 않은 형태로 입력되었습니다. 반드시 자연수로 입력되어야 합니다.";
        assertThatThrownBy(() -> RacingCarValidator.validateTryCount(charTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(charExceptionMessage);
    }
    @Test
    void 시도횟수_음수_입력_테스트() {
        String charTryCount = "a";
        String charExceptionMessage = "시도 횟수가 허용되지 않은 형태로 입력되었습니다. 반드시 자연수로 입력되어야 합니다.";
        assertThatThrownBy(() -> RacingCarValidator.validateTryCount(charTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(charExceptionMessage);
    }
    @Test
    void 시도횟수_소수_입력테스트() {
        String pointTryCount = "2.5";
        String pointExceptionMessage = "시도 횟수가 허용되지 않은 형태로 입력되었습니다. 반드시 자연수로 입력되어야 합니다.";
        assertThatThrownBy(() -> RacingCarValidator.validateTryCount(pointTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(pointExceptionMessage);
    }
    @Test
    void 시도횟수_0_입력테스트() {
        String zeroTryCount = "0";
        String zeroExceptionMessage = "시도 횟수는 반드시 0보다 큰 자연수로 입력되어야 합니다.";
        assertThatThrownBy(() -> RacingCarValidator.validateTryCount(zeroTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(zeroExceptionMessage);
    }
    @Test
    void 시도횟수_비어있음_테스트(){
        String emptyTryCount = "";
        String emptyExceptionMessage = "시도 횟수 입력이 비어있습니다.";
        assertThatThrownBy(() -> RacingCarValidator.validateTryCount(emptyTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(emptyExceptionMessage);
    }
    @Test
    void 시도횟수_자연수_입력테스트() {
        String normalTryCount = "2";
        assertThatCode(() -> RacingCarValidator.validateTryCount(normalTryCount)).doesNotThrowAnyException();
    }


}
