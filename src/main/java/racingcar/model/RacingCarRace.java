package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.RacingCarOutputView;

public class RacingCarRace {
    public void moveCars(List<Car> cars, Dice dice) {
        for (Car car : cars) {
            moveCarIfPossible(car, dice);
        }
    }

    public void moveCarIfPossible(Car car, Dice dice) {
        if (dice.isMoveable()) {
            car.moveCar();
        }
    }

    public List<String> moveMaxCars(int maxMove, List<String> maxName, Car car) {
        if (maxMove < car.getMoveStatus()) {
            maxName = new ArrayList<>();
            maxName.add(car.getCarName());
        } else if (maxMove == car.getMoveStatus()) {
            maxName.add(car.getCarName());
        }
        return maxName;
    }

    public void game(String[] carName, String tryCount) {
        int intTryCount = Integer.parseInt(tryCount);
        RacingCarOutputView.runMessage();
        List<Car> carMoves = Arrays.stream(carName)
                .map(name -> new Car(name.trim()))
                .collect(Collectors.toList());
        Dice dice = new Dice();
        for (int i = 0; i < intTryCount; i++) {
            moveCars(carMoves, dice);
            RacingCarOutputView.perMemberResult(carMoves);
        }
        int maxMove = 0;
        List<String> maxName = new ArrayList<>();
        for (Car car : carMoves) {
            maxName = moveMaxCars(maxMove, maxName, car);
        }
        RacingCarOutputView.finalWinner(maxName);
    }
}
