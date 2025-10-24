package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarRace {
    public void game(String[] carName, String tryCount) {
        int intTryCount = Integer.parseInt(tryCount);

        List<Car> carMoves = new ArrayList<>();
        RacingCarOutputView.runMessage();
        for(String name : carName) {
            carMoves.add(new Car(name));
        }
        Dice dice = new Dice();
        for(int i=0;i<intTryCount;i++){
            for (Car car : carMoves) {
                if (dice.isMoveable()) {
                    car.moveCar();
                }
            }
            RacingCarOutputView.perMemberResult(carMoves);
        }



    }
}
