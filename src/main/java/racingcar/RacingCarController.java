package racingcar;

import java.util.Arrays;

public class RacingCarController {

    public void start(){
        String carName = RacingCarInputView.inputCarName();
        String[] splitName = RacingCarNameParser.parseCarName(carName);
        RacingCarValidator.validateCarName(splitName);
    }

}
