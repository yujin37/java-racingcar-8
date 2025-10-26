package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.model.Dice;

public class DiceTest {
    @Test
    void 주사위_호출_시_둘중_하나_나오는지() {
        Dice dice = new Dice();
        assertThat(dice.isMoveable()).isIn(true, false);
    }
}
