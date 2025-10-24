package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarRace {
    public void game(String[] carName, String tryCount) {
        int intTryCount = Integer.parseInt(tryCount);

        List<Car> carMoves = new ArrayList<>();
        for(String name : carName) {
            carMoves.add(new Car(name));
        }
        Dice dice = new Dice();
        for(int i=0;i<intTryCount;i++){
            carMoves.stream()
                    .filter(car -> dice.isMoveable())
                    .forEach(Car::moveCar);
        }
        for(Car car: carMoves)
            System.out.println(car.getMoveStatus());


    }
}
