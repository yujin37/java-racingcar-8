package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
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
        int maxMove = 0;
        List<String> maxName = new ArrayList<>();
        for(Car car : carMoves) {
            if(maxMove < car.moveStatus) {
                maxMove = car.moveStatus;
                maxName = new ArrayList<>();
                maxName.add(car.getCarName());
            } else if(maxMove == car.moveStatus)
                maxName.add(car.getCarName());
        }
        RacingCarOutputView.finalWinner(maxName);


    }
}
