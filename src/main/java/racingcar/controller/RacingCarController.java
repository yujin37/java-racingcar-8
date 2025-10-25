package racingcar.controller;

import racingcar.model.RacingCarRace;
import racingcar.model.RacingCarNameParser;
import racingcar.model.RacingCarValidator;
import racingcar.view.RacingCarInputView;

public class RacingCarController {

    public void start() {
        String carName = RacingCarInputView.inputCarName();
        String[] splitName = RacingCarNameParser.parseCarName(carName);
        RacingCarValidator.validateCarName(splitName);
        String tryCount = RacingCarInputView.inputTryCount();
        RacingCarValidator.validateTryCount(tryCount);
        RacingCarRace race = new RacingCarRace();
        race.game(splitName, tryCount);
    }

}
