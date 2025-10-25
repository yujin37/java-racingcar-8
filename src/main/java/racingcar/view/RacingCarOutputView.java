package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class RacingCarOutputView {
    public static void runMessage() {
        System.out.println("실행 결과");
    }
    public static void perMemberResult(List<Car> cars) {
        for(Car car : cars) {
            System.out.println(car.getCarName() + " : " + car.getDashMove());
        }
        System.out.println();
    }
    public static void finalWinner(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(",", winners));
    }
}
