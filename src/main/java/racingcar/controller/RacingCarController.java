package racingcar.controller;

import java.util.List;
import racingcar.model.RacingCarNameParser;
import racingcar.model.RacingCarRace;
import racingcar.model.RacingCarValidator;
import racingcar.view.RacingCarInputView;
import racingcar.view.RacingCarOutputView;

public class RacingCarController {

    public void start() {
        String carName = RacingCarInputView.inputCarName();
        String[] splitName = RacingCarNameParser.parseCarName(carName);
        RacingCarValidator.validateCarName(splitName);
        String tryCount = RacingCarInputView.inputTryCount();
        RacingCarValidator.validateTryCount(tryCount);
        RacingCarOutputView.runMessage();
        RacingCarRace race = new RacingCarRace();
        List<String> maxName = race.game(splitName, tryCount);
        RacingCarOutputView.finalWinner(maxName);
    }

}
