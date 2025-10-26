package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.model.RacingCarNameParser;

public class RacingCarNameParserTest {
    @Test
    void 차_이름_들어오면_제대로_나누는지() {
        String carNames = "pobi,nuri";

        String[] result = RacingCarNameParser.parseCarName(carNames);
        assertThat(result).isEqualTo(new String[]{"pobi", "nuri"});
    }
}
