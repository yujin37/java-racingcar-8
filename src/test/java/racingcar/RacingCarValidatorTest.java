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

}
