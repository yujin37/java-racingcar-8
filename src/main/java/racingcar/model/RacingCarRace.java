package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.RacingCarOutputView;

public class RacingCarRace {

    public List<String> game(String[] carName, String tryCount) {
        int intTryCount = Integer.parseInt(tryCount);
        List<Car> carMoves = Arrays.stream(carName)
                .map(name -> new Car(name.trim()))
                .collect(Collectors.toList());
        playRounds(intTryCount, carMoves);
        return calculateWinner(carMoves);
    }

    private void playRounds(int intTryCount, List<Car> carMoves) {
        Dice dice = new Dice();
        for (int i = 0; i < intTryCount; i++) {
            moveCars(carMoves, dice);
            RacingCarOutputView.perMemberResult(carMoves);
        }
    }

    private List<String> calculateWinner(List<Car> carMoves) {
        int maxMove = 0;
        List<String> maxName = new ArrayList<>();
        for (Car car : carMoves) {
            maxName = moveMaxCars(maxMove, maxName, car);
        }
        return maxName;
    }

    private void moveCars(List<Car> cars, Dice dice) {
        for (Car car : cars) {
            moveCarIfPossible(car, dice);
        }
    }

    private void moveCarIfPossible(Car car, Dice dice) {
        if (dice.isMoveable()) {
            car.moveCar();
        }
    }

    private List<String> moveMaxCars(int maxMove, List<String> maxName, Car car) {
        if (maxMove < car.getMoveStatus()) {
            maxName = new ArrayList<>();
            maxName.add(car.getCarName());
        } else if (maxMove == car.getMoveStatus()) {
            maxName.add(car.getCarName());
        }
        return maxName;
    }
}
